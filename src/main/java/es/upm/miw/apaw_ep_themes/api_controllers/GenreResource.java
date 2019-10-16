package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.GenreBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.GenreDto;
import es.upm.miw.apaw_ep_themes.dtos.GenrePatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(GenreResource.GENRES)
public class GenreResource {
    static final String GENRES = "/genres";
    static final String ID_ID = "/{id}";

    private GenreBusinessController genreBusinessController;

    @Autowired
    public GenreResource(GenreBusinessController genreBusinessController){
        this.genreBusinessController=genreBusinessController;
    }

    @PostMapping
    public GenreDto create(@RequestBody GenreDto genreDto){
        genreDto.validate();
        return this.genreBusinessController.create(genreDto);
    }

    @GetMapping
    public List<GenreDto> readAll() {
        return this.genreBusinessController.readAll();
    }

    @PatchMapping(value = ID_ID)
    public void patch(@PathVariable String id, @RequestBody GenrePatchDto genrePatchDto) {
        genrePatchDto.validate();
        this.genreBusinessController.patch(id, genrePatchDto);
    }

}
