/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_m6_uf4;

import ElsMeusBeans.Producte;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;


public class OmplirProductes {
    public static void main(String[] args) {
        //Obrir la base de dades
        ODB odb = ODBFactory.open("Producte_com.BD");
        
        //Creo un array de 10 productes
        Producte p1 = new Producte(1," PS3",100,10,50);
        Producte p2 = new Producte(2," PS4",200,10,50);
        Producte p3 = new Producte(3," SWITCH",300,20,50);
        Producte p4 = new Producte(4," PS5",20,4,50);
        Producte p5 = new Producte(5," XBOX360",20,5,50);
        Producte p6 = new Producte(6," PC",1000,100,50);
        

        //S'emmagatzema els productes
        odb.store(p1);
        odb.store(p2);
        odb.store(p3);
        odb.store(p4);
        odb.store(p5);
        odb.store(p6);
        
        //Es tanca la base de dades
        odb.close();        
    }  
}
