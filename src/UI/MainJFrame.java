/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.DB4OUtil.DB4OUtil;
import Business.ESystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import de.javasoft.synthetica.dark.SyntheticaDarkLookAndFeel;
import java.awt.CardLayout;
import java.text.ParseException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author gandh
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    
    private ESystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
    public MainJFrame() {
        initComponents();
        system = dB4OUtil.retrieveSystem();
        this.setSize(1680, 1050);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        upperContainer = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        txtPasswordField = new javax.swing.JPasswordField();
        enterpriseLabel = new javax.swing.JLabel();
        userProcessContainer = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        upperContainer.setBackground(new java.awt.Color(0, 0, 0));
        upperContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        upperContainer.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 104, -1));

        txtPassword.setUI(null);
        upperContainer.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 37, 3, 0));

        btnLogin.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        upperContainer.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 104, 20));

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EmailID:");
        upperContainer.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password:");
        upperContainer.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        btnLogout.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        upperContainer.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 120, 20));
        upperContainer.add(txtPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 104, -1));

        enterpriseLabel.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(255, 255, 255));
        enterpriseLabel.setText("FOOD MANAGEMENT SYSTEM");
        upperContainer.add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 350, 60));

        jSplitPane.setTopComponent(upperContainer);

        userProcessContainer.setBackground(new java.awt.Color(51, 0, 0));
        userProcessContainer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userProcessContainer.setLayout(new java.awt.CardLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/WhatsApp Image 2022-12-11 at 6.50.08 PM.jpeg"))); // NOI18N
        userProcessContainer.add(jLabel4, "card2");

        jSplitPane.setRightComponent(userProcessContainer);

        getContentPane().add(jSplitPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        
        String email = txtUsername.getText();
        char[] passcode = txtPasswordField.getPassword();
        
        if(email.equalsIgnoreCase("") || passcode.equals("") || (email.equalsIgnoreCase("") && passcode.equals(""))){
            
            JOptionPane.showMessageDialog(null, "Empty Field!", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get user name
        String ToEmail = txtUsername.getText();
        String FromEmail = "aedprojmanan@gmail.com";
        String FromPassword = "whghdojgodwntavq";
        String password = String.valueOf(txtPasswordField.getPassword());
        String emailContent =  " <h1>Welcome To Food Management System</h1> "
                + "<body>  Your have sucessfully logged In : <br>"
                + ToEmail +
                "<br> </body> <h2> Thank you for being a valuable member! </h2><h2>For any issues please contact us on: gandhi.manan@northeastern.edu";
        //Step1: Check in the system admin user account directory if you have the user
        UserAccount userAccount=system.getUserAccountDirectory().authenticateUser(ToEmail, password);

        Enterprise inEnterpriseLevel=null;
        Organization inOrganizationLevel=null;

        if(userAccount==null){
            //Step 2: Go inside each network and check each enterprise
            for(Network network:system.getNetworkList()){
                //Step 2.a: check against each enterprise
                for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                    userAccount=enterprise.getUserAccountDirectory().authenticateUser(ToEmail, password);
                    if(userAccount==null){
                        //Step 3:check against each organization for each enterprise
                        for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()){
                            userAccount=organization.getUserAccountDirectory().authenticateUser(ToEmail, password);
                            if(userAccount!=null){
                                inEnterpriseLevel=enterprise;
                                inOrganizationLevel=organization;
                                break;
                            }
                        }

                    }
                    else{
                        inEnterpriseLevel=enterprise;
                        break;
                    }
                    if(inOrganizationLevel!=null){
                        break;
                    }
                }
                if(inEnterpriseLevel!=null){
                    break;
                }
            }
        }

        if(userAccount==null){
            JOptionPane.showMessageDialog(null, "Invalid credentials, Please try Again!");
            return;
        }
        else{
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
            userProcessContainer.add("workArea",userAccount.getRole().createWorkArea(userProcessContainer, userAccount, inOrganizationLevel, inEnterpriseLevel, system));
            layout.next(userProcessContainer);
        }
        
        /***************************** Mail Code Started *******************************/
        Properties properties1 = new Properties();
        properties1.put("mail.smtp.auth", "true");
        properties1.put("mail.smtp.starttls.enable", "true");
        properties1.put("mail.smtp.host", "smtp.gmail.com");
        properties1.put("mail.smtp.port", "587");
        properties1.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getDefaultInstance(properties1, new javax.mail.Authenticator(){
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(FromEmail,FromPassword);
        }
        });

        try {
            MimeMessage messages = new MimeMessage(session);
            messages.setFrom(new InternetAddress(FromEmail));
            messages.addRecipient(Message.RecipientType.TO,new InternetAddress(ToEmail));
            messages.setSubject("Login Alert: Food Management System");
            messages.setContent(emailContent,"text/html");
            Transport.send(messages);
           // }
        } catch (Exception e) {
//System.out.print("Test1");
        }  
        /***************************** End of Mail *******************************/


        btnLogin.setEnabled(false);
        btnLogout.setEnabled(true);
        txtUsername.setEnabled(false);
        txtPassword.setEnabled(false);

    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        
        btnLogout.setEnabled(false);
        txtUsername.setEnabled(true);
        txtPasswordField.setEnabled(true);
        btnLogin.setEnabled(true);

        txtUsername.setText("");
        txtPasswordField.setText("");

        userProcessContainer.removeAll();
        JPanel blankJP = new JPanel();
        userProcessContainer.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) userProcessContainer.getLayout();
        crdLyt.next(userProcessContainer);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ParseException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JPasswordField txtPasswordField;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPanel upperContainer;
    private javax.swing.JPanel userProcessContainer;
    // End of variables declaration//GEN-END:variables
}
