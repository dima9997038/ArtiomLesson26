package by.teachmeskills.penkovsky.homework25;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        ShowRepository repository = new ShowRepository();
        List<Show> shows;
        try {
            shows = repository.getAllShows();
        } catch (Exception e) {
            System.out.println("Error loading shows from file");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        // Список предикатов для фильтрации
        List<Predicate<Show>> predicates = new ArrayList<>();

        // Выбор критериев фильтрации
        System.out.println("Choose filter criteria (press 0 to finish):");
        System.out.println("1. By country of release");
        System.out.println("2. By year of release");
        System.out.println("3. By rating");
        System.out.println("4. By number of ratings");
        System.out.println("5. By title");
        System.out.println("6. No filtering");
        int choice = scanner.nextInt();
        scanner.nextLine();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    System.out.println("Enter country of release:");
                    String country = scanner.next();
                    predicates.add(show -> show.getCountry().equals(country));
                    break;
                case 2:
                    System.out.println("Enter year of release:");
                    int year = scanner.nextInt();
                    predicates.add(show -> show.getReleaseYear() == year);
                    break;
                case 3:
                    System.out.println("Enter minimum rating:");
                    double minRating = scanner.nextDouble();
                    System.out.println("Enter maximum rating:");
                    double maxRating = scanner.nextDouble();
                    scanner.nextLine(); // добавляем, чтобы считать символ новой строки после ввода maxRating
                    if (minRating > maxRating) {
                        double temp = minRating;
                        minRating = maxRating;
                        maxRating = temp;
                    }
                    if (minRating < 0 || maxRating > 10) {
                        System.out.println("Invalid rating values. Rating must be between 0 and 10");
                        break;
                    }
                    final double finalMinRating = minRating;
                    final double finalMaxRating = maxRating;
                    predicates.add(show -> show.getRating() >= finalMinRating && show.getRating() <= finalMaxRating);
                    break;
                case 4:
                    System.out.println("Enter minimum number of ratings:");
                    int numOfRatings = scanner.nextInt();
                    predicates.add(show -> show.getNumberOfRatings() >= numOfRatings);
                    break;
                case 5:
                    System.out.println("Enter substring to search in title:");
                    String searchString = scanner.nextLine().trim().toLowerCase();
                    predicates.add(show -> show.getTitle().toLowerCase().contains(searchString));
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println("Choose filter criteria (press 0 to finish):");
            System.out.println("1. By country of release");
            System.out.println("2. By year of release");
            System.out.println("3. By rating");
            System.out.println("4. By number of ratings");
            System.out.println("5. By title");
            System.out.println("6. No filtering");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        // Фильтрация списка шоу с помощью выбранных предикатов
        List<Show> filteredShows = shows;
        for (Predicate<Show> predicate : predicates) {
            filteredShows = filteredShows.stream().filter(predicate).collect(Collectors.toList());
        }

        // Выбор критерия сортировки
        System.out.println("Choose sorting criteria:");
        System.out.println("1. By title");
        System.out.println("2. By release year");
        System.out.println("3. By rating");
        System.out.println("4. By number of ratings");
        int sortChoice = scanner.nextInt();
        scanner.nextLine();
        Comparator<Show> comparator = null;
        switch (sortChoice) {
            case 1:
                comparator = Comparator.comparing(Show::getTitle);
                break;
            case 2:
                comparator = Comparator.comparingInt(Show::getReleaseYear);
                break;
            case 3:
                comparator = Comparator.comparingDouble(Show::getRating);
                break;
            case 4:
                comparator = Comparator.comparingInt(Show::getNumberOfRatings);
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        // Сортировка списка шоу с помощью выбранного критерия
        System.out.println("Sort in ascending or descending order (a/d)?");
        String sortOrder = scanner.nextLine().trim().toLowerCase();
        if (sortOrder.equals("d")) {
            comparator = comparator.reversed();
        }
        filteredShows.sort(comparator);

        // Вывод списка шоу на экран
        System.out.println("Filtered and sorted list of shows:");
        for (Show show : filteredShows) {
            System.out.println(show.getTitle() + " | " + show.getReleaseYear() + " | " + show.getCountry() + " | " + show.getRating() + " | " + show.getNumberOfRatings());
        }
    }
}