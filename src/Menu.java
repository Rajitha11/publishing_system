
import com.org.DB.ConnectionSet1;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tuan
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();

        hiddenIcon();
//        showmenu();
    }

    void hiddenIcon() {
        jButton8.setEnabled(false);
        jButton2.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton3.setEnabled(false);
        jButton10.setEnabled(false);
        jButton1.setEnabled(false);
        jButton9.setEnabled(false);
        jButton6.setEnabled(false);
        jButton11.setEnabled(false);
        jButton12.setEnabled(false);
        jButton7.setEnabled(false);
        jButton13.setEnabled(false);
    }

    Menu(String desig, String userTyp, String uname) {

        this();

        jLabel6.setText(uname);

        if (desig.equals("Publishing Manager") && userTyp.equals("Admin")) {
            jButton8.setEnabled(true);
            jButton2.setEnabled(true);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton3.setEnabled(true);
            jButton10.setEnabled(true);
            jButton1.setEnabled(true);
            jButton9.setEnabled(true);
            jButton6.setEnabled(true);
            jButton11.setEnabled(true);
            jButton12.setEnabled(true);
            jButton7.setEnabled(true);
            jButton13.setEnabled(true);

        } else if (desig.equals("Head Of Grafic") && userTyp.equals("User")) {
            jButton10.setEnabled(true);
            jButton1.setEnabled(true);
            jButton9.setEnabled(true);
            jButton13.setEnabled(true);

        } else if (desig.equals("MD") && userTyp.equals("Admin")) {
            jButton8.setEnabled(true);
            jButton2.setEnabled(true);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton3.setEnabled(true);
            jButton10.setEnabled(true);
            jButton1.setEnabled(true);
            jButton9.setEnabled(true);
            jButton6.setEnabled(true);
            jButton11.setEnabled(true);
            jButton12.setEnabled(true);
            jButton7.setEnabled(true);
            jButton13.setEnabled(true);

        } else if (desig.equals("Designer") && userTyp.equals("User")) {
            jButton1.setEnabled(true);

        } else if (desig.equals("Planner") && userTyp.equals("User")) {
            jButton9.setEnabled(true);
            jButton7.setEnabled(true);
            jButton1.setEnabled(true);
            jButton13.setEnabled(true);

        } else if (desig.equals("Typesetter") && userTyp.equals("User")) {
            jButton11.setEnabled(true);

        } else if (desig.endsWith("Assistant Publishing Manager") && userTyp.equals("User")) {
            jButton8.setEnabled(true);
            jButton2.setEnabled(true);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton3.setEnabled(true);
            jButton12.setEnabled(true);
            jButton13.setEnabled(true);
            jButton7.setEnabled(true);

        } else if (desig.equals("IT") && userTyp.equals("Admin")) {
            jButton8.setEnabled(true);
            jButton2.setEnabled(true);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton3.setEnabled(true);
            jButton10.setEnabled(true);
            jButton1.setEnabled(true);
            jButton9.setEnabled(true);
            jButton6.setEnabled(true);
            jButton11.setEnabled(true);
            jButton12.setEnabled(true);
            jButton7.setEnabled(true);
            jButton13.setEnabled(true);

        } else if (desig.equals("Printing") && userTyp.equals("User")) {
            jButton6.setEnabled(true);
            jButton13.setEnabled(true);

        }


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Menu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/evlu.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/evlu1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 90, 66));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/workl.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/workl1.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Process");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Designer");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Evuluation");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/jobc.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/jobc1.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 90, 66));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/catlo0g.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusable(false);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/catlo0g1.png"))); // NOI18N
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Costing");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Manuscript");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 80, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/graphic.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/graphic1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 90, 66));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Receiving ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/Printing.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusable(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/Printing2.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 90, 66));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Job Card");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/cost.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/cost1.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 90, 66));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Discription");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 80, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Printing");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, -1, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/menus.png"))); // NOI18N
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setFocusable(false);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/menus1.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 90, 66));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Catalog");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 580, -1, -1));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/planer.png"))); // NOI18N
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setFocusable(false);
        jButton9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/planer1.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 90, 66));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Planner");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, -1, -1));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/graficDep.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setFocusable(false);
        jButton10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/graficDep1.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 90, 66));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Graphic");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 60, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Product");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, 70, -1));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/typsetter.png"))); // NOI18N
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setFocusable(false);
        jButton11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/typsetter1.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 90, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Typesetter");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, -1, -1));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/trans.png"))); // NOI18N
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setFocusable(false);
        jButton12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/trans1.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 90, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Translations");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 150, 30));

        jLabel17.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel17.setText("Loged As");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 100, 30));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/printshedul.png"))); // NOI18N
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setFocusable(false);
        jButton13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/printshedul1.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 270, 90, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Schedule");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 70, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Printing");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Reprint");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 320, 60, -1));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/reprint.png"))); // NOI18N
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.setFocusable(false);
        jButton14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/reprint1.png"))); // NOI18N
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 180, 140, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/Background_Artboard 2.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -26, 1150, 910));

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("jMenu3");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String uname = jLabel6.getText();
        new resivinManuScript(uname).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String uname = jLabel6.getText();
        new fullEvoluationProcess(uname).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String uname = jLabel6.getText();
        new fulJobCarDetails(uname).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String uname = jLabel6.getText();
        new productDiscription(uname).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String uname = jLabel6.getText();
        new costing(uname).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        String uname = jLabel6.getText();
        new graficDepartment(uname).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String uname = jLabel6.getText();
        new PrintingDepartment(uname).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        String uname = jLabel6.getText();
        new translationDetails(uname).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String uname = jLabel6.getText();
        new Disigner(uname).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String uname = jLabel6.getText();
        new Planner(uname).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        String uname = jLabel6.getText();
        new typeSetterJobs(uname).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        String uname = jLabel6.getText();
        new printing_shedul(uname).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
