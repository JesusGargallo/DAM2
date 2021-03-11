/*
 * File: Tablero.java
 * Author: Aitor Pumar
 * Date: 28-10-2020
 * Description: Clase que gestiona el tablero (inicializar, mostrar, actualizar)
 * y comprueba que las fichas introducidas sean validas
 */
package act9_m3;

import java.util.Arrays;

@SuppressWarnings("FieldMayBeFinal")
public class Tablero {

    // ATRIBUTOS
    private String tablero[][] = new String[8][8];

    // CONSTRUCTOR QUE INICIALIZA EL TABLERO CON LAS POSICIONES INICIALES DE TODAS LAS FICHAS
    public Tablero(){

        // FILA 0 NEGRAS (PIEZAS MAYORES)
        this.tablero[0] = new String[]{"t", "c", "a", "q", "k", "a", "c", "t"};

        // FILA 1 NEGRA (PEON)
        Arrays.fill(this.tablero[1], "p");

        // FILAS VACIAS (2 - 5)
        for (int i = 2; i <= 5; i++) {
            Arrays.fill(this.tablero[i], Ajedrez.VACIO);
        }

        // FILA 6 BLANCA (PEON)
        Arrays.fill(this.tablero[6], "P");

        // FILA 7 BLANCAS (PIEZAS MAYORES)
        this.tablero[7] = new String[]{"T", "C", "A", "Q", "K", "A", "C", "T"};
    }

    // GETTERS Y SETTERS
    public String getValor(int fila, int col){
        return tablero[fila][col];
    }

    public int getLength(){
        return tablero.length; // como es matriz cuadrada solo hago uno (en vez de getFila y getColumna)
    }

    public String[][] getTablero() {
        return tablero;
    }

    // METODOS
    // METODO QUE ACTUALIZA TABLERO
    public void actualiza(Ficha origen, Ficha destino){

        // GUARDA ORIGEN EN DESTINO
        this.tablero[destino.getFila()][destino.getColumna()] =
                this.tablero[origen.getFila()][origen.getColumna()];

        // GUARDA VACIO EN ORIGEN
        this.tablero[origen.getFila()][origen.getColumna()] = Ajedrez.VACIO;
    }
}
