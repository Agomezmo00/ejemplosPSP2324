package solucion;

import java.util.Scanner;

/**
 * @author Eva Royo
 * @date 30/11/2021
 */
public class Principal {

	public static void main(String[] args) {

		int numClientes = 5;
		CircularBuffer<Comanda> lasComandas = new CircularBuffer<Comanda>(3);
		Camarero camarero = new Camarero(lasComandas, numClientes);
		Cocinero cocinero = new Cocinero(lasComandas, numClientes);
		camarero.start();
		cocinero.start();
/*		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		cocinero.para();
		camarero.para();*/
	}

}
