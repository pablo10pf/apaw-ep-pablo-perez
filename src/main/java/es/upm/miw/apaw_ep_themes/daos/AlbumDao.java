package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumDao extends MongoRepository<Album,String> {
}
