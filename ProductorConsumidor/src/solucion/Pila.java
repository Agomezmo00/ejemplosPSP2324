package solucion;

/**
 * Clase para simular una pila, se consume el último dato insertado
 * @author Eva
 * @date 30/11/2021
 *
 */
public class Pila {
	
	int[] array;
	int size = 4;
	private int last=0;
	
	/**
	 * Constructor
	 * @param size	Tamaño de la pila
	 */
	public Pila(int size) {
		this.size = size;
		array = new int[size];
		last = 0;
	}
	
	/**
	 * Añade un entero a la pila
	 * @param dato entero que se cargará en la pila
	 * @return true si lo ha añadido con éxito, false en otro caso
	 */
	public boolean agnade (int dato) {
		if (!estaLlena()) {
			array[last] = dato;
			last++;
			return true;
		}
		return false;
	}

	/**
	 * Retira un entero de la pila
	 * @return el último entero de la pila, -1 si no hay más datos la pila
	 */
	public int sacar () {
		if (!estaVacia()) {
			last--;
			return array[last];
		}
		return -1;
	}
	
	/**
	 * Vacía la pila
	 */
	public void vaciar() {
		last = 0;
	}

	/**
	 * Chequea si la pila está vacía
	 * @return True si la pila está vacía, false en otro caso
	 */
	public boolean estaVacia() {
		if (last < 1) return true;
		return false;
	}

	/**
	 * Chequea si la pila está llena
	 * @return	True si la pila está llena, false en otro caso
	 */
	public boolean estaLlena() {
		if (last == size) {
			return true;
		}
		return false;
	}

}