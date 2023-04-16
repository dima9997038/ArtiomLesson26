package by.teachmeskills.penkovsky.homework25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ShowRepository {

    private Film csvToFilm(String[] data) {
        String title = data[0];
        int releaseYear = Integer.parseInt(data[1]);
        String country = data[2];
        float rating = Float.parseFloat(data[3]);
        int numberOfRatings = Integer.parseInt(data[4]);
        return new Film(title, releaseYear, country, rating, numberOfRatings);
    }

    private Series csvToSeries(String[] data) {
        String title = data[0];
        int releaseYear = Integer.parseInt(data[1]);
        int lastEpisodeYear = Integer.parseInt(data[2]);
        String country = data[3];
        int numberOfSeasons = Integer.parseInt(data[4]);
        int numberOfEpisodes = Integer.parseInt(data[5]);
        float rating = Float.parseFloat(data[6]);
        int numberOfRatings = Integer.parseInt(data[7]);
        return new Series(title, releaseYear, country, rating, numberOfRatings,
                lastEpisodeYear, numberOfSeasons, numberOfEpisodes);
    }

    private List<String[]> readCsvFile(String fileName) throws Exception {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
        }

        return data;
    }

    public List<Show> getAllShows() throws Exception {
        List<Show> shows = new ArrayList<>();
        List<String[]> filmsData = readCsvFile("films.csv");
        List<String[]> seriesData = readCsvFile("series.csv");

        for (String[] row : filmsData) {
            shows.add(csvToFilm(row));
        }

        for (String[] row : seriesData) {
            shows.add(csvToSeries(row));
        }

        return shows;
    }
}