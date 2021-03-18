package uf3_ex3_m6;

import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.base.*;
import org.xmldb.api.*;
import org.xmldb.api.modules.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Uf3_ex3_m6 {

    static int eleccion = 0;

    static Scanner sc = new Scanner(System.in);

    static String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist

    static Collection col = null; // Colección

    static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db"; //URI colección

    static String usu = "admin"; //Usuario

    static String usuPwd = "alumne"; //Clave

    static XPathQueryService servicio;

    public static void main(String[] args) throws XMLDBException {

        try {
            Class cl = Class.forName(driver); //Cargar del driver

            Database database = (Database) cl.newInstance(); //Instancia de la BD 

            DatabaseManager.registerDatabase(database); //Registro del driver
        } catch (Exception e) {
            System.out.println("Error al inicializar la BD eXist");
            e.printStackTrace();
        }

        col = DatabaseManager.getCollection(URI, usu, usuPwd);
        if (col == null) {
            System.out.println(" *** LA COLECCION NO EXISTE. ***");
        }

        
        servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

        ResourceSet result = servicio.query("for $em in /departamentos return $em");
        // recorrer los datos del recurso.
        ResourceIterator i;
        i = result.getIterator();
        if (!i.hasMoreResources()) {
            System.out.println(" LA CONSULTA NO DEVUELVE NADA.");
        }
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println((String) r.getContent());
        }
        col.close(); //borramos

        while (eleccion != 5) {
            System.out.println("1-INSERTA | 2-BORRAR | 3-MODIFICAR | 4-SALIR");
            eleccion = sc.nextInt();
            if (eleccion == 1) {
                insereixdep();
            } else if (eleccion == 2) {
                esborrardep();
            } else if (eleccion == 3) {
                modificadep();
            } 
        }

    }

    
    public static void insereixdep() throws XMLDBException {
        ResourceSet result;
        String dep = null, nom = null, loca = null;
        int numerodep = 0;

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Que num departamento ");
            numerodep = sc.nextInt();

            System.out.println("Escribe el nombre");
            nom = in.readLine();

            System.out.println("Escribe el localizacion");
            loca = in.readLine();

        } catch (Exception e) {
            System.out.println("ERROR");
        }

        ResourceSet result2 = servicio.query("for $de in /departamentos/DEP_ROW[DEPT_NO= " + numerodep + "] return $de");

        ResourceIterator i;
        i = result2.getIterator();
        if (!i.hasMoreResources()) {
            result = servicio.query("update insert <DEP_ROW><DEPT_NO>" + numerodep + "</DEPT_NO><DNOMBRE>" + nom + "</DNOMBRE><LOC>" + loca + "</LOC></DEP_ROW> into /departamentos");
        } else {
            System.out.println("Ja te mes d'un camp amb aquest departament");
        }

    }

    public static void esborrardep() throws XMLDBException {

        int numerodep = 0;
        System.out.println("Que departamento quieres borrar: ");
        numerodep = sc.nextInt();
        //ResourceSet result = servicio.query ("for $em in /departamentos return $em");
        
        
        ResourceSet result = servicio.query("for $de in /departamentos/DEP_ROW[DEPT_NO= " + numerodep + "] return $de");
        
        
        
        ResourceIterator i;
        i = result.getIterator();
            if (!i.hasMoreResources()) {
                System.out.println("NO PUEDES BORRAR COSAS QUE NO EXISTEN");
            }else {
                result = servicio.query("update delete /departamentos/DEP_ROW[DEPT_NO=" + numerodep + "]");
                System.out.println("Este es el numero de departament que se ha borrado: " + numerodep);
                
            }
    }

    public static void modificadep() throws XMLDBException {
        String nom = null, loca = null;
        int numerodep = 0;

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Que num departamento ");
            numerodep = sc.nextInt();

            System.out.println("Escribe el nuevo nombre");
            nom = in.readLine();

            System.out.println("Escribe el nuevo localizacion");
            loca = in.readLine();

            

        } catch (Exception e) {
            System.out.println("ERROR");
        }
        
        //ResourceSet result2 = servicio.query("for $de in /departamentos/DEP_ROW[DEPT_NO= " + numerodep + "] return $de");
        
        ResourceSet result = servicio.query("update replace /departamentos/DEP_ROW[DEPT_NO=" + numerodep + "]/DNOMBRE with <DNOMBRE>" + nom + "</DNOMBRE>");
        ResourceSet result1 = servicio.query("update replace /departamentos/DEP_ROW[DEPT_NO=" + numerodep + "]/LOC with <LOC>" + nom + "</LOC>");
        
        //ResourceIterator i;
        //i = result2.getIterator();
        //if (!i.hasMoreResources());

        
    }

}
