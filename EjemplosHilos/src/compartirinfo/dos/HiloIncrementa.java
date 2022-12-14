package compartirinfo.dos;

public class HiloIncrementa extends Thread {
	private Contador contador;

	public HiloIncrementa(String n, Contador c) {
		this.setName(n);
		contador = c;
	}

	public void run() {
		for (int j = 0; j < 300; j++) {
			contador.incrementa();
//			try {
//				sleep(50);
//			} catch (InterruptedException e) {		}
		}
		System.out.println(getName() + " contador vale " + contador.getValor());
	}
}// FIN HILOA