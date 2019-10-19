package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Document
public class Song extends SongComponent {
    @Id
    private String id;

    private String title;

    private LocalTime duration;

    @DBRef
    private Genre genre;

    public Song(String title, LocalTime duration, Genre genre) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
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

    public Genre getGenre() {
        return genre;
    }


    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(Song song) {
        //empty for leaf
    }

    @Override
    public void remove(Song song) {
        //empty for leaf
    }
}
