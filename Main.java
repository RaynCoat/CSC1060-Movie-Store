/**
 * @author Raymond Boutin
 * @version 5/4/2024
 */
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        String password, keyword, sortBy;
        int option, ascOption;
        boolean ascending = false;
        // Create a MovieStore instance
        MovieStore store = new MovieStore();
        Scanner input = new Scanner(System.in);
        // Ask for password
        System.out.print("Enter password: ");
        password = input.nextLine();
        // Toggle manager mode based on password
        store.toggleManagerMode(password);
        // If in manager mode, provide options to add or remove movies
        if (store.isManagerMode()) {
            System.out.println("Manager Mode: You can add or remove movies.");
            // Example usage:
            // store.addMovie(new Movie("Movie5", "Actor5", "Actress5", 2020, "Sci-Fi"));
            // store.removeMovie("Movie3");
        } else {
            System.out.println("User Mode: You can search or sort movies.");
        }

        // Provide options for searching or sorting movies
        System.out.println("Options:");
        System.out.println("1. Search movie");
        System.out.println("2. Sort movie");
        System.out.print("Choose an option: ");
        option = input.nextInt();
        System.out.println(); // Consume newline

        switch (option) {
            case 1:
                // Search for movies
                System.out.print("Enter keyword to search: ");
                keyword = input.nextLine();
                store.searchMovie(keyword);
                break;
            case 2:
                // Sort movies
                System.out.println("Sort options: title, actor, actress");
                System.out.print("Choose a sort option: ");
                sortBy = input.nextLine();
                System.out.printf("Ascending (1) or Descending (2): ");
                ascOption = input.nextInt();
                if (ascOption == 1){
                    ascending = true;
                } else if ( ascOption == 2){
                    ascending = false;
                }
                else{
                    System.out.println("Invalid Option!");
                }
                store.sortMovies(sortBy, ascending);
                store.displayAllMovies();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}