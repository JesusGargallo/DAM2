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

    private static int totalClientes;
    private boolean Pmensaje = true;

    public static PrintWriter fSalida1[];
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
                    
                    //LOGIN
                    if (Pmensaje) {
                        if (cadena.startsWith("[log]")) {
                            String[] parts = cadena.split("]");

                            if (parts.length == 2) {
                                if (!parts[1].trim().equals("")) {
                                    this.setName(parts[1]);
                                    Pmensaje = !Pmensaje;
                                } else {
                                    cadena = "No seas troll";
                                    fSalida.println(cadena);
                                }
                            } else {
                                cadena = "No vale poner el nombre en blanco";
                                fSalida.println(cadena);
                            }
                            
                        } else if (!cadena.startsWith("[log]")) {
                            cadena = "Debes iniciar sesion primero";
                            fSalida.println(cadena);
                        }
                    } else if (!Pmensaje && cadena.startsWith("[log]")) {
                        cadena = "Ya estas iniciado no puedes volver a iniciar Pelotudo";
                        fSalida.println(cadena);
                    }
                    
                    //MENSAJE
                    if (cadena.startsWith("[mensaje]")) {
                        String[] parts = cadena.split("]");
                        if (parts.length == 2) {
                            if (!parts[1].trim().equals("")) {
                                for(int i=0; i < totalClientes ; i++){
                                    if(!clientes[i].getName().equals(this.getName())){
                                        fSalida1[i].println(parts[1]);
                                        
                                    }
                                }
                            } else {
                                cadena = "No seas troll";
                                fSalida.println(cadena);
                            }
                        } else {
                            cadena = "No vale poner el nombre en blanco";
                            fSalida.println(cadena);
                        }
                    } 
                    
                    
                    //MENSAJE DIRECTO A UN CLIENTE EN CONCRETO
                    if (cadena.startsWith("[mensajeto]")) {
                        String[] parts = cadena.split("]");
                        if (parts.length == 3) {
                            if (!parts[1].trim().equals("")) {
                                for(int i=0; i < totalClientes ; i++){
                                    if(!clientes[i].getName().equals(this.getName())){
                                        fSalida1[i].println(parts[1]);
                                    }
                                }
                            } else {
                                cadena = "No seas troll";
                                fSalida.println(cadena);
                            }
                        } else {
                            cadena = "No vale poner el nombre en blanco";
                            fSalida.println(cadena);
                        }
                    }

                    
                    System.out.println("Cliente " + this.getName() + " - Recibiendo: " + cadena);
                    if (cadena.equals("*")) {
                        break;
                    }
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

            if (c[i] != null) {
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
        
        System.out.println("Cuantos clientes puede soportar ? ");
        totalClientes = sc.nextInt();
        ServidorTCP.clientes = new ServidorTCP[totalClientes];
        ServidorTCP.fSalida1 = new PrintWriter[totalClientes];

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
                    fSalida1[i] = new PrintWriter(clientes[i].cliente.getOutputStream(), true);
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
            while (!finalServer(clientes, totalClientes)) {
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
