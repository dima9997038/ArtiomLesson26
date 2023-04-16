package by.teachmeskills.penkovsky.homework25;

public class Series extends Show {
    private final int lastEpisodeYear;
    private final int numberOfSeasons;
    private final int numberOfEpisodes;

    public Series(String title, int releaseYear, String country, float rating, int numberOfRatings,
                  int lastEpisodeYear, int numberOfSeasons, int numberOfEpisodes) {
        super(title, releaseYear, country, rating, numberOfRatings);
        if (lastEpisodeYear < releaseYear) {
            throw new IllegalArgumentException("Ошибка! Год последнего эпизода должен быть больше или равен году выпуска!");
        }
        if (numberOfSeasons < 1) {
            throw new IllegalArgumentException("numberOfSeasons must be a positive number");
        }
        if (numberOfEpisodes < 1) {
            throw new IllegalArgumentException("Ошибка! Количество сезонов должно быть положительным числом!");
        }
        this.lastEpisodeYear = lastEpisodeYear;
        this.numberOfSeasons = numberOfSeasons;
        this.numberOfEpisodes = numberOfEpisodes;
    }

    @Override
    public String toString() {
        return "Series{" +
                "title='" + getTitle() + '\'' +
                ", releaseYear=" + getReleaseYear() +
                ", country='" + getCountry() + '\'' +
                ", rating=" + getRating() +
                ", numberOfRatings=" + getNumberOfRatings() +
                ", lastEpisodeYear=" + lastEpisodeYear +
                ", numberOfSeasons=" + numberOfSeasons +
                ", numberOfEpisodes=" + numberOfEpisodes +
                '}';
    }
}
