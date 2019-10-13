package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.SongsProposalDao;
import es.upm.miw.apaw_ep_themes.documents.SongsProposal;
import es.upm.miw.apaw_ep_themes.dtos.SongsProposalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SongsProposalBusinessController {
    private SongsProposalDao songsProposalDao;

    @Autowired
    public SongsProposalBusinessController(SongsProposalDao songsProposalDao) {
        this.songsProposalDao = songsProposalDao;
    }

    public SongsProposalDto create(SongsProposalDto songsProposalDto) {
        SongsProposal songsProposal = new SongsProposal(songsProposalDto.getTitle(), songsProposalDto.getDate());
        this.songsProposalDao.save(songsProposal);
        return new SongsProposalDto(songsProposal);
    }
}

