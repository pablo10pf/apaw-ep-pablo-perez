package es.upm.miw.apaw_ep_themes.documents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SongCompositeTest {

    private Song song;

    private SongComposite songComposite;

    @BeforeEach
    void before() {
        song = new Song("Señorita", LocalTime.parse("00:03:20", DateTimeFormatter.ofPattern("HH:mm:ss")), null);
        songComposite = new SongComposite();
        songComposite.add(song);
    }

    @Test
    void testIsComposite() {
        assertTrue(songComposite.isComposite());
    }

    @Test
    void testIsLeaf() {
        assertFalse(song.isComposite());
    }

    @Test
    void testRemoveDish() {
        songComposite.remove(song);
        assertTrue(songComposite.getSongs().isEmpty());
    }
}
