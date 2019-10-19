package es.upm.miw.apaw_ep_themes.documents;

import java.time.LocalTime;

public class SongBuilder {
    private String title;
    private LocalTime duration;
    private Genre genre;

    public SongBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public SongBuilder setDuration(LocalTime duration) {
        this.duration = duration;
        return this;
    }

    public SongBuilder setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public Song createSong() {
        return new Song(title, duration, genre);
    }
}