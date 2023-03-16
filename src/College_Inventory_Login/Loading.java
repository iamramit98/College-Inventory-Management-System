/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package College_Inventory_Login;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Amit Kumar
 */
public class Loading extends javax.swing.JFrame {
    /**
     * Creates new form Loading
     */
    public Loading() {
        setUndecorated(true);        
        initComponents();
        setLocationRelativeTo(null);
        setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        //setBackground(new Color(0,0,0,0));
        load();
        setIcon();
    }
    
    void load(){
        Thread t = new Thread(new Runnable() {
                public void run() 
                {
                    for(int i=0;i<=100;i++)
                    {
                        try 
                        {
                            Thread.sleep(100);
                            jProgressBar1.setValue(i);
                            //jProgressBarLbl.setText(i+"%");
                            //jProgressBarLbl.setText("Wait.... loading "+i+"%");
                            if(i>=0 && i<5){
                                answer.setText("Loading.");
                                jLabel3.setForeground(new Color(0,0,255));
                            }else if(i>=5 && i<10){
                                answer.setText("Loading.");
                                jLabel3.setForeground(new Color(255,0,255));
                            }else if(i>=10 && i<15){
                                answer.setText("Loading..");
                                jLabel3.setForeground(new Color(153,0,153));
                            }else if(i>=15 && i<19){
                                answer.setText("Loading..");
                                jLabel3.setForeground(new Color(51,0,51));
                            }else if(i>=19 && i<20){
                                answer.setText("Loading..");
                                jLabel3.setForeground(new Color(51,0,51));
                            //Database Start
                                /*try{
                                    File file =new File ("C:\\xampp\\xampp_start.exe");
                                    if(file.exists()){
                                        if(Desktop.isDesktopSupported()){
                                            Desktop.getDesktop().open(file);
                                        }else{
                                            JOptionPane.showMessageDialog(null,"Not Supperted");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "File Not Exist");
                                    }
                                }catch(Exception e){
                                    e.printStackTrace();
                                }*/
                            }                            
                            else if(i>=20 && i<25){
                                answer.setText("Loading...");
                                jLabel3.setForeground(new Color(153,0,51));
                            }else if(i>=25 && i<30){
                                answer.setText("Loading...");
                                jLabel3.setForeground(new Color(0,102,0));
                            }else if(i>=30 && i<35){
                                answer.setText("Reading Modules...");
                                jLabel3.setForeground(new Color(153,153,0));
                            }else if(i>=35 && i<40){
                                answer.setText("Reading Modules...");
                                jLabel3.setForeground(new Color(0,153,153));
                            }else if(i>=40 && i<45){
                                answer.setText("Turning on Modules...");
                                jLabel3.setForeground(new Color(0,255,0));
                            }else if(i>=45 && i<=50){
                                answer.setText("Turning on Modules...");
                                jLabel3.setForeground(new Color(102,102,0));
                            }else if(i>=50 && i<55){
                                answer.setText("Starting Modules...");
                                jLabel3.setForeground(new Color(0,0,255));
                            }else if(i>=55 && i<60){
                                answer.setText("Starting Modules...");
                                jLabel3.setForeground(new Color(255,0,255));
                            }else if(i>=60 && i<65){
                                answer.setText("Loading Modules...");
                                jLabel3.setForeground(new Color(153,0,153));
                            }else if(i>=65 && i<70){
                                answer.setText("Loading Modules...");
                                jLabel3.setForeground(new Color(51,0,51));
                            }else if(i>=70 && i<75){
                                answer.setText("Done Loading Modules.");
                                jLabel3.setForeground(new Color(153,0,51));
                            }else if(i>=75 && i<80){
                                answer.setText("Done Loading Modules.");
                                jLabel3.setForeground(new Color(0,102,0));
                            }else if(i>=80 && i<85){
                                answer.setText("Done Loading Modules..");
                                jLabel3.setForeground(new Color(153,153,0));
                            }else if(i>=85 && i<90){
                                answer.setText("Done Loading Modules..");
                                jLabel3.setForeground(new Color(0,153,153));
                            }else if(i>=90 && i<95){
                                answer.setText("Done Loading Modules...");
                                jLabel3.setForeground(new Color(0,255,0));
                            }else if(i>=95 && i<=100){
                                answer.setText("Done Loading Modules...");
                                jLabel3.setForeground(new Color(102,102,0));
                            }
                        }
                        catch (Exception e)     
                        {
                          e.printStackTrace();
                        }

                    }
                dispose();
                new Login().setVisible(true);
                }
        });
        t.start();
    }
    
    /*Loading...
    Reading Modules...
    Turning on Modules...
    Starting Modules...
    Loading Modules...
    Done Loading Modules...*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        answer = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jSeparator1.setForeground(new java.awt.Color(232, 57, 95));
        jSeparator1.setToolTipText("");

        jSeparator2.setForeground(new java.awt.Color(232, 57, 95));
        jSeparator2.setToolTipText("");

        jSeparator3.setForeground(new java.awt.Color(232, 57, 95));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setToolTipText("");

        jSeparator5.setForeground(new java.awt.Color(232, 57, 95));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setToolTipText("");

        answer.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        answer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jProgressBar1.setBackground(new java.awt.Color(153, 255, 153));
        jProgressBar1.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(153, 255, 153));
        jProgressBar1.setStringPainted(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trending120.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Green Global");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("We Create, We Design, We Develop");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(answer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel answer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/trending 512.png")));
    }
}
