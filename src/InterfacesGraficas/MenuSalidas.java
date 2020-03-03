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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class MenuSalidas extends javax.swing.JFrame {
        String cadenaConexion = "jdbc:mysql://localhost/club_nautico";
    Connection conexion;
DefaultTableModel model = new DefaultTableModel();
    String mirarTodo = "SELECT * FROM salidas";
    Statement st;
    ResultSet result;
    /**
     * Creates new form MenuSalidas
     */
     private void eliminar() {

        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        //cargaTicket();
    }
    private void hacerTabla() {
        String[] dato = new String[4];
        try {
            st = conexion.createStatement();
            result = st.executeQuery(mirarTodo);
            while (result.next()) {
                System.out.println(result.getString(3));
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);

                model.addRow(dato);
            }
              st.close();
        } catch (SQLException e) {
        }

    }
    
    private void hacerTablaIdSalidas(int s){
        String[] dato = new String[4];
//     System.out.println(s);
        String query = "SELECT * FROM salidas WHERE idsalida =" + s;
        try {

            st = conexion.createStatement();

            result = st.executeQuery(query);
            while (result.next()) {
                dato[0] = result.getString(1);
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);

                model.addRow(dato);
            }
              st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void hacerTablaIdBarco(int s){
        String[] dato = new String[4];
//     System.out.println(s);
        String query = "SELECT * FROM salidas WHERE idbarco =" + s;
        try {

            st = conexion.createStatement();

            result = st.executeQuery(query);
            while (result.next()) {
                dato[0] = result.getString(1);
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);

                model.addRow(dato);
            }
              st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void hacerTablaDestino(String s){
         String[] dato = new String[4];
//     System.out.println(s);
        String query = "SELECT * FROM salidas WHERE destino = '" + s+"'";
        try {

            st = conexion.createStatement();

            result = st.executeQuery(query);
            while (result.next()) {
                dato[0] = result.getString(1);
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);

                model.addRow(dato);
            }
              st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void hacerTablaFyH(String s){
        String[] dato = new String[4];
//     System.out.println(s);
        String query = "SELECT * FROM salidas WHERE fechahora = '" + s+"'";
        try {

            st = conexion.createStatement();

            result = st.executeQuery(query);
            while (result.next()) {
                dato[0] = result.getString(1);
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);

                model.addRow(dato);
            }
              st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static boolean validaFecha(String fecha) {
        return fecha.matches("^((((([1-9]{1})|([1-2]{1}[0-9]{1})|(3{1}[0-1]{1}))/(([1|3|5|7|8]{1})|(1{1}[0|2]){1}))|((([1-9]{1})|([1-2]{1}[0-9]{1})|(3{1}0{1}))/(([4|6|9]{1})|(1{1}1{1})))|((([1-9]{1})|([1]{1}[0-9]{1})|[2]{1}[0-8]{1})/2))/[0-9]{1,4})" //Años no bisiestos
                + "|((((([1-9]{1})|([1-2]{1}[0-9]{1})|(3{1}[0-1]{1}))/(([1|3|5|7|8]{1})|(1{1}[0|2]){1}))|((([1-9]{1})|([1-2]{1}[0-9]{1})|(3{1}0{1}))/(([4|6|9]{1})|(1{1}1{1})))|((([1-9]{1})|([1-2]{1}[0-9]{1}))/2))"
                + "/(4{1}|8{1}|((1{1}|3{1}|5{1}|7{1}|9{1})[2|6]{1})|((2{1}|4{1}|6{1}|8{1})[0|4|8]{1})|(([1|2|3|4|5|6|7|8|9]{1})([0|2|4|6|8]{1})([0|4|8]{1}))|(([1|2|3|4|5|6|7|8|9]{1})([1|3|5|7|9]{1})([2|6]{1}))|(([1|2|3|4|5|6|7|8|9]{1})([0|1|2|3|4|5|6|7|8|9]{1})([0|2|4|6|8]{1})([0|4|8]{1}))|(([1|2|3|4|5|6|7|8|9]{1})([0|1|2|3|4|5|6|7|8|9]{1})([1|3|5|7|9]{1})([2|6]{1}))))$"); //Años bisiestos desde el año 4 d.c. al 9996*/
    }
    

    
    public MenuSalidas() {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
//         Calendar cal = Calendar.getInstance();
//        
//        jFormattedTextField1.setText(dateFormat.format(cal.getTime()));
           try{
        conexion = DriverManager.getConnection(cadenaConexion, "root", "1234");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        initComponents();
        this.setLocationRelativeTo(null);
        hacerTabla();
    }

      private ArrayList<String> conseguirIds() {
        ArrayList<String> idsBarcos = new ArrayList<String>();
        try {
            st = conexion.createStatement();
            result = st.executeQuery("SELECT * FROM barcos");

            while (result.next()) {
                System.out.println(result.getString(1));
                idsBarcos.add(result.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        return idsBarcos;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textoSalida = new javax.swing.JTextField();
        textoDestino = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cboFiltros = new javax.swing.JComboBox<>();
        textoBuscr = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboBarcos = new javax.swing.JComboBox<>();
        botonEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textoFyH = new javax.swing.JTextField();
        botonFormato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("idSalida");

        jLabel2.setText("Fecha y hora");

        jLabel3.setText("Destino");

        jLabel4.setText("idBarco");

        textoSalida.setEditable(false);

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        cboFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "idSalida", "Fecha y hora", "Destino", "idBarco" }));
        cboFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFiltrosActionPerformed(evt);
            }
        });

        jLabel5.setText("Buscar por");

        model.addColumn("idSalida");
        model.addColumn("Fecha y hora");
        model.addColumn("Destino");
        model.addColumn("idBarco");

        jTable1.setModel(model);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(textoBuscr, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoBuscr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Menu de Salidas");

        botonFormato.setText("Formato");
        botonFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFormatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoSalida)
                                    .addComponent(textoDestino)
                                    .addComponent(cboBarcos, 0, 175, Short.MAX_VALUE)
                                    .addComponent(textoFyH))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(botonAgregar)))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonVolver)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(botonEliminar)))
                        .addGap(42, 42, 42)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textoFyH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboBarcos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAgregar)
                            .addComponent(botonActualizar)
                            .addComponent(botonEliminar))
                        .addGap(59, 59, 59)
                        .addComponent(botonVolver))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        ArrayList ids  = conseguirIds();
        for (int i = 0; i<ids.size();i++){
            cboBarcos.addItem(ids.get(i).toString());

        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        // TODO add your handling code here:
        Inicio i = new Inicio();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
               
        
         String fechahora = textoFyH.getText();
                String destino = textoDestino.getText();
        if (!destino.equalsIgnoreCase("")&& !fechahora.equalsIgnoreCase("")) {
             
                 try {
             int idbarco = Integer.parseInt(cboBarcos.getSelectedItem().toString());
            st = conexion.createStatement();
     
           String agregar = "INSERT INTO salidas (fechahora,destino,idbarco) VALUES ('" + fechahora + "','" + destino + "'," + idbarco+ ")";

            st.executeUpdate(agregar);
            JOptionPane.showMessageDialog(null, "Se ha agregado con exito");
            textoDestino.setText("");
            textoFyH.setText("");
            textoSalida.setText("");
              st.close();
            eliminar();
            hacerTabla();
          
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            
        } else {
            JOptionPane.showMessageDialog(null, "Llena los campos correctamente");  
        }
        
        
        
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        try{
        st = conexion.createStatement();
          int id = Integer.parseInt(textoSalida.getText());
          
           String eliminar ="DELETE FROM salidas WHERE idsalida="+id;
           st.executeUpdate(eliminar);
            JOptionPane.showMessageDialog(null, "Se ha eliminado con exito");
            textoSalida.setText(null);
            textoDestino.setText(null);
            textoBuscr.setText(null);
              st.close();
            eliminar();
            hacerTabla();
        
           }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         int fila = jTable1.getSelectedRow();
            textoSalida.setText(jTable1.getModel().getValueAt(fila, 0).toString());
            textoFyH.setText(jTable1.getModel().getValueAt(fila, 1).toString());
            textoDestino.setText(jTable1.getModel().getValueAt(fila, 2).toString());
                   cboBarcos.setSelectedItem(jTable1.getValueAt(fila, 3).toString());
            
    }//GEN-LAST:event_jTable1MouseClicked

    private void cboFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFiltrosActionPerformed
        // TODO add your handling code here:
          eliminar();
        String seleccion = cboFiltros.getSelectedItem().toString();
        switch (seleccion) {
            case "Todo":
                hacerTabla();
                break;
            case "idSalida":
                try {
                    hacerTablaIdSalidas(Integer.parseInt(textoBuscr.getText()));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;
            case "Fecha y hora":

                hacerTablaFyH(textoBuscr.getText());
                break;
            case "Destino":
                hacerTablaDestino(textoBuscr.getText());
                break;
            case "idBarco":
                try{
                     hacerTablaIdBarco(Integer.parseInt(textoBuscr.getText()));
                } catch(Exception e){
                    System.out.println(e.getMessage());
                }
               
                break;
          
        }
        
        
        
    }//GEN-LAST:event_cboFiltrosActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        if (!textoDestino.getText().equalsIgnoreCase("") && !textoFyH.getText().equalsIgnoreCase("") && !textoSalida.getText().equalsIgnoreCase("")) {
             try {
            st = conexion.createStatement();
            String fechahora = textoFyH.getText();
            String destino = textoDestino.getText();
            int idBarco = Integer.parseInt(cboBarcos.getSelectedItem().toString());
            int id = Integer.parseInt(textoSalida.getText());
          

            String actualizar = "UPDATE salidas SET fechahora ='" + fechahora + "',destino ='" + destino + "',idbarco =" + idBarco + " WHERE idsalida= " + id;
            st.executeUpdate(actualizar);
            JOptionPane.showMessageDialog(null, "Se ha actualizado con exito");
            textoDestino.setText(null);
            textoFyH.setText(null);
            textoSalida.setText(null);
            st.close();
            eliminar();
            hacerTabla();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        } else {
              JOptionPane.showMessageDialog(null, "No estan llenos todos los campos");
        }
       
        
        
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFormatoActionPerformed
        // TODO add your handling code here:
        textoFyH.setText("aaaa-mm-dd hr:min:seg.m");
    }//GEN-LAST:event_botonFormatoActionPerformed

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
            java.util.logging.Logger.getLogger(MenuSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuSalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuSalidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonFormato;
    private javax.swing.JButton botonVolver;
    private javax.swing.JComboBox<String> cboBarcos;
    private javax.swing.JComboBox<String> cboFiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textoBuscr;
    private javax.swing.JTextField textoDestino;
    private javax.swing.JTextField textoFyH;
    private javax.swing.JTextField textoSalida;
    // End of variables declaration//GEN-END:variables
}
