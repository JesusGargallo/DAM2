package exercicio8;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Propietaris implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    private long id;

    private int añosdecarnet;
    private String nombre;
    private Date nacimiento;
    private boolean isdiscapacitado;

    public Propietaris(){
    }

    Propietaris(String nombre, int añosdecarnet, Date nacimiento, boolean isdiscapacitado){
        this.nombre = nombre;
        this.añosdecarnet = añosdecarnet;
        this.nacimiento = nacimiento;
        this.isdiscapacitado = isdiscapacitado;

    }

    public Long getId() {
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public int getAñosdeCarnet(){
        return añosdecarnet;
    }

    public Date getNacimiento(){
        return nacimiento;
    }

    public boolean getIsDiscapacitado(){
        return isdiscapacitado;
    }

    @Override
    public String toString() {
        return "Propietaris{" + "id=" + id + 
                ", a\u00f1osdecarnet=" + añosdecarnet + 
                ", nombre=" + nombre + ", nacimiento=" + nacimiento + 
                ", isdiscapacitado=" + isdiscapacitado + '}';
    }

    


}
