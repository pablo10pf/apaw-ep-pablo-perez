package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class Album {

    @Id
    private String id;

    private String title;

    private float price;

    private LocalDateTime releaseDate;

    private boolean available;

    private List<Song> songs;

    public Album(String title, float price, boolean available){
        this.title=title;
        this.price=price;
        this.releaseDate=LocalDateTime.now();
        this.available=available;
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

    public float getPrice() {
        return price;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
