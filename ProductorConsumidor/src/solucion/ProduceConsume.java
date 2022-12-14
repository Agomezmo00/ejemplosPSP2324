package solucion;

/**
 * Implementa un esquema productor/consumidor. Es decir, habr� un thread que se dedicar� a
crear datos y otro a consumirlos. Es un esquema bastante habitual de concurrencia, con uno
o varios threads creando datos y con uno o varios consumiendo dichos datos. En este caso
habr� s�lo uno de cada. Adem�s, por simplicidad, los datos a producir/consumir ser�n
enteros, empezando por el 1, luego el 2, el 3 y as� sucesivamente hasta el 30. Cada thread
esperar� un tiempo aleatorio entre datos (random), entre 0 y 2 segundos, para simular el
tiempo que tarda en producir/consumir cada dato. Utiliza una pila, con capacidad
para 4 datos, para pasar los datos entre los dos threads. Aseg�rese de sincronizarlos
correctamente (wait/notify) para que el productor no meta datos en la pila cuando �sta
est� llena, ni que el consumidor coja datos cuando este est� vac�a. Haz que el consumidor
imprima los datos una vez que los haya consumido (tras la espera) para ver que no se
pierde ninguno. Imprime tambi�n un mensaje cada vez que un thread tenga que esperar
porque la pila est� llena o vac�a

 * @author Eva Royo
 * @date 30/11/2021
 */
public class ProduceConsume {

	public static void main(String[] args) {

		Pila pila = new Pila(4);
		
		// durante 30 iteraciones crearemos un dato y lo consumiremos
		for (int i = 1; i <= 30; i++) {
			ProduceDatos p = new ProduceDatos(pila, i);
			ConsumirDatos c = new ConsumirDatos(pila);
			p.setName("productor" + i);
			c.setName("consumidor"+i);
			p.start();
			c.start();
		}
	}

}
