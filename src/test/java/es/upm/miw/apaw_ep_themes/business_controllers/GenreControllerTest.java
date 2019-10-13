package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.daos.GenreDao;
import es.upm.miw.apaw_ep_themes.documents.Genre;
import es.upm.miw.apaw_ep_themes.dtos.GenrePatchDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class GenreControllerTest {

    @Autowired
    private GenreDao genreDao;

    @Autowired
    private GenreBusinessController genreBusinessController;

    private Genre genre;

    @BeforeEach
    void before() {
        this.genre = new Genre("Reggue", "Honduras");
        this.genreDao.save(genre);
    }

    @Test
    void testPatchOrigin() {
        GenrePatchDto genrePatchDto = new GenrePatchDto("origin", "Jamaica");
        genreBusinessController.patch(this.genre.getId(), genrePatchDto);
        assertEquals("Jamaica", this.genreDao.findById(genre.getId()).get().getOrigin());
    }

    @AfterEach
    void after() {
        this.genreDao.deleteById(this.genre.getId());
    }

}
