package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.GenreDao;
import es.upm.miw.apaw_ep_themes.documents.Genre;
import es.upm.miw.apaw_ep_themes.dtos.GenreDto;
import es.upm.miw.apaw_ep_themes.dtos.GenrePatchDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GenreBusinessController {
    private GenreDao genreDao;

    @Autowired
    public GenreBusinessController(GenreDao genreDao){
        this.genreDao=genreDao;
    }

    public GenreDto create(GenreDto genreDto){
        Genre genre = new Genre(genreDto.getName(),genreDto.getOrigin());
        this.genreDao.save(genre);
        return new GenreDto(genre);
    }

    public List<GenreDto> readAll() {
        List<Genre> genres = this.genreDao.findAll();
        return genres.stream().map(GenreDto::new).collect(Collectors.toList());
    }

    public void patch(String id, GenrePatchDto userPatchDto) {
        Genre genre = this.genreDao.findById(id).orElseThrow(() -> new NotFoundException("Genre id: " + id));
        if (userPatchDto.getPath().equals("origin")) {
            genre.setOrigin(userPatchDto.getNewValue());
        }
        else{
            throw new BadRequestException("GenrePatchDto is invalid");
        }
        this.genreDao.save(genre);
    }
}
