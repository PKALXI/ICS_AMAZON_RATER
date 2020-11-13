/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booksmartmav;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Displays the book image,title,author, and rating and lets the use rate the book
 * @author Andreja
 */
public class BookPage extends javax.swing.JFrame {

    /**
     * Creates new form bookPage
     */
    private String bookTitle;//the book title
    private String bookAuthor;//the book author
    private int lineNumber;//the line number
    private Customer customer;//Customer object
    
    /**
     * Constructor
     * @param bookTitleInput takes in the book title
     * @param authorTitle takes in the author title
     * @param lineNumber takes in the line number the book is on
     * @param customer takes in the customer object
     */ 
    public BookPage(String bookTitleInput, String authorTitle, int lineNumberInput, Customer customer) throws IOException {
        initComponents();
        
        this.customer = customer;
        bookTitle = bookTitleInput;
        bookAuthor = authorTitle;
        lineNumber = lineNumberInput;
        
        jLabel1.setIcon(new javax.swing.ImageIcon("images\\" + lineNumberInput +".jpg"));
        jLabel2.setText(bookTitleInput);
        jLabel3.setText("By: " + authorTitle);
        jLabel4.setIcon(new javax.swing.ImageIcon("stars\\" + getPopularRating(getIntArr())+ ".png"));
    }//End of constructer
    
    /**
     * Gets all the ratings the book has
     * @return the arr full of ratings
     */
    public int [] getIntArr()throws IOException{
        File myFile = new File("stars\\ratings.txt");
        Scanner inputFile = new Scanner(myFile);
        
        //Finds the file number in the ratings.txt the corresponds to the book file number
        int newLineNumber = 0;
        String temp = null;
        while(inputFile.hasNextLine()){
            temp = inputFile.nextLine();
            newLineNumber += 1;
            
            if(newLineNumber == lineNumber){
                break;
            }
        }
        
        //Stores all the ratings the book has in an array
        int intArr[] = null;
        if(!temp.equals("")){
            String arr [] = temp.split(",");
            intArr = new int [arr.length];
            
            for(int i = 0; i < intArr.length; i++){
                intArr[i] = Integer.parseInt(arr[i]);
            }
        }
        //If it has no ratings, arr is 0
        else{
            intArr = new int [1];
            intArr[0] = 0;
        }
        
        return intArr;
        
    }//End of intArr
    
    /**
     * Takes in the int array with the ratings and returns an int of the most common rating
     * @param int [] a the int array with all the ratings
     * return the most common rating
     */
    public int getPopularRating(int [] a){
        int count = 1, tempCount;
        int popular = a[0];
        int temp = 0;
        
        //Sequential search finds the most common rating
        for(int i = 0; i < (a.length - 1); i++){
            temp = a[i];
            tempCount = 0;
            for(int j = 1; j < a.length; j++){
                if(temp == a[j]){
                    tempCount++;
                }
            }
            if(tempCount > count){
                popular = temp;
                count = tempCount;
            }
        }
        return popular;
    }//End of getPopularRating
    
    /**
     * Adds the user rating to the books ratings
     * @param line the line number the book is on
     * @param value the rating the user gave
     */
    private void appendToRatings(int line, String value){
        File file = new File("stars\\ratings.txt");
        Scanner in = null;

        //Stores all the lines in ratinggs.txt
        ArrayList <String> lines = new ArrayList<>();

        try{
            in = new Scanner(file);
        }catch(Exception e){
            e.printStackTrace();
        }

        while(in.hasNextLine()){
            lines.add(in.nextLine());
        }

        //Adds the user rating to the line number corresponding to the book
        if(lines.get(line-1).equals("")){
            lines.set(line-1, value);
        }else{
            lines.set(line-1, lines.get(line-1) + "," + value);
        }

        //Rewrites the entire ratings file with the new ratings added one
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("stars\\ratings.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for(String s : lines){
            pw.write(s + "\n");
        }
        

        pw.close();
        
        try {
            //Sets the icon to the average amount of stars
            jLabel4.setIcon(new javax.swing.ImageIcon("stars\\" + getPopularRating(getIntArr())+ ".png"));
        } catch (IOException ex) {
            Logger.getLogger(BookPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end of method appendToRatings
    
    public boolean getRatedBooks(String bookName){
        final String filePath = "stars/" + this.customer.getUsername() + "-rated.txt";

        File file = new File(filePath);

        if(!file.exists()){
            try {
                PrintWriter pw = new PrintWriter(filePath);
                pw.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BookPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
        Scanner reader = null;
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BookPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(reader.hasNextLine()){
            String temp = reader.nextLine();
            String arr [] = temp.split(",");
            if(arr[0].equalsIgnoreCase(bookName)){
                return true;
            }
        }
        
        return false;
    }

    public void addRatedBook(String bookName){
        final String filePath = "stars/" +this.customer.getUsername() + "-rated.txt";
        FileWriter fw = null;
        try {
            fw = new FileWriter(filePath,true);
        } catch (IOException ex) {
            Logger.getLogger(BookPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            fw.write(bookName + "," + jTextField1.getText() + "," + lineNumber + "\n");
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(BookPage.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        logo = new javax.swing.JMenu();
        recommended = new javax.swing.JMenu();
        random = new javax.swing.JMenu();
        mainMenu = new javax.swing.JMenu();
        booksYouveRated = new javax.swing.JMenu();
        addBooks = new javax.swing.JMenu();
        clubs = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("images\\1.jpg")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("The Philosopher's Stone");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("By: J.K. Rowling");

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon("stars\\no_Stars.png")); // NOI18N
        jLabel4.setText("jLabel4");

        jTextField1.setText("1-5");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt){
                jTextField1InputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt){
                jTextField1InputFocusLost(evt);
            }
        });

        jButton2.setText("Rate the Book");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon("logos/logo_Menu.png")); // NOI18N
        jMenuBar1.add(logo);

        recommended.setText("Recommended");
        recommended.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        recommended.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recommendedMouseClicked(evt);
            }
        });
        jMenuBar1.add(recommended);

        random.setText("Random");
        random.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        random.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                randomMouseClicked(evt);
            }
        });
        jMenuBar1.add(random);

        mainMenu.setText("Main Menu");
        mainMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(mainMenu);

        booksYouveRated.setText("Books You've Rated");
        booksYouveRated.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        booksYouveRated.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksYouveRatedMouseClicked(evt);
            }
        });
        jMenuBar1.add(booksYouveRated);

        addBooks.setText("Add Books");
        addBooks.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBooksMouseClicked(evt);
            }
        });
        jMenuBar1.add(addBooks);

        clubs.setText("Clubs");
        clubs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        clubs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clubsMouseClicked(evt);
            }
        });
        jMenuBar1.add(clubs);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1))))
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recommendedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recommendedMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_recommendedMouseClicked

    private void randomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_randomMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_randomMouseClicked

    private void mainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuMouseClicked
        try {
            new mainMenu(customer,false).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(BookPage.class.getName()).log(Level.SEVERE, null, ex);
        }       
        this.setVisible(false);
    }//GEN-LAST:event_mainMenuMouseClicked

    private void booksYouveRatedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksYouveRatedMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_booksYouveRatedMouseClicked

    private void addBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBooksMouseClicked
      
    }//GEN-LAST:event_addBooksMouseClicked

    private void clubsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clubsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_clubsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

            new BrowseMenu(customer).setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
    /**
     * The focus lost action event sets the text of the text field to '1-5" if it is empty
     * @param evt The focus lost action event
     */
    private void jTextField1InputFocusLost(java.awt.event.FocusEvent evt){//GEN-FIRST:event_bookGenreInputFocusLost
        if (jTextField1.getText().equals("")) {
            jTextField1.setText("1-5");
        }
    }//GEN-LAST:event_bookGenreInputFocusLost
          
    /**
     * The focus gained action event sets the text of the text field to blank if it says '1-5'
     * @param evt The focus lost action event
     */
    private void jTextField1InputFocusGained(java.awt.event.FocusEvent evt){//GEN-FIRST:event_bookGenreInputFocusGained
        if (jTextField1.getText().equals("1-5")) {
            jTextField1.setText("");
        }
    }//GEN-LAST:event_bookGenreInputFocusGained

    /**
     * The button pressed action event takes in the rating the user inputted in the text field
     * @param evt The mouse action event
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //If the rating is a number
        if(jTextField1.getText().matches("[0-9]+")){
            //If the rating is equal to or less than 5
            if(Integer.parseInt(jTextField1.getText()) <= 5){
                //If you haven't already rated the book
                if(!getRatedBooks(bookTitle)){
                    //Add the rating to the databse
                    appendToRatings(lineNumber,jTextField1.getText());
                    addRatedBook(bookTitle);
                //Else display error
                }//End of if statement
                else{
                    JOptionPane.showMessageDialog(null, "You have already rated this book.","ERROR",JOptionPane.ERROR_MESSAGE);
                }//end of else
            }//End of id statement
            //Else display error
            else{
                JOptionPane.showMessageDialog(null, "Wrong Input. Please Input Again","ERROR",JOptionPane.ERROR_MESSAGE);
                jTextField1.setText("1-5");
            }//End of Else
        }//End of if statement
        //Else display error
        else{
            JOptionPane.showMessageDialog(null, "Wrong Input. Please Input Again","ERROR",JOptionPane.ERROR_MESSAGE);
            jTextField1.setText("1-5");
        }//End of else
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(BookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new BookPage(bookTitle,bookAuthor).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu addBooks;
    private javax.swing.JMenu booksYouveRated;
    private javax.swing.JMenu clubs;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenu logo;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JMenu random;
    private javax.swing.JMenu recommended;
    // End of variables declaration//GEN-END:variables
    
}//End of class BookPage
