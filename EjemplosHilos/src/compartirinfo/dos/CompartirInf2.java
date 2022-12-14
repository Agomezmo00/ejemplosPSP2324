package compartirinfo.dos;

public class CompartirInf2 {
	public static void main(String[] args) {
		Contador cont = new Contador(100);
		HiloIncrementa a = new HiloIncrementa("HiloA", cont);
		HiloDecrementa b = new HiloDecrementa("HiloB", cont);
		a.start();
		b.start();
		System.out.println("Main contador vale " + cont.getValor());
	}
}
