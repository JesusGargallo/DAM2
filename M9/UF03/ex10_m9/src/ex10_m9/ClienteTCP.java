package ex10_m9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteTCP extends Thread {

    static String cadena, eco;
    static Socket cliente ;
    static String host = "localhost";
    static int puerto = 60000; // Puerto remoto
    
    // FLUJO DE SALIDA AL SERVIDOR
    static PrintWriter fSalida;
    
    // FLUJO DE ENTRADA AL SERVIDOR
    static BufferedReader fEntrada;
    
    // FLUJO PARA ENTRADA STANDARD
    static BufferedReader in;
        
    public static void main(String[] args) throws Exception {
        
        cliente = new Socket(host, puerto);

        fSalida = new PrintWriter(cliente.getOutputStream(), true);
        
        fEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        
        in = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Introduce la cadena: ");
        
        

        // LECTURA TECLADO
        cadena = in.readLine();

        while (!cadena.equals("/salir")) {

            // ENVIAR CADENA AL SERVIDOR
            fSalida.println(cadena);
            // RECIBIDA CADENA DEL SERVIDOR
            eco = fEntrada.readLine();
            System.out.println(" =>ECO: " + eco);
            // LECTURA DE TECLADO
            cadena = in.readLine();
        }

        fSalida.close();
        fEntrada.close();
        System.out.println("Finalización del enviamiento...");
        in.close();
        cliente.close();
    }
    public void run(){
        while(!cadena.equals("/salir"));
        try {
            eco = fEntrada.readLine();
            System.out.println(" =>ECO " + eco);
        } catch (Exception e) {
            
        }
    }
    
}