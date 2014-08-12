
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
public class Disigner extends javax.swing.JFrame {

    /**
     * Creates new form Disigner
     */
    SimpleDateFormat d1, d2;
    Timer t;

    public Disigner() {
        initComponents();

        dateMethod();
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

            }
        });
        t.start();
    }

    void tableLoad() {
        try {
            new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn,language,send_dte,disigner_deadln,recomd_price from disigner_jobs d1 inner join grafic_jobs g1 on d1.grafic_jobs_idgrafic_dep = g1.idgrafic_dep inner join costing c1 on g1.job_card_idjob_card = c1.job_card_idjob_card inner join production_description p1 on "
                    + "c1.job_card_idjob_card = p1.job_card_idjob_card inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where job_doned='No'", jTable1);

            new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn,language,send_dte,disigner_deadln,recomd_price from disigner_jobs d1 inner join grafic_jobs g1 on d1.grafic_jobs_idgrafic_dep = g1.idgrafic_dep inner join costing c1 on g1.job_card_idjob_card = c1.job_card_idjob_card inner join production_description p1 on "
                    + "c1.job_card_idjob_card = p1.job_card_idjob_card inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where job_doned='Yes'", jTable2);


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField12 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Designer");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Designer Jobs");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 180, 58));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText("Date ");
        getContentPane().add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 210, 52));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 110, 30));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Jobs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Title", "Author", "ISBN", "Language", "Date", "Deadline", "Retail Price"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1040, 190));

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });
        jPanel8.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 295, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Search");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 55, -1));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1100, 270));

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
        jPanel10.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 90, 20));

        jTextField9.setEditable(false);
        jPanel10.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 250, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("ISBN");
        jPanel10.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        jTextField10.setEditable(false);
        jPanel10.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 290, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Authour/Translator Name");
        jPanel10.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Language");
        jPanel10.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jTextField11.setEditable(false);
        jPanel10.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 290, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Date ");
        jPanel10.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, -1, -1));
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 140, 30));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setText("Retail Price");
        jPanel10.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jTextField21.setEditable(false);
        jPanel10.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 170, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("Deadline");
        jPanel10.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, -1, -1));
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 140, 30));
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 70, 30));

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 1050, 170));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Save");
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 810, 108, 45));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Update");
        jButton5.setBorder(null);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 810, 108, 45));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Delete");
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 810, 108, 45));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cover Disigner", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCheckBox1.setText("* Completed The Job");
        jPanel4.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 610, 290, 90));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Completed Jobs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Title", "Author", "ISBN", "Language", "Date", "Deadline", "Retail Price"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel9.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 620, 190));

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
        });
        jPanel9.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 20, 250, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Search");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 55, -1));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 680, 270));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 750, 80, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            // TODO add your handling code here:
            //        set values from the feilds
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            int i = jTable1.getSelectedRow();
            String jbid = dtm.getValueAt(i, 0).toString();

            ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card,manuscript_name,fname,isbn,language,send_dte,disigner_deadln,recomd_price,idgrafic_dep from disigner_jobs d1 inner join grafic_jobs g1 on d1.grafic_jobs_idgrafic_dep = g1.idgrafic_dep inner join costing c1 on g1.job_card_idjob_card = c1.job_card_idjob_card inner join production_description p1 on "
                    + "c1.job_card_idjob_card = p1.job_card_idjob_card inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where job_doned='No' AND idjob_card='" + jbid + "'");

            if (rs.next()) {
                String jbid2 = rs.getString("idjob_card");
                jLabel29.setText(jbid2);

                String book = rs.getString("manuscript_name");
                jTextField5.setText(book);

                String author = rs.getString("fname");
                jTextField10.setText(author);

                String isbn = rs.getString("isbn");
                jTextField9.setText(isbn);

                String langu = rs.getString("language");
                jTextField11.setText(langu);

                String sntdt = rs.getString("send_dte");
                jLabel3.setText(sntdt);

                String deadln = rs.getString("disigner_deadln");
                jLabel4.setText(deadln);

                String retailpz = rs.getString("recomd_price");
                jTextField21.setText(retailpz);

                String gid = rs.getString("idgrafic_dep");
                jLabel1.setText(gid);
            }
            //        String jbid = dtm.getValueAt(i, 0).toString();
            //        jLabel29.setText(jbid);
            //        
            //        String book = dtm.getValueAt(i, 1).toString();
            //        jTextField5.setText(book);
            //        
            //        String author = dtm.getValueAt(i, 2).toString();
            //        jTextField10.setText(author);
            //        
            //        String isbn = dtm.getValueAt(i, 3).toString();
            //        jTextField9.setText(isbn);
            //        
            //        String langu = dtm.getValueAt(i, 4).toString();
            //        jTextField11.setText(langu);
            //        
            //        String sntdt = dtm.getValueAt(i, 5).toString();
            //        jLabel3.setText(sntdt);
            //        
            //        String deadln = dtm.getValueAt(i, 6).toString();
            //        jLabel4.setText(deadln);
            //        
            //        jTextField21.setText(retailpz);
            //        jTextField21.setText(retailpz);
        } catch (Exception ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            //save the disiner job complete
            String disiFinish;
            if (jCheckBox1.isSelected()) {
                disiFinish = "Yes";
            } else {
                disiFinish = "No";
            }

            ConnectionSet1.getInstance().setResult("update disigner_jobs set job_doned='" + disiFinish + "',date_job='" + jLabel15.getText() + "' where grafic_jobs_idgrafic_dep='" + jLabel1.getText() + "'");

            jLabel29.setText("");
            jTextField5.setText("");
            jTextField10.setText("");
            jTextField9.setText("");
            jTextField11.setText("");
            jLabel3.setText("");
            jLabel4.setText("");
            jTextField21.setText("");
            jLabel1.setText("");
            jCheckBox1.setSelected(false);
            tableLoad();

        } catch (Exception ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //clear all the data
        jLabel29.setText("");
        jTextField5.setText("");
        jTextField10.setText("");
        jTextField9.setText("");
        jTextField11.setText("");
        jLabel3.setText("");
        jLabel4.setText("");
        jTextField21.setText("");
        jLabel1.setText("");
        jCheckBox1.setSelected(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try {
            // TODO add your handling code here:
            // set data for the update
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
                int i = jTable2.getSelectedRow();
                String jbid = dtm.getValueAt(i, 0).toString();

                ResultSet rs = ConnectionSet1.getInstance().getResult("select idjob_card,manuscript_name,fname,isbn,language,send_dte,disigner_deadln,recomd_price,idgrafic_dep,job_doned from disigner_jobs d1 inner join grafic_jobs g1 on d1.grafic_jobs_idgrafic_dep = g1.idgrafic_dep inner join costing c1 on g1.job_card_idjob_card = c1.job_card_idjob_card inner join production_description p1 on "
                        + "c1.job_card_idjob_card = p1.job_card_idjob_card inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where job_doned='Yes' AND idjob_card='" + jbid + "'");

                if (rs.next()) {
                    String jbid2 = rs.getString("idjob_card");
                    jLabel29.setText(jbid2);

                    String book = rs.getString("manuscript_name");
                    jTextField5.setText(book);

                    String author = rs.getString("fname");
                    jTextField10.setText(author);

                    String isbn = rs.getString("isbn");
                    jTextField9.setText(isbn);

                    String langu = rs.getString("language");
                    jTextField11.setText(langu);

                    String sntdt = rs.getString("send_dte");
                    jLabel3.setText(sntdt);

                    String deadln = rs.getString("disigner_deadln");
                    jLabel4.setText(deadln);

                    String retailpz = rs.getString("recomd_price");
                    jTextField21.setText(retailpz);

                    String gid = rs.getString("idgrafic_dep");
                    jLabel1.setText(gid);
                    
                    String jobOk = rs.getString("job_doned");
                    if(jobOk.equals("Yes")){
                        jCheckBox1.setSelected(true);
                    }
                    
                }
        } catch (Exception ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            //update the table
            String disiFinish;
                if (jCheckBox1.isSelected()) {
                    disiFinish = "Yes";
                } else {
                    disiFinish = "No";
                }

                ConnectionSet1.getInstance().setResult("update disigner_jobs set job_doned='" + disiFinish + "',date_job='" + jLabel15.getText() + "' where grafic_jobs_idgrafic_dep='" + jLabel1.getText() + "'");

                jLabel29.setText("");
                jTextField5.setText("");
                jTextField10.setText("");
                jTextField9.setText("");
                jTextField11.setText("");
                jLabel3.setText("");
                jLabel4.setText("");
                jTextField21.setText("");
                jLabel1.setText("");
                jCheckBox1.setSelected(false);
                tableLoad();
        } catch (Exception ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        try {
            // TODO add your handling code here:
            // serch the new jobs
            new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn,language,send_dte,disigner_deadln,recomd_price from disigner_jobs d1 inner join grafic_jobs g1 on d1.grafic_jobs_idgrafic_dep = g1.idgrafic_dep inner join costing c1 on g1.job_card_idjob_card = c1.job_card_idjob_card inner join production_description p1 on "
                        + "c1.job_card_idjob_card = p1.job_card_idjob_card inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where job_doned='No' AND (fname like('" + jTextField8.getText() + "%%" + "') or manuscript_name like('" + jTextField8.getText() + "%%%" + "') or idjob_card like('" + jTextField8.getText() + "%%" + "'))", jTable1);
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        try {
            // TODO add your handling code here:
            //serch the complete
            new tablemodel1().fillTable("select idjob_card,manuscript_name,fname,isbn,language,send_dte,disigner_deadln,recomd_price from disigner_jobs d1 inner join grafic_jobs g1 on d1.grafic_jobs_idgrafic_dep = g1.idgrafic_dep inner join costing c1 on g1.job_card_idjob_card = c1.job_card_idjob_card inner join production_description p1 on "
                        + "c1.job_card_idjob_card = p1.job_card_idjob_card inner join job_card j1 on p1.job_card_idjob_card = j1.idjob_card inner join reseving_manuscript r1 on j1.reseving_manuscript_idrm = r1.idrm inner join author a1 on r1.author_idauthor = a1.idauthor where job_doned='Yes' AND (fname like('" + jTextField12.getText() + "%%" + "') or manuscript_name like('" + jTextField12.getText() + "%%%" + "') or idjob_card like('" + jTextField12.getText() + "%%" + "'))", jTable2);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Disigner.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField12KeyReleased

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
            java.util.logging.Logger.getLogger(Disigner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Disigner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Disigner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Disigner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Disigner().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
