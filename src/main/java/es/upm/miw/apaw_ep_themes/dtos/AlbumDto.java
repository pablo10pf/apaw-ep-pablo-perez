package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Album;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

import java.time.LocalDateTime;

public class AlbumDto {
    private String id;

    private String title;

    private float price;

    private LocalDateTime releaseDate;

    private boolean available;

    public AlbumDto(){
        //empty for framework
    }

    public AlbumDto(String title, float price, boolean available){
        this.title=title;
        this.price=price;
        this.releaseDate =LocalDateTime.now();
        this.available=available;
    }

    public AlbumDto(Album album){
        this.title=album.getTitle();
        this.price=album.getPrice();
        this.releaseDate=album.getReleaseDate();
        this.available=album.isAvailable();
    }

    public String getId() {
        return id;
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

    public void validate(){
        if(title == null || title.isEmpty() || this.price<=0){
            throw new BadRequestException("Incomplete AlbumDto");
        }
    }
}
