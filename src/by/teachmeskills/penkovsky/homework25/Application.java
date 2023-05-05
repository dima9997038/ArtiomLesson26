package by.teachmeskills.penkovsky.homework25;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    public void start() {
        ShowRepository repository = new ShowRepository();
        List<Show> shows;
        try {
            shows = repository.getAllShows();
        } catch (Exception e) {
            System.out.println("Error loading shows from file");
            return;
        }

        List<Show> filteredShows = customPredicate(shows);
        customComparing(filteredShows);
    }

    private List<Show> customPredicate(List<Show> shows) {
        Scanner scanner = new Scanner(System.in);

        // Список предикатов для фильтрации
        List<Predicate<Show>> predicates = new ArrayList<>();

        // Выбор критериев фильтрации
        choiceFilters();
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
            choiceFilters();
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        // Фильтрация списка шоу с помощью выбранных предикатов
        List<Show> filteredShows = shows;
        for (Predicate<Show> predicate : predicates) {
            filteredShows = filteredShows
                    .stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
        }
        System.out.println("Filtered and sorted list of shows:");
        for (Show show : filteredShows) {
            System.out.println(show.getTitle() + " | " + show.getReleaseYear() + " | " + show.getCountry() + " | " + show.getRating() + " | " + show.getNumberOfRatings());
        }
        return filteredShows;
    }


    private void customComparing(List<Show> shows) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Show> conditions = new LinkedHashMap<>();
        LinkedHashMap<String, String> keyOfConditional = new LinkedHashMap<>();
        choiceCriteria();
        boolean forLoop = true;
        int choice = scanner.nextInt();
        scanner.nextLine();
        while (forLoop) {
            switch (choice) {
                case 1 -> {
                    System.out.println("Sort in ascending or descending order (a/d)?");
                    if (scanner.nextLine().trim().equalsIgnoreCase("d")) {
                        keyOfConditional.put("title", "desc");
                    } else {
                        keyOfConditional.put("title", "asc");
                    }
                }
                case 2 -> {
                    System.out.println("Sort in ascending or descending order (a/d)?");
                    if (scanner.nextLine().trim().equalsIgnoreCase("d")) {
                        keyOfConditional.put("releaseYear", "desc");
                    } else {
                        keyOfConditional.put("releaseYear", "asc");
                    }
                }
                case 3 -> {
                    System.out.println("Sort in ascending or descending order (a/d)?");
                    if (scanner.nextLine().trim().equalsIgnoreCase("d")) {
                        keyOfConditional.put("rating", "desc");
                    } else {
                        keyOfConditional.put("rating", "asc");
                    }
                }
                case 4 -> {
                    System.out.println("Sort in ascending or descending order (a/d)?");
                    if (scanner.nextLine().trim().equalsIgnoreCase("d")) {
                        keyOfConditional.put("numberOfRatings", "desc");
                    } else {
                        keyOfConditional.put("numberOfRatings", "asc");
                    }
                }
                case 0 -> {
                    if (!keyOfConditional.isEmpty()) {
                        forLoop = false;
                    } else {
                        System.out.println("You must select at least one criteria");
                    }
                }
                default -> System.out.println("Invalid choice");
            }
            if (forLoop) {
                choiceCriteria();
                choice = scanner.nextInt();
                scanner.nextLine();
            }

        }
        shows.stream()
                .sorted((h1, h2) -> {
                    keyOfConditional.forEach((key, value) -> conditions.put(key + ":" + value, h2));
                    return h1.compareTo(conditions);
                })
                .forEach(System.out::println);
    }

    private static void choiceCriteria() {
        System.out.println("Choose sorting criteria (press 0 to finish):");
        System.out.println("1. By title");
        System.out.println("2. By release year");
        System.out.println("3. By rating");
        System.out.println("4. By number of ratings");
    }

    private static void choiceFilters() {
        System.out.println("Choose filter criteria (press 0 to finish):");
        System.out.println("1. By country of release");
        System.out.println("2. By year of release");
        System.out.println("3. By rating");
        System.out.println("4. By number of ratings");
        System.out.println("5. By title");
        System.out.println("6. No filtering");
    }
}