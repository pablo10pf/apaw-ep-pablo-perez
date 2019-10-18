package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Artist;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

import java.time.LocalDateTime;

public class ArtistDto {

    private String id;

    private String name;

    private String country;

    private LocalDateTime birthdate;

    public ArtistDto() {
        //Empty for framework
    }

    public ArtistDto(Artist artist) {
        this.name = artist.getName();
        this.country = artist.getCountry();
        this.birthdate = artist.getBirthdate();
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

    public void validate() {
        if (name == null || name.isEmpty() || country == null || country.isEmpty()) {
            throw new BadRequestException("Incomplete ArtistDto");
        }
    }
}
