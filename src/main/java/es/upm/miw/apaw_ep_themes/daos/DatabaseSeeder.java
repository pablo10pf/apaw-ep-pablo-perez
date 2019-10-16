package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.daos.GenreDao;
import es.upm.miw.apaw_ep_themes.daos.SongDao;

import es.upm.miw.apaw_ep_themes.documents.Genre;
import es.upm.miw.apaw_ep_themes.documents.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DatabaseSeeder {
    private SongDao songDao;
    private GenreDao genreDao;
    private Genre genre;
    private Song song;

    @Autowired
    public DatabaseSeeder(SongDao songDao, GenreDao genreDao){
        this.songDao=songDao;
        this.genreDao=genreDao;
        seedGenres();
        seedSongs();
    }

    private void seedGenres(){
        genre= new Genre("Pop","England");
        genre.setId("1");
        genreDao.save(genre);
    }
    private void seedSongs(){
        song = new Song("Now",formatTime("00:03:20"),genre);
        song.setId("1");
        songDao.save(song);
    }

    private LocalTime formatTime(String time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(time, formatter);
    }
}
