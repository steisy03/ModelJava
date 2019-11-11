package Vistas;

import Service.Modelo;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modulos.Combo;

public class VPersona extends javax.swing.JFrame {

    private final Modelo modelo;
    private int condicion = 1;
    private int codigo = 0;
    private Map<String, Object> map;
    private final DefaultTableModel dModel;
    private String result;

    public VPersona() throws ClassNotFoundException, IOException {
        initComponents();
        modelo = new Modelo();
        dModel = new DefaultTableModel();
        this.generarTabla();
        TPersona.setModel(this.llenarTabla());
        this.llenarCombo();
        TPersona.getColumnModel().getColumn(3).setMaxWidth(0);
        TPersona.getColumnModel().getColumn(4).setMaxWidth(0);
        TPersona.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void limpiar() throws IOException {
        TNombre.setText("");
        TApellido.setText("");
        CActivo.setSelected(false);
        this.condicion = 1;
        this.codigo = 0;
        TNombre.requestFocus();
        TPersona.setModel(this.llenarTabla());
        CTipoPersona.setSelectedItem(new Combo(0, "Seleccione"));
    }

    private void capturarDatos() {
        map = new HashMap<>();
        map.put("id", this.codigo);
        map.put("nombre", TNombre.getText());
        map.put("apellido", TApellido.getText());
        map.put("id_tipo_persona", ((Combo) CTipoPersona.getSelectedItem()).getId());
        map.put("estado", CActivo.isSelected());
    }

    private boolean validar() throws IOException {

        if (TNombre.getText().equals("")) {
            this.message("debe llenar la nombre", "Advertencia");
            return false;
        } else if (this.condicion == 1 && modelo.buscar("get_persona", TNombre.getText()).equals("1")) {
            this.message("el nombre ya existe", "Advertencia");
            return false;
        } else if (TApellido.getText().equals("")) {
            this.message("debe llenar la apellido", "Advertencia");
            return false;
        }
        this.capturarDatos();
        return true;
    }

    /*generar la tabla con todas las caracteristicas*/
    private void generarTabla() {
        dModel.addColumn("#");
        dModel.addColumn("Nombre");
        dModel.addColumn("Apellido");
        dModel.addColumn("estado");
        dModel.addColumn("id_tipo_persona");
        dModel.addColumn("tipo_persona");
    }

    private DefaultTableModel llenarTabla() throws IOException {
        //limpiar modelo
        for (int i = dModel.getRowCount() - 1; i >= 0; i--) {
            dModel.removeRow(i);
        }
        //volver a llenar
        Object[] fila = new Object[6];
        List<Map<String, Object>> list = modelo.buscar("get_persona", "f_persona", new HashMap<>());
        list.stream().forEach(mapsData -> {
            fila[0] = mapsData.get("id");
            fila[1] = mapsData.get("nombre");
            fila[2] = mapsData.get("apellido");
            fila[3] = mapsData.get("estado");
            fila[4] = mapsData.get("id_tipo_persona");
            fila[5] = mapsData.get("tipo_persona");
            dModel.addRow(fila);
        });
        return dModel;
    }

    private void llenarCombo() throws IOException {
        List<Map<String, Object>> list = modelo.buscar("get_tipo_persona", "f_tipo_persona", new HashMap<>());
        CTipoPersona.addItem(new Combo(0, "Seleccione"));
        list.stream().forEach(mapsData -> {
            CTipoPersona.addItem(new Combo(mapsData.get("id"), mapsData.get("descripcion").toString()));
        });
    }

    /*mensajes*/
    private void message(String menssage, String header) {
        JOptionPane.showMessageDialog(null, menssage, header, JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CActivo = new javax.swing.JCheckBox();
        CTipoPersona = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TDireccion1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TDireccion2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        BSalvar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TPersona = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        CActivo.setText("Activo");

        jLabel1.setText("Nombre:");

        jLabel3.setText("Tipo Persna:");

        TNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNombreActionPerformed(evt);
            }
        });

        jLabel2.setText("Apellido:");

        jLabel4.setText("Direccion 1:");

        jLabel5.setText("Direccion 2:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(CActivo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(0, 190, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TDireccion1)
                                    .addComponent(TNombre)
                                    .addComponent(TApellido)
                                    .addComponent(CTipoPersona, 0, 246, Short.MAX_VALUE)
                                    .addComponent(TDireccion2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TDireccion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CActivo)
                .addGap(17, 17, 17))
        );

        jButton3.setText("Salir");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        BSalvar.setText("Salvar");
        BSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BSalvarMouseClicked(evt);
            }
        });
        BSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSalvarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BSalvar)
                        .addComponent(jButton2)))
                .addGap(34, 34, 34))
        );

        TPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Nombre", "Apellido", "Estado"
            }
        ));
        TPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TPersonaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TPersona);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNombreActionPerformed

    }//GEN-LAST:event_TNombreActionPerformed
    /* */
    private void BSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BSalvarMouseClicked
        try {
            if (validar()) {
                if (this.condicion == 1) {
                    result = modelo.crud("crear_persona", map);
                } else {
                    result = modelo.crud("modificar_persona", map);
                }
                if (result.equals("1")) {
                    this.message("Operación realizada correctamente", "Informacion");
                    this.limpiar();
                } else {
                    this.message(result, "Advertencia");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(VPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BSalvarMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try {
            this.limpiar();
        } catch (IOException ex) {
            Logger.getLogger(VPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    private void TPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPersonaMouseClicked
        if (TPersona.getSelectedRow() != -1) {
            this.condicion = 2;
            this.codigo = Integer.parseInt(TPersona.getValueAt(TPersona.getSelectedRow(), 0).toString());
            this.TNombre.setText(TPersona.getValueAt(TPersona.getSelectedRow(), 1).toString());
            this.TApellido.setText(TPersona.getValueAt(TPersona.getSelectedRow(), 2).toString());
            this.CActivo.setSelected((Boolean) TPersona.getValueAt(TPersona.getSelectedRow(), 3));
            this.CTipoPersona.setSelectedItem(new Combo(Integer.parseInt(TPersona.getValueAt(TPersona.getSelectedRow(), 4).toString()),TPersona.getValueAt(TPersona.getSelectedRow(), 5).toString()));
        }
    }//GEN-LAST:event_TPersonaMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BSalvarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            this.limpiar();
        } catch (IOException ex) {
            Logger.getLogger(VPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(VPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VPersona().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(VPersona.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(VPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BSalvar;
    private javax.swing.JCheckBox CActivo;
    private javax.swing.JComboBox<Combo> CTipoPersona;
    private javax.swing.JTextField TApellido;
    private javax.swing.JTextField TDireccion1;
    private javax.swing.JTextField TDireccion2;
    private javax.swing.JTextField TNombre;
    private javax.swing.JTable TPersona;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
