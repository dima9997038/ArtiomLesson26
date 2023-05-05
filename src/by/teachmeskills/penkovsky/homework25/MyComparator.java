package by.teachmeskills.penkovsky.homework25;

import java.util.Comparator;
import java.util.Map;

public class MyComparator implements Comparator<Show> {
    private final Map<String, String> conditions;

    public MyComparator(Map<String, String> conditions) {
        this.conditions = conditions;
    }

    @Override
    public int compare(Show show1, Show show2) {
        for (Map.Entry<String, String> entry : conditions.entrySet()) {
            switch (entry.getKey()) {
                case ("title") -> {
                    if (entry.getValue().equals("asc")) {
                        return show1.getTitle().compareTo(show2.getTitle());
                    }
                    if (entry.getValue().equals("desc")) {
                        return show1.getTitle().compareTo(show2.getTitle());
                    }
                }
                case ("releaseYear") -> {
                    if (entry.getValue().equals("asc")) {
                        return Integer.compare(show1.getReleaseYear(), show2.getReleaseYear());
                    }
                    if (entry.getValue().equals("desc")) {
                        return Integer.compare(show2.getReleaseYear(), show1.getReleaseYear());
                    }
                }
                case ("rating") -> {
                    if (entry.getValue().equals("asc")) {
                        return Float.compare(show2.getRating(), show1.getRating());
                    }
                    if (entry.getValue().equals("desc")) {
                        return Float.compare(show1.getRating(), show2.getRating());
                    }
                }
                case ("numberOfRatings") -> {
                    if (entry.getValue().equals("asc")) {
                        return Integer.compare(show1.getNumberOfRatings(), show2.getNumberOfRatings());
                    }
                    if (entry.getValue().equals("desc")) {
                        return Integer.compare(show2.getNumberOfRatings(), show1.getNumberOfRatings());
                    }
                }
            }
        }
        return 0;
    }

}
