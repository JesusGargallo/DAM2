package uf1m6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumne
 */

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlRootElement

public class Directori {

    private Fitxer[] directori;
    private String ruta;

    public Directori() {
    }

    public Directori(Fitxer[] directori, String ruta) {
        this.directori = directori;
        this.ruta = ruta;
    }

    public Fitxer[] getDirectori() {
        return directori;
    }

    public void setDirectori(Fitxer[] directori) {
        this.directori = directori;
    }
    
    @XmlAttribute(name="ruta")  
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    
}
