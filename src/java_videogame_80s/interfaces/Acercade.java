package java_videogame_80s.interfaces;

public class Acercade extends javax.swing.JFrame {

    private MenuActions menuActions;

    public Acercade() {
        this.menuActions = menuActions; 
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aboutus_content = new javax.swing.JPanel();
        devs_tittle = new javax.swing.JLabel();
        dev1_tittle = new javax.swing.JLabel();
        dev2_title = new javax.swing.JLabel();
        dev3_title = new javax.swing.JLabel();
        dev4_title = new javax.swing.JLabel();
        dev5_title = new javax.swing.JLabel();
        aboutus_button = new javax.swing.JPanel();
        aboutus_title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));

        aboutus_content.setBackground(new java.awt.Color(52, 52, 60));

        devs_tittle.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        devs_tittle.setForeground(new java.awt.Color(155, 152, 152));
        devs_tittle.setText("Desarrolladores");

        dev1_tittle.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        dev1_tittle.setForeground(new java.awt.Color(155, 152, 152));
        dev1_tittle.setText("Juan D. Anzola Quiroga ");

        dev2_title.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        dev2_title.setForeground(new java.awt.Color(155, 152, 152));
        dev2_title.setText("Mateo Aristizábal Serna ");

        dev3_title.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        dev3_title.setForeground(new java.awt.Color(155, 152, 152));
        dev3_title.setText("Brancys A. Barrios Suarez");

        dev4_title.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        dev4_title.setForeground(new java.awt.Color(155, 152, 152));
        dev4_title.setText("Santiago Llenera Lancheros");

        dev5_title.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        dev5_title.setForeground(new java.awt.Color(155, 152, 152));
        dev5_title.setText("Edilberto M. Rodriguez Fontalvo");

        aboutus_button.setBackground(new java.awt.Color(155, 152, 152));
        aboutus_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutus_buttonMouseClicked(evt);
            }
        });

        aboutus_title.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        aboutus_title.setText("Regresar");

        javax.swing.GroupLayout aboutus_buttonLayout = new javax.swing.GroupLayout(aboutus_button);
        aboutus_button.setLayout(aboutus_buttonLayout);
        aboutus_buttonLayout.setHorizontalGroup(
            aboutus_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutus_buttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aboutus_title)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        aboutus_buttonLayout.setVerticalGroup(
            aboutus_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutus_buttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aboutus_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(155, 152, 152));
        jLabel1.setText("Miguel A. Altamar Rodriguez");

        javax.swing.GroupLayout aboutus_contentLayout = new javax.swing.GroupLayout(aboutus_content);
        aboutus_content.setLayout(aboutus_contentLayout);
        aboutus_contentLayout.setHorizontalGroup(
            aboutus_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutus_contentLayout.createSequentialGroup()
                .addGroup(aboutus_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aboutus_contentLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(aboutus_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(devs_tittle)
                            .addGroup(aboutus_contentLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(aboutus_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dev3_title)
                                    .addComponent(dev4_title)
                                    .addComponent(dev5_title)
                                    .addComponent(jLabel1)
                                    .addComponent(dev1_tittle)
                                    .addComponent(dev2_title)))))
                    .addGroup(aboutus_contentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(aboutus_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(537, Short.MAX_VALUE))
        );
        aboutus_contentLayout.setVerticalGroup(
            aboutus_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutus_contentLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(devs_tittle)
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dev1_tittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dev2_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dev3_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dev4_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dev5_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                .addComponent(aboutus_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        aboutus_button.getAccessibleContext().setAccessibleName("Regresar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutus_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutus_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutus_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutus_buttonMouseClicked
        menuActions.setHomeView();
    }//GEN-LAST:event_aboutus_buttonMouseClicked

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
            java.util.logging.Logger.getLogger(Acercade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acercade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acercade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acercade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Acercade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aboutus_button;
    private javax.swing.JPanel aboutus_content;
    private javax.swing.JLabel aboutus_title;
    private javax.swing.JLabel dev1_tittle;
    private javax.swing.JLabel dev2_title;
    private javax.swing.JLabel dev3_title;
    private javax.swing.JLabel dev4_title;
    private javax.swing.JLabel dev5_title;
    private javax.swing.JLabel devs_tittle;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
