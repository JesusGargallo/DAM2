package act5_m9;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ServidorTCP2 {
	
	public static void main (String[] args) throws Exception {
            Scanner teclado = new Scanner(System.in);	
            
		int numPort = 60000;
		ServerSocket servidor = new ServerSocket(numPort);
		String cadena = "";
                
                System.out.println("Introdueix el num de clients que podra rebre el servidor: ");
		int numClients = teclado.nextInt();
		
		// Determinem les vegades que es conectaran els clients
		for (int i = 0; i < numClients; i++) {

			Socket clientConnectat = null;
			PrintWriter fsortida = null;
			BufferedReader fentrada = null;

			System.out.println("Esperant connexió... ");
			clientConnectat = servidor.accept();
			System.out.println("Client " + (i+1) + " connectat... ");

			//FLUX DE SORTIDA AL CLIENT
			fsortida = new PrintWriter(clientConnectat.getOutputStream(), true);


			//FLUX D'ENTRADA DEL CLIENT
			fentrada = new BufferedReader(new InputStreamReader(clientConnectat.getInputStream()));

			while ((cadena = fentrada.readLine()) != null) {

				fsortida.println(cadena);
				System.out.println("Rebent: "+cadena);
				if (cadena.equals("*")) break;

			}
			fentrada.close();
			fsortida.close();
			clientConnectat.close();
		}


		//TANCAR STREAMS I SOCKETS
		System.out.println("Tancant connexió... ");
		//		fentrada.close();
		//		fsortida.close();
		//		clientConnectat.close();
		servidor.close();
		
	}

}

