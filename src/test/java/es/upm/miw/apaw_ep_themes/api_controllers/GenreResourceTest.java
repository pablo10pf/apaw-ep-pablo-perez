package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.GenreDto;
import es.upm.miw.apaw_ep_themes.dtos.GenrePatchDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
public class GenreResourceTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        GenreDto genreDto = this.webTestClient
                .post().uri(GenreResource.GENRES)
                .body(BodyInserters.fromObject(new GenreDto("Pop", "England")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(GenreDto.class).returnResult().getResponseBody();
        assertNotNull(genreDto);
        assertEquals("Pop", genreDto.getName());
        assertEquals("England", genreDto.getOrigin());
    }

    GenreDto createGenre() {
        GenreDto genreDto = this.webTestClient
                .post().uri(GenreResource.GENRES)
                .body(BodyInserters.fromObject(new GenreDto("Rock", "USA")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(GenreDto.class).returnResult().getResponseBody();
        return genreDto;
    }

    @Test
    void testCreateGenreException() {
        GenreDto genreDto = new GenreDto(null, null);
        this.webTestClient
                .post().uri(GenreResource.GENRES)
                .body(BodyInserters.fromObject(genreDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testReadAll() {
        GenreDto genreDto = new GenreDto("Rock", "USA");
        this.webTestClient
                .post().uri(GenreResource.GENRES)
                .body(BodyInserters.fromObject(genreDto))
                .exchange()
                .expectStatus().isOk();
        List<GenreDto> list =
                this.webTestClient
                        .get().uri(GenreResource.GENRES)
                        .exchange()
                        .expectStatus().isOk()
                        .expectBodyList(GenreDto.class)
                        .returnResult().getResponseBody();
        assertTrue(list.size() > 0);
        assertNotNull(list.get(0).getId());
        assertNotNull(list.get(0).getName());
        assertNotNull(list.get(0).getOrigin());
    }

    @Test
    void testGenrePatch() {
        String id = createGenre().getId();
        this.webTestClient
                .patch().uri(GenreResource.GENRES + GenreResource.ID_ID, id)
                .body(BodyInserters.fromObject(new GenrePatchDto("origin", "EEUU")))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testGenrePatchIdException() {
        this.webTestClient
                .patch().uri(GenreResource.GENRES + GenreResource.ID_ID, "no")
                .body(BodyInserters.fromObject(new GenrePatchDto("none", "none")))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testGenreBadPatchDtoException() {
        String id = createGenre().getId();
        this.webTestClient
                .patch().uri(GenreResource.GENRES + GenreResource.ID_ID, id)
                .body(BodyInserters.fromObject(new GenrePatchDto()))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
