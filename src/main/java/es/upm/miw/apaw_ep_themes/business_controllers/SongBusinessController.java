package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.GenreDao;
import es.upm.miw.apaw_ep_themes.daos.SongDao;
import es.upm.miw.apaw_ep_themes.documents.Genre;
import es.upm.miw.apaw_ep_themes.documents.Song;
import es.upm.miw.apaw_ep_themes.dtos.SongDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SongBusinessController {
    private SongDao songDao;

    private GenreDao genreDao;

    @Autowired
    public SongBusinessController(SongDao songDao, GenreDao genreDao) {
        this.songDao = songDao;
        this.genreDao = genreDao;
    }

    public void update(String id, SongDto songDto){
        Song song= this.findSongByIdAssured(id);
        song.setTitle(songDto.getTitle());
        song.setDuration(songDto.getDuration());
        this.songDao.save(song);
    }
    private Song findSongByIdAssured(String id) {
        return this.songDao.findById(id).orElseThrow(() -> new NotFoundException("Song id: " + id));
    }
}
