package servidor;
import java.net.*;
import java.io.*;


public class AppServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = null;
		Socket socket = null;
		int conexion = 0;
		int puerto = 8081;
		
		
		/*Creación del socket "server", el cual escuchará por peticiones de conexión en la máquina local, 
		en el puerto indicado en "puerto", es importante que el puerto se asigne de esta manera porque la máquina remota
		 que pedirá la conexión tiene que saber la dirección IP y el número de puerto al cual hacer la petición de conexión*/
		try{
			server = new ServerSocket(puerto);
		} catch (IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		/*Ahora es mometo de poner al socket yo a escuchar por peticiones de conexión, 
		 * es importante que notes dos cosas: hay que atrapar la excepción IOException 
		 * en caso de que haya error y que el programa para su ejecución en esta instrucción
		 *  hasta que haya una petición de conexión y ésta sea aceptada, como puedes ver cuando
		 *   se ejecute el accept() regresará un socket, en este caso llamado socket*/
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
