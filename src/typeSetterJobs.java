
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
public class typeSetterJobs extends javax.swing.JFrame {

    /**
     * Creates new form typeSetterJobs
     */
    SimpleDateFormat d1, d2;
    Timer t;

    public typeSetterJobs() {
        initComponents();

        //hide the jlist
        jPanel5.setVisible(false);


        dateMethod();

    }

    typeSetterJobs(String uname) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this();

        jLabel4.setText(uname);

        tableLoad();
//        chechFormatingComplete();
    }

//    void chechFormatingComplete(){
//        try {
//            
//            ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card,complte from formating_jobs f1 inner join proof_details p1 on f1.proof_details_idproof_details = p1.idproof_details inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card where complte='Yes' AND idjob_card='" + jLabel2.getText() + "'");
//        
//            if(rs.next()){
//                jCheckBox3.setVisible(true);
//                jCheckBox6.setVisible(true);
//            }
//            
//        } catch (Exception ex) {
//            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    void tableLoad() {
        try {

            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language from job_card j1 inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where type_setter='" + jLabel4.getText() + "'", jTable4);
            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language,job_accepted from typesetter_staus t1 inner join job_card j1 on t1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where type_setter='" + jLabel4.getText() + "'", jTable5);
            new tablemodel1().fillTable("select job_card_idjob_card,b_title,p_step,p_reader,remarkp,sent_date,resive_date from proof_details p1 inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card where type_setter='" + jLabel4.getText() + "'", jTable2);
            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language from proof_details p1 inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where p_step='3 rd Proof' AND type_setter='" + jLabel4.getText() + "'", jTable1);
            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language from typesetter_fil t1 inner join job_card j1 on t1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where complete='Yes' AND type_setter='" + jLabel4.getText() + "'", jTable3);
            new tablemodel1().fillTable("select idjob_card,resive_date,manuscript_name,fname,isbn,language,complte from formating_jobs f1 inner join proof_details p1 on f1.proof_details_idproof_details = p1.idproof_details inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where complte='Yes' AND type_setter='" + jLabel4.getText() + "'", jTable7);
            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language from typesetter_fil t1 inner join proof_details p1 on t1.job_card_idjob_card = p1.job_card_idjob_card inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where complete='No' AND type_setter='" + jLabel4.getText() + "' AND p_step='3 rd Proof'", jTable6);
            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language from typesetter_fil t1 inner join job_card j1 on t1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where complete='Yes' AND type_setter='" + jLabel4.getText() + "'", jTable8);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
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

                jLabel38.setText(d1.format(d));
                jLabel39.setText(d2.format(d));

                jLabel25.setText(d1.format(d));
                jLabel32.setText(d2.format(d));

                jLabel66.setText(d1.format(d));
                jLabel67.setText(d2.format(d));

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
        jLabel14 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField18 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel72 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jTextField23 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel49 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel73 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jButton9 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jTextField27 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jLabel54 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField24 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jTextField25 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Type Setter Jobs");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Typesetter Jobs");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 230, 58));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 210, 52));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 110, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 710, 108, 45));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Clear");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 790, 108, 45));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("Date ");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Jobs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Date", "Title", "Author", "ISBN", "Language"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        jScrollPane3.setViewportView(jTable4);

        jPanel13.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1070, 170));

        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField18KeyReleased(evt);
            }
        });
        jPanel13.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 295, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Search");
        jPanel13.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 55, -1));

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1110, 270));

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Job Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("Book Title");
        jPanel16.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 110, -1));

        jTextField19.setEditable(false);
        jPanel16.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 291, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText("Job No ");
        jPanel16.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));
        jPanel16.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 130, 20));

        jTextField20.setEditable(false);
        jPanel16.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 250, -1));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setText("ISBN");
        jPanel16.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        jTextField21.setEditable(false);
        jPanel16.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 290, -1));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel57.setText("* Typesetter Job Accepted");
        jPanel16.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, -1, -1));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setText("Language");
        jPanel16.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jTextField22.setEditable(false);
        jPanel16.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 290, -1));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("Date ");
        jPanel16.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, -1, -1));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setText("Authour/Translator name");
        jPanel16.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setText("* Typesetter Job Accepted Date");
        jPanel16.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setText("Yes");
        jPanel16.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, -1, -1));
        jPanel16.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 170, -1));
        jPanel16.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 100, 20));

        jPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 1070, 210));

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Accepted Jobs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Date", "Title", "Author", "ISBN", "Language", "Accepted Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jPanel17.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 920, 150));

        jTextField23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField23KeyReleased(evt);
            }
        });
        jPanel17.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 240, -1));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setText("Search");
        jPanel17.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 60, -1));

        jPanel1.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 960, 230));

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, 0));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/home.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/home1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 70));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/sarasavi.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 267, 65));

        jTabbedPane1.addTab("Typesetter Jobs", jPanel1);

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proof Reading", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText("* Proof Step");
        jPanel14.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("* Remark");
        jPanel14.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));
        jPanel14.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 290, -1));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("* Sent Date ");
        jPanel14.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("Job Card No");
        jPanel14.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane7.setViewportView(jTextArea3);

        jPanel14.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 420, 60));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setText("* Book Title");
        jPanel14.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 100, -1));

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton12.setText("Save");
        jButton12.setBorder(null);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 80, 30));
        jPanel14.add(jDateChooser5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 200, -1));

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox3.setText("3 rd  Proof");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        buttonGroup1.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox5.setText("1 st Proof");
        jPanel14.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        buttonGroup1.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox6.setText("2 nd  Proof");
        jPanel14.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel14.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 260, -1));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 70));

        jPanel14.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 280, 80));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel73.setText("* Proof Reader");
        jPanel14.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));
        jPanel14.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 100, 30));

        jLabel5.setText("Select the Book Name First");
        jPanel14.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 14, 210, 20));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("Clear");
        jButton8.setBorder(null);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, 80, 30));

        jPanel12.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 1040, 220));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proof Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Card No", "Book Title", "Proof Step ", "Proof Reader", "Remark", "Sent Date", "Date Returned"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane4.setViewportView(jTable2);

        jPanel11.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1000, 200));

        jPanel12.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 1050, 240));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel26.setText("Proof Details");
        jPanel12.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 210, 58));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("Date ");
        jPanel12.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel12.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 210, 52));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel12.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 110, 30));

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
        });
        jPanel12.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 295, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Search");
        jPanel12.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 55, -1));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("* Date Returned");
        jPanel12.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 600, -1, -1));
        jPanel12.add(jDateChooser6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 600, 200, -1));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("Update");
        jButton9.setBorder(null);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 600, 80, 30));

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Date", "Title", "Author", "ISBN", "Language", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(jTable7);

        jPanel12.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, 1090, 180));

        jTextField27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField27KeyReleased(evt);
            }
        });
        jPanel12.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 295, -1));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel75.setText("Search");
        jPanel12.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 650, 55, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commplte Formating Jobs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel12.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 1110, 240));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setText("Delete");
        jButton10.setBorder(null);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel12.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 600, 80, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/sarasavi.png"))); // NOI18N
        jPanel12.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 267, 65));

        jTabbedPane1.addTab("Proof Details", jPanel12);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel23.setText("Typesetter Details");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 270, 58));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 210, 52));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 110, 30));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proof Completed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Date", "Title", "Author", "ISBN", "Language"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1060, 190));

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });
        jPanel8.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 295, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Search");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 55, -1));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1100, 250));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Job Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Book Title");
        jPanel9.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 110, -1));

        jTextField5.setEditable(false);
        jPanel9.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 291, -1));
        jPanel9.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 90, 30));

        jTextField9.setEditable(false);
        jPanel9.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 250, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("ISBN");
        jPanel9.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, -1));

        jTextField10.setEditable(false);
        jPanel9.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 290, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Authour/Translator name");
        jPanel9.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Language");
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jTextField11.setEditable(false);
        jPanel9.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 290, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Date ");
        jPanel9.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, -1, -1));
        jPanel9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 100, 30));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel74.setText("Job No ");
        jPanel9.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, -1));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 1010, 130));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Update");
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 780, 108, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Complete Work", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 100, 40));

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("* Type Setting & Proof Complete");
        jPanel7.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("* Complete Date ");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jCheckBox8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox8.setText("OK");
        jPanel7.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 50, -1));
        jPanel7.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 160, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 340, 80));

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("* Number Of Pages");
        jPanel10.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setText("* Product Size");
        jPanel10.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField14KeyTyped(evt);
            }
        });
        jPanel10.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 150, -1));
        jPanel10.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 150, -1));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 360, 80));

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox7.setText("B & W");
        jPanel15.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jCheckBox9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox9.setText("Colour");
        jPanel15.add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jTextField16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField16KeyTyped(evt);
            }
        });
        jPanel15.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 150, -1));

        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField17KeyTyped(evt);
            }
        });
        jPanel15.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 150, -1));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setText("* Positives");
        jPanel15.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jCheckBox10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox10.setText("  have");
        jPanel15.add(jCheckBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        jCheckBox11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox11.setText("  have");
        jPanel15.add(jCheckBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, -1));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setText("* Shades");
        jPanel15.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 70, -1));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel70.setText("* Images");
        jPanel15.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel51.setText("* NO of Pages");
        jPanel15.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel71.setText("* NO of Pages");
        jPanel15.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jPanel2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 540, 80));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 560, 350));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Date ");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Clear");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 780, 90, 40));

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Complted Jobs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Date", "Title", "Author", "ISBN", "Language"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable8MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTable8);

        jPanel20.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 530, 200));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Search");
        jPanel20.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 55, -1));
        jPanel20.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 210, -1));

        jPanel3.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 550, 270));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/sarasavi.png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 267, 65));

        jTabbedPane1.addTab("Type Setter Details", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Completed Jobs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Date", "Title", "Author", "ISBN", "Language"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable3);

        jPanel18.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1060, 200));

        jTextField24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField24KeyReleased(evt);
            }
        });
        jPanel18.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 295, -1));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setText("Search");
        jPanel18.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 55, -1));

        jPanel4.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 1100, 290));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel64.setText("Ongoing Jobs");
        jPanel4.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 270, 58));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel65.setText("Date ");
        jPanel4.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 210, 52));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel4.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 110, 30));

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ongoing Jobs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Date", "Title", "Author", "ISBN", "Language"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTable6);

        jPanel19.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1060, 200));
        jPanel19.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 295, -1));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel68.setText("Search");
        jPanel19.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 55, -1));

        jPanel4.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 1100, 290));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel69.setText("Completed Jobs");
        jPanel4.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 270, 58));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/sarasavi.png"))); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 267, 65));

        jTabbedPane1.addTab("Completed & Ongoing Jobs", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 900));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        // set value from the new jobs table to te txt feilds
        DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
        int i = jTable4.getSelectedRow();

        String s1 = dtm.getValueAt(i, 0).toString();
        String s2 = dtm.getValueAt(i, 1).toString();
        String s3 = dtm.getValueAt(i, 2).toString();
        String s4 = dtm.getValueAt(i, 3).toString();
        String s5 = dtm.getValueAt(i, 4).toString();
        String s6 = dtm.getValueAt(i, 5).toString();

        jLabel72.setText(s1);
        jLabel55.setText(s2);
        jTextField19.setText(s3);
        jTextField21.setText(s4);
        jTextField20.setText(s5);
        jTextField22.setText(s6);
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jLabel72.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select The Job Card", "error", JOptionPane.WARNING_MESSAGE);

        } else if (!jLabel72.getText().isEmpty()) {
            try {

                ResultSet rs1 = ConnectionSet1.getInstance().getResult("select job_card_idjob_card from typesetter_staus where job_card_idjob_card='" + jLabel72.getText() + "'");
                if (rs1.next()) {
                    JOptionPane.showMessageDialog(this, "This Job Card is Allready Assinged", "error", JOptionPane.WARNING_MESSAGE);

                } else if (!jCheckBox1.isSelected()) {
                    JOptionPane.showMessageDialog(this, "No Value for the Save", "error", JOptionPane.WARNING_MESSAGE);

                } else {
                    try {
                        // TODO add your handling code here:
                        //approve job typeSetter

                        int job_crd = 0;
                        ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card from job_card where idjob_card='" + jLabel72.getText() + "'");
                        if (rs.next()) {
                            job_crd = rs.getInt("idjob_card");
                        }

                        String acptdte = datechosser(jDateChooser2);
                        String jobacp;
                        if (jCheckBox1.isSelected()) {
                            jobacp = "Yes";
                        } else {
                            jobacp = "No";
                        }

                        ConnectionSet1.getInstance().setResult("insert into typesetter_staus(accept_date,job_accepted,job_card_idjob_card) values('" + acptdte + "','" + jobacp + "','" + job_crd + "') ");
                        jLabel72.setText("");
                        jLabel55.setText("");
                        jTextField19.setText("");
                        jTextField21.setText("");
                        jTextField20.setText("");
                        jTextField22.setText("");
                        jDateChooser2.setDate(null);
                        jCheckBox1.setSelected(false);
                        tableLoad();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            } catch (Exception ex) {
                Logger.getLogger(fullEvoluationProcess.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // clear all
        jLabel72.setText("");
        jLabel55.setText("");
        jTextField19.setText("");
        jTextField21.setText("");
        jTextField20.setText("");
        jTextField22.setText("");
        jDateChooser2.setDate(null);
        jCheckBox1.setSelected(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField18KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyReleased
        try {
            // TODO add your handling code here:
            // search new job for the type setter

            tablemodel1.fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language from job_card j1 inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where type_setter='" + jLabel4.getText() + "' AND (fname like('" + jTextField18.getText() + "%%" + "') or manuscript_name like('" + jTextField18.getText() + "%%%" + "') or isbn like('" + jTextField18.getText() + "%%%" + "'))", jTable4);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField18KeyReleased

    private void jTextField23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField23KeyReleased
        try {
            // TODO add your handling code here:
            //approve the job typesetter
            tablemodel1.fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language,job_accepted from typesetter_staus t1 inner join job_card j1 on t1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where type_setter='" + jLabel4.getText() + "' AND (fname like('" + jTextField23.getText() + "%%" + "') or manuscript_name like('" + jTextField23.getText() + "%%%" + "') or isbn like('" + jTextField23.getText() + "%%%" + "'))", jTable5);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField23KeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        //get the manuscriptname
        if (!jTextField1.getText().isEmpty()) {
            try {
                jPanel5.setVisible(true);

                //ResultSet rs = ConnectionSet1.getInstance().getResult("select * from reseving_manuscript where manuscript_name like('" + jTextField1.getText() + "%%%%%" + "')");
                ResultSet rs = ConnectionSet1.getInstance().getResult("select manuscript_name,idjob_card from job_card j1 inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm where type_setter='" + jLabel4.getText() + "' AND manuscript_name like('" + jTextField1.getText() + "%%%%%" + "')");
                Vector v = new Vector();
                //Vector v1 = new Vector();

                while (rs.next()) {
                    v.add(rs.getString("manuscript_name"));
                    //v1.add(rs.getString("idjob_card"));
                    jLabel2.setText(rs.getString("idjob_card"));
                }

                jList1.setListData(v);

            } catch (Exception ex) {
                Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jPanel5.setVisible(false);
            jLabel2.setText("");
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        //select the name in arrov keys
        if (evt.getKeyCode() == 40) {
            jList1.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed
        // TODO add your handling code here:
        //set value for the textfeild to click the enter button
        if (evt.getKeyCode() == 10) {
            String mname = jList1.getSelectedValue().toString();
            jTextField1.setText(mname);
            jPanel5.setVisible(false);
        }
    }//GEN-LAST:event_jList1KeyPressed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        //set value for the textfeild
        String mname = jList1.getSelectedValue().toString();
        jTextField1.setText(mname);
        jPanel5.setVisible(false);
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (jLabel2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select The Book Name First", "error", JOptionPane.WARNING_MESSAGE);

        } else if (!jLabel2.getText().isEmpty()) {
            try {

                String proof;
                if (jCheckBox5.isSelected()) {
                    proof = "1 st Proof";
                } else if (jCheckBox6.isSelected()) {
                    proof = "2 nd Proof";
                } else {
                    proof = "3 rd Proof";
                }

                ResultSet rs = ConnectionSet1.getInstance().getResult("select job_card_idjob_card,p_step from proof_details where job_card_idjob_card='" + jLabel2.getText() + "' AND p_step='" + proof + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "proof is added", "error", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        // TODO add your handling code here:
                        //save the proof details

//                String proof;
//                if (jCheckBox5.isSelected()) {
//                    proof = "1 st Proof";
//                } else if (jCheckBox6.isSelected()) {
//                    proof = "2 nd Proof";
//                } else {
//                    proof = "3 rd Proof";
//                }

                        if (jCheckBox3.isSelected()) {
                            ResultSet rs3 = ConnectionSet1.getInstance().getResult("select complte,idjob_card from formating_jobs f1 inner join proof_details p1 on f1.proof_details_idproof_details = p1.idproof_details inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card where complte='Yes' AND idjob_card='" + jLabel2.getText() + "'");
                            if (rs3.next()) {
                                String sdte = datechosser(jDateChooser5);
                                //String dtertn = datechosser(jDateChooser6);

                                ConnectionSet1.getInstance().setResult("insert into proof_details(`proof_details`.`b_title`, `proof_details`.`p_step`, `proof_details`.`p_reader`, `proof_details`.`sent_date`,`proof_details`.`remarkp`, `proof_details`.`job_card_idjob_card`) values"
                                        + "('" + jTextField1.getText() + "','" + proof + "','" + jTextField13.getText() + "','" + sdte + "','" + jTextArea3.getText() + "','" + jLabel2.getText() + "')");

                                jTextField1.setText("");
                                jTextField13.setText("");
                                jTextArea3.setText("");
                                jLabel2.setText("");
                                jDateChooser5.setDate(null);
                                buttonGroup1.clearSelection();
                                tableLoad();
                            } else {
                                JOptionPane.showMessageDialog(this, "Formatting is not completed", "error", JOptionPane.WARNING_MESSAGE);
                            }

                        } else {

                            String sdte = datechosser(jDateChooser5);
                            //String dtertn = datechosser(jDateChooser6);

                            ConnectionSet1.getInstance().setResult("insert into proof_details(`proof_details`.`b_title`, `proof_details`.`p_step`, `proof_details`.`p_reader`, `proof_details`.`sent_date`,`proof_details`.`remarkp`, `proof_details`.`job_card_idjob_card`) values"
                                    + "('" + jTextField1.getText() + "','" + proof + "','" + jTextField13.getText() + "','" + sdte + "','" + jTextArea3.getText() + "','" + jLabel2.getText() + "')");

                            jTextField1.setText("");
                            jTextField13.setText("");
                            jTextArea3.setText("");
                            jLabel2.setText("");
                            jDateChooser5.setDate(null);
                            buttonGroup1.clearSelection();
                            tableLoad();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            } catch (Exception ex) {
                Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            // TODO add your handling code here:
            //update proof details
            String proof;
            if (jCheckBox5.isSelected()) {
                proof = "1 st Proof";
            } else if (jCheckBox6.isSelected()) {
                proof = "2 nd Proof";
            } else {
                proof = "3 rd Proof";
            }

            String sdte = datechosser(jDateChooser5);
            String dtertn = datechosser(jDateChooser6);

            ConnectionSet1.getInstance().setResult("Update proof_details set b_title='" + jTextField1.getText() + "',p_reader='" + jTextField13.getText() + "',sent_date='" + sdte + "',resive_date='" + dtertn + "',remarkp='" + jTextArea3.getText() + "' where p_step='" + proof + "' and job_card_idjob_card='" + jLabel2.getText() + "'");
            jTextField1.setText("");
            jTextField13.setText("");
            jTextArea3.setText("");
            jLabel2.setText("");
            buttonGroup1.clearSelection();
            jDateChooser5.setDate(null);
            jDateChooser6.setDate(null);
            tableLoad();

        } catch (Exception ex) {
//            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(this, "proof is added", "error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        try {
            // TODO add your handling code here:
            //proof details search
            tablemodel1.fillTable("select job_card_idjob_card,b_title,p_step,p_reader,remarkp,sent_date,resive_date from proof_details p1 inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card  where type_setter='" + jLabel4.getText() + "' AND (b_title like('" + jTextField12.getText() + "%%%" + "') or job_card_idjob_card like('" + jTextField12.getText() + "%%" + "') or p_step like('" + jTextField12.getText() + "%%" + "'))", jTable2);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try {
            // TODO add your handling code here:
            //set data from the proof details
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            int i = jTable2.getSelectedRow();

            String s1 = dtm.getValueAt(i, 0).toString();
            jLabel2.setText(s1);

            String s2 = dtm.getValueAt(i, 1).toString();
            jTextField1.setText(s2);

            String prof = dtm.getValueAt(i, 2).toString();
            if (prof.equals("1 st Proof")) {
                jCheckBox5.setSelected(true);
            } else if (prof.equals("2 nd Proof")) {
                jCheckBox6.setSelected(true);
            } else {
                jCheckBox3.setSelected(true);
            }

            String s4 = dtm.getValueAt(i, 3).toString();
            jTextField13.setText(s4);

            String s5 = dtm.getValueAt(i, 4).toString();
            jTextArea3.setText(s5);

            String s6 = dtm.getValueAt(i, 5).toString();
            Date d1 = new Date(s6);
            d1.getDate();
            jDateChooser5.setDate(d1);

            String s7 = dtm.getValueAt(i, 6).toString();
            Date d2 = new Date(s7);
            d2.getDate();
            jDateChooser6.setDate(d2);



        } catch (Exception ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        //claer all
        jTextField1.setText("");
        jTextField13.setText("");
        jTextArea3.setText("");
        jLabel2.setText("");
        buttonGroup1.clearSelection();
        jDateChooser5.setDate(null);
        jDateChooser6.setDate(null);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        try {
            // TODO add your handling code here:
            //serch Typesetter details
            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language from proof_details p1 inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where p_step='3 rd Proof' AND type_setter='" + jLabel4.getText() + "' AND (fname like('" + jTextField8.getText() + "%%" + "') or manuscript_name like('" + jTextField8.getText() + "%%%" + "') or isbn like('" + jTextField8.getText() + "%%%" + "'))", jTable1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        // set values from typesetter details
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int i = jTable1.getSelectedRow();

        String s1 = dtm.getValueAt(i, 0).toString();
        jLabel29.setText(s1);

        String s2 = dtm.getValueAt(i, 1).toString();
        jLabel3.setText(s2);

        String s3 = dtm.getValueAt(i, 2).toString();
        jTextField5.setText(s3);

        String s4 = dtm.getValueAt(i, 3).toString();
        jTextField10.setText(s4);

        String s5 = dtm.getValueAt(i, 4).toString();
        jTextField9.setText(s5);

        String s6 = dtm.getValueAt(i, 5).toString();
        jTextField11.setText(s6);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jLabel29.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select the job Card", "error", JOptionPane.WARNING_MESSAGE);

        } else if (!jLabel29.getText().isEmpty()) {
            try {

                ResultSet rs1 = ConnectionSet1.getInstance().getResult("select job_card_idjob_card from typesetter_fil where job_card_idjob_card='" + jLabel29.getText() + "'");
                if (rs1.next()) {
                    JOptionPane.showMessageDialog(this, "The Job Is Allready Completed", "error", JOptionPane.WARNING_MESSAGE);
                } else {

                    try {
                        // TODO add your handling code here:
                        //add typesetter details
                        String cmlwrk;
                        if (jCheckBox8.isSelected()) {
                            cmlwrk = "Yes";
                        } else {
                            cmlwrk = "No";
                        }

                        String cmldte = datechosser(jDateChooser1);

                        String pstv_clr;
                        if (jCheckBox9.isSelected()) {
                            pstv_clr = "Yes";
                        } else {
                            pstv_clr = "No";
                        }

                        String pstv_clr_pge = jTextField16.getText();

                        String bw;
                        if (jCheckBox7.isSelected()) {
                            bw = "Yes";
                        } else {
                            bw = "No";
                        }

                        String bw_pge = jTextField17.getText();
                        String img;
                        if (jCheckBox10.isSelected()) {
                            img = "Have";
                        } else {
                            img = "No";
                        }

                        String shade;
                        if (jCheckBox11.isSelected()) {
                            shade = "Have";
                        } else {
                            shade = "No";
                        }
                        /////////////////////////////////////
                        String psize = jTextField15.getText();
                        String pnfpge = jTextField14.getText();

                        int job_crd = 0;
                        ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card from job_card where idjob_card='" + jLabel29.getText() + "'");
                        if (rs.next()) {
                            job_crd = rs.getInt("idjob_card");
                        }

                        ConnectionSet1.getInstance().setResult("insert into typesetter_fil(`typesetter_fil`.`complete`, `typesetter_fil`.`cmpt_date`, `typesetter_fil`.`psitiv_clr`, `typesetter_fil`.`psitiv_clr_pge`, `typesetter_fil`.`psitiv_bw`, `typesetter_fil`.`psitiv_bw_pge`, `typesetter_fil`.`img`, `typesetter_fil`.`shades`, `typesetter_fil`.`job_card_idjob_card`) "
                                + "values('" + cmlwrk + "','" + cmldte + "','" + pstv_clr + "','" + pstv_clr_pge + "','" + bw + "','" + bw_pge + "','" + img + "','" + shade + "','" + job_crd + "')");

                        ConnectionSet1.getInstance().setResult("insert into production_description(pduct_sz,nm_pages,job_card_idjob_card) values('" + psize + "','" + pnfpge + "','" + job_crd + "')");
                        tableLoad();
                        jTextField16.setText("");
                        jTextField17.setText("");
                        jTextField15.setText("");
                        jTextField14.setText("");
                        jLabel29.setText("");
                        jLabel3.setText("");
                        jTextField5.setText("");
                        jTextField10.setText("");
                        jTextField9.setText("");
                        jTextField11.setText("");
                        jCheckBox8.setSelected(false);
                        jCheckBox9.setSelected(false);
                        jCheckBox7.setSelected(false);
                        jCheckBox10.setSelected(false);
                        jCheckBox11.setSelected(false);
                        jDateChooser1.setDate(null);

                    } catch (Exception ex) {
                        Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } catch (Exception ex) {
                Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField24KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField24KeyReleased
        try {
            // TODO add your handling code here:
            new tablemodel1().fillTable("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language from typesetter_fil t1 inner join job_card j1 on t1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor"
                    + " where complete='Yes' AND type_setter='" + jLabel4.getText() + "' AND (fname like('" + jTextField24.getText() + "%%" + "') or manuscript_name like('" + jTextField24.getText() + "%%%" + "') or isbn like('" + jTextField24.getText() + "%%%" + "'))", jTable3);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField24KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            //             TODO add your handling code here:
            //            go back to home
            String uname = jLabel4.getText();
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
            if (username.equals(uname) && typ.equals("User") && desig.equals("Typesetter")) {
                System.out.println("2");
                new Menu("Typesetter", "User", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("Admin") && desig.equals("IT")) {
                System.out.println("3");
                new Menu("IT", "Admin", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("User") && desig.equals("Assistant Publishing Manager")) {
                new Menu("Assistant Publishing Manager", "User", uname).setVisible(true);
                dispose();

            } else if (username.equals(uname) && typ.equals("Admin") && desig.equals("Publishing Manager")) {
                System.out.println("3");
                new Menu("Publishing Manager", "Admin", uname).setVisible(true);
                dispose();

            }

        } catch (Exception ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
//        clear all the data in feilds
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField15.setText("");
        jTextField14.setText("");
        jLabel29.setText("");
        jLabel3.setText("");
        jTextField5.setText("");
        jTextField10.setText("");
        jTextField9.setText("");
        jTextField11.setText("");
        jCheckBox8.setSelected(false);
        jCheckBox9.setSelected(false);
        jCheckBox7.setSelected(false);
        jCheckBox10.setSelected(false);
        jCheckBox11.setSelected(false);
        jDateChooser1.setDate(null);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Check the Formating is Completed", "check", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jTextField27KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField27KeyReleased
        try {
            // TODO add your handling code here:
            //        search the data
            new tablemodel1().fillTable("select idjob_card,resive_date,manuscript_name,fname,isbn,language,complte from formating_jobs f1 inner join proof_details p1 on f1.proof_details_idproof_details = p1.idproof_details inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where complte='Yes' AND type_setter='" + jLabel4.getText() + "' AND (b_title like('" + jTextField27.getText() + "%%%" + "') or job_card_idjob_card like('" + jTextField27.getText() + "%%" + "') or p_step like('" + jTextField27.getText() + "%%" + "'))", jTable7);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField27KeyReleased

    private void jTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseClicked
        try {
            // TODO add your handling code here:
            //        set value for the feilds
            DefaultTableModel dtm = (DefaultTableModel) jTable8.getModel();
            int i = jTable8.getSelectedRow();
            String jbid = dtm.getValueAt(i, 0).toString();

            ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card,agrmt_sign_date,manuscript_name,fname,isbn,language,complete,cmpt_date,psitiv_clr,psitiv_clr_pge,psitiv_bw,psitiv_bw_pge,img,shades,pduct_sz,nm_pages "
                    + "from typesetter_fil t1 inner join production_description p1 on t1.job_card_idjob_card = p1.job_card_idjob_card"
                    + " inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where complete='Yes'");

            if (rs.next()) {
                String jobid = rs.getString("idjob_card");
                jLabel29.setText(jobid);

                String dte = rs.getString("agrmt_sign_date");
                jLabel3.setText(dte);

                String titel = rs.getString("manuscript_name");
                jTextField5.setText(titel);

                String author = rs.getString("fname");
                jTextField10.setText(author);

                String isbn = rs.getString("isbn");
                jTextField9.setText(isbn);

                String langu = rs.getString("language");
                jTextField11.setText(langu);

                String compt = rs.getString("complete");
                if (compt.equals("Yes")) {
                    jCheckBox8.setSelected(true);
                } else {
                    jCheckBox8.setSelected(false);
                }

                String cmdate = rs.getString("cmpt_date");
                Date d = new Date(cmdate);
                d.getDate();
                jDateChooser1.setDate(d);

                String pst_clr = rs.getString("psitiv_clr");
                if (pst_clr.equals("Yes")) {
                    jCheckBox9.setSelected(true);
                } else {
                    jCheckBox9.setSelected(false);
                }

                String pst_pge = rs.getString("psitiv_clr_pge");
                jTextField16.setText(pst_pge);

                String pst_bw = rs.getString("psitiv_bw");
                if (pst_bw.equals("Yes")) {
                    jCheckBox7.setSelected(true);
                } else {
                    jCheckBox7.setSelected(false);
                }

                String pst_bwpag = rs.getString("psitiv_bw_pge");
                jTextField17.setText(pst_bwpag);

                String img = rs.getString("img");
                if (img.equals("Have")) {
                    jCheckBox10.setSelected(true);
                } else {
                    jCheckBox10.setSelected(false);
                }

                String shade = rs.getString("shades");
                if (shade.equals("Have")) {
                    jCheckBox11.setSelected(true);
                } else {
                    jCheckBox11.setSelected(false);
                }

                String psiz = rs.getString("pduct_sz");
                jTextField15.setText(psiz);

                String nopgs = rs.getString("nm_pages");
                jTextField14.setText(nopgs);

            }

        } catch (Exception ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTable8MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            //        update the typsetter details
            String cmlwrk;
            if (jCheckBox8.isSelected()) {
                cmlwrk = "Yes";
            } else {
                cmlwrk = "No";
            }

            String cmldte = datechosser(jDateChooser1);

            String pstv_clr;
            if (jCheckBox9.isSelected()) {
                pstv_clr = "Yes";
            } else {
                pstv_clr = "No";
            }

            String pstv_clr_pge = jTextField16.getText();

            String bw;
            if (jCheckBox7.isSelected()) {
                bw = "Yes";
            } else {
                bw = "No";
            }

            String bw_pge = jTextField17.getText();
            String img;
            if (jCheckBox10.isSelected()) {
                img = "Have";
            } else {
                img = "No";
            }

            String shade;
            if (jCheckBox11.isSelected()) {
                shade = "Have";
            } else {
                shade = "No";
            }
            /////////////////////////////////////
            String psize = jTextField15.getText();
            String pnfpge = jTextField14.getText();

            ConnectionSet1.getInstance().setResult("update typesetter_fil set complete='" + cmlwrk + "',cmpt_date='" + cmldte + "',psitiv_clr='" + pstv_clr + "',psitiv_clr_pge='" + pstv_clr_pge + "',psitiv_bw='" + bw + "',psitiv_bw_pge='" + bw_pge + "',img='" + img + "',shades='" + shade + "' where job_card_idjob_card='" + jLabel29.getText() + "'");

            ConnectionSet1.getInstance().setResult("update production_description set pduct_sz='" + psize + "',nm_pages='" + pnfpge + "' where job_card_idjob_card='" + jLabel29.getText() + "'");

            tableLoad();
            jTextField16.setText("");
            jTextField17.setText("");
            jTextField15.setText("");
            jTextField14.setText("");
            jLabel29.setText("");
            jLabel3.setText("");
            jTextField5.setText("");
            jTextField10.setText("");
            jTextField9.setText("");
            jTextField11.setText("");
            jCheckBox8.setSelected(false);
            jCheckBox9.setSelected(false);
            jCheckBox7.setSelected(false);
            jCheckBox10.setSelected(false);
            jCheckBox11.setSelected(false);
            jDateChooser1.setDate(null);

        } catch (Exception ex) {
            Logger.getLogger(typeSetterJobs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField14KeyTyped

    private void jTextField16KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField16KeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField16KeyTyped

    private void jTextField17KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField17KeyTyped

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
            java.util.logging.Logger.getLogger(typeSetterJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(typeSetterJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(typeSetterJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(typeSetterJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new typeSetterJobs().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextArea jTextArea3;
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
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
