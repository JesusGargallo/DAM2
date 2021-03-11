/*
 * File: Ajedrez.java
 * Author: Aitor Pumar
 * Date: 28-10-2020
 * Description: Clase que gestiona elementos generales de la partida como cambiar de turno
 * o comprobar si la partida ha acabado
 */
package act9_m3;

public class Ajedrez {

    // CONSTANTES
    public static final String VACIO = "vacio";
    public static final String TORRE = "t";
    public static final String CABALLO = "c";
    public static final String ALFIL = "a";
    public static final String REINA = "q";
    public static final String REY = "k";
    public static final String PEON = "p";

    // ATRIBUTOS
    private boolean turnoBlanca;

    // CONSTRUCTOR (AL CREARSE SIEMPRE ASIGNA PRIMER TURNO A BLANCAS)
    public Ajedrez() {
        this.turnoBlanca = true;
    }

    // GETTERS Y SETTERS
    public boolean isTurnoBlanca() {
        return turnoBlanca;
    }
    public void setTurnoBlanca(boolean turnoBlanca) {
        this.turnoBlanca = turnoBlanca;
    }

    // METODOS
    // METODO QUE CAMBIA DE TURNO
    public void cambiaTurno(){

        // GUARDA SU PROPIO VALOR NEGADO
        this.setTurnoBlanca(!this.turnoBlanca);
    }

    // METODO QUE DEVUELVE SI LA PARTIDA HA ACABADO
    public boolean finalPartida(Tablero tablero) {

        // VARIABLES
        boolean reyBlancasVivo = false;
        boolean reyNegrasVivo = false;
        boolean encontrados = false;

        int i = 0;

        while (!encontrados && i < tablero.getLength()){

            int j = 0;

            while (!encontrados && j < tablero.getLength()){

                if (tablero.getValor(i, j).equals("k"))
                    reyNegrasVivo = true;
                else if (tablero.getValor(i, j).equals("K"))
                    reyBlancasVivo = true;

                encontrados = reyBlancasVivo && reyNegrasVivo;

                j++;
            }
            i++;
        }
        return !encontrados; // si no encuentra los 2 reyes -> final de partida
    }
}
