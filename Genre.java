enum Genre {
    ACTION("action"), FANTASY("fantasy");

    private String genreString;
    
    Genre(String genreString){
        this.genreString = genreString;
    }

    @Override
    public String toString(){
        return this.genreString;
    }
}
