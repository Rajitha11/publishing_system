
import com.org.DB.ConnectionSet1;
import com.org.clz.tablemodel1;
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tuan
 */
public class costing extends javax.swing.JFrame {

    /**
     * Creates new form costing
     */
    SimpleDateFormat d1, d2;
    Timer t;

    public costing() {
        initComponents();

        dateMethod();
        tableLoad();
        totalcost.setText("00.00");
        unitPricecal.setText("00.00");
        totalcost1.setText("00.00");
        unitPricecal1.setText("00.00");


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

                jLabel15.setText(d1.format(d));
                jLabel31.setText(d2.format(d));

                jLabel32.setText(d1.format(d));
                jLabel46.setText(d2.format(d));


            }
        });
        t.start();
    }

    void tableLoad() {
        try {

            new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn,print_qty from production_description p1 inner join typesetter_fil t1 on p1.job_card_idjob_card = t1.job_card_idjob_card inner join job_card j1 "
                    + "on t1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where complete='Yes' AND imprint_check IS NOT NULL", jTable2);

            new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn,cmpy_name,q_price from quotations q1 inner join production_description p1 on q1.job_card_idjob_card = p1.job_card_idjob_card inner join typesetter_fil t1 "
                    + "on p1.job_card_idjob_card = t1.job_card_idjob_card inner join job_card j1 on t1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor", jTable1);

            new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn,print_qty from production_description p1 inner join typesetter_fil t1 on p1.job_card_idjob_card = t1.job_card_idjob_card inner join job_card j1 "
                    + "on t1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where complete='Yes' AND imprint_check IS NOT NULL", jTable3);

            new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn,print_qty,recomd_price from costing c1 inner join production_description p1 on c1.job_card_idjob_card = p1.job_card_idjob_card inner join job_card j1 "
                    + "on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor", jTable5);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void calTotal() {
        double tot, transFee = 0, TypeFee = 0, profFee = 0, desingFee = 0, trcngCost = 0, positvCost = 0, prntCost = 0, other = 0;

        if (!ftrans.getText().isEmpty()) {
            transFee = Double.parseDouble(ftrans.getText());
        }

        if (!ftyp.getText().isEmpty()) {
            TypeFee = Double.parseDouble(ftyp.getText());
        }

        if (!fread.getText().isEmpty()) {
            profFee = Double.parseDouble(fread.getText());
        }

        if (!fcovr.getText().isEmpty()) {
            desingFee = Double.parseDouble(fcovr.getText());
        }

        if (!ftracng.getText().isEmpty()) {
            trcngCost = Double.parseDouble(ftracng.getText());
        }

        if (!fpositive.getText().isEmpty()) {
            positvCost = Double.parseDouble(fpositive.getText());
        }

        if (!fprinting.getText().isEmpty()) {
//            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
//            int i = jTable4.getSelectedRow();

//            String s1 = dtm.getValueAt(i, 1).toString();
//            jLabel42.setText(s1);

            //String s2 = dtm.getValueAt(i, 2).toString();
//            String s2 = fprinting.getText();
//            double prntCo = Double.parseDouble(s2);
//            prntCost = prntCost + prntCo;
            //prntCost=Double.parseDouble(dtm.getValueAt(i, 2).toString());
            //fprinting.getText();
            //fprinting.setText(s2);
            prntCost = Double.parseDouble(fprinting.getText());
        }

        if (!fother.getText().isEmpty()) {
            other = Double.parseDouble(fother.getText());
        }

        tot = transFee + TypeFee + profFee + desingFee + trcngCost + positvCost + prntCost + other;
        totalcost.setText(tot + "");

    }

    void getUnitPrice() {
        if (totalcost.getText().isEmpty()) {
            unitPricecal.setText("00.00");
        } else {
            double unitPrce, total, qty;
            total = Double.parseDouble(totalcost.getText());
            qty = Double.parseDouble(jTextField27.getText());

            unitPrce = total / qty;
            unitPricecal.setText(unitPrce + "");

        }
    }

    void getUnitPrice1() {
        if (totalcost1.getText().isEmpty()) {
            unitPricecal1.setText("00.00");
        } else {
            double unitPrce, total, qty;
            total = Double.parseDouble(totalcost1.getText());
            qty = Double.parseDouble(jTextField28.getText());

            unitPrce = total / qty;
            unitPricecal1.setText(unitPrce + "");

        }
    }

    void calTotal1() {
        double tot, transFee = 0, TypeFee = 0, profFee = 0, desingFee = 0, trcngCost = 0, positvCost = 0, prntCost = 0, other = 0;

        if (!ftrans1.getText().isEmpty()) {
            transFee = Double.parseDouble(ftrans1.getText());
        }

        if (!ftyp1.getText().isEmpty()) {
            TypeFee = Double.parseDouble(ftyp1.getText());
        }

        if (!fread1.getText().isEmpty()) {
            profFee = Double.parseDouble(fread1.getText());
        }

        if (!fcovr1.getText().isEmpty()) {
            desingFee = Double.parseDouble(fcovr1.getText());
        }

        if (!ftracng1.getText().isEmpty()) {
            trcngCost = Double.parseDouble(ftracng1.getText());
        }

        if (!fpositive1.getText().isEmpty()) {
            positvCost = Double.parseDouble(fpositive1.getText());
        }

        if (!fprinting1.getText().isEmpty()) {
            prntCost = Double.parseDouble(fprinting1.getText());
        }

        if (!fother1.getText().isEmpty()) {
            other = Double.parseDouble(fother1.getText());
        }

        tot = transFee + TypeFee + profFee + desingFee + trcngCost + positvCost + prntCost + other;
        totalcost1.setText(tot + "");
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jTextField8 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jTextField12 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jTextField13 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ftrans = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        ftyp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fread = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fcovr = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ftracng = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fpositive = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        fprinting = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        fother = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        totalcost = new javax.swing.JLabel();
        unitprice = new javax.swing.JPanel();
        unitPricecal = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        retaiprice = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        pmay = new javax.swing.JCheckBox();
        pman = new javax.swing.JCheckBox();
        jLabel36 = new javax.swing.JLabel();
        diay = new javax.swing.JCheckBox();
        dian = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        ftrans1 = new javax.swing.JTextField();
        ftyp1 = new javax.swing.JTextField();
        fread1 = new javax.swing.JTextField();
        fcovr1 = new javax.swing.JTextField();
        ftracng1 = new javax.swing.JTextField();
        fpositive1 = new javax.swing.JTextField();
        fprinting1 = new javax.swing.JTextField();
        fother1 = new javax.swing.JTextField();
        totalcost1 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        unitprice1 = new javax.swing.JPanel();
        unitPricecal1 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        retaiprice1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Costing");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quotations");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 160, 58));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("Date ");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 210, 52));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 110, 30));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "All Quotation Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });
        jPanel8.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 295, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Search");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 55, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Title", "Author", "ISBN", "Company", "Quoted Price"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 1050, 150));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 1130, 240));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Quotation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("* Company Name");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("* Quoted Price");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, -1));
        jPanel3.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 250, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Book Title");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Author");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jTextField9.setEditable(false);
        jPanel3.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 290, -1));

        jTextField10.setEditable(false);
        jPanel3.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 290, -1));

        jTextField11.setEditable(false);
        jPanel3.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 250, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("ISBN");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sarasvi Printers", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 290, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setText("Job No ");
        jPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, -1));
        jPanel3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 80, 30));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("Print QTy");
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        jTextField15.setEditable(false);
        jPanel3.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 140, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 1060, 160));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Job Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
        });
        jPanel9.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 295, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Search");
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 55, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Title", "Author", "ISBN", "Print Qty"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel9.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1090, 120));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1130, 190));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, 90, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Update");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 480, 90, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 480, 90, 30));

        jTabbedPane1.addTab("Get Quotation", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Costing");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 130, 58));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText("Date ");
        jPanel2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 210, 52));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 110, 30));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Job Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField13KeyReleased(evt);
            }
        });
        jPanel10.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 295, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Search");
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 55, -1));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Title", "Author", "ISBN", "QTY"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jPanel10.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1090, 120));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1130, 180));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quoted Book  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Book Title");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Author");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        jTextField16.setEditable(false);
        jPanel4.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 290, -1));

        jTextField17.setEditable(false);
        jPanel4.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 290, -1));

        jTextField18.setEditable(false);
        jPanel4.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 250, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("ISBN");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("QTY");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, -1, -1));

        jTextField27.setEditable(false);
        jPanel4.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 100, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("Job Card No");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 90, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 1060, 100));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("* Editing/Translation Fees");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        ftrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftransActionPerformed(evt);
            }
        });
        ftrans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftransKeyReleased(evt);
            }
        });
        jPanel2.add(ftrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 290, -1));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quotation Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Company", "Quoted Price"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable4);

        jPanel11.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 390, 130));

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, 450, 160));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("* Typesetting Fees");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        ftyp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftypActionPerformed(evt);
            }
        });
        ftyp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftypKeyReleased(evt);
            }
        });
        jPanel2.add(ftyp, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 290, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("* Proof Reading Fees");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        fread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freadActionPerformed(evt);
            }
        });
        fread.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                freadKeyReleased(evt);
            }
        });
        jPanel2.add(fread, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 290, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("* Cover Designing Fees");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        fcovr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fcovrActionPerformed(evt);
            }
        });
        fcovr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fcovrKeyReleased(evt);
            }
        });
        jPanel2.add(fcovr, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 290, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("* Tracings Cost");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, -1));

        ftracng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftracngActionPerformed(evt);
            }
        });
        ftracng.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftracngKeyReleased(evt);
            }
        });
        jPanel2.add(ftracng, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 290, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("* Positives Cost");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        fpositive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fpositiveActionPerformed(evt);
            }
        });
        fpositive.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fpositiveKeyReleased(evt);
            }
        });
        jPanel2.add(fpositive, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, 290, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Price Calculation");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 580, -1, -1));

        fprinting.setEditable(false);
        fprinting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fprintingActionPerformed(evt);
            }
        });
        fprinting.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fprintingKeyReleased(evt);
            }
        });
        jPanel2.add(fprinting, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, 290, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("* Other Expences");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, -1, -1));

        fother.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fotherKeyReleased(evt);
            }
        });
        jPanel2.add(fother, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, 290, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Total Costs");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, -1, -1));

        jLabel18.setText("-----------------------------------------------------------------------------");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 720, 310, 10));

        jLabel26.setText("-----------------------------------------------------------------------------");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 640, 310, -1));

        jLabel27.setText("-----------------------------------------------------------------------------");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 710, 310, -1));

        totalcost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(totalcost, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 664, 160, 40));

        unitprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        unitprice.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        unitPricecal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        unitprice.add(unitPricecal, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 20, 130, 40));

        jPanel2.add(unitprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 600, 330, 80));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("* Printing Cost");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setText("Recommanded Retail Price ");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 730, 250, -1));
        jPanel2.add(retaiprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 720, 150, 40));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("* Publishing Manager Approve");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 750, 210, -1));

        buttonGroup1.add(pmay);
        pmay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pmay.setText("Yes");
        jPanel2.add(pmay, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 750, -1, -1));

        buttonGroup1.add(pman);
        pman.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pman.setText("No");
        jPanel2.add(pman, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 750, -1, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("* Director's Approve");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 790, 210, -1));

        buttonGroup2.add(diay);
        diay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        diay.setText("Yes");
        jPanel2.add(diay, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 790, -1, -1));

        buttonGroup2.add(dian);
        dian.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dian.setText("No");
        jPanel2.add(dian, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 790, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Clear");
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 810, 108, 45));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Delete");
        jButton5.setBorder(null);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 810, 108, 45));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Save");
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 810, 108, 45));
        jPanel2.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 570, 160, 20));

        jTabbedPane1.addTab("Costing", jPanel2);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setText("Costed Books");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 220, 58));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("Date ");
        jPanel5.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 210, 52));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel5.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 110, 30));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Costed Book", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Title", "Author", "ISBN", "Qty", "Recommanded Price"
            }
        ));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable5);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1080, 140));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1120, 170));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quoted Book  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("Book Title");
        jPanel7.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("Author");
        jPanel7.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        jTextField19.setEditable(false);
        jPanel7.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 290, -1));

        jTextField20.setEditable(false);
        jPanel7.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 290, -1));

        jTextField21.setEditable(false);
        jPanel7.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 250, -1));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setText("ISBN");
        jPanel7.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, -1, -1));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("QTY");
        jPanel7.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, -1, -1));

        jTextField28.setEditable(false);
        jPanel7.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 100, -1));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setText("Job Card No");
        jPanel7.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));
        jPanel7.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 90, 30));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 1060, 100));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setText("* Editing/Translation Fees");
        jPanel5.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setText("* Typesetting Fees");
        jPanel5.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel55.setText("* Proof Reading Fees");
        jPanel5.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setText("* Cover Designing Fees");
        jPanel5.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel57.setText("* Tracings Cost");
        jPanel5.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, -1));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setText("* Positives Cost");
        jPanel5.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("* Printing Cost");
        jPanel5.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, -1, -1));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setText("* Other Expences");
        jPanel5.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, -1, -1));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quotation Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Company", "Quoted Price"
            }
        ));
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);

        jPanel12.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 390, 130));

        jPanel5.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, 450, 160));

        ftrans1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftrans1KeyReleased(evt);
            }
        });
        jPanel5.add(ftrans1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 290, -1));

        ftyp1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftyp1KeyReleased(evt);
            }
        });
        jPanel5.add(ftyp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 290, -1));

        fread1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fread1KeyReleased(evt);
            }
        });
        jPanel5.add(fread1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 290, -1));

        fcovr1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fcovr1KeyReleased(evt);
            }
        });
        jPanel5.add(fcovr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 290, -1));

        ftracng1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftracng1KeyReleased(evt);
            }
        });
        jPanel5.add(ftracng1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 290, -1));

        fpositive1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fpositive1KeyReleased(evt);
            }
        });
        jPanel5.add(fpositive1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, 290, -1));

        fprinting1.setEditable(false);
        fprinting1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fprinting1KeyReleased(evt);
            }
        });
        jPanel5.add(fprinting1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, 290, -1));

        fother1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fother1KeyReleased(evt);
            }
        });
        jPanel5.add(fother1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, 290, -1));

        totalcost1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel5.add(totalcost1, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 664, 160, 40));

        jLabel61.setText("-----------------------------------------------------------------------------");
        jPanel5.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 640, 310, -1));

        jLabel62.setText("-----------------------------------------------------------------------------");
        jPanel5.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 710, 310, -1));

        jLabel63.setText("-----------------------------------------------------------------------------");
        jPanel5.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 720, 310, 10));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel64.setText("Price Calculation");
        jPanel5.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 580, -1, -1));

        unitprice1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        unitprice1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        unitPricecal1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        unitprice1.add(unitPricecal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 20, 130, 40));

        jPanel5.add(unitprice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 600, 330, 80));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel65.setText("Recommanded Retail Price ");
        jPanel5.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 730, 250, -1));
        jPanel5.add(retaiprice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 720, 150, 40));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Update");
        jButton7.setBorder(null);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 810, 108, 45));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("Clear");
        jButton8.setBorder(null);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 810, 108, 45));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("Delete");
        jButton9.setBorder(null);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 810, 108, 45));
        jPanel5.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 570, 160, 20));

        jTabbedPane1.addTab("Costed Books", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 900));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            // add quoted prices
            String cmpny = jComboBox1.getSelectedItem().toString();
            String price = jTextField7.getText();

            int job_cardid = 0;
            ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card from job_card where idjob_card='" + jLabel40.getText() + "'");
            if (rs.next()) {
                job_cardid = rs.getInt("idjob_card");
            }

            ConnectionSet1.getInstance().setResult("insert into quotations(cmpy_name,q_price,job_card_idjob_card) values('" + cmpny + "','" + price + "','" + job_cardid + "')");

            jTextField9.setText("");
            jTextField11.setText("");
            jTextField10.setText("");
            jLabel40.setText("");
            jTextField7.setText("");
            jComboBox1.setSelectedIndex(0);
            jTextField15.setText("");
            tableLoad();

        } catch (Exception ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        //set value from the feilds
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        int i = jTable2.getSelectedRow();

        String s = dtm.getValueAt(i, 0).toString();
        jLabel40.setText(s);

        String s1 = dtm.getValueAt(i, 1).toString();
        jTextField9.setText(s1);

        String s2 = dtm.getValueAt(i, 2).toString();
        jTextField10.setText(s2);

        String s3 = dtm.getValueAt(i, 3).toString();
        jTextField11.setText(s3);

        String s4 = dtm.getValueAt(i, 4).toString();
        jTextField15.setText(s4);

    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        try {
            // TODO add your handling code here:
            // set data for the feilds
            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            int i = jTable3.getSelectedRow();

            String jobNo = dtm.getValueAt(i, 0).toString();
            ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card,manuscript_name,fname,isbn,print_qty from production_description p1 inner join typesetter_fil t1 on p1.job_card_idjob_card = t1.job_card_idjob_card inner join job_card j1 "
                    + "on t1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where complete='Yes' AND imprint_check IS NOT NULL AND idjob_card='" + jobNo + "'");

            if (rs.next()) {
                String s1 = rs.getString("idjob_card");
                jLabel38.setText(s1);

                String s2 = rs.getString("manuscript_name");
                jTextField16.setText(s2);

                String s3 = rs.getString("fname");
                jTextField17.setText(s3);

                String s4 = rs.getString("isbn");
                jTextField18.setText(s4);

                String s5 = rs.getString("print_qty");
                jTextField27.setText(s5);

                ResultSet rs1 = ConnectionSet1.getInstance().getResult("select job_card_idjob_card,cmpy_name,q_price from quotations where job_card_idjob_card='" + jobNo + "'");
                if (rs1.next()) {
                    new tablemodel1().fillTable("select job_card_idjob_card,cmpy_name,q_price from quotations", jTable4);
                }


            }

        } catch (Exception ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTable3MouseClicked

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        try {
            // TODO add your handling code here:
            //serch qutoed page job details
            new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn,print_qty from production_description p1 inner join typesetter_fil t1 on p1.job_card_idjob_card = t1.job_card_idjob_card inner join job_card j1 "
                    + "on t1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where complete='Yes' AND imprint_check IS NOT NULL AND (fname like('" + jTextField12.getText() + "%%" + "') or manuscript_name like('" + jTextField12.getText() + "%%%" + "') or idjob_card like('" + jTextField12.getText() + "%%" + "'))", jTable2);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        try {
            // TODO add your handling code here:
            //quoted details search
            new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn,cmpy_name,q_price from quotations q1 inner join production_description p1 on q1.job_card_idjob_card = p1.job_card_idjob_card inner join typesetter_fil t1 "
                    + "on p1.job_card_idjob_card = t1.job_card_idjob_card inner join job_card j1 on t1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where fname like('" + jTextField8.getText() + "%%" + "') or manuscript_name like('" + jTextField8.getText() + "%%%" + "') or idjob_card like('" + jTextField8.getText() + "%%" + "') or cmpy_name like('" + jTextField8.getText() + "%%" + "')", jTable1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyReleased
        try {
            // TODO add your handling code here:
            //costing serch
            new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn,print_qty from production_description p1 inner join typesetter_fil t1 on p1.job_card_idjob_card = t1.job_card_idjob_card inner join job_card j1 "
                    + "on t1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where complete='Yes' AND imprint_check IS NOT NULL AND (fname like('" + jTextField13.getText() + "%%" + "') or manuscript_name like('" + jTextField13.getText() + "%%%" + "') or idjob_card like('" + jTextField13.getText() + "%%" + "'))", jTable3);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField13KeyReleased

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        //set value for the printing fee
        DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
        int i = jTable4.getSelectedRow();

        String s1 = dtm.getValueAt(i, 1).toString();
        jLabel42.setText(s1);

        String s2 = dtm.getValueAt(i, 2).toString();
        fprinting.setText(s2);
        calTotal();
        getUnitPrice();
    }//GEN-LAST:event_jTable4MouseClicked

    private void ftransKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftransKeyReleased
        // TODO add your handling code here:
        calTotal();
        getUnitPrice();
    }//GEN-LAST:event_ftransKeyReleased

    private void ftypKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftypKeyReleased
        // TODO add your handling code here:
        calTotal();
        getUnitPrice();
    }//GEN-LAST:event_ftypKeyReleased

    private void freadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_freadKeyReleased
        // TODO add your handling code here:
        calTotal();
        getUnitPrice();
    }//GEN-LAST:event_freadKeyReleased

    private void fcovrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fcovrKeyReleased
        // TODO add your handling code here:
        calTotal();
        getUnitPrice();
    }//GEN-LAST:event_fcovrKeyReleased

    private void ftracngKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftracngKeyReleased
        // TODO add your handling code here:
        calTotal();
        getUnitPrice();
    }//GEN-LAST:event_ftracngKeyReleased

    private void fpositiveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fpositiveKeyReleased
        // TODO add your handling code here:
        calTotal();
        getUnitPrice();
    }//GEN-LAST:event_fpositiveKeyReleased

    private void fprintingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fprintingKeyReleased
        // TODO add your handling code here:
        calTotal();
        getUnitPrice();
    }//GEN-LAST:event_fprintingKeyReleased

    private void fotherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fotherKeyReleased
        // TODO add your handling code here:
        calTotal();
        getUnitPrice();
    }//GEN-LAST:event_fotherKeyReleased

    private void ftransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftransActionPerformed
        // TODO add your handling code here:
        ftyp.grabFocus();
    }//GEN-LAST:event_ftransActionPerformed

    private void ftypActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftypActionPerformed
        // TODO add your handling code here:
        fread.grabFocus();
    }//GEN-LAST:event_ftypActionPerformed

    private void freadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freadActionPerformed
        // TODO add your handling code here:
        fcovr.grabFocus();
    }//GEN-LAST:event_freadActionPerformed

    private void fcovrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fcovrActionPerformed
        // TODO add your handling code here:
        ftracng.grabFocus();
    }//GEN-LAST:event_fcovrActionPerformed

    private void ftracngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftracngActionPerformed
        // TODO add your handling code here:
        fpositive.grabFocus();
    }//GEN-LAST:event_ftracngActionPerformed

    private void fpositiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fpositiveActionPerformed
        // TODO add your handling code here:
        fother.grabFocus();
    }//GEN-LAST:event_fpositiveActionPerformed

    private void fprintingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fprintingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fprintingActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jLabel38.setText("");
        jTextField16.setText("");
        jTextField18.setText("");
        jTextField17.setText("");
        jTextField27.setText("");
        ftrans.setText("");
        ftyp.setText("");
        fread.setText("");
        fcovr.setText("");
        ftracng.setText("");
        fpositive.setText("");
        fprinting.setText("");
        jLabel42.setText("");
        fother.setText("");
        totalcost.setText("00.00");
        unitPricecal.setText("00.00");
        retaiprice.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            //save the costing details
            int idjob = 0;
            ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card from job_card where idjob_card='" + jLabel38.getText() + "'");
            if (rs.next()) {
                idjob = rs.getInt("idjob_card");
            }

            String transF = ftrans.getText();
            String typF = ftyp.getText();
            String preadF = fread.getText();
            String cvrF = fcovr.getText();
            String tacnC = ftracng.getText();
            String ptvC = fpositive.getText();
            String prntC = fprinting.getText();
            String cmpy_name = jLabel42.getText();
            String othrE = fother.getText();
            String total = totalcost.getText();
            String unitPrc = unitPricecal.getText();
            String rcomnd_price = retaiprice.getText();

            String pmApprov;
            if (pmay.isSelected()) {
                pmApprov = "Yes";
            } else {
                pmApprov = "No";
            }

            String mdApprov;
            if (diay.isSelected()) {
                mdApprov = "Yes";
            } else {
                mdApprov = "No";
            }

            ConnectionSet1.getInstance().setResult("insert into costing(editing_fee,typstng_fee,proofrdng_fee,cverdign_fee,trcng_cost,positv_cost,prnt_cost,print_cmny,other_expec,total_cost,unit_price,recomd_price,pm_approv,md_approv,job_card_idjob_card) "
                    + "values('" + transF + "','" + typF + "','" + preadF + "','" + cvrF + "','" + tacnC + "','" + ptvC + "','" + prntC + "','" + cmpy_name + "','" + othrE + "','" + total + "','" + unitPrc + "','" + rcomnd_price + "','" + pmApprov + "','" + mdApprov + "','" + idjob + "')");

            jLabel38.setText("");
            jTextField16.setText("");
            jTextField18.setText("");
            jTextField17.setText("");
            jTextField27.setText("");
            ftrans.setText("");
            ftyp.setText("");
            fread.setText("");
            fcovr.setText("");
            ftracng.setText("");
            fpositive.setText("");
            fprinting.setText("");
            jLabel42.setText("");
            fother.setText("");
            totalcost.setText("00.00");
            unitPricecal.setText("00.00");
            retaiprice.setText("");

        } catch (Exception ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        try {
            // TODO add your handling code here:
            // set data to the feilds
            DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel();
            int i = jTable5.getSelectedRow();
            String jobid = dtm.getValueAt(i, 0).toString();

            ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card,manuscript_name,fname,isbn,print_qty,c1.* from costing c1 inner join production_description p1 on c1.job_card_idjob_card = p1.job_card_idjob_card inner join job_card j1 "
                    + "on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where idjob_card='" + jobid + "'");

            if (rs.next()) {
                String jobn = rs.getString("idjob_card");
                jLabel52.setText(jobn);

                String title = rs.getString("manuscript_name");
                jTextField19.setText(title);

                String anme = rs.getString("fname");
                jTextField20.setText(anme);

                String isbn = rs.getString("isbn");
                jTextField21.setText(isbn);

                String qty = rs.getString("print_qty");
                jTextField28.setText(qty);

                String editf = rs.getString("editing_fee");
                ftrans1.setText(editf);

                String typf = rs.getString("typstng_fee");
                ftyp1.setText(typf);

                String proff = rs.getString("proofrdng_fee");
                fread1.setText(proff);

                String cvrdef = rs.getString("cverdign_fee");
                fcovr1.setText(cvrdef);

                String tacin = rs.getString("trcng_cost");
                ftracng1.setText(tacin);

                String positv = rs.getString("positv_cost");
                fpositive1.setText(positv);

                String prntc = rs.getString("prnt_cost");
                fprinting1.setText(prntc);

                String prncmp = rs.getString("print_cmny");
                jLabel66.setText(prncmp);

                String othrex = rs.getString("other_expec");
                fother1.setText(othrex);

                String total = rs.getString("total_cost");
                totalcost1.setText(total);

                String unitcst = rs.getString("unit_price");
                unitPricecal1.setText(unitcst);

                String recprc = rs.getString("recomd_price");
                retaiprice1.setText(recprc);

                ResultSet rs1 = ConnectionSet1.getInstance().getResult("select job_card_idjob_card,cmpy_name,q_price from quotations where job_card_idjob_card='" + jobid + "'");
                if (rs1.next()) {
                    new tablemodel1().fillTable("select job_card_idjob_card,cmpy_name,q_price from quotations", jTable6);
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable5MouseClicked

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
        //set values for the printing cost
        DefaultTableModel dtm = (DefaultTableModel) jTable6.getModel();
        int i = jTable6.getSelectedRow();

        String s1 = dtm.getValueAt(i, 1).toString();
        jLabel66.setText(s1);

        String s2 = dtm.getValueAt(i, 2).toString();
        fprinting1.setText(s2);
        calTotal1();
        getUnitPrice1();
    }//GEN-LAST:event_jTable6MouseClicked

    private void ftrans1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftrans1KeyReleased
        // TODO add your handling code here:
        calTotal1();
        getUnitPrice1();
    }//GEN-LAST:event_ftrans1KeyReleased

    private void ftyp1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftyp1KeyReleased
        // TODO add your handling code here:
        calTotal1();
        getUnitPrice1();
    }//GEN-LAST:event_ftyp1KeyReleased

    private void fread1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fread1KeyReleased
        // TODO add your handling code here:
        calTotal1();
        getUnitPrice1();
    }//GEN-LAST:event_fread1KeyReleased

    private void fcovr1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fcovr1KeyReleased
        // TODO add your handling code here:
        calTotal1();
        getUnitPrice1();
    }//GEN-LAST:event_fcovr1KeyReleased

    private void ftracng1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftracng1KeyReleased
        // TODO add your handling code here:
        calTotal1();
        getUnitPrice1();
    }//GEN-LAST:event_ftracng1KeyReleased

    private void fpositive1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fpositive1KeyReleased
        // TODO add your handling code here:
        calTotal1();
        getUnitPrice1();
    }//GEN-LAST:event_fpositive1KeyReleased

    private void fprinting1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fprinting1KeyReleased
        // TODO add your handling code here:
        calTotal1();
        getUnitPrice1();
    }//GEN-LAST:event_fprinting1KeyReleased

    private void fother1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fother1KeyReleased
        // TODO add your handling code here:
        calTotal1();
        getUnitPrice1();
    }//GEN-LAST:event_fother1KeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jLabel52.setText("");
        jTextField19.setText("");
        jTextField20.setText("");
        jTextField21.setText("");
        jTextField28.setText("");
        ftrans1.setText("");
        ftyp1.setText("");
        fread1.setText("");
        fcovr1.setText("");
        ftracng1.setText("");
        fpositive1.setText("");
        fprinting1.setText("");
        jLabel66.setText("");
        fother1.setText("");
        totalcost1.setText("00.00");
        unitPricecal1.setText("00.00");
        retaiprice1.setText("");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            // TODO add your handling code here:
            //update the costed data feild
            String transF = ftrans1.getText();
            String typF = ftyp1.getText();
            String preadF = fread1.getText();
            String cvrF = fcovr1.getText();
            String tacnC = ftracng1.getText();
            String ptvC = fpositive1.getText();
            String prntC = fprinting1.getText();
            String cmpy_name = jLabel66.getText();
            String othrE = fother1.getText();
            String total = totalcost1.getText();
            String unitPrc = unitPricecal1.getText();
            String rcomnd_price = retaiprice1.getText();

            ConnectionSet1.getInstance().setResult("update costing set editing_fee='" + transF + "',typstng_fee='" + typF + "',proofrdng_fee='" + preadF + "',cverdign_fee='" + cvrF + "',trcng_cost='" + tacnC + "',positv_cost='" + ptvC + "',prnt_cost='" + prntC + "',print_cmny='" + cmpy_name + "',other_expec='" + othrE + "',total_cost='" + total + "',unit_price='" + unitPrc + "',recomd_price='" + rcomnd_price + "' where job_card_idjob_card='" + jLabel52.getText() + "'");

            jLabel52.setText("");
            jTextField19.setText("");
            jTextField20.setText("");
            jTextField21.setText("");
            jTextField28.setText("");
            ftrans1.setText("");
            ftyp1.setText("");
            fread1.setText("");
            fcovr1.setText("");
            ftracng1.setText("");
            fpositive1.setText("");
            fprinting1.setText("");
            jLabel66.setText("");
            fother1.setText("");
            totalcost1.setText("00.00");
            unitPricecal1.setText("00.00");
            retaiprice1.setText("");

        } catch (Exception ex) {
            Logger.getLogger(costing.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(costing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(costing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(costing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(costing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new costing().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox dian;
    private javax.swing.JCheckBox diay;
    private javax.swing.JTextField fcovr;
    private javax.swing.JTextField fcovr1;
    private javax.swing.JTextField fother;
    private javax.swing.JTextField fother1;
    private javax.swing.JTextField fpositive;
    private javax.swing.JTextField fpositive1;
    private javax.swing.JTextField fprinting;
    private javax.swing.JTextField fprinting1;
    private javax.swing.JTextField fread;
    private javax.swing.JTextField fread1;
    private javax.swing.JTextField ftracng;
    private javax.swing.JTextField ftracng1;
    private javax.swing.JTextField ftrans;
    private javax.swing.JTextField ftrans1;
    private javax.swing.JTextField ftyp;
    private javax.swing.JTextField ftyp1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JCheckBox pman;
    private javax.swing.JCheckBox pmay;
    private javax.swing.JTextField retaiprice;
    private javax.swing.JTextField retaiprice1;
    private javax.swing.JLabel totalcost;
    private javax.swing.JLabel totalcost1;
    private javax.swing.JLabel unitPricecal;
    private javax.swing.JLabel unitPricecal1;
    private javax.swing.JPanel unitprice;
    private javax.swing.JPanel unitprice1;
    // End of variables declaration//GEN-END:variables
}
