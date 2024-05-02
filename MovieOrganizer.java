package bankproc;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieOrganizer {

    private ArrayList<Movie> movies;
    private static Scanner scanner;

    public MovieOrganizer() {
        movies = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addMovie() {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.print("Enter movie director: ");
        String director = scanner.nextLine();
        System.out.print("Enter movie year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after integer input
        System.out.print("Enter movie genre: ");
        String genre = scanner.nextLine();

        movies.add(new Movie(title, director, year, genre));
        System.out.println("Movie added successfully!");
    }

    public void searchMoviesByTitle() {
        System.out.print("Enter movie title to search: ");
        String searchTitle = scanner.nextLine();

        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(searchTitle)) {
                movie.displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Movie not found!");
        }
    }

    public void searchMoviesByGenre() {
        System.out.print("Enter movie genre to search: ");
        String searchGenre = scanner.nextLine();

        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(searchGenre)) {
                movie.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No movies found in that genre!");
        }
    }

    public void displayAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies in collection!");
        } else {
            for (Movie movie : movies) {
                movie.displayInfo();
            }
        }
    }

    public static void main(String[] args) {
        MovieOrganizer organizer = new MovieOrganizer();

        int choice;
        do {
            System.out.println("\nMovie Collection Organizer");
            System.out.println("1. Add Movie");
            System.out.println("2. Search Movies by Title");
            System.out.println("3. Search Movies by Genre");
            System.out.println("4. Display All Movies");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    organizer.addMovie();
                    break;
                case 2:
                    organizer.searchMoviesByTitle();
                    break;
                case 3:
                    organizer.searchMoviesByGenre();
                    break;
                case 4:
                    organizer.displayAllMovies();
                    break;
                case 5:
                    System.out.println("Exiting Movie Collection Organizer!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}

