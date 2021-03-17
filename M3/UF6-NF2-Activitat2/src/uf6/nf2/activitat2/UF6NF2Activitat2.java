package uf6.nf2.activitat2;

import java.util.Scanner;


public class UF6NF2Activitat2 {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);    
    
    calcul(1,13);
    }
    
    public static void calcul (int fila, int pedres){
        if (fila == pedres){
            System.out.println("Fila: " + fila + ", Sobra: " + 0);
            
        } else if (fila > pedres){
            System.out.println("Fila: " + (fila -1) + ", Sobra: " + pedres);
            
        }else if (fila < pedres){
            calcul(fila + 1, pedres - fila);
        }
    }
    
}


