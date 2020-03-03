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
public class Socios {
    private int idsocios;
    private String dni;
    private String nombre;

    public Socios(int idsocios, String dni, String nombre) {
        this.idsocios = idsocios;
        this.dni = dni;
        this.nombre = nombre;
    }

    
    
    public int getIdsocios() {
        return idsocios;
    }

    public void setIdsocios(int idsocios) {
        this.idsocios = idsocios;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
