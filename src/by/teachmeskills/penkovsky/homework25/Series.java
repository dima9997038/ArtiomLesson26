package by.teachmeskills.penkovsky.homework25;

public class Series extends Show {
    private int lastEpisodeYear;
    private int numberOfSeasons;
    private int numberOfEpisodes;

    public Series(String title, int releaseYear, String country, float rating, int numberOfRatings,
                  int lastEpisodeYear, int numberOfSeasons, int numberOfEpisodes) {
        super(title, releaseYear, country, rating, numberOfRatings);
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
