/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RandomBook extends javax.swing.JFrame {
    private Customer customer;

    /**
     * Creates new form RandomBook
     */
    public RandomBook(Customer customer) {
        this.customer = new Customer(customer);
        initComponents();
        algorithm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        title = new javax.swing.JLabel();
        bookCover3 = new javax.swing.JLabel();
        bookCover1 = new javax.swing.JLabel();
        bookCover2 = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        title3 = new javax.swing.JLabel();
        author3 = new javax.swing.JLabel();
        author2 = new javax.swing.JLabel();
        author1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        logo = new javax.swing.JMenu();
        recMenu = new javax.swing.JMenu();
        menuMenu = new javax.swing.JMenu();
        browseMenu = new javax.swing.JMenu();
        ratedMenu = new javax.swing.JMenu();
        addMenu = new javax.swing.JMenu();
        friendsMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        title.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        title.setText("Random Books You May Like!");

        bookCover3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookCover3.setIcon(new javax.swing.ImageIcon(
                "C:\\Users\\kalsi\\Documents\\NetBeansProjects\\Booksmart_App\\logo_Menu.png")); // NOI18N

        bookCover1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookCover1.setIcon(new javax.swing.ImageIcon(
                "C:\\Users\\kalsi\\Documents\\NetBeansProjects\\Booksmart_App\\logo_Menu.png")); // NOI18N

        bookCover2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookCover2.setIcon(new javax.swing.ImageIcon(
                "C:\\Users\\kalsi\\Documents\\NetBeansProjects\\Booksmart_App\\logo_Menu.png")); // NOI18N

        title2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("Title PlaceHolder");

        title1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("Title PlaceHolder");
        title1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        title3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        title3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title3.setText("Title PlaceHolder");

        author3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        author3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        author3.setText("Author Place Holder");

        author2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        author2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        author2.setText("Author Place Holder");

        author1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        author1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        author1.setText("Author Place Holder");

        logo.setIcon(new javax.swing.ImageIcon(
                "C:\\Users\\kalsi\\Documents\\NetBeansProjects\\Booksmart_App\\logo_Menu.png")); // NOI18N
        jMenuBar1.add(logo);

        recMenu.setText("Recommended");
        recMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(recMenu);

        recMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recMenuMouseClicked(evt);
            }
        });

        menuMenu.setText("Main Menu");
        menuMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(menuMenu);

        menuMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMenuMouseClicked(evt);
            }
        });

        browseMenu.setText("Browse");
        browseMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(browseMenu);

        browseMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseMenuMouseClicked(evt);
            }
        });

        ratedMenu.setText("Book's You've Rated");
        ratedMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(ratedMenu);

        ratedMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ratedMenuMouseClicked(evt);
            }
        });

        addMenu.setText("Add Books");
        addMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(addMenu);

        addMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMenuMouseClicked(evt);
            }
        });

        friendsMenu.setText("Clubs");
        friendsMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(friendsMenu);

        friendsMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                friendsMenuMouseClicked(evt);
            }
        });

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(80, 80, 80)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 640,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(80, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(title1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup().addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(author1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(bookCover1, javax.swing.GroupLayout.DEFAULT_SIZE, 233,
                                                        Short.MAX_VALUE))))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(author2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(title2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bookCover2, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bookCover3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(title3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(author3, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                        .addGap(20, 20, 20)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout.createSequentialGroup().addComponent(title).addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(bookCover3, javax.swing.GroupLayout.PREFERRED_SIZE, 293,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bookCover2, javax.swing.GroupLayout.PREFERRED_SIZE, 293,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bookCover1, javax.swing.GroupLayout.PREFERRED_SIZE, 293,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(title2).addComponent(title3).addComponent(title1))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(author3).addComponent(author1).addComponent(author2))
                                        .addGap(0, 22, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    private void friendsMenuMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            new Friends_Page(this.customer, null).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setVisible(false);

    }

    private void menuMenuMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            new mainMenu(this.customer).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setVisible(false);
    }

    private void browseMenuMouseClicked(java.awt.event.MouseEvent evt) {
        new BrowseMenu(customer).setVisible(true);
        this.setVisible(false);
    }

    private void ratedMenuMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            new SeeRated(this.customer).setVisible(true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.setVisible(false);        
    }

    private void addMenuMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            new addBooks(this.customer).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.setVisible(false);        
    }
    
    private void recMenuMouseClicked(java.awt.event.MouseEvent evt) {                                  
        new Recommend(this.customer).setVisible(true);

        this.setVisible(false);        
    }
    
    public ArrayList<Integer> getRated() {
        ArrayList<Integer> alreadyRated = new ArrayList<>();

        File myFile = new File("stars/" + this.customer.getUsername() + "-rated.txt"); // pranav change!!!! help me!!!
        Scanner inputFile = null;
        try {
            inputFile = new Scanner(myFile);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        while(inputFile.hasNextLine()){
            String [] line = inputFile.nextLine().split(",");

            alreadyRated.add(Integer.parseInt(line[2]));
        }//end while loop

        return alreadyRated;
    }//end getRated

    public void algorithm(){
        final String BOOK_DIR = "images";
        final String bookList = "data/books_update.txt";

        ArrayList <Integer> alreadyRated = getRated();

        File dir = new File(BOOK_DIR);
        File [] bookCovers = dir.listFiles();

        int [] covers = new int [3];
        int [] alreadySelected = {-1,-1,-1};

        for(int i = 0; i < covers.length; i++){
            boolean run = true;

            while(run){
                covers[i] = (int) (Math.random()*bookCovers.length);

                for(int j = i-1; j > -1; j--){
                    if(covers[i] == alreadySelected[j] || alreadyRated.contains(covers[i])){
                        run = false;
                        break;
                    }
                }

                run = !run;
            }
            alreadySelected[i] = covers[i];
        }

        String bookCover1Path = "images\\" + (covers[0]+1) + ".jpg";
        String bookCover2Path = "images\\" + (covers[1]+1) + ".jpg";
        String bookCover3Path = "images\\" + (covers[2]+1) + ".jpg";

        bookCover1.setIcon(new javax.swing.ImageIcon(bookCover1Path));
        bookCover2.setIcon(new javax.swing.ImageIcon(bookCover2Path));
        bookCover3.setIcon(new javax.swing.ImageIcon(bookCover3Path));


        int [] coversCopy = new int[covers.length];

        for(int i = 0; i < coversCopy.length; i++){
            coversCopy[i] = covers[i]; 
        }

        Arrays.sort(coversCopy);

        HashMap <Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < coversCopy.length; i++){
            for(int j = 0; j < coversCopy.length; j++){
                if(coversCopy[i] == covers[j]){
                    map.put(coversCopy[i], j);
                    break;
                }
            }
        }   
        System.out.println(map);

        String [] [] info = {
            {"PlaceHolder","PlaceHolder","PlaceHolder"},
            {"PlaceHolder","PlaceHolder","PlaceHolder"}
        };

        File file = new File(bookList);

        Scanner reader = null;

        try{
            reader = new Scanner(file);
        }catch(Exception e){
            e.printStackTrace();
        }

        int indexCount = 0;
        int count = 0;
        
        System.out.println("----------------------------");

        while(reader.hasNextLine()){
            boolean cont = false;

            if(count == coversCopy[indexCount]){
                cont = true;
            }else{
                System.out.println(count + " " + coversCopy[indexCount]);
            }

            if(!cont){
                reader.nextLine();
                count++;
            }else{
                String [] line = reader.nextLine().split(",");

                System.out.println(line[0] + " " + line[1]);
                
                System.out.println(indexCount);

                info[0][map.get(coversCopy[indexCount])] = line[0];
                info[1][map.get(coversCopy[indexCount])] = line[1];

                indexCount++;
                count++;
            }

            if(indexCount == 3){
                break;
            }
        }

        title1.setText(info[0][0]);
        title2.setText(info[0][1]);
        title3.setText(info[0][2]);

        author1.setText(info[1][0]);
        author2.setText(info[1][1]);
        author3.setText(info[1][2]);
        
        System.out.println(Arrays.toString(info));
    }//end of method algorithm
    
    // /**
    //  * @param args the command line arguments
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
    //         java.util.logging.Logger.getLogger(RandomBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(RandomBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(RandomBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(RandomBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the form */
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new RandomBook().setVisible(true);
    //         }
    //     });
    // }

    // Variables declaration - do not modify                     
    private javax.swing.JMenu addMenu;
    private javax.swing.JLabel author1;
    private javax.swing.JLabel author2;
    private javax.swing.JLabel author3;
    private javax.swing.JLabel bookCover1;
    private javax.swing.JLabel bookCover2;
    private javax.swing.JLabel bookCover3;
    private javax.swing.JMenu browseMenu;
    private javax.swing.JMenu friendsMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu logo;
    private javax.swing.JMenu menuMenu;
    private javax.swing.JMenu ratedMenu;
    private javax.swing.JMenu recMenu;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    // End of variables declaration                   
}
