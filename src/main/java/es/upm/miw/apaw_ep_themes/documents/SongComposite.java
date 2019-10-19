package es.upm.miw.apaw_ep_themes.documents;

import java.util.ArrayList;
import java.util.List;

public class SongComposite implements SongComponent {

    private List<Song> songs;

    public SongComposite() {
        this.songs = new ArrayList<>();
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(Song song) {
        this.songs.add(song);
    }

    @Override
    public void remove(Song song) {
        this.songs.remove(song);
    }
}
