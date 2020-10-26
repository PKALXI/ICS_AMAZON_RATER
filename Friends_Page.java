import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author jaimoraes
 */
public class Friends_Page extends javax.swing.JFrame {

    
    private String[]clubs;
    private String user;
    boolean isFriends=false;//feature cancelled
    private File currentFile=new File("None Selected.txt");
    private String storedAt="";
    private Customer CurrentCust;
    /**
     * Creates new form Friends_Page
     */
    public Friends_Page(Customer UserCust,String folder) throws IOException {
        CurrentCust = UserCust;
        String select;
        if(isFriends)
            select="Friend";
        else
            select="Chat";
        
        File userFile = new File(UserCust.getUsername()+select+".txt");
        System.out.println(UserCust.getUsername()+select+".txt");
        if(!userFile.isFile())
            userFile.createNewFile();
        
        
        BufferedReader reader = new BufferedReader(new FileReader(userFile));
        
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        
        String[] list = new String[lines];
        
        Scanner loadList= new Scanner(userFile);
        
        for(int x=0;x<list.length;x++)
        {
            if(loadList.hasNextLine())
                list[x]=loadList.nextLine();
        }
        this.clubs=list.clone();
        
        this.user=UserCust.getUsername();
      
        if(folder!=""&&folder!=null)
            this.storedAt=folder+"/";
        
        
        
        initComponents();
        
        this.setVisible(true);
    }

    

   /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        FriendSelector = new javax.swing.JComboBox(this.modelToSet());
        jScrollPane1 = new javax.swing.JScrollPane();
        MessageDisplay = new javax.swing.JTextArea();
        MessageInput = new javax.swing.JTextField();
        EnterButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        DoNotUse = new javax.swing.JMenu();
        RandomBook = new javax.swing.JMenu();
        MainMenu = new javax.swing.JMenu();
        Browse = new javax.swing.JMenu();
        BooksRated = new javax.swing.JMenu();
        AddBooks = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        FriendSelector.setEditable(true);
        FriendSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FriendSelectorActionPerformed(evt);
            }
        });

        MessageDisplay.setColumns(20);
        MessageDisplay.setRows(5);
        jScrollPane1.setViewportView(MessageDisplay);

        EnterButton.setText("Enter");
        EnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Hoefler Text", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 51));
        jLabel2.setText("Clubs");

        DoNotUse.setIcon(new javax.swing.ImageIcon(getClass().getResource("logo_Menu.png"))); // NOI18N
        jMenuBar2.add(DoNotUse);

        RandomBook.setText("Random Book");
        RandomBook.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        RandomBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RandomBookMouseClicked(evt);
            }
        });
        jMenuBar2.add(RandomBook);

        MainMenu.setText("Main Menu");
        MainMenu.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        MainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainMenuMouseClicked(evt);
            }
        });
        jMenuBar2.add(MainMenu);

        Browse.setText("Browse");
        Browse.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        Browse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrowseMouseClicked(evt);
            }
        });
        jMenuBar2.add(Browse);

        BooksRated.setText("Books you've rated");
        BooksRated.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        BooksRated.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BooksRatedMouseClicked(evt);
            }
        });
        jMenuBar2.add(BooksRated);

        AddBooks.setText("Add Books");
        AddBooks.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        AddBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBooksMouseClicked(evt);
            }
        });
        jMenuBar2.add(AddBooks);

        jMenu3.setText("Recommended");
        jMenu3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MessageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EnterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE))
                            .addComponent(FriendSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FriendSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MessageInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EnterButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>        

      private void MainMenuMouseClicked(java.awt.event.MouseEvent evt) {                                      
        try {
            new mainMenu(CurrentCust).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setVisible(false);
    }                                     

    private void BrowseMouseClicked(java.awt.event.MouseEvent evt) {                                    
        new BrowseMenu(CurrentCust).setVisible(true);
        this.setVisible(false);
    }                                   

    private void BooksRatedMouseClicked(java.awt.event.MouseEvent evt) {                                        
        new SeeRated(CurrentCust).setVisible(true);
        this.setVisible(false);
    }                                       

    private void AddBooksMouseClicked(java.awt.event.MouseEvent evt) {                                      
        try {
            new addBooks(CurrentCust).setVisible(true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.setVisible(false);
    }                                     

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {                                    
        new Recommend(CurrentCust).setVisible(true);
        this.setVisible(false);
    }                                   

    private void RandomBookMouseClicked(java.awt.event.MouseEvent evt) {                                        
        new RandomBook(CurrentCust).setVisible(true);
        this.setVisible(false);
    }                                       

    private void EnterButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try{
        if(this.MessageInput.getText()!=""&&this.MessageInput.getText()!=null){
            this.send(this.MessageInput.getText());
            this.MessageInput.setText("");
          } 
        }catch(IOException E){
            this.MessageDisplay.setText("ERROR! Please report this to a System Administrator.");
        }finally{
        System.out.println("Enter Button");
        }
    }                                           

    private void FriendSelectorActionPerformed(java.awt.event.ActionEvent evt) {                                               
        try{
        if(!((String)this.FriendSelector.getSelectedItem()).equals("None Selected"))
            this.load((String)this.FriendSelector.getSelectedItem());
        }catch(IOException E){
            this.MessageDisplay.setText("ERROR! Please report this to a System Administrator.");
        }finally{
        System.out.println("Friend Selector");
        }
    }                                              

    private String[] modelToSet(){
        String[] toReturn= new String[this.clubs.length+1];
        toReturn[0]="None Selected";
        for(int x=0; x<this.clubs.length;x++)
            toReturn[x+1]=this.clubs[x];
        
        return toReturn;
    }
    
    private void load(String loadFrom)throws IOException{
        System.out.println("Load");
        if(isFriends)
            this.loadFriends(loadFrom);
        else{
                File load= new File(this.storedAt+loadFrom+".txt");
                this.loadFile(load);
           }
    }
    
    private void loadFriends(String loadFrom)throws IOException{
        System.out.println("LoadFriends");
        File load=new File(this.storedAt+this.user+"/"+loadFrom+".txt");
        if(load.isFile())
            this.loadFile(load);
        else
            this.loadFile(new File(this.storedAt+loadFrom+"/"+this.user+".txt"));
        
    }
    
    private void send(String toSend) throws IOException{
        System.out.println("Send");
        if(this.currentFile!=null){
            FileWriter fileToWrite= new FileWriter(this.currentFile,true);
            PrintWriter write= new PrintWriter(fileToWrite);
            write.println(this.user+": "+toSend);
            write.close();
        }
        this.loadFile(this.currentFile);
        
    }
    
    private void loadFile(File loadFrom)throws IOException{
        this.currentFile=loadFrom;
        System.out.println("ELoad File");
        boolean userReg = false;
        for(String test:this.clubs){
            if((test+".txt").equals(loadFrom.getName()))
                userReg=true;
         }
        
        String select;
        if(this.isFriends)
            select="Friend";
        else
            select="Chat";
        
        File userFile = new File(this.user+select+".txt");
        
        if(!userReg){
            FileWriter temp = new FileWriter(userFile, true);
            PrintWriter add = new PrintWriter(temp);
            
            String toPrint="";
            for(int x=0; x+4<loadFrom.getName().length();x++)
                toPrint+=loadFrom.getName().charAt(x);
            add.println(toPrint);
            add.close();
            
            System.out.println("Adding "+toPrint);
            String[]tempClubs= new String[1+this.clubs.length];
            for(int x=0;x<this.clubs.length;x++)
                tempClubs[x]=this.clubs[x];
            tempClubs[tempClubs.length-1]=toPrint;
            this.clubs=tempClubs.clone();
            
            this.FriendSelector.addItem(toPrint);
        }
            
        
        if(!loadFrom.isFile())
            {
            loadFrom.createNewFile();
            this.MessageDisplay.setText("No Messages Exist yet.");
            }
            else
            {
                Scanner load=new Scanner(loadFrom);
                String finalPrint="";
                while(load.hasNextLine())
                    finalPrint+="\n"+load.nextLine();
                this.MessageDisplay.setText(finalPrint);
            }
    }
            

    // Variables declaration - do not modify                     
    private javax.swing.JMenu AddBooks;
    private javax.swing.JMenu BooksRated;
    private javax.swing.JMenu Browse;
    private javax.swing.JMenu DoNotUse;
    private javax.swing.JButton EnterButton;
    private javax.swing.JComboBox<String> FriendSelector;
    private javax.swing.JMenu MainMenu;
    private javax.swing.JTextArea MessageDisplay;
    private javax.swing.JTextField MessageInput;
    private javax.swing.JMenu RandomBook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}