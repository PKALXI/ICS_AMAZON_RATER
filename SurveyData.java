public class SurveyData {
    private String favouriteGenre;
    private String favouriteBook;
    private String favouriteAuthor;

    public SurveyData(String favouriteGenre, String favouriteBook, String favouriteAuthor){
        this.favouriteAuthor = favouriteAuthor;
        this.favouriteBook = favouriteBook;
        this.favouriteGenre = favouriteGenre;
    }

    public SurveyData(SurveyData surveyData){
        this.favouriteAuthor = surveyData.favouriteAuthor;
        this.favouriteBook = surveyData.favouriteBook;
        this.favouriteGenre = surveyData.favouriteGenre;
    }

    public String getFavouriteGenre() {
        return favouriteGenre;
    }

    public void setFavouriteGenre(String favouriteGenre) {
        this.favouriteGenre = favouriteGenre;
    }

    public String getFavouriteBook() {
        return favouriteBook;
    }

    public void setFavouriteBook(String favouriteBook) {
        this.favouriteBook = favouriteBook;
    }

    public String getFavouriteAuthor() {
        return favouriteAuthor;
    }

    public void setFavouriteAuthor(String favouriteAuthor) {
        this.favouriteAuthor = favouriteAuthor;
    }
}