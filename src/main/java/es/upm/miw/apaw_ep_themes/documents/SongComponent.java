package es.upm.miw.apaw_ep_themes.documents;

public interface SongComponent {

    boolean isComposite();

    void add(Song song);

    void remove(Song song);

}
