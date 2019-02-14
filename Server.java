package servidor;

import java.io.*;
import java.net.*;

public class Server extends Thread {

	private Socket socket;
	private int conexion = 0;
	// DataOutputStream salida;
	private String mensajeRecibido;
	
	private Validador validador;
	
	
	
	public Server(Socket socket, int conexion){
		this.socket = socket;
		this.conexion = conexion;
	}
	
	public void run() {
		BufferedReader entrada;
		System.out.println("Conectado al thread "+conexion);
		
		//canales de entrada y salida
		try {
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//	salida = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("Confirmando conexion al cliente....");
		//	salida.writeUTF("Conexión exitosa...n envia un mensaje :D");
			//Recepcion de mensaje
			mensajeRecibido = entrada.readLine();
			System.out.println(mensajeRecibido);
			validador = new Validador(mensajeRecibido);
			validador.validadorCabecera();
			
		//	salida.writeUTF("Se recibio tu mensaje.n Terminando conexion...");
		//	salida.writeUTF("Gracias por conectarte, adios!");
			System.out.println("Cerrando conexión...");
			socket.close();//Aqui se cierra la conexión con el cliente


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		
	}
}
