package com.mycompany.booksmartmav;

//import nessessary libraries
import java.io.*;//file writing and reading purposes
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * First page to greet you after a successfully login. It also displays a random book and quote of the day
 * 
 * @author Andreja
 */
public class mainMenu extends javax.swing.JFrame {
    private Customer customer; //Customer object
    private boolean newInfo; //Wether the page is being accessed the first time or second time
    

    /**
     * Constructor
     * @param customer the customer object
     * @param newInfor wether the page is being accessed the first time or second time
     */
    public mainMenu(Customer customer, boolean newInfo) {
        this.customer = customer;
        this.newInfo = newInfo;

        //Auto-gen method to create components
        initComponents();
        
        //Opens up the images folder
        File directory = new File("images");
        
        //The image file number to be displayed on the page
        int fileNumber = 0;
        //Stores the ranom quote
        String quote = null;
        
        //If the page is being opened for the first time
        if(newInfo == true){
            //Declare print writer for writing to file
            PrintWriter fWriter = null;
            //Try, catch to initilize printwriter
            try{
                fWriter = new PrintWriter("data/Quote and Book.txt");
            }catch(Exception e){
                e.printStackTrace();
            }    
                
            //Try, catch to get a random quote and assign it to quote
            try{
                quote = randomQuote();
            }catch (Exception e){
                e.printStackTrace();
            }
                
            //writes the quote into the text file
            fWriter.println(quote);
                
            //Creates an array of all the book image files
            File fileArr[] = directory.listFiles();
                
            //Picks a random number within the length of the array
            fileNumber = (int) (Math.random() * fileArr.length);
                
            //Writes the random number into the text file
            fWriter.println(fileNumber);
            
            //Closes the printwriter
            fWriter.close();
        }//End of if statement
        else{
            //Open the text file that the data was previously written to
            File myFile = new File("data/Quote and Book.txt");
            //Declare scanner for reading
            Scanner fileReader = null;
            
            //try, catch to initalize scanner
            try{
                fileReader = new Scanner(myFile);
            } catch(Exception e){
                e.printStackTrace();
            }
            
            //Creates arr size 2 to hold the image file number and quote from text file
            String arr [] = new String[2];
                
            //reads text file and stores image file and quote into each array index
            arr[0] = fileReader.nextLine();              
            arr[1] = fileReader.nextLine();
            
            //Sets to variables to equal each array index to be printed to the screen.
            quote = arr[0];
            fileNumber = Integer.parseInt(arr[1]);
        }
        
        //Displays the random quote to the screen
        jTextArea1.setText(quote);

        //Displays the random book image to the screen
        jLabel1.setIcon(new javax.swing.ImageIcon("images\\" + (fileNumber + 1) + ".jpg"));

        //Opens up file
        File file = new File("data/books.txt");    
        //Declares scanner for reading
        Scanner inputFile = null;

        //Try, catch to initialize scanner
        try {
            inputFile = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //int count keeps track of the line number the scanner is on
        int count = 0;
        //String array to store the information on a line in the txt file
        String line[] = null;
        //Whilte the inputfile has next line
        while (inputFile.hasNextLine()) {
            //If the current line number equals the random image number (the image is named after it corresponding line number in the txt file)
            if (count == fileNumber) {
                //Split the information on the line and store it in line []
                line = inputFile.nextLine().split(",");
                break;
            }
            //Add one to count
            count++;
            //Move the scanner one forward
            inputFile.nextLine();
        }

        //Display the book title to the screen
        jLabel2.setText(line[0]);
        //Display the book author to the screen
        jLabel3.setText(line[1]);
        //Display and ad to the screen
        jLabel4.setIcon(new javax.swing.ImageIcon("logos/ad.jpg"));

    }//End of constructer
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Recommended = new javax.swing.JMenu();
        Random = new javax.swing.JMenu();
        Browse = new javax.swing.JMenu();
        BooksYouveRated = new javax.swing.JMenu();
        addBooks = new javax.swing.JMenu();
        friends = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(214, 217, 223));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextArea1.setHighlighter(null);
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setIcon(new javax.swing.ImageIcon(
                "images/logo_Menu.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("jLabel3");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(214, 217, 223));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Quote of The Day:");
        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(214, 217, 223));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Book of The Day:");
        jTextField2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(214, 217, 223));
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Sponsored By:");
        jTextField3.setToolTipText("");
        jTextField3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
            
        System.out.println(new File("logos/logo_Menu.png").exists());
        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Andreja\\Documents\\NetBeansProjects\\BookSmartMav\\logos/logo_Menu.png")); // NOI18N
        jMenuBar1.add(jMenu1);

        Recommended.setText("Recommended");
        Recommended.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Recommended.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecommendedMouseClicked(evt);
            }
        });
        jMenuBar1.add(Recommended);

        Random.setText("Random");
        Random.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Random.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RandomMouseClicked(evt);
            }
        });
        jMenuBar1.add(Random);

        Browse.setText("Browse");
        Browse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Browse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrowseMouseClicked(evt);
            }
        });
        jMenuBar1.add(Browse);

        BooksYouveRated.setText("Books You've Rated");
        BooksYouveRated.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BooksYouveRated.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BooksYouveRatedMouseClicked(evt);
            }
        });
        jMenuBar1.add(BooksYouveRated);

        addBooks.setText("Add Books");
        addBooks.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBooksMouseClicked(evt);
            }
        });
        jMenuBar1.add(addBooks);

        friends.setText("Clubs");
        friends.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        friends.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                friendsMouseClicked(evt);
            }
        });
        jMenuBar1.add(friends);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                .addComponent(jTextField1)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(90, 90, 90)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(
                                        jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Picks a random quote.
     * @return random quote.
     */
    private String randomQuote() throws IOException {
        String file = "data/quotes.csv";

        //Opens file and prepares for reading
        File myFile = new File(file);
        Scanner inputFile = new Scanner(myFile);

        //Creates arr the size of the amount of quotes
        String arr[] = new String[350];
        
        //Stores all the quotes from the file in the array
        int i = 0;
        while (inputFile.hasNextLine()) {
            arr[i] = inputFile.nextLine();
            i++;
        }
        
        //Picks a random number
        int random = (int) (Math.random() * 350);
        
        //Returns a quote based on the random number chose
        return arr[random];
    }//End of randomQuote

    /**
    * Goes to "Recommended" page when button in menu bar is clicked
    */
    private void RecommendedMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_RecommendedMouseClicked
        new Recommend(this.customer).setVisible(true);
        this.dispose();
    }// GEN-LAST:event_RecommendedMouseClicked

    /**
    * Goes to "Random" page when button in menu bar is clicked
    */
    private void RandomMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_RandomMouseClicked
        new RandomBook(this.customer).setVisible(true);
        this.dispose();
    }// GEN-LAST:event_RandomMouseClicked

    /**
    * Goes to the "Browse" page when button in menu bar is clicked
    */ 
    private void BrowseMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_BrowseMouseClicked
        new BrowseMenu(customer).setVisible(true);
        this.dispose();
    }// GEN-LAST:event_BrowseMouseClicked

    /**
    * Goes to "Books You've Rated" page when button in menu bar is clicked
    */ 
    private void BooksYouveRatedMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_BooksYouveRatedMouseClicked
        try {
            new SeeRated(this.customer).setVisible(true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_BooksYouveRatedMouseClicked

    /**
    * Goes to "Add Books" page when button in menu bar is clicked
    */ 
    private void addBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBooksMouseClicked
        try {
            new addBooks(this.customer).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(mainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_addBooksMouseClicked

    /**
    * Goes to "Clubs" page when button in menu bar is clicked
    */ 
    private void friendsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friendsMouseClicked
        try{
            new Friends_Page(this.customer, null).setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        this.dispose();
    }//GEN-LAST:event_friendsMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu BooksYouveRated;
    private javax.swing.JMenu Browse;
    private javax.swing.JMenu Random;
    private javax.swing.JMenu Recommended;
    private javax.swing.JMenu addBooks;
    private javax.swing.JMenu friends;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
    
}//End of class MainMenu