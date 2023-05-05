package by.teachmeskills.penkovsky.homework25;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Show implements Comparable<LinkedHashMap<String, Show>> {
    private final String title;
    private final int releaseYear;
    private final String country;
    private final float rating;
    private final int numberOfRatings;

    public Show(String title, int releaseYear, String country, float rating, int numberOfRatings) {
        if (releaseYear < 1) {
            throw new IllegalArgumentException("Ошибка! Год выпуска должен быть положительным числом!");
        }
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Ошибка! Рейтинг должен быть между 0 и 10!");
        }
        this.title = title;
        this.releaseYear = releaseYear;
        this.country = country;
        this.rating = rating;
        this.numberOfRatings = numberOfRatings;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getCountry() {
        return country;
    }

    public float getRating() {
        return rating;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    @Override
    public int compareTo(LinkedHashMap<String, Show> conditions) {
        if (conditions == null) {
            return 0;
        }
        int val = 0;
        for (Map.Entry<String, Show> entry : conditions.entrySet()) {
            Show value = entry.getValue();
            switch (entry.getKey()) {
                case ("title:asc") -> {
                    String title = this.getTitle();
                    val = title.compareTo(value.getTitle());
                    if (val != 0) {
                        return val;
                    }
                }
                case ("title:desc") -> {
                    String title = this.getTitle();
                    val = title.compareTo(value.getTitle());
                    if (val != 0) {
                        return val * -1;
                    }
                }
                case ("releaseYear:asc") -> {
                    Integer releaseYear = this.getReleaseYear();
                    val = releaseYear.compareTo(value.getReleaseYear());
                    if (val != 0) {
                        return val;
                    }
                }
                case ("releaseYear:desc") -> {
                    Integer releaseYear = this.getReleaseYear();
                    val = releaseYear.compareTo(value.getReleaseYear());
                    if (val != 0) {
                        return val * -1;
                    }
                }
                case ("rating:asc") -> {
                    Float rating = this.getRating();
                    val = rating.compareTo(value.getRating());
                    if (val != 0) {
                        return val;
                    }
                }
                case ("rating:desc") -> {
                    Float rating = this.getRating();
                    val = rating.compareTo(value.getRating());
                    if (val != 0) {
                        return val * -1;
                    }
                }
                case ("numberOfRatings:asc") -> {
                    Integer numberOfRatings = this.getNumberOfRatings();
                    val = numberOfRatings.compareTo(value.getNumberOfRatings());
                    if (val != 0) {
                        return val;
                    }
                }
                case ("numberOfRatings:desc") -> {
                    Integer numberOfRatings = this.getNumberOfRatings();
                    val = numberOfRatings.compareTo(value.getNumberOfRatings());
                    if (val != 0) {
                        return val * -1;
                    }
                }
            }
        }
        return val;
    }
}
