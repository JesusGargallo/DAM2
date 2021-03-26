package uf6_nf3_activitat2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UF6_NF3_Activitat2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        
        
        String dades;
        String linia;
        FileReader entrada = new FileReader("dades.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Name of the file?");
        dades = sc.nextLine();
        
        
        while((linia = in.readLine()) != null){
            try {
                
            } catch (Exception e){
                
            }
        }
        
        
        
    }
    
}
