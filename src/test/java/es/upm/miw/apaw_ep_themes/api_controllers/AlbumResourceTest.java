package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.daos.AlbumDao;
import es.upm.miw.apaw_ep_themes.documents.Album;
import es.upm.miw.apaw_ep_themes.dtos.AlbumDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ApiTestConfig
public class AlbumResourceTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    private AlbumDao albumDao;

    @Test
    void testSearch() {
        Album album = new Album("Cero",15,true);
        albumDao.save(album);
        List<AlbumDto> albumDtos = this.webTestClient
                .get().uri(uriBuilder ->
                        uriBuilder.path(AlbumResource.ALBUMS+ AlbumResource.SEARCH)
                                .queryParam("q", "available:true")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(AlbumDto.class)
                .returnResult().getResponseBody();
        assertFalse(albumDtos.isEmpty());
    }

    @Test
    void testSearchException() {
        this.webTestClient
                .get().uri(uriBuilder ->
                uriBuilder.path(AlbumResource.ALBUMS+ AlbumResource.SEARCH)
                        .queryParam("q", "price:10")
                        .build())
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
