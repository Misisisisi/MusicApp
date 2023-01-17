package pl.github.annaZajac.MusicApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.github.annaZajac.MusicApp.calculations.CalculateClass;
import pl.github.annaZajac.MusicApp.repository.AlbumRepository;
import pl.github.annaZajac.MusicApp.model.Album;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private CalculateClass calculateClass;

    @GetMapping("")
    public List<Album> getAll() {
        List<Album> album = albumRepository.getAll();
        List<Album> albumViewList = new ArrayList<>();

        for (int i = 0; i < album.size(); i++) {
            int albumId = album.get(i).getAlbum_id();
            String totalAlbumLength = calculateClass.getDurationTimeOfAlbum(albumId);
            Album albumView = new Album(album.get(i).getAlbum_id(), album.get(i).getPerformer(), album.get(i).getAlbumTitle(), album.get(i).getReleaseDate(), album.get(i).getVersion(), totalAlbumLength);
            albumViewList.add(albumView);
        }
        return albumViewList;
    }

    @GetMapping("/{id}")
    public Album getAlbumById(@PathVariable int id) {
        String totalAlbumLength = calculateClass.getDurationTimeOfAlbum(id);
        Album album = albumRepository.getAlbumById(id);
        Album albumView = new Album(album.getAlbum_id(), album.getPerformer(), album.getAlbumTitle(), album.getReleaseDate(), album.getVersion(), totalAlbumLength);
        return albumView;
    }

    @PostMapping("/addAlbums")
    public String addAlbums(@RequestBody List<Album> albums) {
        return albumRepository.saveAlbums(albums);
    }

    @PostMapping("/addSingleAlbum")
    public String addSingleAlbum(@RequestBody Album album) {
        return albumRepository.saveSingleAlbum(album);
    }

    @PutMapping("/{id}")
    public String updateAlbum(@PathVariable int id, @RequestBody Album updatedAlbum) {
        Album album = albumRepository.getAlbumById(id);

        if (album != null) {
            album.setPerformer(updatedAlbum.getPerformer());
            album.setAlbumTitle(updatedAlbum.getAlbumTitle());
            album.setReleaseDate(updatedAlbum.getReleaseDate());
            album.setVersion(updatedAlbum.getVersion());

            albumRepository.updateAlbum(album);

            return "OK";
        } else {
            return "ERROR";
        }
    }

    @PatchMapping("/{id}")
    public String partiallyUpdateAlbum(@PathVariable int id, @RequestBody Album updatedAlbum) {
        Album album = albumRepository.getAlbumById(id);

        if (album != null) {
            if (updatedAlbum.getPerformer() != null) album.setPerformer(updatedAlbum.getPerformer());
            if (updatedAlbum.getAlbumTitle() != null) album.setAlbumTitle(updatedAlbum.getAlbumTitle());
            if (updatedAlbum.getReleaseDate() != null) album.setReleaseDate(updatedAlbum.getReleaseDate());
            if (updatedAlbum.getVersion() != null) album.setVersion(updatedAlbum.getVersion());

            albumRepository.updateAlbum(album);

            return "OK";
        } else {
            return "ERROR";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteAlbum(@PathVariable int id) {
        return albumRepository.deleteAlbum(id);
    }

}
