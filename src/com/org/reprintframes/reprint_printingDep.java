/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.reprintframes;

import com.org.DB.ConnectionSet1;
import com.org.clz.tablemodel1;
import com.toedter.calendar.JDateChooser;
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
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuan
 */
public class reprint_printingDep extends javax.swing.JFrame {

    /**
     * Creates new form reprint_printingDep
     */
    
    SimpleDateFormat d1, d2;
    Timer t;
    
    public reprint_printingDep() {
        initComponents();
        
        dateMethod();
        
        loadBoardtp();
        loadPaperTyp();
        loadGauge();
        bindingTyp();
        
        tabelLaod();
        
    }
    
    
    void dateMethod() {
        //set date & time
        d1 = new SimpleDateFormat("yyyy/ MMM/ dd/ EEEE");
        d2 = new SimpleDateFormat("  hh:mm aaa");
        t = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                date.setText(d1.format(d));
                time.setText(d2.format(d));


            }
        });
        t.start();
    }
    
    void bindingTyp() {
        try {
            ResultSet rs = ConnectionSet1.getInstance().getResult("select * from binding");
                Vector v = new Vector();
                while (rs.next()) {
                    String bt = rs.getString("binding_typ");
                    jComboBox1.addItem(bt);
                }
        } catch (Exception ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    void loadPaperTyp() {
        try {
            ResultSet rs = ConnectionSet1.getInstance().getResult("select * from paper_type");
                Vector v = new Vector();
                while (rs.next()) {
                    //v.add(rs.getString("ptname"));
                    String s9 = rs.getString("ptname");
                    jComboBox5.addItem(s9);
    //                
                }
        } catch (Exception ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    void tabelLaod(){
        try {
            
            new tablemodel1().fillTable("select idreprint_stores,deliver_printing,isbn,manuscript_name,printer,paper_typ,qty_sagest,smpl_cpy,book_cver from reprint_publishing rpp1 inner join reprint_stores rps1 on rpp1.reprint_stores_idreprint_stores = rps1.idreprint_stores inner join job_card j1 on rps1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where pub_status = 'approv'", jTable3);
            new tablemodel1().fillTable("select idreprint_stores,manuscript_name,isbn,printer,paper_type,bordr_typ,estimte_qty,estimte_cost,estimte_unit from reprint_printingdep pd1 inner join reprint_stores s1 on pd1.reprint_stores_idreprint_stores = s1.idreprint_stores inner join reprint_publishing p1 on s1.idreprint_stores = p1.reprint_stores_idreprint_stores inner join job_card j1 on s1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript m1 on j1.reseving_manuscript_idrm = m1.idrm where status_prnt='approv print'", jTable2);
            new tablemodel1().fillTable("select idreprint_stores,apply_dte,isbn,manuscript_name,fname,recomd_price,print_attempt,mve from reprint_stores rps1 inner join costing c1 on rps1.job_card_idjob_card = c1.job_card_idjob_card inner join job_card j1 on c1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where reprntaply = 'apply'", jTable7);
            new tablemodel1().fillTable("select idreprint_stores,apply_dte,isbn,manuscript_name,fname,recomd_price,print_attempt,mve from reprint_stores rps1 inner join reprint_publishing pub1 on rps1.idreprint_stores = pub1.reprint_stores_idreprint_stores inner join costing c1 on rps1.job_card_idjob_card = c1.job_card_idjob_card inner join job_card j1 on c1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where pub_status = 'approv'", jTable6);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void clearall(){
    
        jLabel14.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField6.setText("");
        jTextField4.setText("");
//        loadBoardtp();
//        loadGauge();
//        loadPaperTyp();
//        bindingTyp();
        jComboBox5.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jTextField11.setText("");
        jLabel5.setText("");
        jComboBox1.setSelectedIndex(0);
        jTextArea1.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
        jTextField8.setText("");
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBox5 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField12 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField13 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        time2 = new javax.swing.JLabel();
        date2 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setText("Reprint Request Form");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, 40));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 290, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField2.setToolTipText("ISBN or Book Name");
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 210, 30));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/search.png"))); // NOI18N
        jButton4.setToolTipText("Search");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 40, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 100, 30));

        date.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 240, 41));

        time.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, 140, 26));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reprint No", "Book Title", "ISBN", "Printer", "Paper type", "Cover type", "Est: Quantity", "Est: Cost", "Est: Unit Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, 1100, 140));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Description Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Product Size");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jTextField6.setEditable(false);
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 290, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("* Remark");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Number Of Pages");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jTextField4.setEditable(false);
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 290, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Paper Type");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Perfect Binding", "Center Wire" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 160, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("* Inner Pages");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("* Cover");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Board Type");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, -1));

        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 200, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Gauge");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Gauge");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("* Binding ");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 90, 30));

        jTextArea1.setColumns(5);
        jTextArea1.setRows(5);
        jTextArea1.setTabSize(2);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 180, 270, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Book Title");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Author");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel2.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 290, -1));

        jTextField10.setEditable(false);
        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel2.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 290, -1));

        jTextField11.setEditable(false);
        jPanel2.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 250, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Job Card No");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, 30));

        jPanel2.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 100, -1));

        jPanel2.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 100, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("ISBN");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 50, -1));
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 90, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Last Production Cost");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Year", "month", "QTY", "Cost", "Unit Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setHeaderValue("Year");
        jTable1.getColumnModel().getColumn(1).setHeaderValue("month");
        jTable1.getColumnModel().getColumn(2).setHeaderValue("QTY");
        jTable1.getColumnModel().getColumn(3).setHeaderValue("Cost");
        jTable1.getColumnModel().getColumn(4).setHeaderValue("Unit Cost");

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 520, 50));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Estimated Printing ");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, -1, 30));

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 130, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("*Quantity ");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 70, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("*Cost");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 60, 30));

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 130, 30));

        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, 130, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("*Unit Cost");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 70, 30));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 1100, 10));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 10, 140));

        jPanel2.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 200, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("SUBMIT");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 270, 100, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("CLEAR");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 310, 100, 30));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(jTable4);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 520, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 1120, 390));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Copyright © All Rights Reserved at Sarasavi Publishers");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 880, 500, 20));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reprint No", "Delivery Date", "ISBN", "Book Title", "Printer", "Paper type", "Quantity Suggested", "Sampel copies", "Book Cover"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1120, 160));

        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField12.setToolTipText("ISBN or Book Name");
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 680, 220, 30));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/search.png"))); // NOI18N
        jButton5.setToolTipText("Search");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 680, 40, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Printing Department");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, 20));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/sarasavi.png"))); // NOI18N
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 267, 65));

        jTabbedPane1.addTab("Reprint Request Form", jPanel1);

        jPanel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Printing Department");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, 20));
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 290, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Search");
        jButton3.setToolTipText("Search");
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 98, 29));

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField7.setToolTipText("ISBN or Book Name");
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });
        jPanel4.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 223, 29));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Search");
        jButton6.setToolTipText("Search");
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 98, 29));

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField13.setToolTipText("ISBN or Book Name");
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField13KeyReleased(evt);
            }
        });
        jPanel4.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 223, 29));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reprint Accepted  Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reprint No", "Added Date", "ISBN", "Book Title", "Author Name", "Price", "Print Attempt", "Move"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jTable6);

        jPanel5.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 28, 1100, 230));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 1120, 280));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reprint Requested Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reprint No", "Added Date", "ISBN", "Book Title", "Author Name", "Price", "Print Attempt", "Move"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(jTable7);

        jPanel6.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1100, 180));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1120, 220));

        time2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel4.add(time2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, 140, 26));

        date2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel4.add(date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 240, 41));

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Copyright © All Rights Reserved at Sarasavi Publishers");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 850, 500, 20));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel29.setText("Reprint Details");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, 40));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/sarasavi.png"))); // NOI18N
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 267, 65));

        jTabbedPane1.addTab("Applied Reprints", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 900));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        clear the feilds
        clearall();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        try {
            // TODO add your handling code here:
    //        set data to the fields
            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            int i = jTable3.getSelectedRow();
            String reprintNo = dtm.getValueAt(i, 0).toString();
            
            ResultSet rs = ConnectionSet1.getInstance().getResult("select idreprint_stores,manuscript_name,fname,pduct_sz,nm_pages,innr_paper_typ,innr_paper_gauge,cver_brd_typ,cver_brd_gauge,isbn,idjob_card,binding_typ from reprint_publishing repd1 inner join reprint_stores res1 on repd1.reprint_stores_idreprint_stores = res1.idreprint_stores inner join job_card j1 "
                    + "on res1.job_card_idjob_card = j1.idjob_card inner join costing c1 on j1.idjob_card = c1.job_card_idjob_card inner join production_description pd1 on c1.job_card_idjob_card = pd1.job_card_idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where pub_status = 'approv'");
            
            if(rs.next()){
                String repID = rs.getString("idreprint_stores");
                jLabel14.setText(repID);
                
                String titel = rs.getString("manuscript_name");
                jTextField9.setText(titel);
                
                String author = rs.getString("fname");
                jTextField10.setText(author);
                
                String psiz = rs.getString("pduct_sz");
                jTextField6.setText(psiz);
                
                String nop = rs.getString("nm_pages");
                jTextField4.setText(nop);
                
                String inerpaprtyp = rs.getString("innr_paper_typ");
                Vector v = new Vector();
                v.add(inerpaprtyp);
                jComboBox5.setModel(new DefaultComboBoxModel(v));
                
                String inerpaprgage = rs.getString("innr_paper_gauge");
                Vector v1 = new Vector();
                v1.add(inerpaprgage);
                jComboBox3.setModel(new DefaultComboBoxModel(v1));
                
                String cvrbrdrtyp = rs.getString("cver_brd_typ");
                Vector v2 = new Vector();
                v2.add(cvrbrdrtyp);
                jComboBox2.setModel(new DefaultComboBoxModel(v2));
                
                String cvrbrdrgage = rs.getString("cver_brd_gauge");
                Vector v3 = new Vector();
                v3.add(cvrbrdrgage);
                jComboBox4.setModel(new DefaultComboBoxModel(v3));
                
                String isbn = rs.getString("isbn");
                jTextField11.setText(isbn);
                
                String jobno = rs.getString("idjob_card");
                jLabel5.setText(jobno);
                
                String bindintyp = rs.getString("binding_typ");
                Vector v4 = new Vector();
                v4.add(bindintyp);
                jComboBox1.setModel(new DefaultComboBoxModel(v4));
                
                ResultSet rs1 = ConnectionSet1.getInstance().getResult("select shedul_year,shedul_dte,qty,total_cost,unit_price from printing p1 inner join prnting_shedul ph1 on p1.prnting_shedul_idprnting_shedul = ph1.idprnting_shedul inner join job_card j1 on ph1.job_card_idjob_card = j1.idjob_card inner join costing c1 on j1.idjob_card = c1.job_card_idjob_card");
                if(rs1.next()){
                    new tablemodel1().fillTable("select shedul_year,shedul_dte,qty,total_cost,unit_price from printing p1 inner join prnting_shedul ph1 on p1.prnting_shedul_idprnting_shedul = ph1.idprnting_shedul inner join job_card j1 on ph1.job_card_idjob_card = j1.idjob_card inner join costing c1 on j1.idjob_card = c1.job_card_idjob_card where idjob_card='"+jLabel5.getText()+"'", jTable1);
                }
                
                ResultSet rs2 = ConnectionSet1.getInstance().getResult("select rp_shedul_year,rp_shedul_dte,rp_qty,estimte_cost,estimte_unit from reprinting rp1 inner join reprint_prntshedul resh1 on rp1.reprint_prntshedul_idreprint_prntshedul = resh1.idreprint_prntshedul inner join reprint_stores res1 on resh1.reprint_stores_idreprint_stores = res1.idreprint_stores inner join reprint_printingdep rprd1 on res1.idreprint_stores = rprd1.reprint_stores_idreprint_stores inner join job_card j1 on res1.job_card_idjob_card = j1.idjob_card");
                if(rs2.next()){
                    new tablemodel1().fillTable("select rp_shedul_year,rp_shedul_dte,rp_qty,estimte_cost,estimte_unit from reprinting rp1 inner join reprint_prntshedul resh1 on rp1.reprint_prntshedul_idreprint_prntshedul = resh1.idreprint_prntshedul inner join reprint_stores res1 on resh1.reprint_stores_idreprint_stores = res1.idreprint_stores inner join reprint_printingdep rprd1 on res1.idreprint_stores = rprd1.reprint_stores_idreprint_stores inner join job_card j1 on res1.job_card_idjob_card = j1.idjob_card", jTable4);
                }
                
            }
            loadPaperTyp();
            loadBoardtp();
            loadGauge();
            bindingTyp();
            
        } catch (Exception ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
    //        save the data
            String bind = jComboBox1.getSelectedItem().toString();
            String ptyp = jComboBox5.getSelectedItem().toString();
            String pgage = jComboBox3.getSelectedItem().toString();
            String btyp = jComboBox2.getSelectedItem().toString();
            String bgage = jComboBox4.getSelectedItem().toString();
            String remrk = jTextArea1.getText();
            String qty = jTextField3.getText();
            String cost = jTextField5.getText();
            String unitcost = jTextField8.getText();
            
            int reprintid = 0;
            ResultSet rs = ConnectionSet1.getInstance().getResult("select idreprint_stores from reprint_stores where idreprint_stores='" + jLabel14.getText() + "'");
            if (rs.next()) {
                reprintid = rs.getInt("idreprint_stores");
            }
            
            ConnectionSet1.getInstance().setResult("insert into reprint_printingdep(binding,paper_type,paper_gauge,bordr_typ,bordr_gauge,remark_reprint,estimte_qty,estimte_cost,estimte_unit,reprint_stores_idreprint_stores,status_prnt) values('"+bind+"','"+ptyp+"','"+pgage+"','"+btyp+"','"+bgage+"','"+remrk+"','"+qty+"','"+cost+"','"+unitcost+"','"+reprintid+"','approv print')");
            
//            ConnectionSet1.getInstance().setResult("update reprint_stores set reprntaply='approv print' where idreprint_stores='" + reprintid + "'");
            
            clearall();
            tabelLaod();
            
        } catch (Exception ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        try {
            // TODO add your handling code here:
    //        search the data
            new tablemodel1().fillTable("select idreprint_stores,deliver_printing,isbn,manuscript_name,printer,paper_typ,qty_sagest,smpl_cpy,book_cver from reprint_publishing rpp1 inner join reprint_stores rps1 on rpp1.reprint_stores_idreprint_stores = rps1.idreprint_stores inner join job_card j1 on rps1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where reprntaply = 'approv' AND (fname like('" + jTextField2.getText() + "%%" + "') or manuscript_name like('" + jTextField2.getText() + "%%%" + "') or isbn like('" + jTextField2.getText() + "%%%" + "'))", jTable3);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        try {
            // TODO add your handling code here:
            new tablemodel1().fillTable("select idreprint_stores,manuscript_name,isbn,printer,paper_type,bordr_typ,estimte_qty,estimte_cost,estimte_unit from reprint_printingdep pd1 inner join reprint_stores s1 on pd1.reprint_stores_idreprint_stores = s1.idreprint_stores inner join reprint_publishing p1 on s1.idreprint_stores = p1.reprint_stores_idreprint_stores inner join job_card j1 on s1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript m1 on j1.reseving_manuscript_idrm = m1.idrm where status_prnt='approv print' AND (manuscript_name like('" + jTextField12.getText() + "%%%" + "') or isbn like('" + jTextField12.getText() + "%%%" + "'))", jTable2);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        try {
            // TODO add your handling code here:
            new tablemodel1().fillTable("select idreprint_stores,apply_dte,isbn,manuscript_name,fname,recomd_price,print_attempt,mve from reprint_stores rps1 inner join costing c1 on rps1.job_card_idjob_card = c1.job_card_idjob_card inner join job_card j1 on c1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where reprntaply = 'apply' AND (manuscript_name like('" + jTextField7.getText() + "%%%" + "') or isbn like('" + jTextField7.getText() + "%%%" + "'))", jTable7);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyReleased
        try {
            // TODO add your handling code here:
            new tablemodel1().fillTable("select idreprint_stores,apply_dte,isbn,manuscript_name,fname,recomd_price,print_attempt,mve from reprint_stores rps1 inner join reprint_publishing pub1 on rps1.idreprint_stores = pub1.reprint_stores_idreprint_stores inner join costing c1 on rps1.job_card_idjob_card = c1.job_card_idjob_card inner join job_card j1 on c1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where pub_status = 'approv' AND (manuscript_name like('" + jTextField13.getText() + "%%%" + "') or isbn like('" + jTextField13.getText() + "%%%" + "'))", jTable6);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(reprint_printingDep.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jTextField13KeyReleased

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
//        validate
        char c = evt.getKeyChar();

        if (c != evt.VK_BACK_SPACE && c != evt.VK_DELETE) {

            if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {

                evt.consume();
            }
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
//        validate
        char c = evt.getKeyChar();

        if (c != evt.VK_BACK_SPACE && c != evt.VK_DELETE) {

            if (!(c == '.' || c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {

                evt.consume();
            }
        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        // TODO add your handling code here:
//        validate
        char c = evt.getKeyChar();

        if (c != evt.VK_BACK_SPACE && c != evt.VK_DELETE) {

            if (!(c == '.' || c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {

                evt.consume();
            }
        }
    }//GEN-LAST:event_jTextField8KeyTyped

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
            java.util.logging.Logger.getLogger(reprint_printingDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reprint_printingDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reprint_printingDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reprint_printingDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reprint_printingDep().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JLabel date2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel time;
    private javax.swing.JLabel time2;
    // End of variables declaration//GEN-END:variables
}
