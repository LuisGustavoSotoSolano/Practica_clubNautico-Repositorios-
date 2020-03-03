/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author labcisco
 */
public class MenuSocios extends javax.swing.JFrame {
String cadenaConexion = "jdbc:mysql://localhost/club_nautico";
Connection conexion;
DefaultTableModel model = new DefaultTableModel();
String mirarTodo = "SELECT * FROM socios";
Statement st;
ResultSet result;


public void eliminar(){
    
        DefaultTableModel tb = (DefaultTableModel) jTable2.getModel();
        int a = jTable2.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
        tb.removeRow(tb.getRowCount()-1);
        }
        //cargaTicket();
    }
    /**
     * Creates new form MenuSocios
     */

    private void hacerTabla() {
        String[] dato = new String[3];
        try {
            st = conexion.createStatement();
            result = st.executeQuery(mirarTodo);
            while (result.next()) {
                System.out.println(result.getString(3));
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);

                model.addRow(dato);
        
            }
                    st.close();
        } catch (SQLException e) {
        }

    }

    private void hacerTablaNombre(String s) {
        String[] dato = new String[3];
//     System.out.println(s);
        String query = "SELECT * FROM socios WHERE nombre='" + s + "'";
        if (s == "") {
            JOptionPane.showMessageDialog(null, "Escriba un nombre en el campo de texto");
        } else {
            try {

                st = conexion.createStatement();

                result = st.executeQuery(query);
                while (result.next()) {
                    System.out.println(result.getString(3));
                    dato[0] = result.getString(1);
                    dato[1] = result.getString(2);
                    dato[2] = result.getString(3);
                    model.addRow(dato);
                }
                st.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
    private void hacerTablaDNI(String s) {
        String[] dato = new String[3];
//     System.out.println(s);
        String query = "SELECT * FROM socios WHERE dni='" + s + "'";
        if (s == "") {
            JOptionPane.showMessageDialog(null, "Escriba un nombre en el campo de texto");
        } else {
            try {

                st = conexion.createStatement();

                result = st.executeQuery(query);
                while (result.next()) {
                    System.out.println(result.getString(3));
                    dato[0] = result.getString(1);
                    dato[1] = result.getString(2);
                    dato[2] = result.getString(3);
                    model.addRow(dato);
           
                }
                         st.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
    private void hacerTablaIdSocio(int s) {
        String[] dato = new String[3];
//     System.out.println(s);
        String query = "SELECT * FROM socios WHERE idsocios=" + s;

        try {

            st = conexion.createStatement();

            result = st.executeQuery(query);
            while (result.next()) {
                System.out.println(result.getString(3));
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                model.addRow(dato);
           
            }
                 st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
  
   private boolean verificarDNI(String dni){
       boolean sos =false;
       for (int i = 0; i < jTable2.getModel().getRowCount(); i++) {
           if (dni.equalsIgnoreCase(jTable2.getModel().getValueAt(i, 1).toString())) {
            
               sos =  true;
           }
                   }
      
       return sos;      

   }


    public MenuSocios() {
        try{
        conexion = DriverManager.getConnection(cadenaConexion, "root", "1234");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
//        hacerTabla();
        initComponents();
        this.setLocationRelativeTo(null);
        hacerTabla();
        verificarDNI(mirarTodo);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textoID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textoDNI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        textoBuscar = new javax.swing.JTextField();
        cboFiltros = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        botonEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        textoID.setEditable(false);

        jLabel2.setText("DNI");

        jLabel3.setText("Nombre");

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        cboFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Nombre", "DNI", "idSocio" }));
        cboFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFiltrosActionPerformed(evt);
            }
        });

        jLabel4.setText("Buscar por");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        model.addColumn("idSocio");
        model.addColumn("DNI");
        model.addColumn("nombre");
        jTable2.setModel(model);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Menu de socios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(botonGuardar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(botonVolver)
                        .addGap(125, 125, 125))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textoDNI)
                                    .addComponent(textoID, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(botonActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(botonEliminar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(39, 39, 39)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonGuardar)
                            .addComponent(botonActualizar)
                            .addComponent(botonEliminar))
                        .addGap(71, 71, 71)
                        .addComponent(botonVolver))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFiltrosActionPerformed
        // TODO add your handling code here:

        String seleccion = cboFiltros.getSelectedItem().toString();
        switch (seleccion){
            case "Todo":
                try {
                    eliminar();
                    hacerTabla();
                } catch (Exception e) {
                }
            break;
            case "Nombre":
                eliminar();
                hacerTablaNombre(textoBuscar.getText());
                
            break;
            case "DNI":
                eliminar();
                hacerTablaDNI(textoBuscar.getText());
            break;
            case "idSocio":
                eliminar();
                try {
                     hacerTablaIdSocio(Integer.parseInt(textoBuscar.getText()));
                } catch (Exception e) {
                }
               
            break;
        }
        
    }//GEN-LAST:event_cboFiltrosActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        // TODO add your handling code here:
        Inicio i = new Inicio();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:

        String nombre = textoNombre.getText();
        String dni = textoDNI.getText();
        if (!nombre.equalsIgnoreCase("") && !dni.equalsIgnoreCase("")) {
            if (!verificarDNI(dni)) {
                try {
                    st = conexion.createStatement();
                    String agregar = "INSERT INTO socios (dni,nombre) VALUES ('" + dni + "','" + nombre + "')";

//        st.execute(agregar);
                    st.executeUpdate(agregar);
                    JOptionPane.showMessageDialog(null, "Se ha agregado con exito");
                    textoDNI.setText(null);
                    textoID.setText(null);
                    textoNombre.setText(null);
                      st.close();
                    eliminar();
                    hacerTabla();
                 
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                botonActualizarActionPerformed(evt);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No ha llenado los campos correctamente");
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // TODO add your handling code here:
        try{
        st = conexion.createStatement();
          int id = Integer.parseInt(textoID.getText());
            String nombre = textoNombre.getText();
           String dni = textoDNI.getText();
          
           String actualizar ="UPDATE socios SET nombre='"+nombre+"',dni= '"+dni+"' WHERE idsocios="+id;
           st.executeUpdate(actualizar);
            JOptionPane.showMessageDialog(null, "Se ha actualizado con exito");
            textoDNI.setText(null);
            textoID.setText(null);
            textoNombre.setText(null);
              st.close();
            eliminar();
            hacerTabla();
           
           }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        try {
            int fila = jTable2.getSelectedRow();
            textoID.setText(jTable2.getModel().getValueAt(fila,0).toString());
             textoDNI.setText(jTable2.getModel().getValueAt(fila,1).toString());
              textoNombre.setText(jTable2.getModel().getValueAt(fila,2).toString());
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
         try{
        st = conexion.createStatement();
          int id = Integer.parseInt(textoID.getText());
          
           String eliminar ="DELETE FROM socios WHERE idsocios="+id;
           st.executeUpdate(eliminar);
            JOptionPane.showMessageDialog(null, "Se ha eliminado con exito");
            textoDNI.setText(null);
            textoID.setText(null);
            textoNombre.setText(null);
              st.close();
            eliminar();
            hacerTabla();
        
           }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuSocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuSocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuSocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuSocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuSocios().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonVolver;
    private javax.swing.JComboBox<String> cboFiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField textoBuscar;
    private javax.swing.JTextField textoDNI;
    private javax.swing.JTextField textoID;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
}
