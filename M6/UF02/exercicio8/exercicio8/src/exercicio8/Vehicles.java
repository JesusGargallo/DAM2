package exercicio8;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Vehicles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    private long id;

    private int añoModelo;
    private String marca;
    private Date dia;
    private boolean isNegro;

    public Vehicles(){
    }

    Vehicles(String marca, int añoModelo, Date dia, boolean isNegro){
        this.marca = marca;
        this.añoModelo = añoModelo;
        this.dia = dia;
        this.isNegro = isNegro;

    }

    public Long getId() {
        return id;
    }

    public String getMarca(){
        return marca;
    }

    public int getAñoModelol(){
        return añoModelo;
    }

    public Date getDia(){
        return dia;
    }

    public boolean getIsNegro(){
        return isNegro;
    }

    @Override
    public String toString() {
        return "Vehicles{" + "id=" + id + ", añoModelo=" + añoModelo + ", marca="
                + marca + ", dia=" + dia + ", isNegro=" + isNegro + '}';
    }


}

