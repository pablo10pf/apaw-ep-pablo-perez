package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.SongsProposal;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import org.hibernate.validator.internal.util.privilegedactions.LoadClass;

import java.time.LocalDateTime;

public class SongsProposalDto {

    private String id;

    private String title;

    private LocalDateTime date;

    public SongsProposalDto(String title, LocalDateTime date) {
        this.title = title;
        this.date = date;
    }

    public SongsProposalDto(SongsProposal songsProposal) {
        this.id = songsProposal.getId();
        this.title = songsProposal.getTitle();
        this.date = songsProposal.getDate();
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

    public void validate() {
        if (title == null || title.isEmpty() || date == null) {
            throw new BadRequestException("Incomplete SongsProposalDto");
        }
    }

    @Override
    public String toString() {
        return "SongsProposalDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
