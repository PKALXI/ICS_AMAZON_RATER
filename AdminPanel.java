/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.Runtime;
import java.util.ArrayList;

/**
 *
 * @author jaimoraes
 */
public class AdminPanel extends javax.swing.JFrame {

    private Customer user;

    /**
     * Creates new form AdminPanel
     */
    public AdminPanel(Customer c) {
        initComponents();
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.Error.setText("");
        this.Display.setText("Type help for more commands.");
        this.user = new Customer(c);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Display = new javax.swing.JTextArea();
        Command = new javax.swing.JTextField();
        Enter = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        App = new javax.swing.JButton();
        Error = new javax.swing.JLabel();
        TitleText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Booksmart ~ ADMIN ACCESS");
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        Display.setColumns(20);
        Display.setRows(5);
        jScrollPane1.setViewportView(Display);

        Command.setText("Enter Command Here");
        Command.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CommandFocusGained(evt);
            }
        });
        Command.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommandActionPerformed(evt);
            }
        });

        Enter.setText("Enter");
        Enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterActionPerformed(evt);
            }
        });

        Reset.setText("Reset Console");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        App.setText("Go to App");
        App.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppActionPerformed(evt);
            }
        });

        Error.setForeground(new java.awt.Color(255, 0, 51));
        Error.setText("Error Messages");

        TitleText.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        TitleText.setText("Admin Console");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 354,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(App,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 334,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Command, javax.swing.GroupLayout.PREFERRED_SIZE, 603,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(Error)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(Enter,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 91,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TitleText).addGap(271, 271, 271)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(47, Short.MAX_VALUE).addComponent(TitleText).addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Command, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Enter))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(Error)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Reset).addComponent(App))
                        .addContainerGap()));

        pack();
    }// </editor-fold>

    // The following two are two ways to enter commands.
    /**
     * calls the command parsing method on the current input in Command.
     * 
     * @param evt clicking the ENTER button.
     */
    private void EnterActionPerformed(java.awt.event.ActionEvent evt) {
        this.parseCommand();
    }

    /**
     * calls the command parsing method on the current input in Command.
     * 
     * @param evt pressing ENTER in the command entry area.
     */
    private void CommandActionPerformed(java.awt.event.ActionEvent evt) {
        this.parseCommand();
    }

    /**
     * resets the command window to help clear view.
     * 
     * @param evt the reset button's action performed event.
     */
    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {
        this.Display.setText("");
        this.Error.setText("");
    }

    /**
     * Loads the regular app when that button is pressed.
     * 
     * @param evt the action performed event.
     */
    private void AppActionPerformed(java.awt.event.ActionEvent evt) {
        // PRANAV link to the main menu please.
    }

    /**
     * When focus is gained on the Command line, clear it so that a new command can
     * be typed.
     * 
     * @param evt the focusGained event
     */
    private void CommandFocusGained(java.awt.event.FocusEvent evt) {
        this.Command.setText("");
    }

    /**
     * parses command input and executes it.
     */
    public void parseCommand() {
        // clear error input
        this.Error.setText("");

        // seperate command input into a readable form.
        String[] sepInput = this.Command.getText().split("/");

        // length of sepInput if tree
        if (sepInput.length < 1)
            this.Error.setText("Error: not a valid command");
        else {

            // call correct comand depending tree
            if (sepInput[0].equalsIgnoreCase("help"))
                this.help();
            else if (sepInput[0].equalsIgnoreCase("delete"))
                this.delete(sepInput);
            else if (sepInput[0].equalsIgnoreCase("viewChat"))
                this.viewChat(sepInput);
            else
                this.Error.setText("Error: not a valid command");
        } // check the length of sepInput if tree

    }// parseCommand method

    private void help() {
        this.addText(
                "\n\n*********Commands********\n remember to split arguments via the use of a slash (e.g. delete/book/harry potter)\n\nhelp : displays a list of commands\n\nviewChat [String name of the chat] :\n displays all messages in that chat \n\ndelete [\"book\" or \"chat\" or \"user\"] [String name of thing to delete] :\n deletes listed item.");
    }

    private void delete(String[] input){
        if(input.length<3)
            this.Error.setText(this.Error.getText()+"Error: no parameters for 'delete' command");
        else{
            if(input[1].equalsIgnoreCase("book")||input[1].equalsIgnoreCase("chat")){
                //processing deleting the chat/books
                if(input[1].equalsIgnoreCase("chat")){
                    try{
                    PrintWriter clear = new PrintWriter(new File(input[2]+".txt"));
                    clear.close();
                    }catch(FileNotFoundException e){
                        this.Error.setText(this.Error.getText()+"Error: no chat with the given name.");
                        if(input[2].contains(".txt"))
                            this.Error.setText(this.Error.getText()+"try removing \".txt\".");
                    }//catch
                }else{
                    try{
                    File readFrom= new File("Books.txt");
                    Scanner sc= new Scanner(readFrom);
                    ArrayList<String> books = new ArrayList<>();
                    int index=-1;
                    int count=0;
                    while(sc.hasNextLine()){
                        String temp=sc.nextLine();
                        count++;
                        String[]process=temp.split(",");
                        if(process[1].equalsIgnoreCase(input[2])&&index==-1)
                            index=count;
                        else
                            books.add(temp);
                        
                    }
                    sc.close();
                    PrintWriter write= new PrintWriter(readFrom);
                    for(int x=1;x<books.size();x++)
                        write.println(books.get(x));
                    write.close();
                    
                    if(index==-1)
                        this.addText("No Books with that name found.");
                    else{
                    
                    //PRANAV please deletete the commets surrounding this                    
                    
                        String[] cmd = {
                         "python",
                         "delete_pi.py",
                            "images/"+index+".png",
                             };
                        Runtime.getRuntime().exec(cmd);    
                    }
                    }catch(Exception e){
                        this.addText("Error: Books file not found. Deletion failed.");
                    }//catch
                }//deleting tree
            }else
              this.Error.setText(this.Error.getText()+" Error: invalid parameters.");    
        }//checking String[] length to determine if there are the correct number of parameters or more
    }//delete method
    
    private void viewChat(String[] input){
        if(input.length!=2)
            this.Error.setText("Error: Invalid viewChat parameters.");
        else{
            File newFile= new File(input[1]+".txt");
            if(newFile.exists()){
                try{
                Scanner load = new Scanner(newFile);
                
                String finalPrint="";
                while(load.hasNextLine())
                    finalPrint+="\n"+load.nextLine();
                this.Display.setText(finalPrint);
                
                }catch(Exception e){
                    this.Error.setText("Error: File does not exist.");
                }//try catch 
                
            }else
                this.Error.setText("Chat does not exist");
        }//length if tree
    }//viewChat method

    
    /**
     * Adds the given argument to the display while keeping the old displayed messages
     * @param add what to add
     */
    private void addText(String add){
        String temp=this.Display.getText();
        temp+="\n"+add;
        this.Display.setText(temp);
    }//addDisplay method

    // Variables declaration - do not modify                     
    private javax.swing.JButton App;
    private javax.swing.JTextField Command;
    private javax.swing.JTextArea Display;
    private javax.swing.JButton Enter;
    private javax.swing.JLabel Error;
    private javax.swing.JButton Reset;
    private javax.swing.JLabel TitleText;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   

}//AdminPanel jFrame class