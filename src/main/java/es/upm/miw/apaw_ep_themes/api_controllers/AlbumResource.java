package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.AlbumBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.AlbumDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AlbumResource.ALBUMS)
public class AlbumResource  {
    static final String ALBUMS="/albums";
    static final String SEARCH="/search";

    private AlbumBusinessController albumBusinessController;

    @Autowired
    public AlbumResource(AlbumBusinessController albumBusinessController){
        this.albumBusinessController=albumBusinessController;
    }

    @GetMapping(value = SEARCH)
    public List<AlbumDto> find(@RequestParam String q) {
        if (!"available".equals(q.split(":")[0])) {
            throw new BadRequestException("query param q is incorrect, missing 'available:'");
        }
        return this.albumBusinessController.findByAvailableTrue(Boolean.parseBoolean(q.split(":")[1]));
    }

}
