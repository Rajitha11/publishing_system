
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
import javax.swing.table.DefaultTableModel;

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
///////////////////////////////////////////////////
    void tableLoad(){
        try {
            new tablemodel1().fillTable("select idrm,fname,contact_no,address,email,manuscript_name,catergory,ms_type from reseving_manuscript r1 inner join author t2 on r1.author_idauthor = t2.idauthor", jTable1);
            new tablemodel1().fillTable("Select manuscript_name,catergory,sub_catergory,language,qulification,ms_type,media_type from reseving_manuscript", jTable3);
            new tablemodel1().fillTable("Select fname,lname,contact_no,address,email from author", jTable2);
            
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
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        mscript_serch = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        aname = new javax.swing.JTextField();
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        eemail = new javax.swing.JTextField();
        efn = new javax.swing.JTextField();
        eln = new javax.swing.JTextField();
        econtct = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        eaddress = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        ecatag = new javax.swing.JComboBox();
        esub_catag = new javax.swing.JComboBox();
        eusb = new javax.swing.JCheckBox();
        eown = new javax.swing.JCheckBox();
        etrans = new javax.swing.JCheckBox();
        ehard = new javax.swing.JCheckBox();
        ecd = new javax.swing.JCheckBox();
        emnu_name = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Receving The Manuscript");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 308, 58));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Date ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 210, 52));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 110, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recive No", "Authour Name", "Contact No", "Address", "Email", "Script Name", "Catergory", "Script Type"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 1110, 160));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Search");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, 55, -1));

        mscript_serch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mscript_serchKeyReleased(evt);
            }
        });
        jPanel4.add(mscript_serch, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 295, -1));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCheckBox1.setText("* New Author");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel4.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("* Author Name");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, -1, -1));

        aname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                anameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anameKeyReleased(evt);
            }
        });
        jPanel4.add(aname, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 350, -1));

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
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, -1));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 1080, 190));

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

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 1090, 160));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 810, 108, 45));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Clear");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 810, 108, 45));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 50));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 380, 50));

        jTabbedPane1.addTab("Reserving Manuscript", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Manuscripts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "fname", "lname", "Contact No", "Addres", "Email"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        jPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1130, 210));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1150, 270));

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });
        jPanel5.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 76, 295, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Search");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 76, 55, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setText("Author Details");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 300, 58));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Date ");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 210, 52));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 110, 30));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Author Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("* Last Name");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("* Contact Number");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 62, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("* Email");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 93, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("* Current Address");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 62, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("* Author First Name");
        jPanel8.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 31, -1, -1));
        jPanel8.add(eemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 240, -1));
        jPanel8.add(efn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 240, -1));
        jPanel8.add(eln, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 240, -1));
        jPanel8.add(econtct, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 240, -1));

        eaddress.setColumns(20);
        eaddress.setRows(5);
        jScrollPane6.setViewportView(eaddress);

        jPanel8.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 360, -1));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 1090, 180));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Update");
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 690, 108, 45));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 690, 108, 45));

        jTabbedPane1.addTab("Author Details", jPanel5);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Manuscripts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Manuscript Name", "Catergory", "Sub Catergory", "Language", "Qulification", "Script Type", "Media Type"
            }
        ));
        jScrollPane5.setViewportView(jTable3);

        jPanel9.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1130, 200));

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1150, 240));
        jPanel6.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 76, 295, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel26.setText("Reserving Manuscript Details");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 380, 58));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Search");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 76, 55, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Date ");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 210, 52));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 110, 30));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Manuscript Details"));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("* Manuscript Type");
        jPanel10.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("* Media Of The Manuscript");
        jPanel10.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("* Qulifications ");
        jPanel10.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 120, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setText("* Sub Catergory");
        jPanel10.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("* Subject (Catergory)");
        jPanel10.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("* Language ");
        jPanel10.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 120, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText("* Name Of The Manuscript");
        jPanel10.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("* Received No ");
        jPanel10.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        jLabel44.setText("jLabel3");
        jPanel10.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, -1));
        jPanel10.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 250, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel10.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 190, -1));

        ecatag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel10.add(ecatag, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 190, -1));

        esub_catag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel10.add(esub_catag, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 190, -1));

        buttonGroup4.add(eusb);
        eusb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eusb.setText("USB");
        jPanel10.add(eusb, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 140, -1, -1));

        buttonGroup3.add(eown);
        eown.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eown.setText("Own");
        jPanel10.add(eown, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        buttonGroup3.add(etrans);
        etrans.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etrans.setText("Translation");
        jPanel10.add(etrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        buttonGroup4.add(ehard);
        ehard.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ehard.setText("Hard Copy");
        jPanel10.add(ehard, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, -1, -1));

        buttonGroup4.add(ecd);
        ecd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ecd.setText("CD/DVD");
        jPanel10.add(ecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, -1, -1));
        jPanel10.add(emnu_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 250, -1));

        jPanel6.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 1080, 190));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Update");
        jButton5.setBorder(null);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 700, 108, 45));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Delete");
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 700, 108, 45));

        jTabbedPane1.addTab("Reserving Manuscript Details", jPanel6);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 900));

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

    private void mscript_serchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mscript_serchKeyReleased
        try {
            // TODO add your handling code here:
            // manuscript Search
            tablemodel1.fillTable("select idrm,fname,contact_no,address,email,manuscript_name,catergory,ms_type from reseving_manuscript r1 inner join author t2 on r1.author_idauthor = t2.idauthor where fname like('" + mscript_serch.getText() + "%%" + "') or manuscript_name like('" + mscript_serch.getText() + "%%%" + "')", jTable1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(resivinManuScript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(resivinManuScript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(resivinManuScript.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_mscript_serchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        // set data select the table row
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField5KeyReleased

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
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox catag;
    private javax.swing.JCheckBox cd;
    private javax.swing.JTextField contct;
    private javax.swing.JTextArea eaddress;
    private javax.swing.JComboBox ecatag;
    private javax.swing.JCheckBox ecd;
    private javax.swing.JTextField econtct;
    private javax.swing.JTextField eemail;
    private javax.swing.JTextField efn;
    private javax.swing.JCheckBox ehard;
    private javax.swing.JTextField eln;
    private javax.swing.JTextField email;
    private javax.swing.JTextField emnu_name;
    private javax.swing.JCheckBox eown;
    private javax.swing.JComboBox esub_catag;
    private javax.swing.JCheckBox etrans;
    private javax.swing.JCheckBox eusb;
    private javax.swing.JTextField fname;
    private javax.swing.JCheckBox hardc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
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
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JComboBox langu;
    private javax.swing.JTextField ln;
    private javax.swing.JTextField mscript_serch;
    private javax.swing.JTextField nme_manuscript;
    private javax.swing.JCheckBox own;
    private javax.swing.JTextField qulifi;
    private javax.swing.JComboBox sub_catag;
    private javax.swing.JCheckBox trans;
    private javax.swing.JCheckBox usb;
    // End of variables declaration//GEN-END:variables
}
