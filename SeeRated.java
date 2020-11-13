/**
* This page lets the user cycle through every book that they've rated
* Author: Luke Cihra
* Date Created: October 17, 2020
* Last Modified: November 2, 2020
* Assumptions: 
**/

//allows page to read from an external file, use of arraylists and dialogue boxes
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeeRated extends javax.swing.JFrame {
    private String bookTitle; //stores title of book being cycled through
    private String bookAuthor; //stores author of book being cycled through
    int nextCount = 1;//stores what point in the list of rated books the user is at
    int indexCount = 0;//stores index of book being cycled through
    ArrayList <String[]> ratedBooks = new ArrayList<>(); //stores info for all books rated by user
    String line[] = null;
    
    //preparing to read from books.txt
    File bookStuff = new File("books.txt");
    Scanner bookInfo = null;
    
    private Customer customer;

    /**
     * Creates new form SeeRated, displays the first book they've rated, or, if they haven't rated anything yet, nothing
     */
    public SeeRated(Customer customer) throws IOException{
        try {
            new Scanner(bookStuff);
        } catch (Exception e) {
            e.printStackTrace();
        }

        initComponents();
        
        this.customer = customer;

        getRatedBooks();
                
        if (ratedBooks.size() > 0){ 
            starRating.setVisible(true);

            prevButton.setVisible(false);//makes previous button invisible on first book being cycled through

            bookCover.setIcon(new javax.swing.ImageIcon("images/" + (ratedBooks.get(indexCount)[0]) + ".jpg")); //sets book cover to that of book being cycled through

            line = bookInfo.nextLine().split(",");//stores book information (author, genre, title) for single book in individual indices

            bookTitle = line[0];
            bookAuthor = line[1];
            //displays title and author of book being cycled through
            jTextArea1.setText("Title: " + ratedBooks.get(indexCount)[1]);
            jTextArea2.setText("Author: " + ratedBooks.get(indexCount)[2]);
            starRating.setIcon(new javax.swing.ImageIcon("resized_Stars/" + getInt() + ".png")); //sets star rating to that of book being cycled through
        }//end of if statement for when user has rated at least one book
        else {
            JOptionPane.showMessageDialog(null, "You have not rated any books on this account. Check the user manual for instructions on how to start rating books.");
            prevButton.setVisible(false);
            nextButton.setVisible(false);
            starRating.setVisible(false);
        }//end of if statement for when user has not yet rated any books
    }//end of SeeRated method

/**
 * adds all books that user has rated to arraylist which can be cycled through in page
 */
 public void getRatedBooks() {
    try {
            //preparing to read file containing books rated by user (rated.txt)
            File myFile = new File("stars/"+this.customer.getUsername()+"-rated.txt");
            Scanner inputFile = new Scanner(myFile);
            
            //preparing to read from book database
            File bookFile = new File("books.txt"); 
            Scanner inputFile2 = new Scanner(bookFile);

            //stores line read from books.txt and splits title, author etc. into separate indices
            ArrayList <String[]> lines = new ArrayList<>(); 

            //adds every line in books.txt to arraylist lines
            while(inputFile2.hasNextLine()){
                lines.add(inputFile2.nextLine().split(","));
            }//end of while loop adding every line in books.txt to arraylist lines

            //adds book in arraylist line to arraylist ratedbooks if it has been rated by the user
            while(inputFile.hasNextLine()){
                String book = inputFile.nextLine().split(",")[0];
                for(String [] line: lines){
                    if(line[0].equalsIgnoreCase(book)){
                        ratedBooks.add(new String[]{
                            String.valueOf(lines.indexOf(line) + 1),
                            line[0],
                            line[1]
                        });
                    }//end of if statement comparing line in books.txt to line in seeRated.txt
                }//end of for loop reading through arraylist of books.txt's lines
            }//end of while loop for reading through user's rated.txt 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SeeRated.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end of getRatedBooks method
    
    /**
    * Gets star rating for book
    * @return how many stars the user rated the book that they're looking at
    */
    public int getInt(){
        File myFile = new File("stars/"+this.customer.getUsername()+"-rated.txt");
        Scanner inputFile = null;
        
        try {
            inputFile = new Scanner(myFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SeeRated.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        while(inputFile.hasNextLine()){
            String temp = inputFile.nextLine();
            String arr[] = temp.split(",");
            if(Integer.parseInt(ratedBooks.get(indexCount)[0]) == Integer.parseInt(arr[2])){
                return Integer.parseInt(arr[1]);
            }//end of if statement returning star rating of book in ratedBooks arraylist
        }//end of while loop making string variable temp from line in user's rated.txt and string array arr from split version of temp
        return 0; //default return statement
    }//end of getInt method
    
    /**
    * reverts the scanner reading from books.txt to the beginning of the file
    */
    public void readReset() {
        File bookStuff = new File("books.txt");
        //try-catch to initialize scanner to read from books.txt
        try { 
            bookInfo = new Scanner(bookStuff);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SeeRated.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end of method readReset

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
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
        starRating.setIcon(new javax.swing.ImageIcon(getClass().getResource("logo_Menu.png"))); // NOI18N

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
                .addComponent(bookCover)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(bookCover, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(214, 217, 223));
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(214, 217, 223));
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setAutoscrolls(false);
        jTextArea2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(starRating, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    }//end of init.Components

    /**
    * displays information for next book rated by user when "next book" button is pressed
    */
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        if (bookInfo.hasNextLine()) { 
            nextCount++;
            indexCount++;
            
            //if you press next there's guaranteed to be a previous book
            prevButton.setVisible(true); 
            
            //splits specific pieces of information into array indices
            line = bookInfo.nextLine().split(",");
            
            //makes next button invisible if no more books to cycle through
            if (ratedBooks.size() == nextCount) nextButton.setVisible(false);

            //displays book info, cover and star rating
            System.out.println(line[0]);
            bookTitle = line[0];
            bookAuthor = line[1];
            jTextArea1.setText("Title: " + ratedBooks.get(indexCount)[1]);
            jTextArea2.setText("Author: " + ratedBooks.get(indexCount)[2]);
            starRating.setIcon(new javax.swing.ImageIcon("resized_Stars/" + getInt() + ".png"));
            bookCover.setIcon(new javax.swing.ImageIcon("images/" + (ratedBooks.get(indexCount)[0]) + ".jpg"));
        }//end of if statement for when user clicks "Next Book" button
    }//end nextButtonActionPerformed

    /**
    * Goes to "Recommended" page when button in menu bar is clicked
    */ 
    private void menuRecommendedMouseClicked(java.awt.event.MouseEvent evt) {
        new Recommend(customer).setVisible(true);
        this.setVisible(false);
    }//end event menuRecommendedMouseClicked

    /**
    * Goes to "Random" page when button in menu bar is clicked
    */ 
    private void menuRandomMouseClicked(java.awt.event.MouseEvent evt) {
        new RandomBook(customer).setVisible(true);
        this.setVisible(false);
    }//end event menuRandomMouseClicked

    /**
    * Goes to "Browse" page when button in menu bar is clicked
    */ 
    private void menuBrowseMouseClicked(java.awt.event.MouseEvent evt) {
        new menuBrowse(customer).setVisible(true);
        this.setVisible(false);
    }//end event menuBrowseMouseClicked

    /**
    * Returns to the main menu when the "Main Menu" button in menu bar is clicked
    */   
    private void menuMenuMouseClicked(java.awt.event.MouseEvent evt) {                                      
        try {
            new mainMenu(this.customer).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setVisible(false);
    }//end event menuMenuMouseClicked

    /**
    * Goes to "Clubs" page when button in menu bar is clicked
    */ 
    private void clubsMenuMouseClicked(java.awt.event.MouseEvent evt) {                                       
        //try-catch to go create instance of clubs page
        try{
            new Friends_Page(this.customer, null).setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        } 
        this.setVisible(false);
    }//end event clubsMenuMouseClicked

    /**
    * Goes to "Add Books" page when button in menu bar is clicked
    */ 
    private void menuAddMouseClicked(java.awt.event.MouseEvent evt) {
        //try-catch to create instance of addBooks page
        try {
            new addBooks(customer).setVisible(true);
            this.setVisible(false);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//end event menuAddMouseClicked

    /**
    * displays information for previous book rated by user when previous button is pressed
    */
    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        
        indexCount--;
        nextCount--;
        
        //if you're going to a previous book there's guaranteed to be a book after
        nextButton.setVisible(true);
        
        //if no books to go back to make previous button invisible
        if (nextCount > 1) prevButton.setVisible(true);
        else prevButton.setVisible(false);
        
        //displays book info, cover and star rating
        jTextArea1.setText("Title: " + ratedBooks.get(indexCount)[1]);
        jTextArea2.setText("Author: " + ratedBooks.get(indexCount)[2]); 
        bookCover.setIcon(new javax.swing.ImageIcon("images/" + (ratedBooks.get(indexCount)[0]) + ".jpg")); 
        starRating.setIcon(new javax.swing.ImageIcon("resized_Stars/" + getInt() + ".png"));
    }//end prevButtonActionPerformed

    // Variables declaration - do not modify
    private javax.swing.JLabel bookCover;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
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
    // End of variables declaration
}//End of class SeeRated
