/**
 * @author Raymond Boutin
 * @version 5/4/2024
 */
class Movie {
    private String title;
    private String leadingActor;
    private String leadingActress;
    private int releaseYear;
    private String genre;

    // Constructor
    public Movie(String title, String leadingActor, String leadingActress, int releaseYear, String genre) {
        this.title = title;
        this.leadingActor = leadingActor;
        this.leadingActress = leadingActress;
        this.releaseYear = releaseYear;
        this.genre = genre;
        }

    // Getter for title
    public String getTitle() {
        return title;
    }
    // Getter for leading actor
    public String getActor() {
        return leadingActor;
    }
    // Getter for leading actress
    public String getActress() {
        return leadingActress;
    }
    // Getter for release year
    public int getYear() {
        return releaseYear;
    }
    // Getter for genre
    public String getGenre() {
        return genre;
    }
    // Custom toString method
    public String toString() {
        return "Title: " + title + ", Actor: " + leadingActor + ", Actress: " + leadingActress +
                ", Year: " + releaseYear + ", Genre: " + genre;
    }
}