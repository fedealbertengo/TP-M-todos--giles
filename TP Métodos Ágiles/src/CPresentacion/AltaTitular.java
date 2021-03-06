package CPresentacion;

import CDatos.Conexion;
import CEntidades.Titular;
import CLogica.GestorTitular;
import CLogica.GestorUsuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.TextField;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AltaTitular extends javax.swing.JPanel {

    Container menuAnt;
    JFrame jFrame;
    String tituloAnt;
    Dimension dimAnt;
    boolean redimAnt;
    java.awt.event.WindowAdapter wdAnt;
    java.awt.event.WindowAdapter wd;
    
    boolean llamadoPorOtro;
    public Long idTitularCreado = new Long(0);
    
    public AltaTitular(JFrame frameAnt, Container menAnt, String titAnt, Dimension dim, boolean redAnt, java.awt.event.WindowAdapter wdAnt) {
        initComponents();
        this.setBackground(Color.BLACK);
        menuAnt = menAnt;
        jFrame = frameAnt;
        tituloAnt = titAnt;
        dimAnt = dim;
        redimAnt = redAnt;
        llamadoPorOtro = false;
        this.wdAnt = wdAnt;
        configurarParamsJFrame();
    }
    
    public AltaTitular(JFrame frameAnt, Container menAnt, String titAnt, Dimension dim, boolean redAnt, java.awt.event.WindowAdapter wdAnt, boolean llamado) {
        initComponents();
        menuAnt = menAnt;
        jFrame = frameAnt;
        tituloAnt = titAnt;
        dimAnt = dim;
        redimAnt = redAnt;
        llamadoPorOtro = llamado;
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfDocumento = new javax.swing.JTextField();
        cmbTipoDocumento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dateFechaNac = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbGrupoSang = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbFactorSang = new javax.swing.JComboBox<>();
        cbDonante = new javax.swing.JCheckBox();
        btnAceptar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfNacionalidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();

        jTextField4.setText("jTextField4");

        btnVolver.setForeground(new java.awt.Color(0, 51, 244));
        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 51, 244));
        jLabel1.setText("Nombre");

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 51, 244));
        jLabel2.setText("Apellido");

        jLabel3.setForeground(new java.awt.Color(0, 51, 244));
        jLabel3.setText("Documento");

        cmbTipoDocumento.setForeground(new java.awt.Color(0, 51, 244));
        cmbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "CI", "LE", "LC", "PS" }));
        cmbTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoDocumentoActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 51, 244));
        jLabel5.setText("Fecha de Nacimiento");

        dateFechaNac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        dateFechaNac.setToolTipText("formato: dd/mm/aaaa");
        dateFechaNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFechaNacActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 51, 244));
        jLabel4.setText("Direccion");

        jLabel7.setForeground(new java.awt.Color(0, 51, 244));
        jLabel7.setText("Grupo Sanguineo");

        cmbGrupoSang.setForeground(new java.awt.Color(0, 0, 244));
        cmbGrupoSang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "AB", "O" }));
        cmbGrupoSang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGrupoSangActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 51, 244));
        jLabel8.setText("Factor");

        cmbFactorSang.setForeground(new java.awt.Color(0, 51, 244));
        cmbFactorSang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+", "-" }));

        cbDonante.setForeground(new java.awt.Color(0, 51, 244));
        cbDonante.setText("Donante de Órganos");

        btnAceptar.setForeground(new java.awt.Color(0, 51, 244));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 51, 244));
        jLabel6.setText("Nacionalidad");

        jLabel9.setForeground(new java.awt.Color(0, 51, 244));
        jLabel9.setText("Sexo");

        cmbSexo.setForeground(new java.awt.Color(0, 51, 244));
        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        cmbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSexoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbGrupoSang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8))
                                    .addComponent(cbDonante))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbFactorSang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAceptar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNacionalidad))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfDireccion))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dateFechaNac))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbTipoDocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfApellido)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dateFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbGrupoSang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbFactorSang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cbDonante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void cmbTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoDocumentoActionPerformed

    private void dateFechaNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFechaNacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFechaNacActionPerformed

    private void cmbGrupoSangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGrupoSangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGrupoSangActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if((!tfNombre.getText().equals("")) && (!tfApellido.getText().equals("")) && (!tfDocumento.getText().equals("")) && (!dateFechaNac.getText().equals("")) && (!tfDireccion.getText().equals("")) && (!tfNacionalidad.getText().equals(""))){
            try{
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaActual = dateFormat.format(new java.util.Date());
            
                String fechaNac = dateFechaNac.getText().split("-")[2] + "-" + dateFechaNac.getText().split("")[1] + "-" + dateFechaNac.getText().split("-")[0];
                Titular tit = new Titular(tfNombre.getText(), tfApellido.getText(), (String)cmbTipoDocumento.getSelectedItem(), Long.parseLong(tfDocumento.getText()), Date.valueOf(fechaNac), tfDireccion.getText(), (String)cmbGrupoSang.getSelectedItem(), ((String)cmbFactorSang.getSelectedItem()).equals("+"), cbDonante.isSelected(), Date.valueOf(fechaActual), null, GestorUsuario.getUsuarioLogeado().getID(), tfNacionalidad.getText(), ((String)cmbSexo.getSelectedItem()).charAt(0));
                GestorTitular.altaTitular(tit);
                if(llamadoPorOtro){
                    this.idTitularCreado = (((ArrayList<Titular>)((Object)Conexion.consultar("SELECT * FROM Titular WHERE TipoDocumento = '" + (String)cmbTipoDocumento.getSelectedItem() + "' AND NumeroDocumento = " + tfDocumento.getText(), Titular.class))).get(0)).getID();
                   ((EmitirLicencia)this.menuAnt).setearTitular(idTitularCreado);
                    volver();
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            String mensaje = "Los siguientes campos no pueden estar vacíos:";
            if(tfNombre.getText().equals("")){
                mensaje += "\nNombre";
            }
            if(tfApellido.getText().equals("")){
                mensaje += "\nApellido";
            }
            
            if(tfDocumento.getText().equals("")){
                mensaje += "\nDocumento";
            }
            
            if(dateFechaNac.getText().equals("")){
                mensaje += "\nFecha de Nacimiento";
            }
            
            if(tfDireccion.getText().equals("")){
                mensaje += "\nDireccion";
            }
            if(tfNacionalidad.getText().equals("")){
                mensaje += "\nNacionalidad";
            }
            if(mensaje.contains("\n")){
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cmbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSexoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JCheckBox cbDonante;
    private javax.swing.JComboBox<String> cmbFactorSang;
    private javax.swing.JComboBox<String> cmbGrupoSang;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JComboBox<String> cmbTipoDocumento;
    private javax.swing.JFormattedTextField dateFechaNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfDocumento;
    private javax.swing.JTextField tfNacionalidad;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
