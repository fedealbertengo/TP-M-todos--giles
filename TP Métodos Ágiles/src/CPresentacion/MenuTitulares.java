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

    public MenuTitulares(JFrame frameAnt, Container menAnt, String titAnt, Dimension dim, boolean redAnt) {
        initComponents();
        menuAnt = menAnt;
        jFrame = frameAnt;
        tituloAnt = titAnt;
        dimAnt = dim;
        redimAnt = redAnt;
        configurarParamsJFrame();
    }
    
    public void configurarParamsJFrame(){

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        btnMenuTitulares = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(296, 262));

        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        btnMenuTitulares.setText("Alta de Titular");
        btnMenuTitulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuTitularesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnMenuTitulares))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnMenuTitulares)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        jFrame.setContentPane(menuAnt);
        jFrame.setTitle(tituloAnt);
        jFrame.resize(dimAnt);
        jFrame.setResizable(redimAnt);
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnMenuTitularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuTitularesActionPerformed
        AltaTitular menu = new AltaTitular(this.jFrame, this.jFrame.getContentPane(), this.jFrame.getTitle(), this.jFrame.size(), this.jFrame.isResizable());
        this.jFrame.setContentPane(menu);
        this.jFrame.setTitle("Alta de Titular");
        this.jFrame.invalidate();
        this.jFrame.validate();
        this.jFrame.repaint();
    }//GEN-LAST:event_btnMenuTitularesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenuTitulares;
    private javax.swing.JButton btnVolver;
    // End of variables declaration//GEN-END:variables
}
