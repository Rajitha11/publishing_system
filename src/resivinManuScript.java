
import com.org.DB.ConnectionSet1;
import com.org.clz.tablemodel1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tuan
 */
//  1st step
public class resivinManuScript extends javax.swing.JFrame {

    /**
     * Creates new form resivinManuScript
     */
    SimpleDateFormat d1, d2;
    Timer t;

    public resivinManuScript() {
        initComponents();
        //translation panel hide

        //call set date & time method
        dateMethod();

        //jlist hide
        jPanel3.setVisible(false);
        //hide new author
        jPanel1.setVisible(false);
        // load data from the table
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

    void tableLoad(){
        try {
            new tablemodel1().fillTable("select idrm,fname,contact_no,address,email,manuscript_name,catergory,ms_type from reseving_manuscript r1 inner join author t2 on r1.author_idauthor = t2.idauthor", jTable1);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(resivinManuScript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(resivinManuScript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(resivinManuScript.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
//    public String maxid(String columname, String table, int columno) throws Exception {
//        int i2 = 0;
//        ResultSet sr = ConnectionSet1.getInstance().getResult("SELECT * from " + table + " WHERE(SELECT Max(" + columname + ")FROM " + table + ")");
//        while (sr.next()) {
//            String id = sr.getString(columno);
//            int i = Integer.parseInt(id);
//            i2 = i + 1;
//        }
//        
//        return i2 + "".toString();
//    }
    //ownerid.setText(maxid("oid", "owner", 1));
    void save() {
        try {
            // save the content of resiving manuscript
            String mtype;
            String mediaty;
            //
            if (own.isSelected()) {
                mtype = "Own";
            } else {
                mtype = "Translation";
            }
            //
            if (hardc.isSelected()) {
                mediaty = "Hard Copy";
            } else if (cd.isSelected()) {
                mediaty = "CD/DVD";
            } else {
                mediaty = "USB";
            }

            if (jCheckBox1.isSelected()) {
                System.out.println("aaaaaaaaaa");

                ConnectionSet1.getInstance().setResult("insert into author(`author`.`fname`, `author`.`lname`, `author`.`contact_no`, `author`.`address`, `author`.`email`) values ('" + fname.getText() + "','" + ln.getText() + "','" + contct.getText() + "','" + addres.getText() + "','" + email.getText() + "')");
                System.out.println("bbbbbbbb");

                int author = 0;
                ResultSet rs = ConnectionSet1.getInstance().getResult("select idauthor from author where fname='"+fname.getText()+"' order by idauthor limit 1");
                System.out.println("ccccccc");
                if (rs.first()) {
                    author = rs.getInt("idauthor");
                }

                System.out.println("ddddddddddddd");
                ConnectionSet1.getInstance().setResult("insert into reseving_manuscript( `reseving_manuscript`.`manuscript_name`, `reseving_manuscript`.`catergory`, `reseving_manuscript`.`sub_catergory`, `reseving_manuscript`.`language`, `reseving_manuscript`.`qulification`, `reseving_manuscript`.`ms_type`, `reseving_manuscript`.`media_type`, `reseving_manuscript`.`date`, `reseving_manuscript`.`author_idauthor`)"
                        + " values ('" + nme_manuscript.getText() + "','" + catag.getSelectedItem() + "','" + sub_catag.getSelectedItem() + "','" + langu.getSelectedItem() + "','" + qulifi.getText() + "','" + mtype + "','" + mediaty + "','" + new Date() + "','" + author + "')");
                System.out.println("eeeeeeeeeeeee");


            } else {
                System.out.println("fffffffffff");
                int author = 0;
                ResultSet rs = ConnectionSet1.getInstance().getResult("select idauthor from author where fname='" + aname.getText() + "' order by idauthor limit 1");
                System.out.println("ggggggggggggggggggg");
                if (rs.first()) {
                    author = rs.getInt("idauthor");
                }

                System.out.println("hhhhhhhhhhhhh");
                ConnectionSet1.getInstance().setResult("insert into reseving_manuscript( `reseving_manuscript`.`manuscript_name`, `reseving_manuscript`.`catergory`, `reseving_manuscript`.`sub_catergory`, `reseving_manuscript`.`language`, `reseving_manuscript`.`qulification`, `reseving_manuscript`.`ms_type`, `reseving_manuscript`.`media_type`, `reseving_manuscript`.`date`, `reseving_manuscript`.`author_idauthor`)"
                        + " values ('" + nme_manuscript.getText() + "','" + catag.getSelectedItem() + "','" + sub_catag.getSelectedItem() + "','" + langu.getSelectedItem() + "','" + qulifi.getText() + "','" + mtype + "','" + mediaty + "','" + new Date() + "','" + author + "')");
                System.out.println("iiiiiiiiiiiiii");

            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    void clear(){
        //clear values
        jCheckBox1.setText("");
        aname.setText("");
        nme_manuscript.setText("");
        qulifi.setText("");
        fname.setText("");
        ln.setText("");
        contct.setText("");
        addres.setText("");
        email.setText("");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        contct = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addres = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        own = new javax.swing.JCheckBox();
        trans = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        hardc = new javax.swing.JCheckBox();
        cd = new javax.swing.JCheckBox();
        usb = new javax.swing.JCheckBox();
        qulifi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        sub_catag = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        catag = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        langu = new javax.swing.JComboBox();
        nme_manuscript = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        aname = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Receving The Manuscript");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 308, 58));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recive No", "Authour Name", "Contact No", "Address", "Email", "Script Name", "Catergory", "Script Type"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 1110, 160));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 295, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Search");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, 55, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 840, 108, 45));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 840, 108, 45));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Update");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 840, 108, 45));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Author Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("* Last Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("* Contact Number");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 62, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("* Email");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 93, -1, -1));
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 200, -1));
        jPanel1.add(contct, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 200, -1));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 270, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("* Current Address");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 62, -1, -1));

        addres.setColumns(20);
        addres.setRows(5);
        addres.setText("\n\n\n");
        jScrollPane1.setViewportView(addres);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 62, 360, 82));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("* Author First Name");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 31, -1, -1));
        jPanel1.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 1090, 160));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Date ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 210, 52));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 110, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Manuscript Details"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("* Manuscript Type");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        buttonGroup1.add(own);
        own.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        own.setText("Own Write");
        jPanel2.add(own, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        buttonGroup1.add(trans);
        trans.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        trans.setText("Translation");
        jPanel2.add(trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("* Media Of The Manuscript");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        buttonGroup2.add(hardc);
        hardc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hardc.setText("Hard Copy");
        jPanel2.add(hardc, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, -1, -1));

        buttonGroup2.add(cd);
        cd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cd.setText("CD/CVD");
        jPanel2.add(cd, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, -1, -1));

        buttonGroup2.add(usb);
        usb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usb.setText("USB");
        jPanel2.add(usb, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, -1, -1));
        jPanel2.add(qulifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 350, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("* Qulifications ");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 120, -1));

        sub_catag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(sub_catag, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 206, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("* Sub Catergory");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("* Subject (Catergory)");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        catag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(catag, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 206, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("* Language ");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 120, -1));

        langu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(langu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 206, -1));
        jPanel2.add(nme_manuscript, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 270, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("* Name Of The Manuscript");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("* Received No ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 1080, 190));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCheckBox1.setText("* New Author");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("* Author Name");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, -1, -1));

        aname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                anameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anameKeyReleased(evt);
            }
        });
        getContentPane().add(aname, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 350, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // insert to the database
        save();
        clear();
        tableLoad();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        //select new author
        if (jCheckBox1.isSelected()) {
            jPanel1.setVisible(true);
        } else {
            jPanel1.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void anameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anameKeyReleased
        // TODO add your handling code here:
        // get result author names
        if(!aname.getText().isEmpty()){
            
            try {
                
                jPanel3.setVisible(true);
                ResultSet rs = ConnectionSet1.getInstance().getResult("select * from author where fname like('" + aname.getText() + "%%%%%" + "')");
                
                Vector v = new Vector();
                while(rs.next()){
                    v.add(rs.getString("fname"));
                }
                
                jList1.setListData(v);
                
                
            } catch (Exception ex) {
                Logger.getLogger(resivinManuScript.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            jPanel3.setVisible(false);
        }
    }//GEN-LAST:event_anameKeyReleased

    private void anameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anameKeyPressed
        // TODO add your handling code here:
        //select the name
        if(evt.getKeyCode()== 40){
            jList1.requestFocus();
        }
    }//GEN-LAST:event_anameKeyPressed

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed
        // TODO add your handling code here:
        // set author name for the textfeild
        if(evt.getKeyCode() == 10){
            String an = jList1.getSelectedValue().toString();
            aname.setText(an);
            
            jPanel3.setVisible(false);
        }
    }//GEN-LAST:event_jList1KeyPressed

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
            java.util.logging.Logger.getLogger(resivinManuScript.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(resivinManuScript.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(resivinManuScript.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(resivinManuScript.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new resivinManuScript().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addres;
    private javax.swing.JTextField aname;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox catag;
    private javax.swing.JCheckBox cd;
    private javax.swing.JTextField contct;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JCheckBox hardc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JComboBox langu;
    private javax.swing.JTextField ln;
    private javax.swing.JTextField nme_manuscript;
    private javax.swing.JCheckBox own;
    private javax.swing.JTextField qulifi;
    private javax.swing.JComboBox sub_catag;
    private javax.swing.JCheckBox trans;
    private javax.swing.JCheckBox usb;
    // End of variables declaration//GEN-END:variables
}
