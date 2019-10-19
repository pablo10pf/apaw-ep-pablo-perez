package es.upm.miw.apaw_ep_themes.documents;

public abstract class SongComponent {

    public abstract boolean isComposite();

    public abstract void add(Song song);

    public abstract void remove(Song song);

}
