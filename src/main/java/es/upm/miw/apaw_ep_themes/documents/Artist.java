package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class Artist {

    @Id
    private String id;

    private String name;

    private String country;

    private LocalDateTime birthdate;

    private List<Album> albums;

    public Artist(String name, String country, LocalDateTime birthdate) {
        this.name = name;
        this.country = country;
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    public List<Album> getAlbums() {
        return albums;
    }
}
