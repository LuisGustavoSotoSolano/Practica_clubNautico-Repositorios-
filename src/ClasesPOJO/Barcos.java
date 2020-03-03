/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesPOJO;

/**
 *
 * @author Luis
 */
public class Barcos {
    private int idbarco;
    private String matricula;
    private String nombre;
    private int numAmarre;
    private float cuota;
    private int idSocio;

    public Barcos(int idbarco, String matricula, String nombre, int numAmarre, float cuota, int idSocio) {
        this.idbarco = idbarco;
        this.matricula = matricula;
        this.nombre = nombre;
        this.numAmarre = numAmarre;
        this.cuota = cuota;
        this.idSocio = idSocio;
    }

    
    
    public int getIdbarco() {
        return idbarco;
    }

    public void setIdbarco(int idbarco) {
        this.idbarco = idbarco;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumAmarre() {
        return numAmarre;
    }

    public void setNumAmarre(int numAmarre) {
        this.numAmarre = numAmarre;
    }

    public float getCuota() {
        return cuota;
    }

    public void setCuota(float cuota) {
        this.cuota = cuota;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
    
}
