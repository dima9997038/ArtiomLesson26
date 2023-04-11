package by.teachmeskills.penkovsky.homework25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ShowRepository {

    public List<Show> getAllShows() {
        List<Show> shows = new ArrayList<>();

        try (BufferedReader filmsReader = new BufferedReader(new FileReader("films.csv"));
             BufferedReader seriesReader = new BufferedReader(new FileReader("series.csv"))) {

            String line;
            while ((line = filmsReader.readLine()) != null) {
                String[] data = line.split(",");
                String title = data[0];
                int releaseYear = Integer.parseInt(data[1]);
                String country = data[2];
                float rating = Float.parseFloat(data[3]);
                int numberOfRatings = Integer.parseInt(data[4]);

                shows.add(new Film(title, releaseYear, country, rating, numberOfRatings));
            }
            while ((line = seriesReader.readLine()) != null) {
                String[] data = line.split(",");
                String title = data[0];
                int releaseYear = Integer.parseInt(data[1]);
                int lastEpisodeYear = Integer.parseInt(data[2]);
                String country = data[3];
                int numberOfSeasons = Integer.parseInt(data[4]);
                int numberOfEpisodes = Integer.parseInt(data[5]);
                float rating = Float.parseFloat(data[6]);
                int numberOfRatings = Integer.parseInt(data[7]);

                shows.add(new Series(title, releaseYear, country, rating, numberOfRatings,
                        lastEpisodeYear, numberOfSeasons, numberOfEpisodes));
            }

        } catch (Exception e) {
            System.out.println("Произошла ошибка при чтении данных: " + e.getMessage());
        }

        return shows;
    }
    public static void main(String[] args) {
        ShowRepository repo = new ShowRepository();
        List<Show> shows = repo.getAllShows();

        for (Show show : shows) {
            System.out.println(show);
        }
    }
}
