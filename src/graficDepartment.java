
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
public class graficDepartment extends javax.swing.JFrame {

    /**
     * Creates new form graficDepartment
     */
    SimpleDateFormat d1, d2;
    Timer t;

    public graficDepartment() {
        initComponents();

        dateMethod();

        try {
            jLabel17.setText(maxid("idgrafic_dep", "grafic_jobs", 1));
        } catch (Exception ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    graficDepartment(String uname) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this();
        jLabel69.setText(uname);
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
                jLabel15.setText(d1.format(d));
                jLabel31.setText(d2.format(d));

                jLabel14.setText(d1.format(d));
                jLabel30.setText(d2.format(d));

                jLabel16.setText(d1.format(d));
                jLabel32.setText(d2.format(d));

                jLabel24.setText(d1.format(d));
                jLabel54.setText(d2.format(d));

            }
        });
        t.start();
    }

    public static String datechosser(JDateChooser jd) {
        SimpleDateFormat sd = new SimpleDateFormat("dd /MMMM /yyyy");
        Date d = jd.getDate();
        String date = sd.format(d);
        System.out.println(date);
        return date;

    }

    void tableLoad() {
        try {
            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language,recomd_price from costing c1 inner join production_description p1 on c1.job_card_idjob_card = p1.job_card_idjob_card "
                    + "inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where md_approv='Yes'", jTable1);

            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language,job_doned,job_done from grafic_jobs g1 inner join disigner_jobs d1 on g1.idgrafic_dep = d1.grafic_jobs_idgrafic_dep inner join planner p1 "
                    + "on g1.idgrafic_dep = p1.grafic_jobs_idgrafic_dep inner join job_card j1 on g1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where job_done='Yes' AND job_doned='Yes' AND postv_cmplt is null", jTable3);

            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language,job_doned,job_done from grafic_jobs g1 inner join disigner_jobs d1 on g1.idgrafic_dep = d1.grafic_jobs_idgrafic_dep inner join planner p1 "
                    + "on g1.idgrafic_dep = p1.grafic_jobs_idgrafic_dep inner join job_card j1 on g1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where job_done='No' or job_doned='No'", jTable5);
            
            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language,job_doned,job_done from grafic_jobs g1 inner join disigner_jobs d1 on g1.idgrafic_dep = d1.grafic_jobs_idgrafic_dep inner join planner p1 "
                    + "on g1.idgrafic_dep = p1.grafic_jobs_idgrafic_dep inner join job_card j1 on g1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where job_done='Yes' AND job_doned='Yes' AND (printin_shedul='added' or printin_shedul='sendP')", jTable4);

            new tablemodel1().fillTable("select * from grfic_other_jobs", jTable2);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String maxid(String columname, String table, int columno) throws Exception {
        int i2 = 0;
        ResultSet sr = ConnectionSet1.getInstance().getResult("SELECT * from " + table + " WHERE(SELECT Max(" + columname + ")FROM " + table + ")");
        while (sr.next()) {
            String id = sr.getString(columno);
            int i = Integer.parseInt(id);
            i2 = i + 1;
        }

        return i2 + "".toString();
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
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel69 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField13 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTextField12 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel68 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Grafic Department");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Jobs");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 130, 58));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText("Date ");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 210, 52));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 110, 30));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Jobs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Date", "Title", "Author", "ISBN", "Language", "Retail Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1080, 150));

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });
        jPanel8.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 295, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Search");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 55, -1));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1100, 220));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Job Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Book Title");
        jPanel10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 110, -1));

        jTextField5.setEditable(false);
        jPanel10.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 291, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Job No ");
        jPanel10.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));
        jPanel10.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 80, 30));

        jTextField9.setEditable(false);
        jPanel10.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 250, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("ISBN");
        jPanel10.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        jTextField10.setEditable(false);
        jPanel10.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 290, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Authour/Translator name");
        jPanel10.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Language");
        jPanel10.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jTextField11.setEditable(false);
        jPanel10.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 290, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Date ");
        jPanel10.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, -1, -1));
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 180, 30));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setText("Retail Price");
        jPanel10.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        jTextField21.setEditable(false);
        jPanel10.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 170, -1));

        jLabel17.setText("jLabel17");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 100, 30));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 1050, 170));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Save");
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 750, 108, 45));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Clear");
        jButton5.setBorder(null);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 750, 108, 45));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Delete");
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 750, 108, 45));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cover Disigner", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "saman", "charith", "thilina" }));
        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 206, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("* Disigner Name");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("* Deadline");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        jPanel4.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 200, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 570, 370, 130));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Layout Planner", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("* Planner Name");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "saman", "charith", "thilina" }));
        jPanel5.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 206, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("* Deadline");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        jPanel5.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 200, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 570, 370, 130));

        jLabel69.setText("jLabel69");
        jPanel1.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 10, 0));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/home.png"))); // NOI18N
        jButton13.setContentAreaFilled(false);
        jButton13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/home1.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 70));

        jTabbedPane1.addTab("Grafic Department", jPanel1);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("On Going Jobs");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 190, 58));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("Date ");
        jPanel6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 210, 52));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 110, 30));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Designing & Planning Complete Jobs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Date", "Title", "Author", "ISBN", "Language", "Complete Desiging", "Complete Palaning"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jPanel11.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1080, 160));

        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField13KeyReleased(evt);
            }
        });
        jPanel11.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 295, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Search");
        jPanel11.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 55, -1));

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 1120, 230));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Job Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("Book Title");
        jPanel12.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 110, -1));

        jTextField6.setEditable(false);
        jPanel12.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 291, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("Job No ");
        jPanel12.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));
        jPanel12.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 70, 30));

        jTextField14.setEditable(false);
        jPanel12.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 250, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("ISBN");
        jPanel12.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        jTextField15.setEditable(false);
        jPanel12.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 290, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("Authour/Translator name");
        jPanel12.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText("Language");
        jPanel12.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jTextField16.setEditable(false);
        jPanel12.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 290, -1));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("Date ");
        jPanel12.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, -1, -1));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("Disigning Complete");
        jPanel12.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jTextField17.setEditable(false);
        jPanel12.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 290, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("Planning Complete");
        jPanel12.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, -1, -1));

        jTextField18.setEditable(false);
        jPanel12.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 250, -1));
        jPanel12.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 230, 20));
        jPanel12.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 100, 30));

        jPanel6.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 1050, 160));

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setText("* Positive Out Completed");
        jPanel7.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        buttonGroup1.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox6.setText("Yes");
        jPanel7.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        buttonGroup1.add(jCheckBox7);
        jCheckBox7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox7.setText("No");
        jPanel7.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        buttonGroup2.add(jCheckBox8);
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox8.setText("No");
        jPanel7.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        buttonGroup2.add(jCheckBox9);
        jCheckBox9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox9.setText("Yes");
        jPanel7.add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("* Trasing Completed");
        jPanel7.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 210, -1));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setText("* CTP");
        jPanel7.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 210, -1));

        buttonGroup3.add(jCheckBox10);
        jCheckBox10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox10.setText("Yes");
        jPanel7.add(jCheckBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        buttonGroup3.add(jCheckBox11);
        jCheckBox11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox11.setText("No");
        jPanel7.add(jCheckBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 710, 400, 140));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Save");
        jButton7.setBorder(null);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 810, 108, 45));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("Clear");
        jButton8.setBorder(null);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 810, 108, 45));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("Delete");
        jButton9.setBorder(null);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 810, 108, 45));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Date", "Title", "Author", "ISBN", "Language", "Complete Desiging", "Complete Palaning"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable5);

        jPanel6.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1090, 160));

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "On Going Jobs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1120, 190));

        jTabbedPane1.addTab("Jobs in Hand", jPanel6);

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel23.setText("Completed Jobs");
        jPanel13.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 210, 58));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setText("Date ");
        jPanel13.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel13.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 210, 52));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel13.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 110, 30));

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Completed Jobs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Date", "Title", "Author", "ISBN", "Language", "Disigner Complete", "Planner Complete"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable4);

        jPanel14.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1090, 180));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel14.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 260, -1));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setText("Search");
        jPanel14.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1110, 270));

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Job Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel55.setText("Book Title");
        jPanel15.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 110, -1));

        jTextField7.setEditable(false);
        jPanel15.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 291, -1));
        jPanel15.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 100, 30));

        jTextField22.setEditable(false);
        jPanel15.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 250, -1));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setText("ISBN");
        jPanel15.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        jTextField23.setEditable(false);
        jPanel15.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 290, -1));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("Authour/Translator name");
        jPanel15.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setText("Language");
        jPanel15.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jTextField24.setEditable(false);
        jPanel15.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 290, -1));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setText("Date ");
        jPanel15.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, -1, -1));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setText("Disigning Complete");
        jPanel15.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jTextField25.setEditable(false);
        jPanel15.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 290, -1));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setText("Planning Complete");
        jPanel15.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, -1, -1));

        jTextField26.setEditable(false);
        jPanel15.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 250, -1));
        jPanel15.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 230, 20));
        jPanel15.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 100, 30));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel67.setText("Job No ");
        jPanel15.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 1050, 160));

        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel64.setText("* Positive Out Completed");
        jPanel16.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        buttonGroup1.add(jCheckBox12);
        jCheckBox12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox12.setText("Yes");
        jPanel16.add(jCheckBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        buttonGroup1.add(jCheckBox13);
        jCheckBox13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox13.setText("No");
        jPanel16.add(jCheckBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        buttonGroup2.add(jCheckBox14);
        jCheckBox14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox14.setText("No");
        jPanel16.add(jCheckBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        buttonGroup2.add(jCheckBox15);
        jCheckBox15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox15.setText("Yes");
        jPanel16.add(jCheckBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel65.setText("* Trasing Completed");
        jPanel16.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 210, -1));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel66.setText("* CTP");
        jPanel16.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 210, -1));

        buttonGroup3.add(jCheckBox16);
        jCheckBox16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox16.setText("Yes");
        jPanel16.add(jCheckBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        buttonGroup3.add(jCheckBox17);
        jCheckBox17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox17.setText("No");
        jPanel16.add(jCheckBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        jPanel13.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, 400, 140));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setText("Update");
        jButton10.setBorder(null);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 750, 108, 45));

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setText("Delete");
        jButton11.setBorder(null);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel13.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 750, 108, 45));

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton12.setText("Clear");
        jButton12.setBorder(null);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 750, 108, 45));

        jTabbedPane1.addTab("Completed Jobs", jPanel13);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Other Jobs");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 160, 58));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("Date ");
        jPanel2.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 210, 52));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 110, 30));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Other Job Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
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
                "Other Job No", "Job Name", "Designer Name", "Receiving Date", "Complete Date", "Remark"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel9.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 1050, 220));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1130, 300));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 750, 108, 45));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Update");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 750, 108, 45));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 750, 108, 45));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("* Receiving Date");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("* Job Name");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("* Remark");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 290, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 840, 80));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("* Completed Date");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("* Designer");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 290, -1));
        jPanel3.add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 200, -1));
        jPanel3.add(jDateChooser5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 200, -1));

        jLabel68.setText("jLabel68");
        jPanel3.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 70, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 1060, 220));

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton14.setText("Clear");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 700, 90, 30));

        jTabbedPane1.addTab("Other Jobs", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 900));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            // TODO add your handling code here:
            //        set data to the feilds
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            int i = jTable1.getSelectedRow();
            String jobid = dtm.getValueAt(i, 0).toString();

            ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language,recomd_price from costing c1 inner join production_description p1 on c1.job_card_idjob_card = p1.job_card_idjob_card "
                    + "inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where md_approv='Yes' AND idjob_card='" + jobid + "'");

            if (rs.next()) {
                String job_crdid = rs.getString("idjob_card");
                jLabel29.setText(job_crdid);

                String ag_date = rs.getString("agrmt_sign_date");
                jLabel4.setText(ag_date);

                String titl = rs.getString("manuscript_name");
                jTextField5.setText(titl);

                String author = rs.getString("fname");
                jTextField10.setText(author);

                String ibn = rs.getString("isbn");
                jTextField9.setText(ibn);

                String langu = rs.getString("language");
                jTextField11.setText(langu);

                String rprce = rs.getString("recomd_price");
                jTextField21.setText(rprce);

            }

        } catch (Exception ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jLabel29.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select The Job Card", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (!jLabel29.getText().isEmpty()) {
            try {
                ResultSet rs2 = ConnectionSet1.getInstance().getResult("select job_card_idjob_card from grafic_jobs where job_card_idjob_card='" + jLabel29.getText() + "'");
                if (rs2.next()) {
                    JOptionPane.showMessageDialog(this, "This Joob Card is Allready Assinged", "error", JOptionPane.WARNING_MESSAGE);

                } else {
                    try {
                        // TODO add your handling code here:
                        //save data 
                        String dingerName = jComboBox1.getSelectedItem().toString();
                        String dndead = datechosser(jDateChooser1);

                        String planerName = jComboBox2.getSelectedItem().toString();
                        String pdead = datechosser(jDateChooser3);

                        int job_cardid = 0;
                        ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card from job_card where idjob_card='" + jLabel29.getText() + "'");
                        if (rs.next()) {
                            job_cardid = rs.getInt("idjob_card");
                        }

                        ConnectionSet1.getInstance().setResult("insert into grafic_jobs(disigner_nme,disigner_deadln,planner_nme,planner_deadln,job_card_idjob_card,send_dte) "
                                + "values('" + dingerName + "','" + dndead + "','" + planerName + "','" + pdead + "','" + job_cardid + "','" + jLabel16.getText() + "')");

                        int grfjid = 0;
                        ResultSet rs1 = ConnectionSet1.getInstance().getResult("select idgrafic_dep from grafic_jobs where idgrafic_dep='" + jLabel17.getText() + "'");
                        if (rs1.next()) {
                            grfjid = rs1.getInt("idgrafic_dep");
                        }

                        ConnectionSet1.getInstance().setResult("insert into disigner_jobs(job_doned,grafic_jobs_idgrafic_dep) values('No','" + grfjid + "')");
                        ConnectionSet1.getInstance().setResult("insert into planner(job_done,grafic_jobs_idgrafic_dep) values('No','" + grfjid + "')");

                        jLabel17.setText(maxid("idgrafic_dep", "grafic_jobs", 1));
                        jComboBox1.setSelectedIndex(0);
                        jComboBox2.setSelectedIndex(0);

                        jTextField5.setText("");
                        jLabel29.setText("");
                        jTextField10.setText("");
                        jTextField9.setText("");
                        jTextField11.setText("");
                        jLabel4.setText("");
                        jTextField21.setText("");
                        jDateChooser1.setDate(null);
                        jDateChooser3.setDate(null);

                    } catch (Exception ex) {
                        Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } catch (Exception ex) {
                Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        try {
            // TODO add your handling code here:
            //set values for the feilds
            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            int i = jTable3.getSelectedRow();
            String jobid = dtm.getValueAt(i, 0).toString();

            ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language,job_doned,job_done,idgrafic_dep from grafic_jobs g1 inner join disigner_jobs d1 on g1.idgrafic_dep = d1.grafic_jobs_idgrafic_dep inner join planner p1 "
                    + "on g1.idgrafic_dep = p1.grafic_jobs_idgrafic_dep inner join job_card j1 on g1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where job_done='Yes' AND job_doned='Yes' AND postv_cmplt is null");

            if (rs.next()) {
                String idjob = rs.getString("idjob_card");
                jLabel39.setText(idjob);

                String jobdate = rs.getString("agrmt_sign_date");
                jLabel18.setText(jobdate);

                String title = rs.getString("manuscript_name");
                jTextField6.setText(title);

                String author = rs.getString("fname");
                jTextField15.setText(author);

                String isbn = rs.getString("isbn");
                jTextField14.setText(isbn);

                String langu = rs.getString("language");
                jTextField16.setText(langu);

                String disjbdn = rs.getString("job_doned");
                jTextField17.setText(disjbdn);

                String plnjbdn = rs.getString("job_done");
                jTextField18.setText(plnjbdn);

                String idgrf = rs.getString("idgrafic_dep");
                jLabel19.setText(idgrf);

            }

        } catch (Exception ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (jLabel39.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select The Job Card", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                // TODO add your handling code here:
                //save the job in hand is completed
                String positv_cplt;
                if (jCheckBox6.isSelected()) {
                    positv_cplt = "Yes";
                } else {
                    positv_cplt = "No";
                }

                String tracng_cplt;
                if (jCheckBox9.isSelected()) {
                    tracng_cplt = "Yes";
                } else {
                    tracng_cplt = "No";
                }

                String ctp;
                if (jCheckBox10.isSelected()) {
                    ctp = "Yes";
                } else {
                    ctp = "No";
                }

                ConnectionSet1.getInstance().setResult("update grafic_jobs set postv_cmplt='" + positv_cplt + "',trcng_cmplt='" + tracng_cplt + "',ctp='" + ctp + "',printin_shedul='added' where idgrafic_dep='" + jLabel19.getText() + "'");

                jTextField6.setText("");
                jTextField15.setText("");
                jTextField16.setText("");
                jTextField17.setText("");
                jLabel39.setText("");
                jLabel19.setText("");
                jTextField14.setText("");
                jLabel18.setText("");
                jTextField18.setText("");
                buttonGroup1.clearSelection();
                buttonGroup2.clearSelection();
                buttonGroup3.clearSelection();
                tableLoad();

            } catch (Exception ex) {
                Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        try {
            // TODO add your handling code here:
            //set value for the table
            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
            int i = jTable4.getSelectedRow();
            String jobid = dtm.getValueAt(i, 0).toString();

            ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language,job_doned,job_done,idgrafic_dep,postv_cmplt,trcng_cmplt,ctp from grafic_jobs g1 inner join disigner_jobs d1 on g1.idgrafic_dep = d1.grafic_jobs_idgrafic_dep inner join planner p1 "
                    + "on g1.idgrafic_dep = p1.grafic_jobs_idgrafic_dep inner join job_card j1 on g1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where job_done='Yes' AND job_doned='Yes' AND postv_cmplt is not null");

            if (rs.next()) {
                String idjob = rs.getString("idjob_card");
                jLabel57.setText(idjob);

                String jobdate = rs.getString("agrmt_sign_date");
                jLabel25.setText(jobdate);

                String title = rs.getString("manuscript_name");
                jTextField7.setText(title);

                String author = rs.getString("fname");
                jTextField23.setText(author);

                String isbn = rs.getString("isbn");
                jTextField22.setText(isbn);

                String langu = rs.getString("language");
                jTextField24.setText(langu);

                String disjbdn = rs.getString("job_doned");
                jTextField25.setText(disjbdn);

                String plnjbdn = rs.getString("job_done");
                jTextField26.setText(plnjbdn);

                String idgrf = rs.getString("idgrafic_dep");
                jLabel26.setText(idgrf);

                String pos_cmplt = rs.getString("postv_cmplt");
                if (pos_cmplt.equals("Yes")) {
                    jCheckBox12.setSelected(true);
                } else {
                    jCheckBox13.setSelected(true);
                }

                String trsng_cmplt = rs.getString("trcng_cmplt");
                if (trsng_cmplt.equals("Yes")) {
                    jCheckBox15.setSelected(true);
                } else {
                    jCheckBox14.setSelected(true);
                }

                String ctp = rs.getString("ctp");
                if (ctp.equals("Yes")) {
                    jCheckBox16.setSelected(true);
                } else {
                    jCheckBox17.setSelected(true);
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        //clear all data
        jTextField6.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jLabel39.setText("");
        jLabel19.setText("");
        jTextField14.setText("");
        jLabel18.setText("");
        jTextField18.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        buttonGroup3.clearSelection();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (jLabel57.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select The Job Card", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                // TODO add your handling code here:
                //update the complete jobs
                String positv_cplt;
                if (jCheckBox12.isSelected()) {
                    positv_cplt = "Yes";
                } else {
                    positv_cplt = "No";
                }

                String tracng_cplt;
                if (jCheckBox15.isSelected()) {
                    tracng_cplt = "Yes";
                } else {
                    tracng_cplt = "No";
                }

                String ctp;
                if (jCheckBox16.isSelected()) {
                    ctp = "Yes";
                } else {
                    ctp = "No";
                }

                ConnectionSet1.getInstance().setResult("update grafic_jobs set postv_cmplt='" + positv_cplt + "',trcng_cmplt='" + tracng_cplt + "',ctp='" + ctp + "' where idgrafic_dep='" + jLabel26.getText() + "'");

                jTextField7.setText("");
                jTextField23.setText("");
                jTextField24.setText("");
                jTextField25.setText("");
                jLabel57.setText("");
                jLabel26.setText("");
                jTextField22.setText("");
                jLabel25.setText("");
                jTextField26.setText("");
                buttonGroup1.clearSelection();
                buttonGroup2.clearSelection();
                buttonGroup3.clearSelection();
                tableLoad();

            } catch (Exception ex) {
                Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        //clear all data
        jTextField7.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        jTextField25.setText("");
        jLabel57.setText("");
        jLabel26.setText("");
        jTextField22.setText("");
        jLabel25.setText("");
        jTextField26.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        buttonGroup3.clearSelection();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        try {
            // TODO add your handling code here:
            //search a new jobs
            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language,recomd_price from costing c1 inner join production_description p1 on c1.job_card_idjob_card = p1.job_card_idjob_card "
                    + "inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where md_approv='Yes' AND (fname like('" + jTextField8.getText() + "%%" + "') or manuscript_name like('" + jTextField8.getText() + "%%%" + "') or idjob_card like('" + jTextField8.getText() + "%%" + "'))", jTable1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyReleased
        try {
            // TODO add your handling code here:
            //serch on goin jobs
            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language,job_doned,job_done from grafic_jobs g1 inner join disigner_jobs d1 on g1.idgrafic_dep = d1.grafic_jobs_idgrafic_dep inner join planner p1 "
                    + "on g1.idgrafic_dep = p1.grafic_jobs_idgrafic_dep inner join job_card j1 on g1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where job_done='Yes' AND job_doned='Yes' AND postv_cmplt is null  AND (fname like('" + jTextField13.getText() + "%%" + "') or manuscript_name like('" + jTextField13.getText() + "%%%" + "') or idjob_card like('" + jTextField13.getText() + "%%" + "'))", jTable3);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField13KeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        try {
            // TODO add your handling code here:
            //serch the complete jobs
            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language,job_doned,job_done from grafic_jobs g1 inner join disigner_jobs d1 on g1.idgrafic_dep = d1.grafic_jobs_idgrafic_dep inner join planner p1 "
                    + "on g1.idgrafic_dep = p1.grafic_jobs_idgrafic_dep inner join job_card j1 on g1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where job_done='Yes' AND job_doned='Yes' AND postv_cmplt is not null  AND (fname like('" + jTextField1.getText() + "%%" + "') or manuscript_name like('" + jTextField1.getText() + "%%%" + "') or idjob_card like('" + jTextField1.getText() + "%%" + "'))", jTable4);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            //add the other job details
            String jname = jTextField19.getText();
            String disinr = jTextField20.getText();
            String reci_dte = datechosser(jDateChooser5);
            //String cmplt_dte =  datechosser(jDateChooser4);
            String remk = jTextArea1.getText();

            ConnectionSet1.getInstance().setResult("insert into grfic_other_jobs(jname,disigner,recive_dte,remark) values('" + jname + "','" + disinr + "','" + reci_dte + "','" + remk + "')");

            jTextField19.setText("");
            jTextField20.setText("");
            jTextArea1.setText("");
            tableLoad();

        } catch (Exception ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try {
            // TODO add your handling code here:
            // set data from the feilds
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            int i = jTable2.getSelectedRow();
            String ojid = dtm.getValueAt(i, 0).toString();

            ResultSet rs = ConnectionSet1.getInstance().getResult("select * from grfic_other_jobs");

            if (rs.next()) {
                String ojbid = rs.getString("idgrfic_other_jobs");
                jLabel68.setText(ojbid);

                String jbnme = rs.getString("jname");
                jTextField19.setText(jbnme);

                String disigner = rs.getString("disigner");
                jTextField20.setText(disigner);

                String resdte = rs.getString("recive_dte");
                Date d = new Date(resdte);
                d.getDate();
                jDateChooser5.setDate(d);

                String remrk = rs.getString("remark");
                jTextArea1.setText(remrk);

                String cmpltdte = rs.getString("cmplt_dte");
                Date d1 = new Date(cmpltdte);
                d1.getDate();
                jDateChooser4.setDate(d1);

            }

        } catch (Exception ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            //update the form
            String jname = jTextField19.getText();
            String disinr = jTextField20.getText();
            String reci_dte = datechosser(jDateChooser5);
            String cmplt_dte = datechosser(jDateChooser4);
            String remk = jTextArea1.getText();

            ConnectionSet1.getInstance().setResult("update grfic_other_jobs set jname='" + jname + "',disigner='" + disinr + "',recive_dte='" + reci_dte + "',cmplt_dte='" + cmplt_dte + "',remark='" + remk + "' where idgrfic_other_jobs='" + jLabel68.getText() + "'");

            jTextField19.setText("");
            jTextField20.setText("");
            jTextArea1.setText("");
            tableLoad();

        } catch (Exception ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        try {
            // TODO add your handling code here:
            //serch other jobs details
            new tablemodel1().fillTable("select * from grfic_other_jobs where jname like('" + jTextField12.getText() + "%%" + "') or idgrfic_other_jobs like('" + jTextField12.getText() + "%%%" + "')", jTable2);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(graficDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
//        clear all the data
        jTextField5.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jLabel29.setText("");
        jLabel17.setText("");
        jTextField9.setText("");
        jLabel4.setText("");
        jTextField21.setText("");
        jComboBox1.setSelectedIndex(0);
        jDateChooser1.setDate(null);
        jComboBox2.setSelectedIndex(0);
        jDateChooser3.setDate(null);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {
            //             TODO add your handling code here:
            //            go back to home
            String uname = jLabel69.getText();
            String username = null;
            String desig = null;
            String typ = null;
            //
            ResultSet rs = ConnectionSet1.getInstance().getResult("select * from user where username='" + uname + "'");
            if (rs.next()) {
                desig = rs.getString("designation");
                username = rs.getString("username");
                typ = rs.getString("user_type");

            }

            System.out.println("1");
            if (username.equals(uname) && typ.equals("User") && desig.equals("Designer")) {
                System.out.println("2");
                new Menu("Designer", "User", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("Admin") && desig.equals("IT")) {
                System.out.println("3");
                new Menu("IT", "Admin", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("User") && desig.equals("Head Of Grafic")) {
                new Menu("Head Of Grafic", "User", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("User") && desig.equals("Planner")) {
                System.out.println("2");
                new Menu("Planner", "User", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("Admin") && desig.equals("Publishing Manager")) {
                System.out.println("3");
                new Menu("Publishing Manager", "Admin", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("Admin") && desig.equals("MD")) {
                System.out.println("3");
                new Menu("MD", "Admin", uname).setVisible(true);
                dispose();

            }

        } catch (Exception ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        //clear all feilds
        jDateChooser5.setDate(null);
        jTextField19.setText("");
        jTextArea1.setText("");
        jLabel68.setText("");
        jDateChooser4.setDate(null);
        jTextField20.setText("");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
        jTextField20.grabFocus();
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
        jTextArea1.grabFocus();
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable5MouseClicked

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
            java.util.logging.Logger.getLogger(graficDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(graficDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(graficDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(graficDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new graficDepartment().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
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
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
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
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
