package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.SongBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.SongDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SongResource.SONGS )
public class SongResource {
    static final String SONGS="/songs";
    static final String ID_ID = "/{id}";
    static final String TITLE = "/title";

    private SongBusinessController songBusinessController;

    @Autowired
    public SongResource(SongBusinessController songBusinessController){
        this.songBusinessController=songBusinessController;
    }

    @PutMapping(value =ID_ID)
    public void update(@PathVariable String id, @RequestBody SongDto songDto){
        songDto.validate();
        this.songBusinessController.update(id,songDto);
    }

    @DeleteMapping(value = ID_ID)
    public void delete(@PathVariable String id) {
        this.songBusinessController.delete(id);
    }


}
