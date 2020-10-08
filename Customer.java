public class Customer {
    private String firstName;
    private String email;
    private String lastName;
    private String password;
    private String username;
    private SurveyGenre surveyGenre;
    private SurveyBook surveyBook;
    private SurveyAuthor surveyAuthor;

    public SurveyData getSurveyData() {
        return surveyData;
    }

    public void setSurveyData(SurveyGenre surveyGen, SurveyBook SurveyBoo, SurveyAuthor SurveyAuth) {
        surveyGenre = new SurveyGenre(surveyGen);
        surveyBook = new SurveyBook(surveyBoo);
        surveyAuthor = new SurveyAuthor(surveyAuth);
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
