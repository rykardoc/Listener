package servidor;
import java.util.Properties;
import java.io.*;

public class Validador {
private String mensajeRecibido;
private String mensajeValidado;

	public Validador(String mensajeRecibido){
		this.mensajeRecibido = mensajeRecibido;
	}
	
	public String validadorCabecera(){
		
		String cabecera = mensajeRecibido.substring(1, 11);
		System.out.println("Cabecera : "+cabecera);
		
		return cabecera;
	}
	
	public boolean  inyectaaTxt(){
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/prueba.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		return true;
	}
	
	public void cargaArchivoValidador(){
		
	}
}
