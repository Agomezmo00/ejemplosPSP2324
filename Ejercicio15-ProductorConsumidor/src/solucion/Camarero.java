package solucion;


public class Camarero extends Thread {

	private static final int SEGUNDOSCOMANDA = 200;
	CircularBuffer<Comanda> lasComandas = new CircularBuffer<Comanda>(10);
	private boolean parar = false;
	private int numComanda;
	private int numClientes;
	
	public Camarero(CircularBuffer<Comanda> q, int numClientes) {
		lasComandas = q;
		numComanda = 0;
		this.numClientes = numClientes;
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
		int iteraciones = numClientes;
		while (!parar && iteraciones>0) {
			try {
				// como las comandas son compartidas, sincronizo su acceso
				synchronized (lasComandas) {
					if (lasComandas.isFull()) {
						// es porque no hay datos --> me espero a que me avisen de que hay datos
						System.err.println("Comandero lleno, soy el camarero y espero");
						lasComandas.wait();
					}
					Comanda c = new Comanda(Cocina.cocinaPlato(), numComanda++);
					System.err.println("Estoy tomando la comanda número " + numComanda +
							" .. me están pidiendo... " + c.getPlato());
					lasComandas.add(c);
					System.err.println("\t Comanda añadida");
					lasComandas.notifyAll(); // notifico que he cocinado el plato
				}
				sleep(SEGUNDOSCOMANDA); // me cuesta pedir la comanda unos segundos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.err.println("Soy camarero " + iteraciones);
			iteraciones--;
		}
	}
	
	
}