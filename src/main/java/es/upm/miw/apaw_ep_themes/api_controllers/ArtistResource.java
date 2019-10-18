package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.ArtistBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.ArtistDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ArtistResource.ARTISTS)
public class ArtistResource {

    static final String ARTISTS = "/artists";

    private ArtistBusinessController artistBusinessController;

    @Autowired
    public ArtistResource(ArtistBusinessController artistBusinessController) {
        this.artistBusinessController = artistBusinessController;
    }

    @PostMapping
    public ArtistDto create(@RequestBody ArtistDto artistDto) {
        artistDto.validate();
        return this.artistBusinessController.create(artistDto);
    }
}
