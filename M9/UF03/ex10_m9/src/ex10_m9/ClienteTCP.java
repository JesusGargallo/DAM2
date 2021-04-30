package ex10_m9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteTCP extends Thread {

    Socket cliente;

    private ClienteTCP(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        String eco;

        BufferedReader fEntrada = null;
        try {
            //esto es lo que recibo del server
            fEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //leo lo que recibo del servidor
            while ((eco = fEntrada.readLine()) != null){
                System.out.println(" =>ECO " + eco);
            }

        } catch (Exception e) {

        }
        try {
            fEntrada.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String cadena;
        
        String host = "localhost";
        int puerto = 60000; // Puerto remoto

        Socket cliente = new Socket(host, puerto);

        // esto es el mensaje que envio al servidor
        PrintWriter fSalida = new PrintWriter(cliente.getOutputStream(), true);

        //esto es el teclado
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        ClienteTCP clienteT = new ClienteTCP(cliente);

        Thread thread = new Thread(clienteT);
        thread.start();
        
        System.out.println("Dime tu nombre:");
        cadena = in.readLine();
        
//        System.out.println("Introduce la cadena: ");
//
//        // LECTURA TECLADO
//        cadena = in.readLine();

        while (!cadena.equals("[salir]")) {

            // ENVIAR CADENA AL SERVIDOR
            fSalida.println(cadena);
            // LECTURA DE TECLADO
            cadena = in.readLine();
        }

        fSalida.close();

        System.out.println("Finalización del enviamiento...");
        in.close();
        cliente.close();
    }

}
