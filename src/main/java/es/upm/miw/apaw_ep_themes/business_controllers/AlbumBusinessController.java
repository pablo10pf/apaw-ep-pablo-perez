package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.AlbumDao;
import es.upm.miw.apaw_ep_themes.dtos.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AlbumBusinessController {
    private AlbumDao albumDao;

    @Autowired
    public AlbumBusinessController(AlbumDao albumDao){
        this.albumDao=albumDao;
    }

    public List<AlbumDto> findByAvailableTrue(boolean available) {
        return this.albumDao.findAll().stream()
                .filter(album -> album.isAvailable() == available)
                .map(AlbumDto::new)
                .collect(Collectors.toList());
    }
}
