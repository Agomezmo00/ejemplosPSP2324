package alternativa2y3;

public class HiloSimple  extends Thread {

	private boolean paraHilo;

	/**
	 * El constructor
	 */
	public HiloSimple() {
		paraHilo = false;
	}
	
	public void parar() {
		paraHilo = true;
	}
	
	public void run() {
		int numero = 0;
		while (!isInterrupted()) {
			System.out.println("soy " + this.getName() + " " + numero++);
		}
	}
}
