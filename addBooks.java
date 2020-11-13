package com.mycompany.booksmartmav;

//imports
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*; //For file writing purposes
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * Allows the user to add books to the database
 * 
 * @author Andreja
 */
public class addBooks extends javax.swing.JFrame {
    
    private String arr [] = new String[4]; //String arr for storing all the inputed information
    private boolean checkForBookTitle; //Checks if the book title has been inputed
    private boolean checkForAuthor; //Checks if the author name has been inputed
    private boolean checkForGenre; //Checks if the genre has been inputed
    private boolean checkForFilePath;//Checks that the file path has been inputed
    private Customer customer; //Customer object
    
    //Constructor
    public addBooks(Customer customer) throws IOException{
        this.customer = customer;
        checkForBookTitle = false;
        checkForAuthor = false;
        checkForGenre = false;
        checkForFilePath = false;
        
        //Auto generated method constructing the gui
        initComponents();       
    }//End of constructer
    
    /**
     * Checks that all the variables have been properly inputted
     * @return boolean if all the values have been properly inputted or not
     */
    private boolean checkForValues(){
        boolean allValuesInputed = false;
        //If all the values have been entered check if the user wants to proceed
        if(checkForBookTitle == true && checkForAuthor == true && checkForGenre == true && checkForFilePath == true){
            //Lets the user confirm they want to proceed
            int n = JOptionPane.showConfirmDialog(null,"Would you like to proceed?","Confirm",JOptionPane.YES_NO_OPTION);
            //If they do and the book does not exist all values have been inputed and they are ready to be used
            if(n == 0 && exists(arr[0],arr[1]) == false){
                allValuesInputed = true;
            }
            //else reset all the variables 
            else{
                //If the book already exists prompt the user and reset variablesD
                if(exists(arr[0],arr[1]) == true){
                    JOptionPane.showMessageDialog(null,"This book is already in the database.","Book Exists",JOptionPane.ERROR_MESSAGE);
                }
                allValuesInputed = false;
                
                arr[0] = null;
                arr[1] = null;
                arr[2] = null;
                arr[3] = null;
                
                checkForBookTitle = false;
                checkForAuthor = false;
                checkForGenre = false;
                checkForFilePath = false;
                
                bookGenreInput.setText("Input Genre...");
                bookTitleInput.setText("Input Book Title...");
                bookAuthorInput.setText("Input Author...");
                filePathInput.setText("File Path to Image...");
                return allValuesInputed;
            }//End of else
        }//Of if statement
        
        return allValuesInputed;    
    }//End of checkForValues
    
    /**
     * Checks to see if the book being added is already in the database
     * @param bookTitle the title of the book being inputted
     * @param authorTitle the name of the author of the book
     * @return boolean wether the book is in the database or not
     */
    private boolean exists(String bookTitle, String authorTitle){
        boolean exists = false;
        
        //Open file
        File myFile = new File("data\\books.txt");
        //Declare scanner for reading
        Scanner fileReader = null;
        
        //try, catch to initialize scanner
        try{
            fileReader = new Scanner(myFile);
        }catch(Exception e){
            System.out.println("ERROR MESSAGE");
        }
        
        //Read through the name and author of every book in the database, if the title of the book and the author match an entry in the database return true and break, else return false.
        String array [] = null;
        while(fileReader.hasNextLine()){
            String temp = fileReader.nextLine();
            
            array = temp.split(",");
            
            if(array[0].equalsIgnoreCase(arr[0]) && array[1].equalsIgnoreCase(arr[1])){
                exists = true;
                break;
            }
        }
        
        return exists;
    }//End of exists
       
    /**
     * Appends the data base to add the new book
     */
    private void appendFile() throws IOException{
        //Opens up file and prepares to append for appending
        FileWriter fwriter = new FileWriter("data\\books.txt",true);
        PrintWriter outputFile = new PrintWriter(fwriter);
        
        //Appends the book.txt file to add the book name,author and parent genre
        outputFile.println(arr[0] + "," + arr[1] + "," + genreParent(arr[2]));
        
        //Closes the file writer and print writer
        fwriter.close();
        outputFile.close();
        
        //If the genre is not already supported, and appears more then two times, append the genre file to add the genre
        if(genresSupported(arr[2]).equals("found")){
               FileWriter fwriter2 = new FileWriter("data\\genres.txt",true);
               PrintWriter outputFile2 = new PrintWriter(fwriter2);

               outputFile2.println(arr[2] + "," + arr[2]);
               
               //Closes the file writer and print writer
               fwriter2.close();
               outputFile2.close();
        }//End of if statement
        
        //Opens another file writer and printwriter
        FileWriter fwriter3 = new FileWriter("stars\\ratings.txt",true);
        PrintWriter outputFile3 = new PrintWriter(fwriter3);
        
        //add a blank line to create space to store ratings for the new book
        outputFile3.println("");
        
        //close the file writer and prtin writer
        fwriter3.close();
        outputFile3.close();
        
        //Reset the values of the array to null
        arr[0] = null;
        arr[1] = null;
        arr[2] = null;
    }//End of appendFile
    
    /**
     * Resizes the image and adds the image file to the image folder
     */
    private void addFileImage() throws IOException{
        String filePath = "images";
        
        File files [] = new File(filePath).listFiles();
        filePath += "\\" + (files.length + 1) + ".jpg";
        
        //reads input image
        File inputFile = new File(arr[3]);
        System.out.println(inputFile.exists());
        BufferedImage inputImage = ImageIO.read(inputFile);
        File outputFile = new File(filePath);
       
        //creates ouput image
        BufferedImage outputImage = new BufferedImage(229,293,inputImage.getType());
        
        //Scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, 229, 293, null);
        g2d.dispose();
        
        //Extracts extension of output file
        String formatName = filePath.substring(filePath.lastIndexOf(".") + 1);
        
        //writes to output file
        ImageIO.write(outputImage,formatName,outputFile);
        
        //Sets the image icon to the resized image
        image.setIcon(new javax.swing.ImageIcon(filePath)); 
        
        //Resets the file path to null to get ready for another book path
        arr[3] = null;
    }//End of addFileImage
    
    /**
    * This method check if atleast 2 books of the passed in genre exist
    * @param genre The genre to be sought out for
    * @return Whether at least 2 books of that genre exist
    */
    public String genresSupported(String genre){
        //First we must find if the genre exits in genre.txt
        File genres = new File("data/genres.txt");
        //Scanner to read genres
        Scanner in = null;

        //try catch to initilize the Scanner
        try{
            in = new Scanner(genres);
        }catch(Exception e){
            e.printStackTrace();
        }//end of try-catch

        //while loop to traverse through genres
        while(in.hasNextLine()){
            //Read line in String [] (comma deliniated)
            String [] line = in.nextLine().split(","); 
            //check if index is in the file
            if(genre.equalsIgnoreCase(line[0])){
                System.out.println("Super unique");
                return line[1];
            }//end if
        }//end while loop

        //File object representing the path to the book data
        genres = new File("data\\books.txt");
        //Scanner to read fil
        in = null;
        //try catch to initilize the Scanner
        try{
            in = new Scanner(genres);
        }catch(Exception e){
            e.printStackTrace();
        }//end of try-catch

        //count the number of times the genres were found
        int genreCount = 0;

        //traverse through file
        while(in.hasNextLine()){
            //String [] representing the line the file is on (comma deliniated)
            String [] line = in.nextLine().split(",");

            //check if the genre was found
            if(line[2].equalsIgnoreCase(genre)){
                genreCount++;
            }//end if
        }//end of while loop

        //return the value to genreCount >= 3
        return genreCount > 2 ? "found" : "not found";
    }//end of method genresSupported
    
    /**
     * Checks to see if the genre inputted is a synonym of another already inputted genre, if it is return that genre, if it is not return the inputted genre
     * @param genre the inputted genre
     * @return either the non synonym genre or the inputted genre
     */
    private String genreParent(String genre){
        //Opens up genre.txt and declares scanner to read it
        File myFile = new File("data/genres.txt");
        Scanner fileReader = null;
        
        //try,catch to initialize scanner
        try{
            fileReader = new Scanner(myFile);
        }catch(Exception e){
            System.out.println("ERROR MESSAGE");
        }
        
        //Read through the file, if it matches one of the synonyms, set genreParent equal to the non synonym, if it doesn't set genreParent to the inputted genre
        String genreParent = null;
        while(fileReader.hasNextLine()){
            String temp = fileReader.nextLine();
            
            String arr[] = temp.split(",");
            
            System.out.println(genre + " " + arr[0]);
            
            if(genre.equals(arr[0])){
                genreParent = arr[1];
                break;
            }
            else{
                genreParent = genre;
                break;
            }
        }//End of while loop
        
        return genreParent;
    }//End of genreParent

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        image = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        bookGenreInput = new javax.swing.JTextField();
        bookTitleInput = new javax.swing.JTextField();
        bookAuthorInput = new javax.swing.JTextField();
        filePathInput = new javax.swing.JTextField();
        filePathInputButton = new javax.swing.JButton();
        bookTitleInputButton = new javax.swing.JButton();
        authorInputButton = new javax.swing.JButton();
        genreInputButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        logo = new javax.swing.JMenu();
        recommended = new javax.swing.JMenu();
        random = new javax.swing.JMenu();
        browse = new javax.swing.JMenu();
        booksYouveRated = new javax.swing.JMenu();
        mainMenu = new javax.swing.JMenu();
        clubs = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(214, 217, 223));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Add Books");
        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        image.setIcon(new javax.swing.ImageIcon("logos\\logo_Menu.png")); // NOI18N

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(214, 217, 223));
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Input:");
        jTextField3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(214, 217, 223));
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("Book Image:");
        jTextField4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        bookGenreInput.setText("Input Genre...");
        bookGenreInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookGenreInputActionPerformed(evt);
            }
        });
        bookGenreInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt){
                bookGenreInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt){
                bookGenreInputFocusLost(evt);
            }
        });

        bookTitleInput.setText("Input Book Title...");
        bookTitleInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTitleInputActionPerformed(evt);
            }
        });
        bookTitleInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt){
                bookTitleInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt){
                bookTitleInputFocusLost(evt);
            }
        });

        bookAuthorInput.setText("Input Author...");
        bookAuthorInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAuthorInputActionPerformed(evt);
            }
        });
        bookAuthorInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt){
                bookAuthorInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt){
                bookAuthorInputFocusLost(evt);
            }
        });

        filePathInput.setText("File Path to Image...");
        filePathInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePathInputActionPerformed(evt);
            }
        });
        filePathInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt){
                filePathInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt){
                filePathInputFocusLost(evt);
            }
        });

        filePathInputButton.setText("Input");
        filePathInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePathInputButtonActionPerformed(evt);
            }
        });

        bookTitleInputButton.setText("Input");
        bookTitleInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTitleInputButtonActionPerformed(evt);
            }
        });

        authorInputButton.setText("Input");
        authorInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorInputButtonActionPerformed(evt);
            }
        });

        genreInputButton.setText("Input");
        genreInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreInputButtonActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon("logos\\logo_Menu.png")); // NOI18N
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

        browse.setText("Browse");
        browse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        browse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseMouseClicked(evt);
            }
        });
        jMenuBar1.add(browse);

        booksYouveRated.setText("Books You've Rated");
        booksYouveRated.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        booksYouveRated.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksYouveRatedMouseClicked(evt);
            }
        });
        jMenuBar1.add(booksYouveRated);

        mainMenu.setText("Main Menu");
        mainMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(mainMenu);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(filePathInputButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(filePathInput, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(genreInputButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bookGenreInput, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(authorInputButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bookAuthorInput, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(bookTitleInputButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bookTitleInput, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bookTitleInput, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookTitleInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bookAuthorInput, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(authorInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bookGenreInput, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genreInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filePathInput, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filePathInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * The focus lost action event sets the text of the genre text field to 'Input Genre..." if it is empty or says 'Inputed!'
     * @param evt The focus lost action event
     */
    private void bookGenreInputFocusLost(java.awt.event.FocusEvent evt){//GEN-FIRST:event_bookGenreInputFocusLost
        if (bookGenreInput.getText().equals("") || bookGenreInput.getText().equals("Inputed!")) {
            bookGenreInput.setText("Input Genre...");
        }
    }//GEN-LAST:event_bookGenreInputFocusLost
          
    /**
     * The focus gained action event sets the text of the genre text field to blank if it says 'Input Genre..." or if it says 'Inputed!'
     * @param evt The focus lost action event
     */
    private void bookGenreInputFocusGained(java.awt.event.FocusEvent evt){//GEN-FIRST:event_bookGenreInputFocusGained
        if (bookGenreInput.getText().equals("Input Genre...") || bookGenreInput.getText().equals("Inputed!")) {
            bookGenreInput.setText("");
        }
    }//GEN-LAST:event_bookGenreInputFocusGained
    
     /**
     * The focus gained action event sets the text of the title text field to blank if it says 'Input Title..." or if it says 'Inputed!'
     * @param evt The focus lost action event
     */
    private void bookTitleInputFocusGained(java.awt.event.FocusEvent evt){//GEN-FIRST:event_bookTitleInputFocusGained
        if (bookTitleInput.getText().equals("Input Book Title...") || bookTitleInput.getText().equals("Inputed!")) {
            bookTitleInput.setText("");
        }
    }//GEN-LAST:event_bookTitleInputFocusGained     
    
    /**
     * The focus lost action event sets the text of the title text field to 'Input Title..." if it is empty or says 'Inputed!'
     * @param evt The focus lost action event
     */
    private void bookTitleInputFocusLost(java.awt.event.FocusEvent evt){//GEN-FIRST:event_bookTitleInputFocusLost
        if (bookTitleInput.getText().equals("") || bookTitleInput.getText().equals("Inputed!")) {
            bookTitleInput.setText("Input Book Title...");
        }
    }//GEN-LAST:event_bookTitleInputFocusLost
    
    /**
     * The focus lost action event sets the text of the author text field to 'Input Author..." if it is empty or says 'Inputed!'
     * @param evt The focus lost action event
     */
    private void bookAuthorInputFocusLost(java.awt.event.FocusEvent evt){//GEN-FIRST:event_bookAuthorInputFocusLost
        if (bookAuthorInput.getText().equals("") || bookAuthorInput.getText().equals("Inputed!")) {
            bookAuthorInput.setText("Input Author...");
        }
    }//GET-LAST:event_bookAuthorInputFocusLost
         
    /**
     * The focus gained action event sets the text of the author text field to blank if it says 'Input Author..." or if it says 'Inputed!'
     * @param evt The focus lost action event
     */
    private void bookAuthorInputFocusGained(java.awt.event.FocusEvent evt){//GEN-FIRST:event_bookAuthorInputFocusGained
        if (bookAuthorInput.getText().equals("Input Author...") || bookAuthorInput.getText().equals("Inputed!")) {
            bookAuthorInput.setText("");
        }
    }//GEN-LAST:event_bookAuthorInputFocusGained
          
    /**
     * The focus gained action event sets the text of the file path text field to blank if it says 'File Path to Image..." or if it says 'Inputed!'
     * @param evt The focus lost action event
     */
    private void filePathInputFocusGained(java.awt.event.FocusEvent evt){//GEN-FIRST:event_filePathInputFocusGained
        if (filePathInput.getText().equals("File Path to Image...") || filePathInput.getText().equals("Inputed!")) {
            filePathInput.setText("");
        }
    }//GEN-LAST:event_filePathInputFocusGained
       
    /**
     * The focus lost action event sets the text of the file path text field to 'File Path to Image..." if it is empty or says 'Inputed!'
     * @param evt The focus lost action event
     */
    private void filePathInputFocusLost(java.awt.event.FocusEvent evt){//GEN-FIRST:event_filePathInputFocusLost
        if (filePathInput.getText().equals("") || filePathInput.getText().equals("Inputed!")) {
            filePathInput.setText("File Path to Image...");
        }
    }//GEN-LAST:event_filePathInputFocusLost
          
    /**
    * Goes to "Recommended" page when button in menu bar is clicked
    */
    private void recommendedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recommendedMouseClicked
        new Recommend(this.customer).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_recommendedMouseClicked

    /**
    * Goes to "Random" page when button in menu bar is clicked
    */
    private void randomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_randomMouseClicked
        new RandomBook(customer).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_randomMouseClicked

    /**
    * Goes to the "Browse" page when button in menu bar is clicked
    */ 
    private void browseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseMouseClicked
        new BrowseMenu(customer).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_browseMouseClicked

    /**
    * Goes to "Books You've Rated" page when button in menu bar is clicked
    */ 
    private void booksYouveRatedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksYouveRatedMouseClicked
        try {
            new SeeRated(this.customer).setVisible(true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_booksYouveRatedMouseClicked

    /**
    * Goes to "Main Menu" page when button in menu bar is clicked
    */ 
    private void mainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuMouseClicked
        try {
            new mainMenu(this.customer,false).setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(addBooks.class.getName()).log(Level.SEVERE, null, e);
        }
        this.dispose();
    }//GEN-LAST:event_mainMenuMouseClicked

    /**
    * Goes to "Clubs" page when button in menu bar is clicked
    */
    private void clubsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clubsMouseClicked
        try{
            new Friends_Page(this.customer, null).setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        this.dispose();
    }//GEN-LAST:event_clubsMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void bookGenreInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookGenreInputActionPerformed
        
    }//GEN-LAST:event_bookGenreInputActionPerformed

    private void bookTitleInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTitleInputActionPerformed
        
    }//GEN-LAST:event_bookTitleInputActionPerformed

    private void bookAuthorInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookAuthorInputActionPerformed
        
    }//GEN-LAST:event_bookAuthorInputActionPerformed

    private void filePathInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePathInputActionPerformed
        
    }//GEN-LAST:event_filePathInputActionPerformed

    /**
    * Reads the text in the book title text field when the button is clicked and sets the index of the field arr[0] to the read text if it was properly inputted
    * @param evt the action event
    */ 
    private void bookTitleInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTitleInputButtonActionPerformed
        //If the text inputted is one of the place holders then pop up error and ask the user to reinput
        if(bookTitleInput.getText().equals("Input Book Title...") || bookTitleInput.getText().equals("Inputed!")){
            JOptionPane.showMessageDialog(null,"Make sure the book name is a real name!","Wrong Input",JOptionPane.ERROR_MESSAGE);
            bookTitleInput.setText("Input Book Title...");
        }
        else{
            //Set arr[0] to the converted inputted text
            arr[0] = convert(bookTitleInput.getText());
            
            //Change the place holder
            bookTitleInput.setText("Inputed!");
            //set boolean to true as the tile has been inputted
            checkForBookTitle = true;
            //If all of the values have been inputted properly, add the book to the database
            if(checkForValues() == true){
                try {
                    //Set to false to prepare for another book to be added
                    checkForBookTitle = false;
                    //Append file
                    appendFile();
                    //Add image to the database
                    addFileImage();
                } catch (IOException ex) {
                    Logger.getLogger(addBooks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//End of if statment
        }//End of else
    }//GEN-LAST:event_bookTitleInputButtonActionPerformed

    /**
    * Reads the text in the author title text field when the button is clicked and sets the index of the field arr[1] to the read text if it was properly inputted
    * @param evt the action event
    */ 
    private void authorInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorInputButtonActionPerformed
        //If the author name contains numbers or if it is one of the place holders pop up a error and ask the user to input the author again
        if(bookAuthorInput.getText().matches(".*\\d.*") || bookAuthorInput.getText().equals("Input Author...") || bookAuthorInput.getText().equals("Inputed!")){
            JOptionPane.showMessageDialog(null,"Make sure the author name is a real name!","Wrong Input",JOptionPane.ERROR_MESSAGE);
            bookAuthorInput.setText("Input Author...");
        }
        else{
            //Set arr[1] to equal the converted author input
            arr[1] = convert(bookAuthorInput.getText());
            //Set the place holder
            bookAuthorInput.setText("Inputed!");
            //Set check for author to true as it has been inputed
            checkForAuthor = true;
            //If all of the values have been inputted properly, add the book to the database
            if(checkForValues() == true){
                try {
                    //Set checkForAuthor to false to prepare for another book to be added
                    checkForAuthor = false;
                    //Append file
                    appendFile();
                    //Add image
                    addFileImage();
                } catch (IOException ex) {
                    Logger.getLogger(addBooks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//End of if statmenet
        }//End of else
    }//GEN-LAST:event_authorInputButtonActionPerformed
    
    /**
     * converts the first letter to uppercase and every other letter to lower case
     * @param str the string to be converted
     * @return the converted String
     */ 
    private String convert(String str){
        // Create a char array of given String
        char ch[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {      
            // If first character of a word is found
            if (i == 0 && ch[i] != ' ' || 
                ch[i] != ' ' && ch[i - 1] == ' ') {
                // If it is in lower-case
                if (ch[i] >= 'a' && ch[i] <= 'z') {
                    // Convert into Upper-case
                    ch[i] = (char)(ch[i] - 'a' + 'A');
                }
            }
            
            // If apart from first character
            // Any one is in Upper-case
            else if (ch[i] >= 'A' && ch[i] <= 'Z') 
                // Convert into Lower-Case
                ch[i] = (char)(ch[i] + 'a' - 'A');            
        }
 
        // Convert the char array to equivalent String
        String st = new String(ch);
        return st;
    }//End of convert

    /**
    * Reads the text in the genre input text field when the button is clicked and sets the index of the field arr[2] to the read text if it was properly inputted
    * @param evt the action event
    */ 
    private void genreInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreInputButtonActionPerformed
         //If the genre input contains numbers or if it is one of the place holders pop up a error and ask the user to input the genre again
        if(bookGenreInput.getText().matches(".*\\d.*") || bookGenreInput.getText().equals("Input Genre...") || bookGenreInput.getText().equals("Inputed!")){
            JOptionPane.showMessageDialog(null,"Make sure the genre is a real genre!","Wrong Input",JOptionPane.ERROR_MESSAGE);
            bookGenreInput.setText("Input Genre...");
        }
        else{
            //Set arr[2] to the genre input
            arr[2] = bookGenreInput.getText().toLowerCase();
            //Set place holder
            bookGenreInput.setText("Inputed!");
            //Set checkForGenre to true as it has been inputted
            checkForGenre = true;
            //If all of the values have been inputted properly, add the book to the database
            if(checkForValues() == true){
                try {
                    //Set checkForGenre to false to prepare to add another book
                    checkForGenre = false;
                    //append file
                    appendFile();
                    //add image
                    addFileImage();
                } catch (IOException ex) {
                    Logger.getLogger(addBooks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//End of if statement
        }//End of else
    }//GEN-LAST:event_genreInputButtonActionPerformed

    /**
     * The button pressed action event to input data
     * @param evt The mouse action event
     */
    private void filePathInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePathInputButtonActionPerformed
        //Makes sure the file exists
        if(new File(filePathInput.getText()).exists() == false){
            JOptionPane.showMessageDialog(null,"That file does not exist","Wrong Input",JOptionPane.ERROR_MESSAGE);
            filePathInput.setText("File Path to Image...");
        }
        //Makes sure it is the right type of file
        else if(fileExtension(filePathInput.getText()) == false){
            JOptionPane.showMessageDialog(null,"That is the wrong type of file, this program needs a .jpg file.","Wrong Input",JOptionPane.ERROR_MESSAGE);
            filePathInput.setText("File Path to Image...");
        }
        //Takes in the filePathInput
        else{
            arr[3] = filePathInput.getText();
        
            filePathInput.setText("Inputed!");
            checkForFilePath = true;
            //If all the other variables have been inputed append the file and add the image to the image folder
            if(checkForValues() == true){
                try {
                    //Set checkForFilePath to false to prepare to add another book
                    checkForFilePath = false;
                    //append file
                    appendFile();
                    //Add image
                    addFileImage();
                } catch (IOException ex) {
                    Logger.getLogger(addBooks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//End of if statement
        }//End of else
    }//GEN-LAST:event_filePathInputButtonActionPerformed
    
    /**
     * Checks to see if the file extension is a jpg
     * @param filePath the file file path of the file
     * @return wether the file path is correct or not
     */
    private boolean fileExtension(String filePath){
        String arr  [] = filePath.split("\\.");
        
        //If the last index of the split arr is equal to jpg return true else return false
        if(arr[arr.length - 1].equals("jpg")){
            return true;
        }
        else{
            return false;
        }
    }//End of fileExtension
    
  //  private String converFilePath(String filePath){
        
        
        
   // }

    /**
     * @param args the command line arguments
     */
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
    //         java.util.logging.Logger.getLogger(addBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(addBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(addBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(addBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the form */
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             try {
    //                 new addBooks().setVisible(true);
    //             } catch (IOException ex) {
    //                 Logger.getLogger(addBooks.class.getName()).log(Level.SEVERE, null, ex);
    //             }
    //         }
    //     });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton authorInputButton;
    private javax.swing.JTextField bookAuthorInput;
    private javax.swing.JTextField bookGenreInput;
    private javax.swing.JTextField bookTitleInput;
    private javax.swing.JButton bookTitleInputButton;
    private javax.swing.JMenu booksYouveRated;
    private javax.swing.JMenu browse;
    private javax.swing.JMenu clubs;
    private javax.swing.JTextField filePathInput;
    private javax.swing.JButton filePathInputButton;
    private javax.swing.JButton genreInputButton;
    private javax.swing.JLabel image;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JMenu logo;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JMenu random;
    private javax.swing.JMenu recommended;
    // End of variables declaration//GEN-END:variables
    
}//End of class Add Books