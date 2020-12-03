package exercicio8;

import java.awt.Point;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.*;
import java.util.*;

public class Exercicio8 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        boolean preguntando = true,isNegro, isdiscapacitado;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String marca, nombre, dia, nacimiento;
        int añoModelo, añosdecarnet,siguepreguntando,menunaso;
        
        
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("$objectdb/db/Exercicio8.odb");
        EntityManager em = emf.createEntityManager();

        
        //los datos de los propietarios.
        System.out.println("Introduce el primer propietario");
        em.getTransaction().begin();
        while(preguntando == true){
            System.out.println("Nombre:");
            nombre = sc.nextLine();
            
            System.out.println("Cuantos años de carnet tienes:");
            añosdecarnet = sc.nextInt();
            
            System.out.println("Nacimiento:");
            nacimiento = sc.next();
            Date nacimientoE = sdf.parse(nacimiento);
            
            System.out.println("Es Discapacitado? ");
            isdiscapacitado = sc.nextBoolean();
            
            
            Propietaris pro;
            pro = new Propietaris
            (nombre,añosdecarnet,nacimientoE,isdiscapacitado);
            
            em.persist(pro);
            
            // aqui preguntamos si quieres poner otro propietario.
            System.out.println("Hay un otro propietario? 1-SI / 2-NO ");
            siguepreguntando = sc.nextInt();
            sc.nextLine();
            
            //si dice que si volvemos a preguntar los datos de otro propietario.
            if(siguepreguntando == 1){
                preguntando = true;
            } else {
                preguntando = false;
            } 
        }
        
        
        preguntando = true;
        
        //  aqui ponemos los datos de los vehiculos.
        System.out.println("Introduce el primer coche");
        while(preguntando == true){
            System.out.println("Marca:");
            marca = sc.nextLine();
            
            System.out.println("Año del modelo:");
            añoModelo = sc.nextInt();
            
            System.out.println("Dia de salida del coche:");
            dia = sc.next();
            Date diaE = sdf.parse(dia);
            
            System.out.println("Es negro? ");
            isNegro = sc.nextBoolean();
            
            Vehicles veh;
            veh = new Vehicles
            (marca,añoModelo,diaE,isNegro);
            
            em.persist(veh);
            
            // aqui preguntamos si quieres poner otro coche.
            System.out.println("Hay un otro coche? 1-SI / 2-NO ");
            siguepreguntando = sc.nextInt();
            sc.nextLine();
            
            //si dice que si volvemos a preguntar los datos de otro coche.
            if(siguepreguntando == 1){
                preguntando = true;
            } else {
                preguntando = false;
            } 
        }
        
        em.getTransaction().commit();
        preguntando = true;
        
        while(preguntando == true){
            //aqui escogemos si listar los propietarios o los coches.
            System.out.println("1-Listar propietarios \n 2-Listar coches");
            menunaso = sc.nextInt();
            
            
           if(menunaso == 1){
               //si escogemos el 1 hara esto.
                TypedQuery<Propietaris> query =
                em.createQuery("SELECT pro FROM Propietaris pro", Propietaris.class);
                List<Propietaris> results = query.getResultList();
                for (Propietaris pro : results) {
                    System.out.println(pro);
                }  
           } else {
               //si escogemos el 2 hara esto.
               TypedQuery<Vehicles> query =
                em.createQuery("SELECT veh FROM Vehicles veh", Vehicles.class);
                List<Vehicles> results = query.getResultList();
                for (Vehicles veh : results) {
                    System.out.println(veh);
                } 
           }
           
           //aqui ponemos si quieres continuar si no quieres continuar 
           //acabara el progrma.
           System.out.println("Quieres continuar 1-SI / 2-NO");
           siguepreguntando = sc.nextInt();
           sc.nextLine();
           
           if(siguepreguntando == 1){
               preguntando = true;
           } else {
               preguntando = false;
           }
        }
        
        

        // Close the database connection:
        em.close();
        emf.close();
    }
}
