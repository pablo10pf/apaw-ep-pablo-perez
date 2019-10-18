package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class SongsProposal {
    @Id
    private String id;

    private String title;

    private LocalDateTime date;

    public SongsProposal(String title, LocalDateTime date) {
        this.title = title;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
