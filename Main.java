import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        // //customer for program
        Customer customer = new Customer("Jai", //FIRSTNAME
        "jai@gmail.com", //EMAIL
        "moraes", //LASTNAME
        "Jai_the Guy" //PASSWORD
        , "jai" //USERNAME
        , new SurveyData("tragedy", //SURVEY DATA
        "Pranav", "Pranav"));

        //show main menu
        new mainMenu(customer).setVisible(true);

        // try {
        //     new HelpPage("help.txt").setVisible(true);
        // } catch (FileNotFoundException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        //new AdminPanel(customer).setVisible(true);
    }//end of main method
}//end of class Main
