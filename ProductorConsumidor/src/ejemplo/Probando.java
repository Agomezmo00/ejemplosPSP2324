package ejemplo;

public class Probando {

	public static void main(String[] args) {
		CircularBuffer<String> b = new CircularBuffer<String>(3);
		for (int i = 0; i < 10; i++) {
			System.out.println("Empeza: " + b);
			b.add("uno");
			System.out.println("uno: " + b);
			b.add("dos");
			System.out.println("dos: " + b);
			System.out.println("Obtengo '" + b.get() + "', ahora " + b);

			b.add("tres");
			System.out.println("tres: " + b);
			// Test Overflow
			// b.add("cuatro");
			// System.out.println("cuatro: " + b);

			System.out.println("Obtengo '" + b.get() + "', ahora " + b);
			System.out.println("Obtengo '" + b.get() + "', ahora " + b);
			// Test Underflow
			// System.out.println("Obtengo '" + b.get() + "', ahora " + b);

			// Back to start, let's shift on one
			b.add("NADA");
			b.get();
			System.out.println("----");
		}
	}
}
