/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act9_m9;

/**
 *
 * @author Usuario
 */
public class ServidorTCP2 implements Runnable {

	Socket client;
	ServerSocket server;
	static int numClient;
	String cadena = "";

	public ServidorTCP2(Socket clientConnectat, ServerSocket server) {
		this.client = clientConnectat;
		this.server = server;
		this.numClient ++;
	}
        
}
