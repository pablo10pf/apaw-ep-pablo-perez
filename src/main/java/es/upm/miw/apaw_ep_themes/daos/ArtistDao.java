package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistDao extends MongoRepository<Artist, String> {
}
