package solucion;


public class Cocinero extends Thread {

	private static final int SEGUNDOSCOCINAR = 1500;
	/** estrucura que compare y va a sincronizar **/
	CircularBuffer<Comanda> lasComandas = new CircularBuffer<Comanda>(10);
	private boolean parar = false;
	private int numClientes;
	
	public Cocinero(CircularBuffer<Comanda> q, int numClientes) {
		lasComandas = q;
		this.numClientes= numClientes;
	}
	
	public void para() {
		parar =true;
	}

	/**
	 * Hilo que va a ir consumiendo los datos producidos en la estructura, 
	 * ES EL CONSUMIDOR DE ENTEROS
	 */
	public void run() {
		parar = false;
		int iteraciones=numClientes;
		while (!parar && iteraciones>0) {
			try {
				// como las comandas son compartidas, sincronizo su acceso
				synchronized (lasComandas) {
					if (lasComandas.isEmpty()) {
						// es porque no hay datos --> me espero a que me avisen de que hay datos
						System.err.println("Comanda vacía, soy el cocinero y paro");
						lasComandas.wait();
					}
					Comanda plato = lasComandas.get();
					System.err.println("Estoy cocinando.... " + plato.getPlato());
					lasComandas.notifyAll(); // notifico que he cocinado el plato
				}
				sleep(SEGUNDOSCOCINAR); // me cuesta cocinar unos segundos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			iteraciones--;
		}
	}
	
}