package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Genre {
    @Id
    private int id;

    private String genre;

    private String origin;

    public Genre(String genre, String origin) {
        this.genre = genre;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
