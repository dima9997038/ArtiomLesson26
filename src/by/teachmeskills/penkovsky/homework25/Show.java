package by.teachmeskills.penkovsky.homework25;

public abstract class Show {
    private String title;
    private int releaseYear;
    private String country;
    private float rating;
    private int numberOfRatings;

    public Show(String title, int releaseYear, String country, float rating, int numberOfRatings) {
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
