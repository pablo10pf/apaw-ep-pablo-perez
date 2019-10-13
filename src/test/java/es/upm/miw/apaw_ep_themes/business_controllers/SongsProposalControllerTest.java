package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.daos.SongsProposalDao;
import es.upm.miw.apaw_ep_themes.documents.SongsProposal;
import es.upm.miw.apaw_ep_themes.dtos.SongsProposalDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class SongsProposalControllerTest {
    @Autowired
    private SongsProposalDao songsProposalDao;

    @Autowired
    private SongsProposalBusinessController songsProposalBusinessController;

    private SongsProposal songsProposal;

    @Test
    void testCreate(){
        LocalDateTime dateTime=new Date().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        SongsProposalDto songsProposalDto= new SongsProposalDto("Blanco y negro",dateTime);
        songsProposalBusinessController.create(songsProposalDto);
        assertEquals(1, this.songsProposalDao.findAll().size());
    }

    @AfterEach
    void after(){
        this.songsProposalDao.deleteAll();
    }
}
