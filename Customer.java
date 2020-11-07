public class Customer {
    private String firstName;
    private String email;
    private String lastName;
    private String password;
    private String username;
    private SurveyData surveyData;

    public Customer(){}

    public Customer(String firstName, String email, String lastName, String password, String username, SurveyData surveyData){
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.password = password;
        this.username = username;
        this.surveyData = new SurveyData(surveyData);
    }//end of constructor

    public Customer(Customer customer){
        this.email = customer.email;
        this.firstName = customer.firstName;
        this.lastName = customer.lastName;
        this.password = customer.password;
        this.username = customer.username;
        this.surveyData = new SurveyData(customer.surveyData);
    }//end of constructor

    public SurveyData getSurveyData() {
        return surveyData;
    }//end of method getSurveyData

    public void setSurveyData(SurveyData surveyData) {
        this.surveyData = new SurveyData(surveyData);
    }//end of method setSurveyData

    public String getFirstName() {
        return firstName;
    }//end of method getFirstName

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }//end of method setFirstName

    public String getEmail() {
        return email;
    }//end of method getEmail

    public void setEmail(String email) {
        this.email = email;
    }//end of method setEmail

    public String getLastName() {
        return lastName;
    }//end of method getLastName

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }//end of method setLastName

    public String getPassword() {
        return password;
    }//end of method getPassword

    public void setPassword(String password) {
        this.password = password;
    }//end of method setPassword

    public String getUsername() {
        return username;
    }//end of method getUsername

    public void setUsername(String username) {
        this.username = username;
    }//end of method setUsername

    public boolean equals(Customer other){
        if(this.username.equals(other.username)){
            return true;
        }else{
            return false;
        }//end if else statment
    }//end of method equals
}//end of class Customer