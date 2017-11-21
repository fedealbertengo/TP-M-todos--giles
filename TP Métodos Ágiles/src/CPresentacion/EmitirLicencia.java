/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CPresentacion;

import CDatos.Conexion;
import CEntidades.Licencia;
import CEntidades.Titular;
import CEntidades.Usuario;
import CLogica.GestorCosto;
import CLogica.GestorLicencia;
import CLogica.GestorTitular;
import CLogica.GestorUsuario;
import java.awt.Container;
import java.awt.Dimension;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author fede_
 */
public class EmitirLicencia extends javax.swing.JPanel {

    Container menuAnt;
    JFrame jFrame;
    String tituloAnt;
    Dimension dimAnt;
    boolean redimAnt;
    private Licencia licencia = null;
    java.awt.event.WindowAdapter wdAnt;
    java.awt.event.WindowAdapter wd;
    Long costoLicencia = new Long(0);

    public EmitirLicencia(JFrame frameAnt, Container menAnt, String titAnt, Dimension dim, boolean redAnt, java.awt.event.WindowAdapter wdAnt) {
        initComponents();
        menuAnt = menAnt;
        jFrame = frameAnt;
        tituloAnt = titAnt;
        dimAnt = dim;
        redimAnt = redAnt;
        this.wdAnt = wdAnt;
        configurarParamsJFrame();
    }
    
    public void configurarParamsJFrame(){
        jFrame.setSize((int)(this.getPreferredSize().getWidth() + 30), (int)(this.getPreferredSize().getHeight() + 50));
        wd = new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                volver();
            }
        };
        jFrame.addWindowListener(wd);
        //vaciar campos
        /*tfIdTitular.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
        tfDocumento.setText("");
        tfFechaExpiracion.setText("");
        licencia = null;
        costoLicencia = new Long(0);
        jLCosto.setText(costoLicencia.toString());*/
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        panTitular = new javax.swing.JPanel();
        cmbTipoDocumento = new javax.swing.JComboBox<>();
        tfDocumento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfApellido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfIdTitular = new javax.swing.JTextField();
        panDetLic = new javax.swing.JPanel();
        cmbClase = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfFechaExpiracion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLCosto = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        panTitular.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CI", "LE", "LC", "PS", "DNI" }));
        cmbTipoDocumento.setEnabled(false);
        cmbTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoDocumentoActionPerformed(evt);
            }
        });

        tfDocumento.setEditable(false);

        jLabel5.setText("Documento");

        jLabel6.setText("Nombre");

        tfNombre.setEditable(false);
        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        tfApellido.setEditable(false);

        jLabel7.setText("Apellido");

        jButton3.setText("Seleccionar Titular");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Nuevo Titular");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Id de Titular");

        tfIdTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdTitularActionPerformed(evt);
            }
        });
        tfIdTitular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfIdTitularKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panTitularLayout = new javax.swing.GroupLayout(panTitular);
        panTitular.setLayout(panTitularLayout);
        panTitularLayout.setHorizontalGroup(
            panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTitularLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panTitularLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfIdTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton3)
                            .addGap(18, 18, 18)
                            .addComponent(jButton4))
                        .addGroup(panTitularLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfApellido))))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panTitularLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5)
                    .addGap(18, 18, 18)
                    .addComponent(tfDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(142, Short.MAX_VALUE)))
        );
        panTitularLayout.setVerticalGroup(
            panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTitularLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfIdTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panTitularLayout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tfDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        panDetLic.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmbClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "E", "G" }));
        cmbClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClaseActionPerformed(evt);
            }
        });

        jLabel1.setText("Clase");

        jLabel2.setText("Fecha de Expiración");

        tfFechaExpiracion.setEditable(false);

        jLabel3.setText("Costo: $");

        jLCosto.setText("x");

        javax.swing.GroupLayout panDetLicLayout = new javax.swing.GroupLayout(panDetLic);
        panDetLic.setLayout(panDetLicLayout);
        panDetLicLayout.setHorizontalGroup(
            panDetLicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetLicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbClase, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfFechaExpiracion, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLCosto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panDetLicLayout.setVerticalGroup(
            panDetLicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDetLicLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panDetLicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tfFechaExpiracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLCosto))
                .addContainerGap())
        );

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panDetLic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panTitular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panDetLic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void volver(){
        jFrame.setContentPane(menuAnt);
        jFrame.setTitle(tituloAnt);
        jFrame.resize(dimAnt);
        jFrame.setResizable(redimAnt);
        jFrame.removeWindowListener(wd);
        jFrame.addWindowListener(wdAnt);
    }
    
    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        volver();
    }//GEN-LAST:event_btnVolverMouseClicked

    private void cmbTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoDocumentoActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.jFrame.removeWindowListener(wd);
        AltaTitular menu = new AltaTitular(this.jFrame, this.jFrame.getContentPane(), this.jFrame.getTitle(), this.jFrame.size(), this.jFrame.isResizable(), this.wd, true);
        this.jFrame.setContentPane(menu);
        this.jFrame.setTitle("Alta de Titular");
        this.jFrame.invalidate();
        this.jFrame.validate();
        this.jFrame.repaint();
    }//GEN-LAST:event_jButton4ActionPerformed

    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            if(licencia != null){
                //validar
               GestorLicencia.validarLicencia(licencia); 
               GestorLicencia.altaLicencia(licencia);
               GestorLicencia.generarReportaLicencia(this, licencia);
               GestorLicencia.generarComprobante(this, licencia, new Double(costoLicencia));
               
            }
            else{
                JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed
   
    private java.sql.Date calcularFechaExpiracion(char clase, long idTitular) throws Exception{
        java.sql.Date fecha = GestorLicencia.calcularFechaExpiracion(clase,idTitular);
        return fecha;
    }
    
    private void cmbClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClaseActionPerformed
        if(!tfIdTitular.getText().equals("")){
            try{
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaActual = dateFormat.format(new java.util.Date());
                Long idOriginal = GestorLicencia.recuperarIdOriginal(Long.parseLong(tfIdTitular.getText()));
                boolean esRenovacion = (idOriginal != -1);
                long idTitular = Long.parseLong(tfIdTitular.getText());
                char clase = ((String)cmbClase.getSelectedItem()).charAt(0);
                java.sql.Date fechaExpiracion = calcularFechaExpiracion(((String)cmbClase.getSelectedItem()).charAt(0), Long.parseLong(tfIdTitular.getText()));
                java.sql.Date fechaAct = java.sql.Date.valueOf(fechaActual);
                Usuario usuLog = GestorUsuario.getUsuarioLogeado();
                licencia = new Licencia(Long.parseLong("0"), idTitular, clase, fechaAct, fechaExpiracion, usuLog.getID(), idOriginal, esRenovacion);
                tfFechaExpiracion.setText(dateFormat.format(fechaExpiracion));
                costoLicencia = GestorCosto.calcularCosto(licencia, false);
                jLCosto.setText(costoLicencia.toString());
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_cmbClaseActionPerformed

    private void tfIdTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdTitularActionPerformed

    }//GEN-LAST:event_tfIdTitularActionPerformed

    public void setearTitular(Long idTitular){
        tfIdTitular.setText(idTitular.toString());
        try {
            Titular titu = GestorTitular.getTitular(idTitular);
            tfNombre.setText(titu.getNombre());
            tfApellido.setText(titu.getApellido());
            tfDocumento.setText(titu.getNumeroDocumento().toString());
            cmbTipoDocumento.setSelectedItem(titu.getTipoDocumento());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaActual = dateFormat.format(new java.util.Date());
            java.sql.Date fechaExpiracion = calcularFechaExpiracion(((String)cmbClase.getSelectedItem()).charAt(0), Long.parseLong(tfIdTitular.getText()));
            tfFechaExpiracion.setText(dateFormat.format(fechaExpiracion));
            costoLicencia = GestorCosto.calcularCosto(licencia, false);
            jLCosto.setText(costoLicencia.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void tfIdTitularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIdTitularKeyReleased
        if(!tfIdTitular.getText().equals("")){
            try{
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaActual = dateFormat.format(new java.util.Date());
                Long idOriginal = GestorLicencia.recuperarIdOriginal(Long.parseLong(tfIdTitular.getText()));
                boolean esRenovacion = (idOriginal != null);
                long idTitular = Long.parseLong(tfIdTitular.getText());
                char clase = ((String)cmbClase.getSelectedItem()).charAt(0);
                java.sql.Date fechaAct = java.sql.Date.valueOf(fechaActual);
                Usuario usuLog = GestorUsuario.getUsuarioLogeado();
                Titular titu = GestorTitular.getTitular(idTitular);
                if(titu != null){
                    java.sql.Date fechaExpiracion = calcularFechaExpiracion(((String)cmbClase.getSelectedItem()).charAt(0), Long.parseLong(tfIdTitular.getText()));
                    licencia = new Licencia(Long.parseLong("0"), idTitular, clase, fechaAct, fechaExpiracion, usuLog.getID(), idOriginal, esRenovacion);
                    
                    tfNombre.setText(titu.getNombre());
                    tfApellido.setText(titu.getApellido());
                    tfDocumento.setText(titu.getNumeroDocumento().toString());
                    tfFechaExpiracion.setText(dateFormat.format(fechaExpiracion));
                    cmbTipoDocumento.setSelectedItem(titu.getTipoDocumento());
                    costoLicencia = GestorCosto.calcularCosto(licencia, false);
                    jLCosto.setText(costoLicencia.toString());
                }
                else{
                    throw new Exception("No existe un usuario con la id ingresada.");
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                tfNombre.setText("");
                tfApellido.setText("");
                tfDocumento.setText("");
                tfFechaExpiracion.setText("");
                licencia = null;
                costoLicencia = new Long(0);
                jLCosto.setText(costoLicencia.toString());
            }
        }
        else{
            if(tfIdTitular.getText().equals("")){
                tfNombre.setText("");
                tfApellido.setText("");
                tfDocumento.setText("");
                tfFechaExpiracion.setText("");
                licencia = null;
                costoLicencia = new Long(0);
                jLCosto.setText(costoLicencia.toString());
            }
        }
    }//GEN-LAST:event_tfIdTitularKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.jFrame.removeWindowListener(wd);
        FiltrarTitular menu = new FiltrarTitular(this.jFrame, this.jFrame.getContentPane(), this.jFrame.getTitle(), this.jFrame.size(), this.jFrame.isResizable(), this.wd, true);
        this.jFrame.setContentPane(menu);
        this.jFrame.setTitle("Búsqueda de Titulares");
        this.jFrame.invalidate();
        this.jFrame.validate();
        this.jFrame.repaint();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbClase;
    private javax.swing.JComboBox<String> cmbTipoDocumento;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLCosto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel panDetLic;
    private javax.swing.JPanel panTitular;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfDocumento;
    private javax.swing.JTextField tfFechaExpiracion;
    private javax.swing.JTextField tfIdTitular;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
