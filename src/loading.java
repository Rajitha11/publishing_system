
import com.org.DB.ConnectionSet1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class loading extends javax.swing.JFrame {

    /**
     * Creates new form loading
     */
    int i;
    Timer t;
    public static ConnectionSet1 Connect = ConnectionSet1.getInstance();

    public loading() {
        initComponents();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String title = "LOADING BOOKMEN SARASAVI PUBLISHING SYSTEM 1.0";
                String arr[] = title.split("");

                while (true) {
                    for (int i = 0; i < arr.length; i++) {
                        try {
                            setTitle(getTitle() + arr[i]);
                            Thread.sleep(130);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(loading.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    setTitle("");
                }

            }
        }).start();


        final String fill[] = {"BOOKMEN admin.exe", "BOOKMEN VideoREADME.html", "BOOKMEN VideoLICENSE.txt",
            "DISTRIBUTION.txt", "LEGALNOTICE.txt", "BOOKMEN Videouninstall.exe", "BOOKMEN VideoCREDITS.html",
            "BOOKMEN VideoAbsoluteLayout.java", "BOOKMEN Videoload.jpg", "BOOKMEN Videorssetup.hlp", "my-template.ini",
            "updater.exe", "updater.ini", "index.html", "BOOKMEN VideoSM.CHM", "BOOKMEN VideoREFBAR.ICO",
            "BOOKMEN VideoINTLBAND.HTM", "BOOKMEN VideoFeatherTexture.bmp", "Greenstone.bmp", "SoftM&A.log",
            "SoftM&A.exe", "README.html", "LICENSE.txt", "DISTRIBUTION.txt", "LEGALNOTICE.txt", "uninstall.exe",
            "CREDITS.html", "AbsoluteLayout.java", "load.jpg", "rssetup.hlp", "BOOKMEN Videomy-template.ini",
            "BOOKMEN Videoupdater.exe", "BOOKMEN Videoupdater.ini", "BOOKMEN Videoindex.html", "BOOKMEN VideoSM.CHM",
            "BOOKMEN VideoREFBAR.ICO", "BOOKMEN VideoINTLBAND.HTM", "BOOKMEN VideoFeatherTexture.bmp", "BOOKMEN VideoGreenstone.bmp",
            "SoftM&A.log", "BOOKMEN Video.exe", "README.html", "BOOKMEN VideoLICENSE.txt", "BOOKMEN VideoDISTRIBUTION.txt",
            "BOOKMEN VideoLEGALNOTICE.txt", "BOOKMEN Videouninstall.exe", "BOOKMEN VideoCREDITS.html",
            "BOOKMEN VideoAbsoluteLayout.java", "BOOKMEN Videoload.jpg", "BOOKMEN Videorssetup.hlp",
            "BOOKMEN Videomy-template.ini", "BOOKMEN Videoupdater.exe", "BOOKMEN Videoupdater.ini",
            "BOOKMEN Videoindex.html", "BOOKMEN VideoSM.CHM", "BOOKMEN VideoREFBAR.ICO",
            "BOOKMEN VideoINTLBAND.HTM", "BOOKMEN VideoFeatherTexture.bmp", "Greenstone.bmp",
            "SoftM&A.log", "SoftM&A.exe", "README.html", "LICENSE.txt", "DISTRIBUTION.txt",
            "LEGALNOTICE.txt", "BOOKMEN Videouninstall.exe", "BOOKMEN VideoCREDITS.html",
            "BOOKMEN VideoAbsoluteLayout.java", "load.jpg", "rssetup.hlp", "my-template.ini",
            "updater.exe", "updater.ini", "index.html", "SM.CHM", "REFBAR.ICO", "INTLBAND.HTM",
            "FeatherTexture.bmp", "Greenstone.bmp", "SoftM&A.log", "SoftM&A.exe", "README.html",
            "LICENSE.txt", "DISTRIBUTION.txt", "LEGALNOTICE.txt", "uninstall.exe", "CREDITS.html", "AbsoluteLayout.java",
            "load.jpg", "rssetup.hlp", "my-template.ini", "updater.exe", "updater.ini", "index.html", "SM.CHM", "REFBAR.ICO",
            "vUnicorn.cab", "BOOKMEN VideoUnicorn.cab", "BOOKMEN Developed By W.A Rajitha Madhuranga & Gayan Priyankara", "BOOKMEN Developed By W.A Rajitha Madhuranga & Gayan Priyankara",
            "BOOKMEN Developed By W.A Rajitha Madhuranga & Gayan Priyankara", "BOOKMEN Developed By W.A Rajitha Madhuranga & Gayan Priyankara", "BOOKMEN Developed By W.A Rajitha Madhuranga & Gayan Priyankara"};

        t = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                i++;
                jProgressBar1.setValue(i);
                jLabel2.setText(fill[i]);
                if (i == 100) {
                    try {

                        t.stop();
                        Thread.sleep(40);
                        new login_frm().setVisible(true);
                        dispose();

                    } catch (InterruptedException ex) {
                        Logger.getLogger(loading.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        t.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loading...");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jProgressBar1.setForeground(new java.awt.Color(128, 128, 128));
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 480, 7));

        jLabel2.setFont(new java.awt.Font("Vrinda", 1, 12)); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 410, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Developed By W.A Rajitha Madhuranga & Gayan Priyankara");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 480, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pub/img/Splash screen.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loading().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
