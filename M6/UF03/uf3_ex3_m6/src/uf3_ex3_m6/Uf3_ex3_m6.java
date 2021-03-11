
package uf3_ex3_m6;

import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.base.*;
import org.xmldb.api.*;
import org.xmldb.api.modules.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Uf3_ex3_m6 {

    
    public static void main(String[] args) throws XMLDBException {
        
        String driver = "org.exist.xmldb.DatabaseImpl";
        Collection col = null;
        String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/empleados";
        String usu = "admin";
        String usuPass = "alumne";
        
        try {
            Class cl = Class.forName(driver);
            Database database = (Database) cl.newInstance();
            DatabaseManager.registerDatabase(database);
            
        } catch (Exception e) {
            System.out.println("Error en inicializar la base de dades de exist");
            e.printStackTrace();
        }
        
        col = DatabaseManager.getCollection(URI,usu,usuPass);
        if (col == null)
            System.out.println("****LA COL·LECCIO NO EXISTEIX****");
        XPathQueryService servei = 
                (XPathQueryService) col.getService("XPathQueryService", "1.0");
        ResourceSet result = 
                servei.query("for $en in /EMPLEADOS/EMP_ROW/[DEPT_NO=20] return $en");
        ResourceIterator i;
        i = result.getIterator();
        if(!i.hasMoreResources())
            System.out.println("LA CONSULTA NO TORNA RES");
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println((String)r.getContent());
        }
        col.close();
        
        
        
    }
    
}
