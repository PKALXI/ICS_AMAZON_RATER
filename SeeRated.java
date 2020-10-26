import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeeRated extends javax.swing.JFrame {
    private Customer customer;

    private String bookTitle;
    private String bookAuthor;
    int nextCount = 1;
    String line[] = null;
    
    File bookStuff = new File("books.txt");
    Scanner bookInfo = null;
   
    
    /**
     * Creates new form SeeRated
     */
    public SeeRated(Customer customer) {
        this.customer = customer;

        try{
           bookInfo = new Scanner(bookStuff);
        }catch(Exception e){
            e.printStackTrace();
        }

        initComponents();
        bookCover.setIcon(new javax.swing.ImageIcon("/images/" + nextCount + ".jpg"));

        starRating.setVisible(false);
        
        prevButton.setVisible(false);
        
        line = bookInfo.nextLine().split(",");

        bookTitle = line[0];
        bookAuthor = line[1];
        jLabel3.setText("Title: " + bookTitle);
        jLabel4.setText("Author: " + bookAuthor);
    }
    
    public void readReset() {
        File bookStuff = new File("books.txt");
        
        try{
            bookInfo = new Scanner(bookStuff); 
        }catch(Exception e){
            e.printStackTrace();
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

        jLabel5 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        starRating = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bookCover = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuLogo = new javax.swing.JMenu();
        menuRecommended = new javax.swing.JMenu();
        menuRandom = new javax.swing.JMenu();
        menuBrowse = new javax.swing.JMenu();
        menuRated = new javax.swing.JMenu();
        menuAdd = new javax.swing.JMenu();
        menuClubs = new javax.swing.JMenu();

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Author:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nextButton.setText("Next Book");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        prevButton.setText("Previous Book");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        starRating.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        starRating.setForeground(new java.awt.Color(67, 55, 53));
        starRating.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        starRating.setText("Stars");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(67, 55, 53));
        jLabel2.setText("Books You've Rated");

        bookCover.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("logo_Menu.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(bookCover, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(bookCover, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        menuLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("logo_Menu.png"))); // NOI18N
        menuLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogoMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuLogo);

        menuRecommended.setText("Recommended");
        menuRecommended.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuRecommended.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuRecommendedMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuRecommended);

        menuRandom.setText("Random");
        menuRandom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuRandom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuRandomMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuRandom);

        menuBrowse.setText("Browse");
        menuBrowse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuBrowse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBrowseMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuBrowse);

        menuRated.setText("Main Menu");
        menuRated.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuRated.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuRatedMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuRated);

        menuAdd.setText("Add Books");
        menuAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAddMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAdd);

        menuClubs.setText("Clubs");
        menuClubs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(menuClubs);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(prevButton)
                .addGap(93, 93, 93)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(starRating, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel2)))
                .addContainerGap(163, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(starRating, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(prevButton))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        
        if (bookInfo.hasNextLine()) { 
            nextCount++;
            
            if (nextCount > 1) prevButton.setVisible(true);
            else prevButton.setVisible(false);
            
            line = bookInfo.nextLine().split(",");
            
            if (!bookInfo.hasNextLine()) nextButton.setVisible(false);

            System.out.println(line[0]);
            bookTitle = line[0];
            bookAuthor = line[1];
            jLabel3.setText("Title: " + bookTitle);
            jLabel4.setText("Author: " + bookAuthor);
            bookCover.setIcon(new javax.swing.ImageIcon("images/" + nextCount + ".jpg"));
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void menuLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoMouseClicked
    }//GEN-LAST:event_menuLogoMouseClicked

    private void menuRecommendedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuRecommendedMouseClicked
        new Recommend(this.customer).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuRecommendedMouseClicked

    private void menuRandomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuRandomMouseClicked
        new RandomBook(customer).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuRandomMouseClicked

    private void menuBrowseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBrowseMouseClicked
        new BrowseMenu(customer).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuBrowseMouseClicked

    private void menuRatedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuRatedMouseClicked
        try {
            new mainMenu(this.customer).setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(addBooks.class.getName()).log(Level.SEVERE, null, e);
        }
        this.setVisible(false);
    }//GEN-LAST:event_menuRatedMouseClicked

    private void menuAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAddMouseClicked
        try {
            new addBooks(this.customer).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(mainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_menuAddMouseClicked

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        try {
            readReset();
        } catch (Exception ex) {
            Logger.getLogger(SeeRated.class.getName()).log(Level.SEVERE, null, ex);
        }
        //count: counts what line we're on in text file
        int count = 1;
        String[] line = null;
        while (bookInfo.hasNextLine()) {
            line = bookInfo.nextLine().split(",");
            if (count == nextCount - 1) {
                break;
            }
            else {
                count++;
            }
        }
        bookTitle = line[0];
        bookAuthor = line[1];
        jLabel3.setText("Title: " + bookTitle);
        jLabel4.setText("Author: " + bookAuthor);  
        nextButton.setVisible(true);
        nextCount--;
        if (nextCount > 1) prevButton.setVisible(true);
        else prevButton.setVisible(false);
        bookCover.setIcon(new javax.swing.ImageIcon("images/" + nextCount + ".jpg"));        
    }//GEN-LAST:event_prevButtonActionPerformed

    /**
     * @param args the command line arguments
    //  */
    // public static void main(String args[]) {
    //     /* Set the Nimbus look and feel */
    //     //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    //     /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    //      * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
    //      */
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(SeeRated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(SeeRated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(SeeRated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(SeeRated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the form */
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             try {
    //                 new SeeRated().setVisible(true);
    //             } catch (IOException ex) {
    //                 Logger.getLogger(SeeRated.class.getName()).log(Level.SEVERE, null, ex);
    //             }
    //         }
    //     });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bookCover;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu menuAdd;
    private javax.swing.JMenu menuBrowse;
    private javax.swing.JMenu menuClubs;
    private javax.swing.JMenu menuLogo;
    private javax.swing.JMenu menuRandom;
    private javax.swing.JMenu menuRated;
    private javax.swing.JMenu menuRecommended;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton prevButton;
    private javax.swing.JLabel starRating;
    // End of variables declaration//GEN-END:variables
}