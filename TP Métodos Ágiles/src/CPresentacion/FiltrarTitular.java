package CPresentacion;

import CDatos.Conexion;
import CEntidades.ConsultaGenerica;
import CEntidades.Licencia;
import CLogica.GestorUtilidades;
import java.awt.Container;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FiltrarTitular extends javax.swing.JPanel {

    Container menuAnt;
    JFrame jFrame;
    String tituloAnt;
    Dimension dimAnt;
    boolean redimAnt;
    private Licencia licencia = null;
    java.awt.event.WindowAdapter wdAnt;
    java.awt.event.WindowAdapter wd;
    
    boolean llamadoPorOtro;
    
    public FiltrarTitular(JFrame frameAnt, Container menAnt, String titAnt, Dimension dim, boolean redAnt, java.awt.event.WindowAdapter wdAnt) {
        initComponents();
        menuAnt = menAnt;
        jFrame = frameAnt;
        tituloAnt = titAnt;
        dimAnt = dim;
        redimAnt = redAnt;
        this.wdAnt = wdAnt;
        this.llamadoPorOtro = false;
        configurarParamsJFrame();
        llenarTabla("", "", "", "", "");
    }
    
    public FiltrarTitular(JFrame frameAnt, Container menAnt, String titAnt, Dimension dim, boolean redAnt, java.awt.event.WindowAdapter wdAnt, boolean llamado) {
        initComponents();
        menuAnt = menAnt;
        jFrame = frameAnt;
        tituloAnt = titAnt;
        dimAnt = dim;
        redimAnt = redAnt;
        this.wdAnt = wdAnt;
        this.llamadoPorOtro = llamado;
        configurarParamsJFrame();
        llenarTabla("", "", "", "", "");
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
    
    private void llenarTabla(String idTitular, String nombre, String apellido, String nroDocumento, String tipoDocumento){
        try {
            String query = "SELECT ID, Apellido, Nombre, TipoDocumento, NumeroDocumento, FechaNacimiento, Direccion, GrupoSanguineo, FactorRH, Donante FROM Titular";
            if(!idTitular.equals("") || !nombre.equals("") || !apellido.equals("") || !nroDocumento.equals("") || (!tipoDocumento.equals("No Filtrar") && !tipoDocumento.equals(""))){
                query += " WHERE ";
                if(!idTitular.equals("")){
                    query += " ID = " + idTitular + " AND ";
                }
                if(!nombre.equals("")){
                    query += " Nombre LIKE '%" + nombre + "%' AND ";
                }
                if(!apellido.equals("")){
                    query += " Apellido LIKE '%" + apellido + "%' AND ";
                }
                if(!nroDocumento.equals("")){
                    query += " NumeroDocumento = " + nroDocumento + " AND ";
                }
                if(!tipoDocumento.equals("No Filtrar") && !tipoDocumento.equals("")){
                    query += " TipoDocumento = '" + tipoDocumento + "' AND ";
                }
                query = query.substring(0, query.lastIndexOf(" AND "));
            }
            query += ";";
            GestorUtilidades.llenarTabla(tabTitulares, Conexion.consultar(query, ConsultaGenerica.class));
        }
        catch(IndexOutOfBoundsException ex){
            tabTitulares.setModel(new DefaultTableModel(){
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

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabTitulares = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnFiltrar = new javax.swing.JButton();
        panTitular = new javax.swing.JPanel();
        cmbTipoDocumento = new javax.swing.JComboBox<>();
        tfDocumento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfApellido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfIdTitular = new javax.swing.JTextField();

        jToggleButton1.setText("jToggleButton1");

        setBackground(new java.awt.Color(0, 0, 0));

        tabTitulares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabTitulares.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabTitulares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabTitularesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabTitulares);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnFiltrar.setForeground(new java.awt.Color(0, 51, 244));
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        panTitular.setBackground(new java.awt.Color(0, 0, 0));
        panTitular.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmbTipoDocumento.setForeground(new java.awt.Color(0, 51, 244));
        cmbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Filtrar", "CI", "LE", "LC", "PS", "DNI" }));
        cmbTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoDocumentoActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 51, 244));
        jLabel5.setText("Documento");

        jLabel6.setForeground(new java.awt.Color(0, 51, 244));
        jLabel6.setText("Nombre");

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 51, 244));
        jLabel7.setText("Apellido");

        jLabel8.setForeground(new java.awt.Color(0, 51, 244));
        jLabel8.setText("Id de Titular");

        javax.swing.GroupLayout panTitularLayout = new javax.swing.GroupLayout(panTitular);
        panTitular.setLayout(panTitularLayout);
        panTitularLayout.setHorizontalGroup(
            panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTitularLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panTitularLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfIdTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(tfDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoDocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panTitularLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panTitularLayout.setVerticalGroup(
            panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTitularLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tfDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(tfIdTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltrar)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnFiltrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoDocumentoActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        llenarTabla(tfIdTitular.getText(), tfNombre.getText(), tfApellido.getText(), tfDocumento.getText(), (String)cmbTipoDocumento.getSelectedItem());
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void tabTitularesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTitularesMouseClicked
        if (evt.getClickCount() == 2) {
            if(llamadoPorOtro){
                Long idTitular = Long.parseLong(((DefaultTableModel) tabTitulares.getModel()).getValueAt(tabTitulares.getSelectedRow(), 0).toString());
                ((EmitirLicencia)menuAnt).setearTitular(idTitular);
                volver();
            }
        }
    }//GEN-LAST:event_tabTitularesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> cmbTipoDocumento;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPanel panTitular;
    private javax.swing.JTable tabTitulares;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfDocumento;
    private javax.swing.JTextField tfIdTitular;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
