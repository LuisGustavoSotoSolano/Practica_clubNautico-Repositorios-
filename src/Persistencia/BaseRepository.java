/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;

/**
 *
 * @author lv1013
 * @param <T>
 */
public abstract class BaseRepository<T> {
 
    public abstract void agregar(T a);
    public abstract void eliminar(T a);
    public abstract void actualizar(T a);
    public abstract T buscarPorId(T a); 
    
    public abstract List<T> mostrarTodas();
    
    
}
