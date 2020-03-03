/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import ClasesPOJO.Socios;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lv1013
 */
public class SociosRepository extends BaseRepository<Socios>{
     private Statement st;
     private ResultSet rs;
    
       private void setStatement(Connection c){
        try {
            st = c.createStatement();
        } catch (SQLException e) {
        }

        
    }
    @Override
    public void agregar(Socios a) {
        try {
               st.executeUpdate("INSERT INTO socios (nombre,dni) VALUES ('"+a.getNombre()+"','"+a.getDni()+"')");
               st.close();
        } catch (SQLException e) {
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void eliminar(Socios a) {
        try {
               st.executeUpdate("DELETE FROM socios WHERE nombre ='"+a.getNombre()+"',dni ='"+a.getDni()+"'");
               st.close();
        } catch (SQLException e) {
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Socios a) {
          try {
               st.executeUpdate("UPDATE socios SET nombre ='"+a.getNombre()+"',dni ='"+a.getDni()+"' WHERE idsocios ="+a.getIdsocios());
               st.close();
        } catch (SQLException e) {
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Socios buscarPorId(Socios a) {
        
         try {
             rs = st.executeQuery("SELECT * FROM socios WHERE idsocios ="+a.getIdsocios());
               Socios  s = new Socios(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3)); 
               st.close();
               return s;
        } catch (SQLException e) {
        }
         
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Socios> mostrarTodas() {
        try {
            rs = st.executeQuery("SELECT * FROM socios");
            List<Socios> lista= new ArrayList<Socios>(); 
            
            while (rs.next()) {                
                lista.add(new Socios(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3)));
            }
            return lista;
            
        } catch (SQLException e) {
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
