/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksmart_app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author jaimoraes
 */

public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    
    //Username and password storage
    private String Username;
    private String Password;
    private Customer Login;
    
    //User info file
    private final String SEARCHFROM ="Users.txt";
    
    
    /**
     * initializes all components and sets the page to be visible, shows 'Password' as a prompt
     */
    public LoginPage() {
        initComponents();
        this.PasswordInput.setEchoChar((char)0);
        this.PasswordInput.setText("Password");
        this.UsernameInput.setText("Username");
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PasswordInput = new javax.swing.JPasswordField();
        UsernameInput = new javax.swing.JTextField();
        Logo = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        PasswordInput.setToolTipText("");
        PasswordInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordInputFocusGained(evt);
            }
        });
        PasswordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordInputActionPerformed(evt);
            }
        });

        UsernameInput.setText("Username / Email");
        UsernameInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UsernameInputFocusGained(evt);
            }
        });
        UsernameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameInputActionPerformed(evt);
            }
        });

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/booksmart_app/newpackage/Real_Logo.png"))); // NOI18N
        Logo.setText("jLabel1");

        jToggleButton1.setText("Enter");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jToggleButton1)))
                .addGap(291, 291, 291))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(UsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * gets the user input and tries to find a valid user if they have inputted text for both the username and password
     * @param evt the ActionEvent (in this case User Input in the form of a string)
     */
    private void PasswordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordInputActionPerformed
        this.Password=PasswordInput.getText();
        if(this.Username!=null&&this.Password!=null)
                returnUserInfo();
        
        System.out.println("Password");
    }//GEN-LAST:event_PasswordInputActionPerformed
    
    /**
     * gets the user input and tries to find a valid user if they have inputted text for both the username and password
     * @param evt the ActionEvent (in this case User Input in the form of a string)
     */
    private void UsernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameInputActionPerformed
        this.Username=UsernameInput.getText();
        if(this.Username!=null&&this.Password!=null)
                returnUserInfo();
        
        System.out.println("Username");
           
    }//GEN-LAST:event_UsernameInputActionPerformed

    /**
     * Clears the text field for the user when they click on PasswordInput
     * @param evt the FocusEvent that occurred
     */
    private void PasswordInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordInputFocusGained
        PasswordInput.setEchoChar('*');
        if(this.PasswordInput.getText().equals("Password"))
        PasswordInput.setText("");
    }//GEN-LAST:event_PasswordInputFocusGained

    /**
     * Clears the text field for the user when they click on UsernameInput
     * @param evt the FocusEvent that occurred
     */
    private void UsernameInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UsernameInputFocusGained
        if(this.PasswordInput.getText().equals("Username"))
        UsernameInput.setText("");
    }//GEN-LAST:event_UsernameInputFocusGained

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.Username=this.UsernameInput.getText();
        this.Password=this.PasswordInput.getText();
        if(this.Username!=null&&this.Password!=null)
                returnUserInfo();
        
        System.out.println("Pressed");
    }//GEN-LAST:event_jToggleButton1ActionPerformed
    
    /**
     * 
     */
    private void returnUserInfo(){
        try{
        File scanFrom= new File(this.SEARCHFROM);
        
        Scanner sc = new Scanner(scanFrom);
        
            while(sc.hasNextLine())
            {
                String[] data= sc.nextLine().split(",");
                if(data[0].equals(this.Username)){
                    if(data[4].equals(this.Password)){
                        this.Login.setUsername(data[0]);
                        this.Login.setFirstName(data[1]);
                        this.Login.setLastName(data[2]);
                        this.Login.setEmail(data[3]);
                        this.Login.setPassword(data[4]);
                        
                        
                    }
                    else{
                       this.Password=null;
                       this.PasswordInput.setEchoChar((char)0);
                       this.PasswordInput.setText("Incorrect Username/Password");
                    }
                }
            }
        }catch(FileNotFoundException e){
               System.out.println("ERROR: FileNotFound");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JPasswordField PasswordInput;
    private javax.swing.JTextField UsernameInput;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
