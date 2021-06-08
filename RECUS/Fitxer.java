package uf1m6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.xml.bind.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "directori")
        
class Fitxer {
    

    private String nom;
    private long darreraModificacio;
    private String isDirectory;
    private long size;

    public Fitxer() {
    }

    public Fitxer(String nom, long darreraModificacio, String isDirectory, long size) {
        this.nom = nom;
        this.darreraModificacio = darreraModificacio;
        this.isDirectory = isDirectory;
        this.size = size;
    }
    
    @XmlAttribute(name="nom")     
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    @XmlAttribute(name="darreraModificacio")     
    public long getDarreraModificacio() {
        return darreraModificacio;
    }

    public void setDarreraModificacio(long darreraModificacio) {
        this.darreraModificacio = darreraModificacio;
    }

    @XmlAttribute(name="isDirectory")     
    public String getIsDirectory() {
        return isDirectory;
    }

    public void setIsDirectory(String isDirectory) {
        this.isDirectory = isDirectory;
    }

    @XmlAttribute(name="size")    
    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    
    
    

}
