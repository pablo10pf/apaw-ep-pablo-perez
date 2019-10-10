package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Genre;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class GenreDto {
    private int id;

    private String genre;

    private String origin;

    public GenreDto() {
    }

    public GenreDto(String genre, String origin) {
        this.genre = genre;
        this.origin = origin;
    }

    public GenreDto(Genre genre) {
        this.id = genre.getId();
        this.genre = genre.getGenre();
        this.origin = genre.getOrigin();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void validate() {
        if (genre == null || genre.isEmpty() || origin == null || origin.isEmpty()) {
            throw new BadRequestException("Incomplete GenreDto");
        }
    }

    @Override
    public String toString() {
        return "GenreDto{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
