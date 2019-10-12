package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Genre;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class GenreDto {
    private String id;

    private String name;

    private String origin;

    public GenreDto() {
    }

    public GenreDto(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }

    public GenreDto(Genre genre) {
        this.id = genre.getId();
        this.name = genre.getName();
        this.origin = genre.getOrigin();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }


    public void validate() {
        if (name == null || name.isEmpty() || origin == null || origin.isEmpty()) {
            throw new BadRequestException("Incomplete GenreDto");
        }
    }

    @Override
    public String toString() {
        return "GenreDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
