package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.daos.AlbumDao;
import es.upm.miw.apaw_ep_themes.documents.Album;
import es.upm.miw.apaw_ep_themes.dtos.AlbumDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@TestConfig
public class AlbumControllerTest {

    @Autowired
    private AlbumBusinessController albumBusinessController;

    @Autowired
    private AlbumDao albumDao;

    private Album album;

    @Test
    void testReadByAvailableTrue(){
        Album album = new Album("Cero",15,true);
        albumDao.save(album);
        List<AlbumDto> availableAlbums=albumBusinessController.findByAvailableTrue(true);
        assertFalse(availableAlbums.isEmpty());
    }
}
