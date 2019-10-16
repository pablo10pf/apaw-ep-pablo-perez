package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Song;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class SongDto {
    private String id;

    private String title;

    private LocalTime duration;

    private String genreId;

    public SongDto() {
        //empty for framework
    }

    public SongDto(String title, LocalTime duration, String genreId) {
        this.title = title;
        this.duration = duration;
        this.genreId=genreId;
    }

    public SongDto(Song song) {
        this.id = song.getId();
        this.title = song.getTitle();
        this.duration = song.getDuration();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public void validate() {
        if (title == null || title.isEmpty() || duration == null || this.genreId == null || this.genreId.isEmpty()) {
            throw new BadRequestException("Incomplete SongDto");
        }
    }

    @Override
    public String toString() {
        return "SongDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", genreId='" + genreId + '\'' +
                '}';
    }
}
