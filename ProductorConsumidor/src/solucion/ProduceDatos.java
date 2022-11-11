package solucion;

import java.util.Random;

public class ProduceDatos extends Thread {

	/** estructura que compare y va a sincronizar **/
	Pila laPila = new Pila(4);
	private int datoInsertar; 
	
	public ProduceDatos(Pila q, int dato) {
		laPila = q;
		datoInsertar = dato;
	}
	
	/**
	 * Hilo que agnade a la pila los números, es decir, está PRODUCIENDO DATOS
	 */
	public void run() {
		Random aleat = new Random();
		
		try {
			int tiempo =aleat.nextInt(2)*1000; 
			System.err.println("soy " + this.getName() + " voy a dormir " + tiempo);
			sleep(tiempo); // espera un tiempo aletorio
			synchronized (laPila) {
				//agnado un entero
				while (laPila.estaLlena()) {
					System.err.println("No puedo producir mas, esperare, y soy " + this.getName());
					laPila.wait();
				}; 
				System.err.println("agnado " + datoInsertar + " soy " + this.getName());
				laPila.agnade(datoInsertar);
				laPila.notifyAll(); // notifico que hay dato
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}