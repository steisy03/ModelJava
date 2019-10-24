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

        jLabel1 = new javax.swing.JLabel();
        TNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TPersona = new javax.swing.JTable();
        BSalvar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TApellido = new javax.swing.JTextField();
        CActivo = new javax.swing.JCheckBox();
        CTipoPersona = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        TNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNombreActionPerformed(evt);
            }
        });

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

        jLabel2.setText("Apellido:");

        CActivo.setText("Activo");

        jLabel3.setText("Tipo Persna:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TApellido, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                    .addComponent(CActivo)
                    .addComponent(CTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(14, 14, 14)
                        .addComponent(CTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CActivo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BSalvar)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(23, 23, 23))
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
    private javax.swing.JTextField TNombre;
    private javax.swing.JTable TPersona;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
