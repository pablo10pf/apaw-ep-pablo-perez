package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.daos.SongDao;
import es.upm.miw.apaw_ep_themes.documents.Song;
import es.upm.miw.apaw_ep_themes.dtos.GenreDto;
import es.upm.miw.apaw_ep_themes.dtos.SongDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ApiTestConfig
public class SongResourceTest {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private SongDao songDao;

    private Song song;

    GenreDto createGenre(){
        return this.webTestClient
                .post().uri(GenreResource.GENRES)
                .body(BodyInserters.fromObject(new GenreDto("Rock", "USA")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(GenreDto.class).returnResult().getResponseBody();
    }

    @Test
    void testPutSong() {
        String genreId=createGenre().getId();
        song=songDao.findAll().get(0);
        song.setTitle("Not Now");
        song.setDuration(LocalTime.parse("00:03:30",DateTimeFormatter.ofPattern("HH:mm:ss")));
        String id = song.getId();
        SongDto songDto = new SongDto(song);
        songDto.setGenreId(genreId);
        this.webTestClient
                .put().uri(SongResource.SONGS + SongResource.ID_ID, id)
                .body(BodyInserters.fromObject(songDto))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testDeleteSong(){
        String id = this.songDao.findAll().get(0).getId();
        this.webTestClient
                .delete().uri(SongResource.SONGS + SongResource.ID_ID, id)
                .exchange()
                .expectStatus().isOk();
        assertTrue(this.songDao.findAll().isEmpty());

        songDao.deleteAll();
    }
}
