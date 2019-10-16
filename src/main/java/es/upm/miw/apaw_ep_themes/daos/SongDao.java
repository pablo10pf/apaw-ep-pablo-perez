package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongDao extends MongoRepository<Song,String> {
}
