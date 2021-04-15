package ex1_m6_uf4;


import ElsMeusBeans.Comanda;
import ElsMeusBeans.Producte;

public class Ex1_m6_uf4 {

    
    public static void main(String[] args) {
        
        //array de productos
        Producte[] producte = new Producte[6];
        
        
        producte[0] = new Producte(1," PS3",100,10,50);
        producte[1] = new Producte(2," PS4",200,10,50);
        producte[2] = new Producte(3," SWITCH",300,20,50);
        producte[3] = new Producte(4," PS5",20,4,50);
        producte[4] = new Producte(5," XBOX360",20,5,50);
        producte[5] = new Producte(6," PC",1000,100,50);
        
        //creo el pedido
        Comanda comanda = new Comanda();
        
        for (int i = 0; i < producte.length; i++){
        
        producte[i].addPropertyChangeListener(comanda);
        producte[i].setStockactual(2);
        if(comanda.isDemana()){
            System.out.println("Fer comanda en producte" + producte[i].getDescripcio());
        }
        else {
            System.out.println("No es necessari fer la comanda en producte" + producte[i].getDescripcio());
        }
            
        
        }
    }
    
}
