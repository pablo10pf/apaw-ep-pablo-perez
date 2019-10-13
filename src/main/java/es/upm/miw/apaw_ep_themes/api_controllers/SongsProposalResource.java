package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.SongsProposalBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.SongsProposalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SongsProposalResource.SONGSPROPOSAL)
public class SongsProposalResource {

    static final String SONGSPROPOSAL = "/songsProposal";

    private SongsProposalBusinessController songsProposalBusinessController;

    @Autowired
    public SongsProposalResource(SongsProposalBusinessController songsProposalBusinessController) {
        this.songsProposalBusinessController = songsProposalBusinessController;
    }

    @PostMapping
    public SongsProposalDto create(@RequestBody SongsProposalDto songsProposalDto) {
        songsProposalDto.validate();
        return this.songsProposalBusinessController.create(songsProposalDto);
    }
}
