package alternativasStop;

import java.util.Scanner;

public class Alternativa1 {

	private static Thread hilo = null;

	public static void main(String[] args) {

		
		hilo = new Thread() {
			public void run() {
				Thread yomismo = Thread.currentThread();
				while(hilo == yomismo) {
					System.out.println("Estoy en el hilo...");
				}
			}
		};
		
		// programa principal
		
		hilo.start();

		boolean salir = false;
		String linea;
		Scanner teclado = new Scanner(System.in);
		while (!salir) {
			linea = teclado.nextLine();
			salir = true;
		}

		hilo = null;

	}

}
