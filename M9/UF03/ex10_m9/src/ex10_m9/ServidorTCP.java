package ex10_m9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorTCP extends Thread {
    static Scanner sc = new Scanner(System.in);
    
    // ATRIBUTOS
    private final Socket cliente;
    private final int numCliente;
    private boolean conActiva;
    
    private boolean Pmensaje;
    
    public static PrintWriter fSalida[];
    public static ServidorTCP clientes[];

    // CONSTRUCTOR
    public ServidorTCP(Socket clienteConectado, int i) {
        this.cliente = clienteConectado;
        this.numCliente = i;
        this.conActiva = true;
    }

    // GETTER PARA COMPROBAR SI LA CONEXION CON ESE CLIENTE HA FINALIZADO
    public boolean isConActiva() {
        return conActiva;
    }

    // RUN
    public void run() {

        // VARIABLES
        String cadena;

        // FLUJO DE SALIDA Y ENTRADA AL CLIENTE
        PrintWriter fSalida = null;
        BufferedReader fEntrada = null;
        try {
            fSalida = new PrintWriter(cliente.getOutputStream(), true);
            fEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        } catch (IOException e) {
            System.err.println("Error creando flujo de salida o entrada al cliente " + numCliente);
        }

        
        // CONTROLA ERRORES RECIBIENDO MENSAJES DEL CLIENTE
        try {
            // VA MOSTRANDO LOS MENSAJES DEL CLIENTE HASTA QUE SE DESCONECTE
            if (fEntrada != null) {
                while ((cadena = fEntrada.readLine()) != null) {
                    
                    if(cadena.startsWith("[log]")){
                        
                        String[] parts = cadena.split("]");
                        this.setName(parts[1]);
                        
                        
                    } else if (!cadena.startsWith("[log]")) {
                       System.out.println("Debes iniciar sesion primero");
                    }
                    
                    
                    fSalida.println(cadena);
                    System.out.println("Cliente " + this.getName() + " - Recibiendo: " + cadena);
                    if (cadena.equals("*")) break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error en la conexion del cliente " + numCliente);
        }

        // CONTROLA DESCONEXION CLIENTE
        try {
            // CERRAR STREAMS Y SOCKETS
            if (fEntrada != null) {
                fEntrada.close();
            }
            if (fSalida != null) {
                fSalida.close();
            }
            cliente.close();
            conActiva = false;
            System.out.println("Cerrando conexión cliente..." + numCliente);
        } catch (IOException e) {
            System.out.println("Error cerrando conexion con el cliente " + numCliente);
        }
    }

    // METODO QUE COMPRUEBA SI HAN ACABADO TODAS LAS CONEXIONES CON LOS CLIENTES
    private static boolean finalServer(ServidorTCP[] c, int totalClientes) {

        boolean fin = false;
        boolean clienteConectado = false;

        int i = 0;
        while (i < totalClientes && !clienteConectado) {

            if (c[i] != null){
                clienteConectado = c[i].isConActiva();
            }
            fin = !clienteConectado;
            i++;
        }

        return fin;
    }

    // MAIN
    public static void main(String[] args) {

        
        // VARIABLES
        int totalClientes = 0;
        System.out.println("Cuantos clientes puede soportar ? ");
        totalClientes = sc.nextInt();
        ServidorTCP.clientes = new ServidorTCP[totalClientes];
        ServidorTCP.fSalida = new PrintWriter[totalClientes];
        
        
        final int numPort = 60000;
        ServerSocket servidor = null;
        

        // CONTROLA LA CONEXION DEL SERVIDOR
        try {
            // INICIALIZO SERVIDOR
            servidor = new ServerSocket(numPort);

            // INDICO CREACION SERVIDOR
            System.out.println("Servidor empezado");

        } catch (IOException e) {
            System.err.println("Error inicializando servidor");
        }

        // CONTROLA LA CONEXION CON EL CLIENTE
        try {
            // BUCLE N CLIENTES
            for (int i = 0; i < totalClientes; i++) {

                // ESPERA CONEXION DE UN CLIENTE
                System.out.println("Esperando conexión... ");
                Socket clienteConectado = null;
                if (servidor != null) {
                    clienteConectado = servidor.accept();
                    // LANZA UN HILO CON UN NUEVO CLIENTE
                    clientes[i] = new ServidorTCP(clienteConectado, i);
                    fSalida[i] = new PrintWriter(clientes[i].cliente.getOutputStream(), true);
                    clientes[i].start();
                }
                System.out.println("Cliente conectado... " + i);

                

            }
        } catch (IOException e) {
            System.err.println("Error conectando con cliente");
        }

        // INDICO QUE SE HA LLEGADO AL LIMITE DE CLIENTES
        System.out.println("Limite de clientes alcanzado (" + totalClientes + ")");

        // CONTROLA LA DESCONEXION DEL SERVIDOR
        try {
            // CUANDO EL SERVIDOR HA LLEGADO AL MAXIMO DE CLIENTES, COMPRUEBA CONSTANTEMENTE
            // SI SE HAN DESCONECTADO TODOS LOS CLIENTES
            while (!finalServer(clientes, totalClientes)){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (servidor != null) {
                servidor.close();
            }
            System.out.println("Cerrando conexión servidor");
        } catch (IOException e) {
            System.out.println("Error cerrando conexion del servidor");
        }
    }
}