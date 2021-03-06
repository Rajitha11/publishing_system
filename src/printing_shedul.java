
import com.org.DB.ConnectionSet1;
import com.org.clz.tablemodel1;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tuan
 */
public class printing_shedul extends javax.swing.JFrame {

    /**
     * Creates new form printing_shedul
     */
    SimpleDateFormat d1, d2;
    Timer t;

    public printing_shedul() {
        initComponents();

        dateMethod();


    }

    printing_shedul(String uname) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this();
        jLabel3.setText(uname);
        tableLoad();

    }

    void dateMethod() {
        //set date & time
        d1 = new SimpleDateFormat("yyyy/ MMM/ dd/ EEEE");
        d2 = new SimpleDateFormat("  hh:mm aaa");
        t = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                jLabel14.setText(d1.format(d));
                jLabel30.setText(d2.format(d));

            }
        });
        t.start();
    }

    void tableLoad() {
        try {
            new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn from grafic_jobs g1 inner join production_description p1 on g1.job_card_idjob_card = p1.job_card_idjob_card "
                    + "inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor "
                    + "where printin_shedul='added'", jTable1);


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(printing_shedul.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(printing_shedul.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(printing_shedul.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Printing Schedule");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 220, 58));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("Date ");
        getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 210, 52));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 110, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Books Ready To Prints", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Title", "Author", "ISBN"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 380, 620));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 420, 690));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("<<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 70, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText(">>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 70, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Send To Print", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Title", "Author", "ISBN"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 380, 620));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Choose Month--", " ", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 30));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 90, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 420, 690));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Save");
        jButton7.setBorder(null);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 830, 108, 45));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("* Year");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 50, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("* Choose Month");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 120, 30));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Choose Month--", " ", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, 30));

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 90, 30));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Clear");
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 830, 108, 45));

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 70, 10, 0));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/home.png"))); // NOI18N
        jButton8.setContentAreaFilled(false);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/home1.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 70));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/sarasavi.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 267, 65));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTextField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter The Year", "error", JOptionPane.WARNING_MESSAGE);
        } else if (jComboBox2.getSelectedItem().equals("--Choose Month--")) {
            JOptionPane.showMessageDialog(this, "Please Select The month", "error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                // TODO add your handling code here:
                //        set to the send to print panel
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                int i = jTable1.getSelectedRow();
                String shedulYear = jTextField2.getText();
                String shedulMonth = jComboBox2.getSelectedItem().toString();

                String jobno = dtm.getValueAt(i, 0).toString();
                System.out.println(jobno);

                String title = dtm.getValueAt(i, 1).toString();
                String author = dtm.getValueAt(i, 2).toString();
                String isbn = dtm.getValueAt(i, 3).toString();

                System.out.println(title);
                System.out.println(author);
                System.out.println(isbn);

                ConnectionSet1.getInstance().setResult("insert into prnting_shedul(job_card_idjob_card,shedul_dte,status_printing,shedul_year) values('" + jobno + "','" + shedulMonth + "','No','" + shedulYear + "')");
                ConnectionSet1.getInstance().setResult("update grafic_jobs set printin_shedul='sendP' where job_card_idjob_card='" + jobno + "'");

                new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn from prnting_shedul ps1 inner join grafic_jobs g1 on ps1.job_card_idjob_card = g1.job_card_idjob_card inner join production_description p1 on g1.job_card_idjob_card = p1.job_card_idjob_card "
                        + "inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor Where status_printing='No'", jTable3);


                tableLoad();


            } catch (Exception ex) {
//                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Please Select The Row In Table", "error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            //        get back to the book rent to the print
            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            int i = jTable3.getSelectedRow();

            String jobno = dtm.getValueAt(i, 0).toString();
            System.out.println(jobno);

            String title = dtm.getValueAt(i, 1).toString();
            String author = dtm.getValueAt(i, 2).toString();
            String isbn = dtm.getValueAt(i, 3).toString();

            System.out.println(title);
            System.out.println(author);
            System.out.println(isbn);

            //ConnectionSet1.getInstance().setResult("update prnting_shedul set ");

            ConnectionSet1.getInstance().setResult("update grafic_jobs set printin_shedul='added' where job_card_idjob_card='" + jobno + "'");
            ConnectionSet1.getInstance().setResult("delete from prnting_shedul where job_card_idjob_card ='" + jobno + "'");
            dtm.removeRow(i);

            tableLoad();
        } catch (Exception ex) {
//            Logger.getLogger(printing_shedul.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Please Select The Row In Table", "error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        //shedul the printing details
//        String shedulYear = jTextField2.getText();
//        String shedulMonth = jComboBox2.getSelectedItem().toString();

//        DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();


//        for (int i = 0; i < dtm.getRowCount(); i++) {
//            System.out.println(i);
//            try {
//
//                ConnectionSet1.getInstance().setResult("update prnting_shedul set shedul_dte='" + shedulMonth + "',shedul_year='" + shedulYear + "' where idprnting_shedul = '" + i + "'");
//                System.out.println(i);
//                jTextField2.setText("");
//                jComboBox2.setSelectedIndex(0);
//                jTable3.removeAll();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }

        jTextField2.setText("");
        jComboBox2.setSelectedIndex(0);
        DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
        dtm.setRowCount(0);



    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            //search the printing shel details
            if (jTextField1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter The Year", "error", JOptionPane.WARNING_MESSAGE);
            } else if (jComboBox1.getSelectedItem().equals("--Choose Month--")) {
                JOptionPane.showMessageDialog(this, "Please Select The month", "error", JOptionPane.WARNING_MESSAGE);
            } else {

                tablemodel1.fillTable("select idjob_card,manuscript_name,fname,isbn from prnting_shedul p1 inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 "
                        + "on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where shedul_dte='" + jComboBox1.getSelectedItem().toString() + "' AND shedul_year='" + jTextField1.getText() + "'", jTable3);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(printing_shedul.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(printing_shedul.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(printing_shedul.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jTextField2.setText("");
        jComboBox2.setSelectedIndex(0);
        jTextField1.setText("");
        jComboBox1.setSelectedIndex(0);
        DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
        dtm.setRowCount(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            // TODO add your handling code here:
            //go back to home
            String uname = jLabel3.getText();
            String username = null;
            String desig = null;
            String typ = null;

            ResultSet rs = ConnectionSet1.getInstance().getResult("select * from user where username='" + uname + "'");
            if (rs.next()) {
                desig = rs.getString("designation");
                username = rs.getString("username");
                typ = rs.getString("user_type");

            }

            if (username.equals(uname) && typ.equals("Admin") && desig.equals("IT")) {
                System.out.println("3");
                new Menu("IT", "Admin", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("User") && desig.equals("Printing")) {
                new Menu("Printing", "User", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("Admin") && desig.equals("Publishing Manager")) {
                System.out.println("3");
                new Menu("Publishing Manager", "Admin", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("Admin") && desig.equals("MD")) {
                System.out.println("3");
                new Menu("MD", "Admin", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("User") && desig.equals("Assistant Publishing Manager")) {
                System.out.println("3");
                new Menu("Assistant Publishing Manager", "User", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("User") && desig.equals("Planner")) {
                System.out.println("3");
                new Menu("Planner", "User", uname).setVisible(true);
                dispose();

            }

            //            new Menu("Planner", "User", jLabel5.getText()).setVisible(true);
            //            dispose();
        } catch (Exception ex) {
            Logger.getLogger(Planner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (c != evt.VK_BACK_SPACE && c != evt.VK_DELETE) {

            if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {

                evt.consume();
            }
        }

        if (jTextField2.getText().length() == 4) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (c != evt.VK_BACK_SPACE && c != evt.VK_DELETE) {

            if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {

                evt.consume();
            }
        }

        if (jTextField1.getText().length() == 4) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

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
            java.util.logging.Logger.getLogger(printing_shedul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(printing_shedul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(printing_shedul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(printing_shedul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new printing_shedul().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
