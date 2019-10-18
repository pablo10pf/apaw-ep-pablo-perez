package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.documents.Artist;
import es.upm.miw.apaw_ep_themes.dtos.ArtistDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ApiTestConfig
public class ArtistResourceTest {
    @Autowired
    WebTestClient webTestClient;

    Artist createArtist() {
        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse("1979-06-05", DATEFORMATTER);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalDateTime.now().toLocalTime());
        Artist artist = new Artist("Bisbal", "Spain", localDateTime);
        return artist;
    }

    @Test
    void testCreate() {
        ArtistDto artistDto = this.webTestClient
                .post().uri(ArtistResource.ARTISTS)
                .body(BodyInserters.fromObject(new ArtistDto(createArtist())))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ArtistDto.class).returnResult().getResponseBody();
        assertNotNull(artistDto);
        assertEquals("Bisbal", artistDto.getName());
        assertEquals("Spain", artistDto.getCountry());
    }
}
