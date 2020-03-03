/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import ClasesPOJO.Barcos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis
 */

public class BarcosRepository extends BaseRepository<Barcos> {
    private Statement st;
    private  ResultSet rs;

    private void setStatement(Connection c){
        try {
            st = c.createStatement();
        } catch (SQLException e) {
        }

        
    }
    
    
    @Override
    public void agregar(Barcos a) {
        try {
             st.executeUpdate("INSERT INTO barcos (matricula,nombre,numamarre,cuota) VALUES ('"+a.getMatricula()+"','"+a.getNombre()+"'"+a.getNumAmarre()+","+a.getCuota()+")");
               st.close();
        } catch (SQLException e) {
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Barcos a) {
         try {
             st.executeUpdate("DELETE FROM barcos where idbarco ="+a.getIdbarco());
               st.close();
        } catch (SQLException e) {
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Barcos a) {
        try {
             st.executeUpdate("UPDATE barcos SET matricula ='"+a.getMatricula()+"'nombre ='"+a.getNombre()+"numamarre ="+a.getNumAmarre()+"cuota ="+a.getCuota()+"WHERE idbarco ="+a.getIdbarco());
               st.close();
        } catch (SQLException e) {
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Barcos buscarPorId(Barcos a) {
         try {
             rs = st.executeQuery("SELECT * FROM barcos WHERE idsbarco ="+a.getIdbarco());
               Barcos  s = new Barcos(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)),Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(6))); 
               st.close();
               return s;
        } catch (SQLException e) {
        }
         
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Barcos> mostrarTodas() {
           try {
            rs = st.executeQuery("SELECT * FROM barcos");
            List<Barcos> lista= new ArrayList<Barcos>(); 
            
            while (rs.next()) {                
                lista.add(new Barcos(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)),Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(6)))); 
            }
            return lista;
            
        } catch (SQLException e) {
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
