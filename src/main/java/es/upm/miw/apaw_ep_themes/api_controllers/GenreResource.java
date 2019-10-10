package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controller.GenreBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.GenreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(GenreResource.GENRES)
public class GenreResource {
    static final String GENRES = "/genres";

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
}
