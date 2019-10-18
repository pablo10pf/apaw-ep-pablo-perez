package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.daos.ArtistDao;
import es.upm.miw.apaw_ep_themes.documents.Artist;
import es.upm.miw.apaw_ep_themes.dtos.ArtistDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class ArtistControllerTest {

    @Autowired
    private ArtistDao artistDao;

    @Autowired
    private ArtistBusinessController artistBusinessController;

    Artist createArtist() {
        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse("1979-01-21", DATEFORMATTER);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalDateTime.now().toLocalTime());
        Artist artist = new Artist("Melendi", "Spain", localDateTime);
        return artist;
    }
    @Test
    void testCreate(){
        ArtistDto artistDto = new ArtistDto(createArtist());
        artistDto.validate();
        artistBusinessController.create(artistDto);
        assertEquals(1, this.artistDao.findAll().size());
    }

    @AfterEach
    void after(){
        this.artistDao.deleteAll();
    }
}
