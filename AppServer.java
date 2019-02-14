package servidor;
import java.net.*;
import java.io.*;


public class AppServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = null;
		Socket socket = null;
		int conexion = 0;
		int puerto = 8081;
		
		
		/*Creaci�n del socket "server", el cual escuchar� por peticiones de conexi�n en la m�quina local, 
		en el puerto indicado en "puerto", es importante que el puerto se asigne de esta manera porque la m�quina remota
		 que pedir� la conexi�n tiene que saber la direcci�n IP y el n�mero de puerto al cual hacer la petici�n de conexi�n*/
		try{
			server = new ServerSocket(puerto);
		} catch (IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		/*Ahora es mometo de poner al socket yo a escuchar por peticiones de conexi�n, 
		 * es importante que notes dos cosas: hay que atrapar la excepci�n IOException 
		 * en caso de que haya error y que el programa para su ejecuci�n en esta instrucci�n
		 *  hasta que haya una petici�n de conexi�n y �sta sea aceptada, como puedes ver cuando
		 *   se ejecute el accept() regresar� un socket, en este caso llamado socket*/
		while(true){
			System.out.println("Socket escuchando en puerto "+puerto);		
			try{
				socket = server.accept();
				conexion++;
				Thread t = new Server(socket,conexion);
				t.start();
			//	socket.close();
			} catch (IOException e){
				System.out.println(e.getMessage());
				socket.close();
				server.close();
				System.exit(1);
			}			
		}
		
	}
	

}
