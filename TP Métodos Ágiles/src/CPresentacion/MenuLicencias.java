package CPresentacion;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;

public class MenuLicencias extends javax.swing.JPanel {

    Container menuAnt;
    JFrame jFrame;
    String tituloAnt;
    Dimension dimAnt;
    boolean redimAnt;
    java.awt.event.WindowAdapter wdAnt;
    java.awt.event.WindowAdapter wd;

    public MenuLicencias(JFrame frameAnt, Container menAnt, String titAnt, Dimension dim, boolean redAnt, java.awt.event.WindowAdapter wdAnt) {
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

        btnEmitirLicencia = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnEmitirLicencia1 = new javax.swing.JButton();

        btnEmitirLicencia.setText("Emitir Licencia");
        btnEmitirLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirLicenciaActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        btnEmitirLicencia1.setText("Ver Licencias Expiradas");
        btnEmitirLicencia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirLicencia1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnEmitirLicencia))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnEmitirLicencia1)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnEmitirLicencia)
                .addGap(18, 18, 18)
                .addComponent(btnEmitirLicencia1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmitirLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirLicenciaActionPerformed
        this.jFrame.removeWindowListener(wd);
        EmitirLicencia menu = new EmitirLicencia(this.jFrame, this.jFrame.getContentPane(), this.jFrame.getTitle(), this.jFrame.size(), this.jFrame.isResizable(), this.wd);
        this.jFrame.setContentPane(menu);
        this.jFrame.setTitle("Emitir Licencia");
        this.jFrame.invalidate();
        this.jFrame.validate();
        this.jFrame.repaint();
    }//GEN-LAST:event_btnEmitirLicenciaActionPerformed

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

    private void btnEmitirLicencia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirLicencia1ActionPerformed
        this.jFrame.removeWindowListener(wd);
        FiltrarLicencia menu = new FiltrarLicencia(this.jFrame, this.jFrame.getContentPane(), this.jFrame.getTitle(), this.jFrame.size(), this.jFrame.isResizable(), this.wd);
        this.jFrame.setContentPane(menu);
        this.jFrame.setTitle("Emitir Licencia");
        this.jFrame.invalidate();
        this.jFrame.validate();
        this.jFrame.repaint();
    }//GEN-LAST:event_btnEmitirLicencia1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmitirLicencia;
    private javax.swing.JButton btnEmitirLicencia1;
    private javax.swing.JButton btnVolver;
    // End of variables declaration//GEN-END:variables
}
