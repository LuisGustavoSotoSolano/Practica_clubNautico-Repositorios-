/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class MenuBarcos extends javax.swing.JFrame {

    String cadenaConexion = "jdbc:mysql://localhost/club_nautico";
    Connection conexion;
    DefaultTableModel model = new DefaultTableModel();
    //Necesita mejoras
    String mirarTodo = "SELECT * FROM barcos INNER JOIN socios on barcos.idsocio = socios.idsocios";
    Statement st;
    ResultSet result;

    /**
     * Creates new form MenuBarcos
     */

    private ArrayList<String> conseguirIds() {
        ArrayList<String> idsSocios = new ArrayList<String>();
        try {
            st = conexion.createStatement();
            result = st.executeQuery("SELECT * FROM socios");

            while (result.next()) {
                //System.out.println(result.getString(6));
                idsSocios.add(result.getString(3));
            }
              st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idsSocios;
    }
    

    private void eliminar() {

        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        //cargaTicket();
    }

    private void hacerTabla() {
        String[] dato = new String[7];
        try {
            st = conexion.createStatement();
            result = st.executeQuery(mirarTodo);
           
            while (result.next()) {
                System.out.println(result.getString(3));
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);
                dato[4] = result.getString(5);
                dato[5] = result.getString(9);
                dato[6] = result.getString(6);
                model.addRow(dato);
            }
              st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void hacerTablaIdSocio(int s) {
        String[] dato = new String[7];
//     System.out.println(s);
        String query = "SELECT * FROM barcos INNER JOIN socios on barcos.idsocio = socios.idsocios WHERE idsocio=" + s;

        try {

            st = conexion.createStatement();

            result = st.executeQuery(query);
            while (result.next()) {
                System.out.println(result.getString(3));
                  dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);
                dato[4] = result.getString(5);
                dato[5] = result.getString(9);
                dato[6] = result.getString(6);
                model.addRow(dato);
            }
              st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void hacerTablaIdBarco(int s) {
        String[] dato = new String[7];
//     System.out.println(s);
        String query = "SELECT * FROM barcos INNER JOIN socios on barcos.idsocio = socios.idsocios WHERE idbarco =" + s;

        try {

            st = conexion.createStatement();

            result = st.executeQuery(query);
            while (result.next()) {
 dato[0] = result.getString(1);
            dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);
                dato[4] = result.getString(5);
                dato[5] = result.getString(9);
                dato[6] = result.getString(6);
                model.addRow(dato);
            }
              st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void hacerTablaNumAmarre(int s) {
        String[] dato = new String[7];
//     System.out.println(s);
        String query = "SELECT * FROM barcos INNER JOIN socios on barcos.idsocio = socios.idsocios WHERE numamarre=" + s;

        try {

            st = conexion.createStatement();

            result = st.executeQuery(query);
            while (result.next()) {
             dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);
                dato[4] = result.getString(5);
                dato[5] = result.getString(9);
                dato[6] = result.getString(6);
                model.addRow(dato);
            }
              st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void hacerTablaCuota(float s) {
        String[] dato = new String[7];
//     System.out.println(s);
        String query = "SELECT * FROM barcos INNER JOIN socios on barcos.idsocio = socios.idsocios WHERE cuota=" + s;

        try {

            st = conexion.createStatement();

            result = st.executeQuery(query);
            while (result.next()) {
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);
                dato[4] = result.getString(5);
                dato[5] = result.getString(9);
                dato[6] = result.getString(6);
                model.addRow(dato);
            }
              st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void hacerTablaMatricula(String s) {
        String[] dato = new String[7];
//     System.out.println(s);
        String query = "SELECT * FROM barcos INNER JOIN socios on barcos.idsocio = socios.idsocios WHERE matricula= '" + s + "'";
        if (s == "") {
            JOptionPane.showMessageDialog(null, "Escriba un nombre en el campo de texto");
        } else {
            try {

                st = conexion.createStatement();

                result = st.executeQuery(query);
                while (result.next()) {
           dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);
                dato[4] = result.getString(5);
                dato[5] = result.getString(9);
                dato[6] = result.getString(6);
                    model.addRow(dato);
                }
                  st.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void hacerTablaNombre(String s) {
        String[] dato = new String[7];
        String query = "SELECT * FROM barcos INNER JOIN socios on barcos.idsocio = socios.idsocios WHERE barcos.nombre='" + s + "'";
        if (s == "") {
            JOptionPane.showMessageDialog(null, "Escriba un nombre en el campo de texto");
        } else {
            try {

                st = conexion.createStatement();

                result = st.executeQuery(query);
                while (result.next()) {
               dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(3);
                dato[3] = result.getString(4);
                dato[4] = result.getString(5);
                dato[5] = result.getString(9);
                dato[6] = result.getString(6);
                    model.addRow(dato);
                }
                  st.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
    
     private boolean verificarMatricula(String matricula){
       boolean sos =false;
       for (int i = 0; i < jTable1.getModel().getRowCount(); i++) {
           if (matricula.equalsIgnoreCase(jTable1.getModel().getValueAt(i, 1).toString())) {
                           sos =  true;
           }
                   }
      
       return sos;      

   }
     
     private int obtenerID(String s){
         int idSocio = -1;
         try {
             st = conexion.createStatement();
            result = st.executeQuery("SELECT * FROM socios WHERE nombre = '"+cboSocios.getSelectedItem().toString()+"'");
            result.next();
            idSocio = Integer.parseInt(result.getString(1));
            result.close();
            st.close();
            return idSocio;
         } catch (SQLException e) {
             e.printStackTrace();
         }
          return idSocio;
     }
     
     private boolean verificarCamposTexto(String matricula,String nombreB,String mamarre,String cuota){
         boolean sos = !matricula.equalsIgnoreCase("") && !nombreB.equalsIgnoreCase("") && !mamarre.equalsIgnoreCase("") && !cuota.equalsIgnoreCase("");
         return sos;
     }

    public MenuBarcos() {
        try {
            conexion = DriverManager.getConnection(cadenaConexion, "root", "1234");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        initComponents();
        this.setLocationRelativeTo(null);
        hacerTabla();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textoMatricula = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoAmarre = new javax.swing.JTextField();
        textoCuota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textoIdBarco = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        textoBuscar = new javax.swing.JTextField();
        cboFiltros = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cboSocios = new javax.swing.JComboBox<>();
        botonEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Matricula");

        jLabel2.setText("Nombre");

        jLabel3.setText("# Amarre");

        jLabel4.setText("Cuota");

        jLabel5.setText("Socio");

        textoAmarre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoAmarreKeyTyped(evt);
            }
        });

        textoCuota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoCuotaKeyTyped(evt);
            }
        });

        jLabel6.setText("idBarco");

        textoIdBarco.setEditable(false);

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

        cboFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "idBarco", "Matricula", "Nombre", "# Amarre", "Cuota", "idSocio" }));
        cboFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFiltrosActionPerformed(evt);
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

        jLabel7.setText("Buscar por");

        model.addColumn("idBarco");
        model.addColumn("Matricula");
        model.addColumn("Nombre");
        model.addColumn("# Amarre");
        model.addColumn("Cuota");
        model.addColumn("Socio");
        model.addColumn("idSocio");
        jTable1.setModel(model);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(11, 11, 11)))
                        .addGap(43, 43, 43)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Menu de barcos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(textoNombre))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(textoAmarre)
                                                .addComponent(textoCuota)
                                                .addComponent(cboSocios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel1))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(textoMatricula)
                                                .addComponent(textoIdBarco, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(botonAgregar)
                                        .addGap(41, 41, 41)
                                        .addComponent(botonActualizar)))
                                .addGap(86, 86, 86)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonEliminar)
                                    .addComponent(botonVolver)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textoIdBarco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textoAmarre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textoCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboSocios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAgregar)
                            .addComponent(botonActualizar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(botonVolver)
                .addGap(36, 36, 36))
        );

        ArrayList ids  = conseguirIds();
        for (int i = 0; i<ids.size();i++){
            cboSocios.addItem(ids.get(i).toString());

        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        // TODO add your handling code here:
        Inicio i = new Inicio();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void cboFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFiltrosActionPerformed
        // TODO add your handling code here:
        eliminar();
        String seleccion = cboFiltros.getSelectedItem().toString();
        switch (seleccion) {
            case "Todo":
                hacerTabla();
                break;
            case "idBarco":
                try {
                    hacerTablaIdBarco(Integer.parseInt(textoBuscar.getText()));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;
            case "Matricula":
                hacerTablaMatricula(textoBuscar.getText());
                break;
            case "Nombre":
                hacerTablaNombre(textoBuscar.getText());
                break;
            case "# Amarre":
                try{
                     hacerTablaNumAmarre(Integer.parseInt(textoBuscar.getText()));
                } catch(Exception e){
                    System.out.println(e.getMessage());
                }
               

                break;
            case "Cuota":
                try {
                        hacerTablaCuota((float) Integer.parseInt(textoBuscar.getText()));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            
                break;
            case "idSocio":
                try {
                       hacerTablaIdSocio(Integer.parseInt(textoBuscar.getText()));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
             
                break;
        }
    }//GEN-LAST:event_cboFiltrosActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            int fila = jTable1.getSelectedRow();
            textoIdBarco.setText(jTable1.getModel().getValueAt(fila, 0).toString());
            textoMatricula.setText(jTable1.getModel().getValueAt(fila, 1).toString());
            textoAmarre.setText(jTable1.getModel().getValueAt(fila, 3).toString());
            textoNombre.setText(jTable1.getModel().getValueAt(fila, 2).toString());
            textoCuota.setText(jTable1.getModel().getValueAt(fila, 4).toString());
            cboSocios.setSelectedItem(jTable1.getValueAt(fila, 5).toString());

            // textoIdSocio.setText(jTable1.getModel().getValueAt(fila,5).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
      
         String matricula = textoMatricula.getText();
                String nombre = textoNombre.getText();
        if (verificarCamposTexto(matricula, nombre, textoAmarre.getText(), textoCuota.getText())) {
            if (!verificarMatricula(matricula)) {
                 try {
             int idSocio = obtenerID(cboSocios.getSelectedItem().toString());
            st = conexion.createStatement();
     
           
            int numAmarre = Integer.parseInt(textoAmarre.getText());
            float cuota = (float) Integer.parseInt(textoCuota.getText());
            String agregar = "INSERT INTO barcos (matricula,nombre,numamarre,cuota,idsocio) VALUES ('" + matricula + "','" + nombre + "'," + numAmarre + "," + cuota + "," + idSocio + ")";

            st.executeUpdate(agregar);
            JOptionPane.showMessageDialog(null, "Se ha agregado con exito");
            textoAmarre.setText("");
            textoCuota.setText("");
            textoIdBarco.setText("");
            textoMatricula.setText("");
            textoNombre.setText("");
            eliminar();
            hacerTabla();
            st.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            } else {
                System.out.println("Actualizacion");
                botonActualizarActionPerformed(evt);
            }
        
         
        } else {
            JOptionPane.showMessageDialog(null, "Llena los campos correctamente");  
        }
        
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        try {
              int idSocio = obtenerID(cboSocios.getSelectedItem().toString());
            st = conexion.createStatement();
            int id = Integer.parseInt(textoIdBarco.getText());
            String nombre = textoNombre.getText();
            String matricula = textoMatricula.getText();
            int numAmarre = Integer.parseInt(textoAmarre.getText());
            float cuota = (float) Integer.parseInt(textoCuota.getText());
          

            String actualizar = "UPDATE barcos SET matricula ='" + matricula + "',nombre ='" + nombre + "',numamarre =" + numAmarre + ",cuota =" + cuota + ",idsocio =" + idSocio + " WHERE idbarco= " + id;
            st.executeUpdate(actualizar);
            JOptionPane.showMessageDialog(null, "Se ha actualizado con exito");
            textoAmarre.setText(null);
            textoMatricula.setText(null);
            textoCuota.setText(null);
            textoIdBarco.setText(null);
            textoNombre.setText(null);
            eliminar();
            hacerTabla();
              st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        try{
        st = conexion.createStatement();
          int id = Integer.parseInt(textoIdBarco.getText());
          
           String eliminar ="DELETE FROM barcos WHERE idbarco="+id;
           st.executeUpdate(eliminar);
            JOptionPane.showMessageDialog(null, "Se ha eliminado con exito");
            eliminar();
            hacerTabla();
            st.close();
           }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void textoAmarreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoAmarreKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if (Character.isDigit(car)) {

        } else {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_textoAmarreKeyTyped

    private void textoCuotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCuotaKeyTyped
                char car = evt.getKeyChar();
if(Character.isDigit(car)){

}else{
evt.consume();
getToolkit().beep();
}
    }//GEN-LAST:event_textoCuotaKeyTyped

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
            java.util.logging.Logger.getLogger(MenuBarcos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuBarcos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuBarcos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuBarcos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuBarcos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonVolver;
    private javax.swing.JComboBox<String> cboFiltros;
    private javax.swing.JComboBox<String> cboSocios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textoAmarre;
    private javax.swing.JTextField textoBuscar;
    private javax.swing.JTextField textoCuota;
    private javax.swing.JTextField textoIdBarco;
    private javax.swing.JTextField textoMatricula;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
}
