package compartirinfo.uno;

public class CompartirInf1 {
	public static void main(String[] args) {
		Contador cont = new Contador(100);
		Hilo a = new Hilo("HiloA", cont);
		Hilo b = new Hilo("HiloB", cont);
		a.start();
		b.start();
		try {
			a.join();
			b.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main contador vale " + cont.getValor());
	}
}
