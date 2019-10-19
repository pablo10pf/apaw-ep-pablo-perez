package es.upm.miw.apaw_ep_themes.daos;


import es.upm.miw.apaw_ep_themes.documents.Genre;
import es.upm.miw.apaw_ep_themes.documents.Song;
import es.upm.miw.apaw_ep_themes.documents.SongBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class DatabaseSeeder {
    private SongDao songDao;
    private GenreDao genreDao;
    private Genre genre;


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
        Song song = new SongBuilder().setTitle("Now").setDuration(formatTime("00:03:20")).setGenre(genre).createSong();
        song.setId("1");
        songDao.save(song);
    }

    private LocalTime formatTime(String time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(time, formatter);
    }
}
