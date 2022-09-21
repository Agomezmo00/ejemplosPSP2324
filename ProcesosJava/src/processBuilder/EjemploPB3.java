package processBuilder;

import java.io.File;
import java.io.IOException; 

public class EjemploPB3 { 
  public static void main(String args[]) throws IOException {
    ProcessBuilder pb = new ProcessBuilder("CMD");
    
    File fBat = new File("C:\\Users\\Eva Royo\\temporal\\fichero.bat");
    File fOut = new File("C:\\Users\\Eva Royo\\temporal\\salida.txt");
    File fErr = new File("C:\\Users\\Eva Royo\\temporal\\error.txt");
 
    pb.redirectInput(fBat);
    pb.redirectOutput(fOut);
    pb.redirectError(fErr); 
    pb.start(); 

  }
}// EjemploPB3
