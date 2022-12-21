import java.net.*;
public class Test {
		
	public static void main(String[] args) {
		InetAddress dir = null;

		try {
			dir = InetAddress.getByName("www.google.es");
			System.out.println(dir.getHostAddress());
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
	}
		
}
