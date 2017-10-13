package CPresentacion;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;


public class MenuTitulares extends javax.swing.JPanel {

    Container menuAnt;
    JFrame jFrame;
    String tituloAnt;
    Dimension dimAnt;
    boolean redimAnt;
    java.awt.event.WindowAdapter wdAnt;
    java.awt.event.WindowAdapter wd;
    

    public MenuTitulares(JFrame frameAnt, Container menAnt, String titAnt, Dimension dim, boolean redAnt, java.awt.event.WindowAdapter wdAnt) {
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

        btnVolver = new javax.swing.JButton();
        btnAltaTitular = new javax.swing.JButton();
        btnAltaTitular1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(296, 262));

        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        btnAltaTitular.setText("Alta de Titular");
        btnAltaTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaTitularActionPerformed(evt);
            }
        });

        btnAltaTitular1.setText("Buscar Titulares");
        btnAltaTitular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaTitular1ActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAltaTitular1)
                            .addComponent(btnAltaTitular))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnAltaTitular)
                .addGap(18, 18, 18)
                .addComponent(btnAltaTitular1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(btnVolver)
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

    private void btnAltaTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaTitularActionPerformed
        this.jFrame.removeWindowListener(wd);
        AltaTitular menu = new AltaTitular(this.jFrame, this.jFrame.getContentPane(), this.jFrame.getTitle(), this.jFrame.size(), this.jFrame.isResizable(), this.wd);
        this.jFrame.setContentPane(menu);
        this.jFrame.setTitle("Alta de Titular");
        this.jFrame.invalidate();
        this.jFrame.validate();
        this.jFrame.repaint();
    }//GEN-LAST:event_btnAltaTitularActionPerformed

    private void btnAltaTitular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaTitular1ActionPerformed
        this.jFrame.removeWindowListener(wd);
        FiltrarTitular menu = new FiltrarTitular(this.jFrame, this.jFrame.getContentPane(), this.jFrame.getTitle(), this.jFrame.size(), this.jFrame.isResizable(), this.wd);
        this.jFrame.setContentPane(menu);
        this.jFrame.setTitle("Búsqueda de Titulares");
        this.jFrame.invalidate();
        this.jFrame.validate();
        this.jFrame.repaint();
    }//GEN-LAST:event_btnAltaTitular1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaTitular;
    private javax.swing.JButton btnAltaTitular1;
    private javax.swing.JButton btnVolver;
    // End of variables declaration//GEN-END:variables
}
