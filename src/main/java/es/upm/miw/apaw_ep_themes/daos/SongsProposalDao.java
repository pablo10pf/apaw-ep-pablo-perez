package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.SongsProposal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongsProposalDao extends MongoRepository<SongsProposal, String> {

}
