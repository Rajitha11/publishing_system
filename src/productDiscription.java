
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
import javax.swing.DefaultComboBoxModel;
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
public class productDiscription extends javax.swing.JFrame {

    /**
     * Creates new form productDiscription
     */
    SimpleDateFormat d1, d2;
    Timer t;

    public productDiscription() {
        initComponents();

        dateMethod();

        loadPaperTyp();
        loadBoardtp();
        loadGauge();
        bindingTyp();
    }

    productDiscription(String uname) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this();
        jLabel5.setText(uname);
        tableLoad();

    }

    void bindingTyp() {
        try {
            ResultSet rs = ConnectionSet1.getInstance().getResult("select * from binding");
            Vector v = new Vector();
            while (rs.next()) {
                String bt = rs.getString("binding_typ");
                jComboBox5.addItem(bt);
            }
        } catch (Exception ex) {
            Logger.getLogger(productDiscription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void loadPaperTyp() {
        try {
            ResultSet rs = ConnectionSet1.getInstance().getResult("select * from paper_type");
            Vector v = new Vector();
            while (rs.next()) {
                //v.add(rs.getString("ptname"));
                String s9 = rs.getString("ptname");
                jComboBox1.addItem(s9);
//                
            }
            //jComboBox1.setModel(new DefaultComboBoxModel(v));
        } catch (Exception ex) {
            Logger.getLogger(productDiscription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void loadBoardtp() {
        try {
            ResultSet rs = ConnectionSet1.getInstance().getResult("select * from board_type");
//            Vector v = new Vector();
            while (rs.next()) {
//                v.add(rs.getString("btname"));
                String s9 = rs.getString("btname");
                jComboBox2.addItem(s9);
//                
            }
//            jComboBox2.setModel(new DefaultComboBoxModel(v));
        } catch (Exception ex) {
            Logger.getLogger(productDiscription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void loadGauge() {
        try {
            ResultSet rs = ConnectionSet1.getInstance().getResult("select * from gauge");
//            Vector v = new Vector();
            while (rs.next()) {
//                v.add(rs.getString("gtyp"));
                String s9 = rs.getString("gtyp");
                jComboBox3.addItem(s9);
                jComboBox4.addItem(s9);
//                
            }
//            jComboBox3.setModel(new DefaultComboBoxModel(v));
//            jComboBox4.setModel(new DefaultComboBoxModel(v));
        } catch (Exception ex) {
            Logger.getLogger(productDiscription.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn,pduct_sz,nm_pages,print_qty,innr_paper_typ,cver_brd_typ,imprint_check,remark_pd from production_description p1 inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor", jTable1);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productDiscription.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(productDiscription.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(productDiscription.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Product Description");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Product Description");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 280, 58));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("Date ");
        getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 210, 52));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 110, 30));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Discription", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Book Title", "Author ", "ISBN", "Product Size", "Number Of Pages", "Print Quantity", "Inner Paper Type", "Cover Board Type", "Imprint Checked", "Remark"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1090, 190));
        jPanel8.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 295, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Search");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 55, -1));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1130, 260));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Description Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Product Size");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jTextField6.setEditable(false);
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 290, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("* Remark");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        jTextField2.setToolTipText("YOUR NAME");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 250, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Number Of Pages");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jTextField4.setEditable(false);
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 290, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Paper Type");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 230, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("* Inner Pages");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("* Cover");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Board Type");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 230, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Gauge");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Gauge");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("* Binding");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, -1, -1));

        jTextField7.setToolTipText("Eg- 1000");
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 250, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("* Imprint Checked By");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 430, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Book Title");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Author");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jTextField9.setEditable(false);
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 290, -1));

        jTextField10.setEditable(false);
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 290, -1));

        jTextField11.setEditable(false);
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 250, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Job Card No");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, 230, -1));

        jPanel1.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, 230, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("ISBN");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 90, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("* Print Quantity");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, -1));

        jPanel1.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 140, 250, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 1070, 400));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 830, 108, 45));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Update");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 830, 108, 45));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 830, 108, 45));

        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 70, 0, 10));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/home.png"))); // NOI18N
        jButton12.setContentAreaFilled(false);
        jButton12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/home1.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 70));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 830, 90, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/sarasavi.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 267, 65));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            // TODO add your handling code here:
            //set value for the feilds
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            int i = jTable1.getSelectedRow();
            String job_card = dtm.getValueAt(i, 0).toString();
            ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card,manuscript_name,fname,isbn,pduct_sz,nm_pages,print_qty,innr_paper_typ,cver_brd_typ,imprint_check,remark_pd,innr_paper_gauge,cver_brd_gauge,binding_typ from production_description p1 inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where idjob_card='" + job_card + "'");

            if (rs.next()) {

                String s1 = rs.getString("idjob_card");
                jLabel4.setText(s1);

                String s2 = rs.getString("manuscript_name");
                jTextField9.setText(s2);

                String s3 = rs.getString("fname");
                jTextField10.setText(s3);

                String s4 = rs.getString("isbn");
                jTextField11.setText(s4);

                String s5 = rs.getString("pduct_sz");
                jTextField6.setText(s5);

                String s6 = rs.getString("nm_pages");
                jTextField4.setText(s6);

                String s7 = rs.getString("print_qty");
                jTextField7.setText(s7);

                String s8 = rs.getString("innr_paper_typ");
                Vector v = new Vector();
                v.add(s8);
                jComboBox1.setModel(new DefaultComboBoxModel(v));

                String s9 = rs.getString("cver_brd_typ");
                Vector v1 = new Vector();
                v1.add(s9);
                jComboBox2.setModel(new DefaultComboBoxModel(v1));

                String s10 = rs.getString("imprint_check");
                jTextField2.setText(s10);

                String s11 = rs.getString("remark_pd");
                jTextArea1.setText(s11);

                String s12 = rs.getString("innr_paper_gauge");
                Vector v2 = new Vector();
                v2.add(s12);
                jComboBox3.setModel(new DefaultComboBoxModel(v2));

                String s13 = rs.getString("cver_brd_gauge");
                Vector v3 = new Vector();
                v3.add(s13);
                jComboBox4.setModel(new DefaultComboBoxModel(v3));

                String s14 = rs.getString("binding_typ");
                Vector v4 = new Vector();
                v4.add(s14);
                jComboBox5.setModel(new DefaultComboBoxModel(v4));


            }

            loadPaperTyp();
            loadBoardtp();
            loadGauge();
            bindingTyp();

        } catch (Exception ex) {
            Logger.getLogger(productDiscription.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jLabel4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select Job Card details", "Error", JOptionPane.WARNING_MESSAGE);

        } else if (!jLabel4.getText().isEmpty()) {
            try {
                ResultSet rs = ConnectionSet1.getInstance().getResult("select imprint_check from production_description where imprint_check is null");
                if (rs.next()) {
                    if (!jTextField2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please Enter The In Print Checked By Feild", "error", JOptionPane.WARNING_MESSAGE);

                    } else {
                        try {
                            // TODO add your handling code here:
                            //save the data 
                            String qty = jTextField7.getText();
                            String ptyp = jComboBox1.getSelectedItem().toString();
                            String ptyp_ga = jComboBox3.getSelectedItem().toString();
                            String brtyp = jComboBox2.getSelectedItem().toString();
                            String brtyp_ga = jComboBox4.getSelectedItem().toString();
                            String impnt_check = jTextField2.getText();
                            String remrk = jTextArea1.getText();
                            String bindinty = jComboBox5.getSelectedItem().toString();

                            ConnectionSet1.getInstance().setResult("update production_description set print_qty='" + qty + "',innr_paper_typ='" + ptyp + "',innr_paper_gauge='" + ptyp_ga + "',cver_brd_typ='" + brtyp + "',cver_brd_gauge='" + brtyp_ga + "',imprint_check='" + impnt_check + "',remark_pd='" + remrk + "',binding_typ='" + bindinty + "' where job_card_idjob_card='" + jLabel4.getText() + "'");

                            jTextField7.setText("");
                            jComboBox1.setSelectedIndex(0);
                            jComboBox3.setSelectedIndex(0);
                            jComboBox2.setSelectedIndex(0);
                            jComboBox4.setSelectedIndex(0);
                            jComboBox5.setSelectedIndex(0);
                            jTextField2.setText("");
                            jTextArea1.setText("");
                            jLabel4.setText("");
                            jTextField11.setText("");
                            jTextField9.setText("");
                            jTextField10.setText("");
                            jTextField6.setText("");
                            jTextField4.setText("");
                            tableLoad();

                        } catch (Exception ex) {
                            Logger.getLogger(productDiscription.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "This Job Card is Allready Assinged", "error", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception ex) {
                Logger.getLogger(productDiscription.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jLabel4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select Job Card details", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                // TODO add your handling code here:
                //        update the data product description
                String qty = jTextField7.getText();
                String ptyp = jComboBox1.getSelectedItem().toString();
                String ptyp_ga = jComboBox3.getSelectedItem().toString();
                String brtyp = jComboBox2.getSelectedItem().toString();
                String brtyp_ga = jComboBox4.getSelectedItem().toString();
                String impnt_check = jTextField2.getText();
                String remrk = jTextArea1.getText();
                String bindinty = jComboBox5.getSelectedItem().toString();

                ConnectionSet1.getInstance().setResult("update production_description set print_qty='" + qty + "',innr_paper_typ='" + ptyp + "',innr_paper_gauge='" + ptyp_ga + "',cver_brd_typ='" + brtyp + "',cver_brd_gauge='" + brtyp_ga + "',imprint_check='" + impnt_check + "',remark_pd='" + remrk + "',binding_typ='" + bindinty + "' where job_card_idjob_card='" + jLabel4.getText() + "'");

                jTextField7.setText("");
                jComboBox1.setSelectedIndex(0);
                jComboBox3.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(0);
                jComboBox4.setSelectedIndex(0);
                jComboBox5.setSelectedIndex(0);
                jTextField2.setText("");
                jTextArea1.setText("");
                jLabel4.setText("");
                jTextField11.setText("");
                jTextField9.setText("");
                jTextField10.setText("");
                jTextField6.setText("");
                jTextField4.setText("");
                tableLoad();
            } catch (Exception ex) {
                Logger.getLogger(productDiscription.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            // TODO add your handling code here:
            //go home
            String uname = jLabel5.getText();
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

            } else if (username.equals(uname) && typ.equals("Admin") && desig.equals("Publishing Manager")) {
                new Menu("Publishing Manager", "Admin", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("User") && desig.equals("Assistant Publishing Manager")) {
                System.out.println("3");
                new Menu("Assistant Publishing Manager", "User", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("Admin") && desig.equals("MD")) {
                System.out.println("3");
                new Menu("MD", "Admin", uname).setVisible(true);
                dispose();

            }
        } catch (Exception ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        jTextArea1.grabFocus();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
//        clear all the data
        jTextField7.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jTextField2.setText("");
        jTextArea1.setText("");
        jLabel4.setText("");
        jTextField11.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField6.setText("");
        jTextField4.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (c != evt.VK_BACK_SPACE && c != evt.VK_DELETE) {

            if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {

                evt.consume();
            }
        }
    }//GEN-LAST:event_jTextField7KeyTyped

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
            java.util.logging.Logger.getLogger(productDiscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productDiscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productDiscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productDiscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productDiscription().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
