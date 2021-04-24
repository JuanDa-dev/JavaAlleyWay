package interfaces;

import Utils.PlaySounds;
import java.awt.Dimension;
import java.awt.Toolkit;

public class AboutUs extends javax.swing.JFrame {

    public AboutUs() {
        initComponents();
        centreWindow(); 
    }

    private void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y - 25);
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
        dev6_tittle = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acerca de nosotros");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

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

        dev6_tittle.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        dev6_tittle.setForeground(new java.awt.Color(155, 152, 152));
        dev6_tittle.setText("Miguel A. Altamar Rodriguez");

        returnButton.setBackground(new java.awt.Color(155, 152, 152));
        returnButton.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        returnButton.setText("Regresar");
        returnButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnButton.setFocusable(false);
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aboutus_contentLayout = new javax.swing.GroupLayout(aboutus_content);
        aboutus_content.setLayout(aboutus_contentLayout);
        aboutus_contentLayout.setHorizontalGroup(
            aboutus_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutus_contentLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(aboutus_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(devs_tittle)
                    .addGroup(aboutus_contentLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(aboutus_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dev3_title)
                            .addComponent(dev4_title)
                            .addComponent(dev5_title)
                            .addComponent(dev6_tittle)
                            .addComponent(dev1_tittle)
                            .addComponent(dev2_title))))
                .addContainerGap(537, Short.MAX_VALUE))
        );
        aboutus_contentLayout.setVerticalGroup(
            aboutus_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutus_contentLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(devs_tittle)
                .addGap(13, 13, 13)
                .addComponent(dev6_tittle)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

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

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        PlaySounds btnSound = new PlaySounds("src\\dataSounds\\ButtonSound.wav");
        btnSound.getClip().start();
        new MainInterface().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnButtonActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutUs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AboutUs().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aboutus_content;
    private javax.swing.JLabel dev1_tittle;
    private javax.swing.JLabel dev2_title;
    private javax.swing.JLabel dev3_title;
    private javax.swing.JLabel dev4_title;
    private javax.swing.JLabel dev5_title;
    private javax.swing.JLabel dev6_tittle;
    private javax.swing.JLabel devs_tittle;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}
