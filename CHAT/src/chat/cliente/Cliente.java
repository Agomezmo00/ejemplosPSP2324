package chat.cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

public class Cliente {
	private static final String PROPERTIES_FILE = "src/config/datos.properties";

	public static void main(String[] args) throws InterruptedException {

		Properties properties = new Properties();

		try {
			properties.load(new BufferedReader(new FileReader(PROPERTIES_FILE)));
			int puerto = Integer.valueOf(properties.getProperty("puertoEscucha"));
			String host = properties.getProperty("host"); 

			Socket misocket = new Socket(host, puerto);

			// Para leer lo que llegue por el nuevo socket
			BufferedReader leeCliente = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
			BufferedWriter escribeCliente = new BufferedWriter(new OutputStreamWriter(misocket.getOutputStream()));

			String linea = leeCliente.readLine();
			System.out.println("He leido =>" + linea);
			for (int i = 0; i < 20; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				escribeCliente.write("soy " + linea + " iteraccion:" + i + "\n");
				escribeCliente.flush();
				System.out.println("soy " + linea + " iteraccion:" + i);
			}
			
			leeCliente.close();
			misocket.close();
			System.out.println("TERMINO");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
