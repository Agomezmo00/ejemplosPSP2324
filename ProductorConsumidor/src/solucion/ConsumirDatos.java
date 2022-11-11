package solucion;

import java.util.Random;

public class ConsumirDatos extends Thread {

	/** estrucura que compare y va a sincronizar **/
	Pila laPila = new Pila(4);
	
	public ConsumirDatos(Pila q) {
		laPila = q;
	}
	
	/**
	 * Hilo que va a ir consumiendo los datos producidos en la estructura, 
	 * ES EL CONSUMIDOR DE ENTEROS
	 */
	public void run() {
		
		try {
			Random aleat = new Random();
			Integer res ;

			int tiempo = aleat.nextInt(2)*1000;
			System.err.println("soy " + this.getName() + " voy a dormir " + tiempo);
			sleep(tiempo); // espero un tiempo aleatorio
			// como la pila es compartida, sincronizo su acceso
			synchronized (laPila) {
				// poll es retirar un elemento de la estructura
				while (laPila.estaVacia()) {
					// es porque no hay datos --> me espero a que me avisen de que hay datos
					System.err.println("Pila vacía, voy a parar, y soy " + this.getName());
					laPila.wait();
				}
				res=laPila.sacar();
				System.err.println("consumo " + res + " soy " + this.getName());
				laPila.notifyAll(); // notifico que he consumido un dato
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}