package by.teachmeskills.penkovsky.homework25;

public abstract class Show {
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
}
