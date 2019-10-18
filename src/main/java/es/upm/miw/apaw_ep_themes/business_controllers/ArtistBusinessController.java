package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.ArtistDao;
import es.upm.miw.apaw_ep_themes.documents.Artist;
import es.upm.miw.apaw_ep_themes.dtos.ArtistDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ArtistBusinessController {

    private ArtistDao artistDao;

    @Autowired
    public ArtistBusinessController(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    public ArtistDto create(ArtistDto artistDto) {
        Artist artist = new Artist(artistDto.getName(), artistDto.getCountry(), artistDto.getBirthdate());
        this.artistDao.save(artist);
        return new ArtistDto(artist);
    }
}
