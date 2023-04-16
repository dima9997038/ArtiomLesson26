package by.teachmeskills.penkovsky.homework25;

import java.util.List;

public class Application {
    public static void main(String[] args) throws Exception {
        ShowRepository repo = new ShowRepository();
        List<Show> shows = repo.getAllShows();

        for (Show show : shows) {
            System.out.println(show);
        }
    }
}
