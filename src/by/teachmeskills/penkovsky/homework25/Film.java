package by.teachmeskills.penkovsky.homework25;

public class Film extends Show {

    public Film(String title, int releaseYear, String country, float rating, int numberOfRatings) {
        super(title, releaseYear, country, rating, numberOfRatings);
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + getTitle() + '\'' +
                ", releaseYear=" + getReleaseYear() +
                ", country='" + getCountry() + '\'' +
                ", rating=" + getRating() +
                ", numberOfRatings=" + getNumberOfRatings() +
                '}';
    }
}
