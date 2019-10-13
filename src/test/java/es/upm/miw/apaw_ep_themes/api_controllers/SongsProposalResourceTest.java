package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.SongsProposalDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ApiTestConfig
public class SongsProposalResourceTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        LocalDateTime dateTime=new Date().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        SongsProposalDto songsProposalDto = this.webTestClient
                .post().uri(SongsProposalResource.SONGSPROPOSAL)
                .body(BodyInserters.fromObject(new SongsProposalDto("Bonito",dateTime)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SongsProposalDto.class).returnResult().getResponseBody();
        assertNotNull(songsProposalDto);
        assertEquals("Bonito", songsProposalDto.getTitle());
        assertEquals(dateTime, songsProposalDto.getDate());
    }

    @Test
    void testCreateSongsProposalException() {
        SongsProposalDto songsProposalDto = new SongsProposalDto(null, null);
        this.webTestClient
                .post().uri(SongsProposalResource.SONGSPROPOSAL)
                .body(BodyInserters.fromObject(songsProposalDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
