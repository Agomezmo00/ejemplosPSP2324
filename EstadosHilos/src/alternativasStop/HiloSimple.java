package alternativasStop;

public class HiloSimple extends Thread {

	private Thread yomismo;
	/**
	 * El constructor
	 */
	public HiloSimple() {
	}
	public void parar() {
		yomismo = null;
	}
	
	public void run() {
		int i=0;
		yomismo = this;
		while 
			(Thread.currentThread() == yomismo) {
			System.out.println("hilo" + i);
			i++;
		}
	}
}
