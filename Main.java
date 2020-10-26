public class Main {
    public static void main(String [] args){
        Customer customer = new Customer("Jai", 
            "jai@gmail.com", 
            "moraes", 
            "Jai_the Guy"
            , "jai"
            , new SurveyData("Pranav", 
            "Pranav", "Pranav"));

        new mainMenu(customer).setVisible(true);
    }
}
