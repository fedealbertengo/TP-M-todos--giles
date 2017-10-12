package CPresentacion;

import CLogica.GestorUsuario;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {

    java.awt.event.WindowAdapter wd;
    
    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        wd = new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                dispose();
            }
        };
        this.addWindowListener(wd);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnMenuTitulares = new javax.swing.JButton();
        btnMenuUsuarios = new javax.swing.JButton();
        btnMenuLicencias = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnMenuTitulares.setText("Menu de Titulares");
        btnMenuTitulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuTitularesActionPerformed(evt);
            }
        });

        btnMenuUsuarios.setText("Menu de Usuarios");

        btnMenuLicencias.setText("Menu de Licencias");
        btnMenuLicencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuLicenciasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMenuTitulares)
                    .addComponent(btnMenuUsuarios)
                    .addComponent(btnMenuLicencias))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnMenuTitulares)
                .addGap(32, 32, 32)
                .addComponent(btnMenuUsuarios)
                .addGap(33, 33, 33)
                .addComponent(btnMenuLicencias)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuTitularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuTitularesActionPerformed
        this.removeWindowListener(wd);
        MenuTitulares menu = new MenuTitulares(this, this.getContentPane(), this.getTitle(), this.size(), this.isResizable(), wd);
        this.setContentPane(menu);
        this.setTitle("Menu de Titulares");
        this.invalidate();
        this.validate();
        this.repaint();
    }//GEN-LAST:event_btnMenuTitularesActionPerformed

    private void btnMenuLicenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuLicenciasActionPerformed
        this.removeWindowListener(wd);
        MenuLicencias menu = new MenuLicencias(this, this.getContentPane(), this.getTitle(), this.size(), this.isResizable(), wd);
        this.setContentPane(menu);
        this.setTitle("Menu de Licencias");
        this.invalidate();
        this.validate();
        this.repaint();
    }//GEN-LAST:event_btnMenuLicenciasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
             
            }
        });
        
        try {
            GestorUsuario.setUsuarioLogeado(GestorUsuario.getUsuario(1));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenuLicencias;
    private javax.swing.JButton btnMenuTitulares;
    private javax.swing.JButton btnMenuUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
