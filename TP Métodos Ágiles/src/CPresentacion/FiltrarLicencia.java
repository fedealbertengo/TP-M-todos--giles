/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CPresentacion;

import CDatos.Conexion;
import CEntidades.ConsultaGenerica;
import CEntidades.Licencia;
import CLogica.GestorLicencia;
import CLogica.GestorUtilidades;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FiltrarLicencia extends javax.swing.JPanel {

    Container menuAnt;
    JFrame jFrame;
    String tituloAnt;
    Dimension dimAnt;
    boolean redimAnt;
    private Licencia licencia = null;
    java.awt.event.WindowAdapter wdAnt;
    java.awt.event.WindowAdapter wd;
    
    public FiltrarLicencia(JFrame frameAnt, Container menAnt, String titAnt, Dimension dim, boolean redAnt, java.awt.event.WindowAdapter wdAnt) {
        initComponents();
        menuAnt = menAnt;
        jFrame = frameAnt;
        tituloAnt = titAnt;
        dimAnt = dim;
        redimAnt = redAnt;
        this.wdAnt = wdAnt;
        configurarParamsJFrame();
        llenarTabla("", "", "", "", "", "", "");
    }

    public void configurarParamsJFrame(){
        jFrame.setResizable(true);
        jFrame.setSize((int)(this.getPreferredSize().getWidth() + 30), (int)(this.getPreferredSize().getHeight() + 50));
        wd = new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                volver();
            }
        };
        jFrame.addWindowListener(wd);
    }
    
    private void volver(){
        jFrame.setContentPane(menuAnt);
        jFrame.setTitle(tituloAnt);
        jFrame.resize(dimAnt);
        jFrame.setResizable(redimAnt);
        jFrame.removeWindowListener(wd);
        jFrame.addWindowListener(wdAnt);
    }
    
    private void llenarTabla(String nroLicencia, String nombre, String apellido, String fechaEmisionIni, String fechaEmisionFin, String fechaExpiracionIni, String fechaExpiracionFin){
        try {
            GestorUtilidades.llenarTablaLicenciasExpiradas(tabLicencias, GestorLicencia.getLicenciasExpiradas(nroLicencia, nombre, apellido, fechaEmisionIni, fechaEmisionFin, fechaExpiracionIni, fechaExpiracionFin));
        }
        catch(IndexOutOfBoundsException ex){
            tabLicencias.setModel(new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                 }
             });
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnFiltrar = new javax.swing.JButton();
        panTitular = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfApellido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfNroLicencia = new javax.swing.JTextField();
        ftfFechaEmisionIni = new javax.swing.JFormattedTextField();
        ftfFechaEmisionFin = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ftfFechaExpiracionIni = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        ftfFechaExpiracionFin = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabLicencias = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        panTitular.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Nombre");

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        jLabel7.setText("Apellido");

        jLabel8.setText("Nro de Licencia");

        ftfFechaEmisionIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        ftfFechaEmisionIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfFechaEmisionIniActionPerformed(evt);
            }
        });

        ftfFechaEmisionFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jLabel1.setText("Fecha Emision");

        jLabel2.setText("Desde:");

        jLabel3.setText("Hasta:");

        jLabel4.setText("Fecha Expiracion");

        jLabel5.setText("Desde:");

        ftfFechaExpiracionIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jLabel9.setText("Hasta:");

        ftfFechaExpiracionFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        javax.swing.GroupLayout panTitularLayout = new javax.swing.GroupLayout(panTitular);
        panTitular.setLayout(panTitularLayout);
        panTitularLayout.setHorizontalGroup(
            panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTitularLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panTitularLayout.createSequentialGroup()
                        .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panTitularLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNroLicencia))
                            .addGroup(panTitularLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ftfFechaEmisionIni, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ftfFechaEmisionFin, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panTitularLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfApellido)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panTitularLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ftfFechaExpiracionIni, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ftfFechaExpiracionFin, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panTitularLayout.setVerticalGroup(
            panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTitularLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNroLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftfFechaEmisionIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfFechaEmisionFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftfFechaExpiracionIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfFechaExpiracionFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panTitular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFiltrar)
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panTitular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFiltrar)
                .addGap(70, 70, 70))
        );

        tabLicencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabLicencias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabLicencias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        llenarTabla(tfNroLicencia.getText(), tfNombre.getText(), tfApellido.getText(), ftfFechaEmisionIni.getText(), ftfFechaEmisionFin.getText(), ftfFechaExpiracionIni.getText(), ftfFechaExpiracionFin.getText());
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void ftfFechaEmisionIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfFechaEmisionIniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftfFechaEmisionIniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JFormattedTextField ftfFechaEmisionFin;
    private javax.swing.JFormattedTextField ftfFechaEmisionIni;
    private javax.swing.JFormattedTextField ftfFechaExpiracionFin;
    private javax.swing.JFormattedTextField ftfFechaExpiracionIni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panTitular;
    private javax.swing.JTable tabLicencias;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfNroLicencia;
    // End of variables declaration//GEN-END:variables
}
