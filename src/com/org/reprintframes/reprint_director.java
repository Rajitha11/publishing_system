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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuan
 */
public class reprint_director extends javax.swing.JFrame {

    /**
     * Creates new form reprint_director
     */
    SimpleDateFormat d1, d2;
    Timer t;

    public reprint_director() {
        initComponents();

        dateMethod();
        tableLoad();
    }

    public static String datechosser(JDateChooser jd) {
        SimpleDateFormat sd = new SimpleDateFormat("dd /MMMM /yyyy");
        Date d = jd.getDate();
        String date = sd.format(d);
        System.out.println(date);
        return date;

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

    void tableLoad() {
        try {
            new tablemodel1().fillTable("select idreprint_stores,manuscript_name,isbn,printer,paper_type,bordr_typ,estimte_qty,estimte_cost,estimte_unit from reprint_printingdep pd1 inner join reprint_stores s1 on pd1.reprint_stores_idreprint_stores = s1.idreprint_stores inner join reprint_publishing p1 on s1.idreprint_stores = p1.reprint_stores_idreprint_stores inner join job_card j1 on s1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript m1 on j1.reseving_manuscript_idrm = m1.idrm where status_prnt='approv print'", jTable3);
            new tablemodel1().fillTable("select idreprint_stores,manuscript_name,isbn,fname,prasant_priz,revised_priz,reprint_qty,reprint_approv_dte,reprint_approv from reprint_director d1 inner join reprint_stores rs1 on d1.reprint_stores_idreprint_stores = rs1.idreprint_stores inner join job_card j1 on rs1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript m1 on j1.reseving_manuscript_idrm = m1.idrm inner join author a1 on m1.author_idauthor = a1.idauthor where dir_status='dapprov'", jTable2);
            new tablemodel1().fillTable("select idreprint_stores,manuscript_name,isbn,fname,prasant_priz,revised_priz,reprint_qty,reprint_approv_dte,reprint_approv from reprint_director d1 inner join reprint_stores rs1 on d1.reprint_stores_idreprint_stores = rs1.idreprint_stores inner join job_card j1 on rs1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript m1 on j1.reseving_manuscript_idrm = m1.idrm inner join author a1 on m1.author_idauthor = a1.idauthor where reprint_approv='Approv' AND dir_status='dapprov'", jTable4);
            new tablemodel1().fillTable("select idreprint_stores,manuscript_name,isbn,fname,prasant_priz,revised_priz,reprint_qty,reprint_approv_dte,reprint_approv from reprint_director d1 inner join reprint_stores rs1 on d1.reprint_stores_idreprint_stores = rs1.idreprint_stores inner join job_card j1 on rs1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript m1 on j1.reseving_manuscript_idrm = m1.idrm inner join author a1 on m1.author_idauthor = a1.idauthor where reprint_approv='Reject' AND dir_status='dapprov'", jTable5);
            new tablemodel1().fillTable("select idreprint_stores,apply_dte,isbn,manuscript_name,fname,recomd_price,print_attempt,mve from reprint_stores rps1 inner join costing c1 on rps1.job_card_idjob_card = c1.job_card_idjob_card inner join job_card j1 on c1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where reprntaply = 'apply'", jTable7);
            new tablemodel1().fillTable("select idreprint_stores,apply_dte,isbn,manuscript_name,fname,recomd_price,print_attempt,mve from reprint_publishing rpp1 inner join reprint_stores rps1 on rpp1.reprint_stores_idreprint_stores = rps1.idreprint_stores inner join costing c1 on rps1.job_card_idjob_card = c1.job_card_idjob_card inner join job_card j1 on c1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where pub_status = 'approv'", jTable6);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reprint_director.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reprint_director.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(reprint_director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void clear() {
        jLabel14.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField7.setText("");
        jTextField4.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jTextField6.setText("");
        jTextField14.setText("");
        jLabel5.setText("");
        jTextField11.setText("");
        jTextField1.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
        jTextField8.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jDateChooser1.setDate(null);
        jTextField18.setText("");
        buttonGroup1.clearSelection();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField7 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField19 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField20 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jTextField21 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jCheckBox5 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jTextField22 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jTextField23 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        time1 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setText("Reprint Approval ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, 40));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 290, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField2.setToolTipText("ISBN or Book Name");
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 210, 30));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/search.png"))); // NOI18N
        jButton4.setToolTipText("Search");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 40, 30));

        date.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 240, 41));

        time.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, 140, 26));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reprint No", "Book Title", "ISBN", "Author", "Present Price", "Revised Price", "Quantity", "Approval Date", "Approval"
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 1120, 140));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 100, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Description Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Product Size");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jTextField6.setEditable(false);
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 210, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Number Of Pages");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jTextField4.setEditable(false);
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 120, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Paper Type");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Inner Pages :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Cover           :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Board Type");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Gauge");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Gauge");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Binding ");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 90, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Book Title");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Author");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel2.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 260, -1));

        jTextField10.setEditable(false);
        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel2.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 260, -1));

        jTextField11.setEditable(false);
        jPanel2.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 250, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Job Card No");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("ISBN");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 50, -1));

        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 120, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Estimated Printing Cost");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, -1, 30));

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 120, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Quantity ");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 70, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Cost");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, 40, 30));

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 160, 130, 30));

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel2.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 120, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Unit Cost");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 60, 30));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 530, -1));

        jTextField7.setEditable(false);
        jPanel2.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 120, -1));

        jTextField12.setEditable(false);
        jPanel2.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 210, -1));

        jTextField13.setEditable(false);
        jPanel2.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 80, -1));

        jTextField14.setEditable(false);
        jPanel2.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 80, -1));

        jTextField1.setEditable(false);
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 170, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 1120, 250));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setText("Director's Approval");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, -1, 20));

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCheckBox1.setText(" * APPROVED For Reprint ");
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 540, -1, -1));

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCheckBox2.setText(" * REJECTED For Reprint ");
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 580, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("* Present Price ");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 140, 30));

        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField16KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, 200, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("* Revised Price");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 140, 30));

        jTextField17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField17KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 600, 200, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Director");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("* Approved Date");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 550, 140, 30));

        jTextField18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField18KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 590, 140, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 650, 100, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 650, 90, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("* Quantity");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 590, 140, 30));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1130, 150));

        jTextField19.setToolTipText("ISBN or Book Name");
        jTextField19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField19KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 660, 210, 30));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/search.png"))); // NOI18N
        jButton5.setToolTipText("Search");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 660, 40, 30));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Copyright © All Rights Reserved at Sarasavi Publishers");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 880, 500, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 1130, 10));

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Copyright © All Rights Reserved at Sarasavi Publishers");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 850, 500, 20));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/sarasavi.png"))); // NOI18N
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 267, 70));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 560, 140, -1));

        jTabbedPane1.addTab("Reprint Approvals ", jPanel1);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reprint No", "Book Title", "ISBN", "Author", "Present Price", "Revised Price", "Quantity", "Approval Date", "Approval"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable4);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1120, 270));

        jTextField20.setToolTipText("ISBN or Book Name");
        jPanel3.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 210, 20));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setToolTipText("Search");
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 40, 20));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reprint No", "Book Title", "ISBN", "Author", "Present Price", "Revised Price", "Quantity", "Approval Date", "Approval"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable5);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 1120, 230));

        jTextField21.setToolTipText("ISBN or Book Name");
        jPanel3.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, 210, 20));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setToolTipText("Search");
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, 40, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel6.setText("Reprint Rejected");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, -1, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel7.setText("Reprint Approved  ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 40));

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Copyright © All Rights Reserved at Sarasavi Publishers");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 850, 500, 20));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("Approve");
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 760, 120, 40));

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCheckBox5.setText(" * APPROVED For Reprint ");
        jPanel3.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 760, -1, -1));

        jTabbedPane1.addTab("Approved and rejected Reprints", jPanel3);

        jPanel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Publishing Department");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, 20));
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 290, -1));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setText("Search");
        jButton9.setToolTipText("Search");
        jPanel4.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 98, 29));

        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField22.setToolTipText("ISBN or Book Name");
        jPanel4.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 223, 29));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setText("Search");
        jButton10.setToolTipText("Search");
        jPanel4.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 98, 29));

        jTextField23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField23.setToolTipText("ISBN or Book Name");
        jPanel4.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 223, 29));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reprint Accepted  Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Repint No", "Added Date", "ISBN", "Book Title", "Author Name", "Price", "Print Attempt", "Move"
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
                true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(jTable7);

        jPanel6.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1100, 210));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1120, 260));

        time1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel4.add(time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, 140, 26));

        date1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel4.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 240, 41));

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Copyright © All Rights Reserved at Sarasavi Publishers");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 850, 500, 20));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel36.setText("Reprint Details");
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, 40));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/sarasavi.png"))); // NOI18N
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 267, 70));

        jTabbedPane1.addTab("Applied Reprints", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 900));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        try {
            // TODO add your handling code here:
            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            int i = jTable3.getSelectedRow();
            String reprintID = dtm.getValueAt(i, 0).toString();

            ResultSet rs = ConnectionSet1.getInstance().getResult("select idreprint_stores,manuscript_name,fname,pduct_sz,nm_pages,paper_type,paper_gauge,bordr_typ,bordr_gauge,idjob_card,isbn,binding,estimte_qty,estimte_cost,estimte_unit from reprint_printingdep rp1 inner join reprint_stores rs1 "
                    + "on rp1.reprint_stores_idreprint_stores = rs1.idreprint_stores inner join job_card j1 on rs1.job_card_idjob_card = j1.idjob_card inner join production_description p1 on j1.idjob_card = p1.job_card_idjob_card inner join reseving_manuscript m1 on j1.reseving_manuscript_idrm = m1.idrm "
                    + "inner join author a1 on m1.author_idauthor = a1.idauthor where status_prnt='approv print'");

            if (rs.next()) {

                String rpid = rs.getString("idreprint_stores");
                jLabel14.setText(rpid);

                String titel = rs.getString("manuscript_name");
                jTextField9.setText(titel);

                String author = rs.getString("fname");
                jTextField10.setText(author);

                String psiz = rs.getString("pduct_sz");
                jTextField7.setText(psiz);

                String nop = rs.getString("nm_pages");
                jTextField4.setText(nop);

                String ptyp = rs.getString("paper_type");
                jTextField12.setText(ptyp);

                String pgage = rs.getString("paper_gauge");
                jTextField13.setText(pgage);

                String btyp = rs.getString("bordr_typ");
                jTextField6.setText(btyp);

                String bgage = rs.getString("bordr_gauge");
                jTextField14.setText(bgage);

                String idjob = rs.getString("idjob_card");
                jLabel5.setText(idjob);

                String isbn = rs.getString("isbn");
                jTextField11.setText(isbn);

                String bindin = rs.getString("binding");
                jTextField1.setText(bindin);

                String eqty = rs.getString("estimte_qty");
                jTextField3.setText(eqty);

                String ecost = rs.getString("estimte_cost");
                jTextField5.setText(ecost);

                String eunit = rs.getString("estimte_unit");
                jTextField8.setText(eunit);

            }

        } catch (Exception ex) {
            Logger.getLogger(reprint_director.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        clear the feilds values
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            //        save the data
            String prsntpriz = jTextField16.getText();
            String reviedpriz = jTextField17.getText();
            String qty = jTextField18.getText();
            String reprintok;
            if (jCheckBox1.isSelected()) {
                reprintok = "Approv";
            } else {
                reprintok = "Reject";
            }

            String aplydte = datechosser(jDateChooser1);

            int reprintid = 0;
            ResultSet rs = ConnectionSet1.getInstance().getResult("select idreprint_stores from reprint_stores where idreprint_stores='" + jLabel14.getText() + "'");
            if (rs.next()) {
                reprintid = rs.getInt("idreprint_stores");
            }

            ConnectionSet1.getInstance().setResult("insert into reprint_director(prasant_priz,revised_priz,reprint_qty,reprint_approv,reprint_approv_dte,reprint_stores_idreprint_stores,dir_status) values('" + prsntpriz + "','" + reviedpriz + "','" + qty + "','" + reprintok + "','" + aplydte + "','" + reprintid + "','dapprov')");

            clear();
            tableLoad();

        } catch (Exception ex) {
            Logger.getLogger(reprint_director.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField16KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField16KeyTyped
        // TODO add your handling code here:
//        validate
        char c = evt.getKeyChar();

        if (c != evt.VK_BACK_SPACE && c != evt.VK_DELETE) {

            if (!(c == '.' || c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {

                evt.consume();
            }
        }
    }//GEN-LAST:event_jTextField16KeyTyped

    private void jTextField17KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyTyped
        // TODO add your handling code here:
//        validate
        char c = evt.getKeyChar();

        if (c != evt.VK_BACK_SPACE && c != evt.VK_DELETE) {

            if (!(c == '.' || c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {

                evt.consume();
            }
        }
    }//GEN-LAST:event_jTextField17KeyTyped

    private void jTextField18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyTyped
        // TODO add your handling code here:
//        validate
        char c = evt.getKeyChar();

        if (c != evt.VK_BACK_SPACE && c != evt.VK_DELETE) {

            if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {

                evt.consume();
            }
        }
    }//GEN-LAST:event_jTextField18KeyTyped

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        try {
            // TODO add your handling code here:
            //        serch the details
            new tablemodel1().fillTable("select idreprint_stores,manuscript_name,isbn,printer,paper_type,bordr_typ,estimte_qty,estimte_cost,estimte_unit from reprint_printingdep pd1 inner join reprint_stores s1 on pd1.reprint_stores_idreprint_stores = s1.idreprint_stores inner join reprint_publishing p1 on s1.idreprint_stores = p1.reprint_stores_idreprint_stores inner join job_card j1 on s1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript m1 on j1.reseving_manuscript_idrm = m1.idrm where status_prnt='approv print' AND (manuscript_name like('" + jTextField2.getText() + "%%%" + "') or isbn like('" + jTextField2.getText() + "%%%" + "'))", jTable3);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reprint_director.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reprint_director.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(reprint_director.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField19KeyReleased
        try {
            // TODO add your handling code here:
            //        serch the details
            new tablemodel1().fillTable("select idreprint_stores,manuscript_name,isbn,fname,prasant_priz,revised_priz,reprint_qty,reprint_approv_dte,reprint_approv from reprint_director d1 inner join reprint_stores rs1 on d1.reprint_stores_idreprint_stores = rs1.idreprint_stores inner join job_card j1 on rs1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript m1 on j1.reseving_manuscript_idrm = m1.idrm inner join author a1 on m1.author_idauthor = a1.idauthor where fname like('" + jTextField19.getText() + "%%" + "') or manuscript_name like('" + jTextField19.getText() + "%%%" + "') or isbn like('" + jTextField19.getText() + "%%%" + "')", jTable2);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reprint_director.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reprint_director.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(reprint_director.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField19KeyReleased

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
            java.util.logging.Logger.getLogger(reprint_director.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reprint_director.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reprint_director.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reprint_director.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reprint_director().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel date;
    private javax.swing.JLabel date1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel time;
    private javax.swing.JLabel time1;
    // End of variables declaration//GEN-END:variables
}
