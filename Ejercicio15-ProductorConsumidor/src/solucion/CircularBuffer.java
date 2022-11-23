package solucion;

//Hijack these for simplicity
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

public class CircularBuffer<T> {

	private T[] buffer;

	private int tail; /** indica donde está el final del buffer **/
	private int head; /** indica donde está el comienzo del buffer **/

	@SuppressWarnings("unchecked")
	public CircularBuffer(int n) {
		buffer = (T[]) new Object[n];
		tail = 0;
		head = 0;
	}

	public void add(T toAdd) {
		if (head != (tail - 1)) {
			buffer[head++] = toAdd;
		} else {
			throw new BufferOverflowException();
		}
		head = head % buffer.length;
	}

	public T get() {
		T t = null;
		int adjTail = tail > head ? tail - buffer.length : tail;
		if (adjTail < head) {
			t = (T) buffer[tail++];
			tail = tail % buffer.length;
		} else {
			throw new BufferUnderflowException();
		}
		return t;
	}
	
	public boolean isEmpty() {
		int adjTail = tail > head ? tail - buffer.length : tail;
		if (adjTail >= head) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (head != (tail - 1)) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public String toString() {
		String cadena = "[";
		for (int i = 0; i < buffer.length; i++) {
			cadena = cadena + buffer[i] + ", ";
		}
		cadena = cadena + "]";
		return cadena + "\n CircularBuffer(size=" + buffer.length + ", head=" + head + ", tail=" + tail + ")";
			
	}

}