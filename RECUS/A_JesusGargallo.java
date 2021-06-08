package uf1m6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import uf1m6.Directori;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Ayman
 */
public class A_JesusGargallo{

    
    
    public static void main(String[] args) throws TransformerException, SAXException, IOException, ParserConfigurationException, JAXBException {

        File nomCarpeta;
        String nomFitxer;
        
        Scanner scanner = new Scanner(System.in);
        String directoriooo = scanner.nextLine();
        
        
        
        nomFitxer = scanner.nextLine();
        nomCarpeta = new File(directoriooo);

        
        if (nomCarpeta.exists() && nomCarpeta.isDirectory()) {

            JAXBContext context = JAXBContext.newInstance(Directori.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Cridem a la funcio per omplir XML
            Directori directori = ompleDirectori(nomCarpeta);

            //Mostrem el document XML generat por la sortida estandard
            marshaller.marshal(directori, System.out);

            FileOutputStream fos = new FileOutputStream(nomFitxer + ".xml");
            //guardem l'objecte serializat en un document XML
            marshaller.marshal(directori, fos);
            fos.close();

        } else {
            System.out.println("La carpeta no existe");
        }

    }

    // generem dades de prova
    private static Directori ompleDirectori(File nomCarpeta) {

        Fitxer[] arxius = new Fitxer[nomCarpeta.list().length];
        String[] nomArxius = nomCarpeta.list();

        // Treiem per pantalla els noms dels arxius
        for (int i = 0; i < arxius.length; i++) {
            File file = new File(nomArxius[i]);
            arxius[i] = new Fitxer();
            arxius[i].setNom(file.getName());
            arxius[i].setDarreraModificacio(file.lastModified());
            
            if (file.isDirectory()) {
                arxius[i].setIsDirectory("si");
                arxius[i].setSize(file.length());
            }else{
                arxius[i].setIsDirectory("no");
            }

            System.out.println(arxius[i]);
        }

        Directori directori = new Directori();
        directori.setDirectori(arxius);

        return directori;
    }

}
