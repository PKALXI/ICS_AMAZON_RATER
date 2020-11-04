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
    }

    public Customer(Customer customer){
        this.email = customer.email;
        this.firstName = customer.firstName;
        this.lastName = customer.lastName;
        this.password = customer.password;
        this.username = customer.username;
        this.surveyData = new SurveyData(customer.surveyData);
    }

    public SurveyData getSurveyData() {
        return surveyData;
    }

    public void setSurveyData(SurveyData surveyData) {
        this.surveyData = new SurveyData(surveyData);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}