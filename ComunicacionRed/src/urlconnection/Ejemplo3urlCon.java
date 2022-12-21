package urlconnection;
import java.net.*;
import java.io.*;
import java.util.*;

public class Ejemplo3urlCon {
  
  public static void main(String[] args) throws Exception {
	String cadena;

	URL url = new URL("https://thispersondoesnotexist.com/image");
	URLConnection conexion = url.openConnection();

	System.out.println("Direccion [getURL()]:" + conexion.getURL());

	Date fecha = new Date(conexion.getLastModified());
	System.out.println("Fecha ultima modificacion [getLastModified()]: "+ fecha);
	System.out.println("Tipo de Contenido [getContentType()]: " + conexion.getContentType());

	Map<String, List<String>> camposcabecera = conexion.getHeaderFields();

	// TRES FORMAS DE RECORRER UN MAP
	// ------------------------------1--------------
	System.out.println("=================================================== ");
	System.out.println("TODOS LOS CAMPOS DE CABECERA CON getHeaderFields(): ");
	Iterator it = camposcabecera.entrySet().iterator();
	while (it.hasNext()) {
			Map.Entry map = (Map.Entry) it.next();
			System.out.println(map.getKey() + " : " + map.getValue());
	}
	
	// ------------------------------2--------------
	System.out.println("=================================================== ");
	System.out.println("TODOS LOS CAMPOS DE CABECERA CON getHeaderFields(): ");
	// recorro los campos de la cabecera
	for (Map.Entry<String, List<String>> parejaDatosMapa : camposcabecera.entrySet()) {
		System.out.print(parejaDatosMapa.getKey() + ":");
		List<String> lista = parejaDatosMapa.getValue();
		for (String elemento : lista) {
			System.out.print("\t" + elemento + "\n");
		}
	}
		
	// otra forma de hacerlo
	// ------------------------------3--------------
	System.out.println("=================================================== ");
	System.out.println("TODOS LOS CAMPOS DE CABECERA CON getHeaderFields(): ");
	camposcabecera.forEach((clave, valor) -> System.out.println(clave + ":\t" + valor));
		
	
	System.out.println("=================================================== ");
	System.out.println("CAMPOS 1 Y 4 DE CABECERA:");
	System.out.println("getHeaderField(1)=> " + conexion.getHeaderField(1));
	System.out.println("getHeaderField(4)=> " + conexion.getHeaderField(4));
	System.out.println("=================================================== ");

	System.out.println("CONTENIDO DE [url.getFile()]:" + url.getFile());
	BufferedReader pagina = new BufferedReader(new InputStreamReader(
			url.openStream()));

	while ((cadena = pagina.readLine()) != null) {
			System.out.println(cadena);
	}		
  }
}//