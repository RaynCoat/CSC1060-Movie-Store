/**
 * @author Raymond Boutin
 * @version 5/4/2024
 */
import java.util.ArrayList;
public class MovieStore
{
    private ArrayList<Movie> movies;
    private boolean managerMode;
    private final String managerPassword = "your_password"; // Change this to your desired password
    boolean removed = false;

    // Constructor
    public MovieStore() {
        movies = new ArrayList<>();
        managerMode = false;
    }

    // Method to toggle manager mode based on password
    public void toggleManagerMode(String password) {
        managerMode = password.equals(managerPassword);
    }

    // Method to check if in manager mode
    public boolean isManagerMode() {
        return managerMode;
    }

    // Method to add a movie (only available in manager mode)
    public void addMovie(Movie movie) {
        if (managerMode)
            movies.add(movie);
        else
            System.out.println("Access denied. Manager mode required.");
    }

    // Method to remove a movie (only available in manager mode)
    public void removeMovie(String title) {
        if (managerMode) {
            for (int i = 0; i < movies.size(); i++) {
                Movie movie = movies.get(i);
                if (movie.getTitle().equalsIgnoreCase(title)) {
                    movies.remove(i);
                    removed = true;
                    break;
                }
            }
            if (removed)
                System.out.println("Movie removed successfully.");
            else
                System.out.println("Movie not found.");
        } else {
            System.out.println("Access denied. Manager mode required.");
        }
    }

    // Method to display all movies
    public void displayAllMovies() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    // Method to search for a movie by title, actor, actress, year, or genre
    public void searchMovie(String keyword) {
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    movie.getActor().toLowerCase().contains(keyword.toLowerCase()) ||
                    movie.getActress().toLowerCase().contains(keyword.toLowerCase()) ||
                    String.valueOf(movie.getYear()).contains(keyword) ||
                    movie.getGenre().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(movie);
            }
        }
    }
    // Method to sort movies by title, actor, or actress (A-Z or Z-A)
    public void sortMovies(String sortBy, boolean ascending) {
        if (sortBy.equalsIgnoreCase("title")) {
            bubbleSortByTitle(ascending);
        } else if (sortBy.equalsIgnoreCase("actor")) {
            bubbleSortByActor(ascending);
        } else if (sortBy.equalsIgnoreCase("actress")) {
            bubbleSortByActress(ascending);
        } else {
            System.out.println("Invalid sort option.");
        }
    }

    // Bubble sort by title
    private void bubbleSortByTitle(boolean ascending) {
        int n = movies.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((movies.get(j).getTitle().compareTo(movies.get(j + 1).getTitle())) > 0 == ascending) {
                    Movie temp = movies.get(j);
                    movies.set(j, movies.get(j + 1));
                    movies.set(j + 1, temp);
                }
            }
        }
    }

    // Bubble sort by actor
    private void bubbleSortByActor(boolean ascending) {
        int n = movies.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((movies.get(j).getActor().compareTo(movies.get(j + 1).getActor())) > 0 == ascending) {
                    Movie temp = movies.get(j);
                    movies.set(j, movies.get(j + 1));
                    movies.set(j + 1, temp);
                }
            }
        }
    }

    // Bubble sort by actress
    private void bubbleSortByActress(boolean ascending) {
        int n = movies.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((movies.get(j).getActress().compareTo(movies.get(j + 1).getActress())) > 0 == ascending) {
                    Movie temp = movies.get(j);
                    movies.set(j, movies.get(j + 1));
                    movies.set(j + 1, temp);
                }
            }
        }
    }
}