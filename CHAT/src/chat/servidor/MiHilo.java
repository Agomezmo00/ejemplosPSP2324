package chat.servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MiHilo extends Thread{

	private Socket cliente;
	private int numCliente;

	public MiHilo(int i, Socket cliente) {
		this.numCliente = i;
		this.cliente = cliente;
	}
	
	public void run() {
		// Construyo el recurso dentro del try para que lo cierre  automáticamente
		try (BufferedWriter escribirAlCliente = 
				new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));
			BufferedReader leerDeCliente = 
			new BufferedReader(new InputStreamReader(cliente.getInputStream())))
		{
			
			// envío algo al servidor
			escribirAlCliente.write("Hola, eres el cliente " + numCliente);
			escribirAlCliente.newLine();
			escribirAlCliente.flush();
			
			for (int i = 0; i < 20; i++) {
				String linea = leerDeCliente.readLine();
				System.out.println("Leido -->" + linea + " del cliente "+ numCliente);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
