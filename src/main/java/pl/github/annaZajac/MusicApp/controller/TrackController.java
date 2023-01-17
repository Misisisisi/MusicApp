package pl.github.annaZajac.MusicApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.github.annaZajac.MusicApp.repository.TrackRepository;
import pl.github.annaZajac.MusicApp.model.Track;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tracks")
public class TrackController {

    @Autowired
    public final TrackRepository trackRepository;

    @GetMapping("")
    public List<Track> getAll() {
        return trackRepository.getAll();
    }

    @GetMapping("/{id}")
    public Track getSingleTrack(@PathVariable int id) {
        return trackRepository.getTrackById(id);
    }

    @GetMapping("/album/{id}")
    public List<Track> getAllFromAlbumById(@PathVariable("id") int id) {
        return trackRepository.getAllFromAlbumById(id);
    }

    @PostMapping("/addTracks")
    public String addTracks(@RequestBody List<Track> tracks) {
        return trackRepository.saveTracks(tracks);
    }

    @PostMapping("/addSingleTrack")
    public String addSingleTrack(@RequestBody Track track) {
        return trackRepository.saveSingleTrack(track);
    }

    @PutMapping("/{id}")
    public String updateSingleTrackById(@PathVariable int id, @RequestBody Track updatedTrack) {
        Track track = trackRepository.getTrackById(id);

        if (track != null) {
            track.setAlbumId(updatedTrack.getAlbumId());
            track.setTrackTitle(updatedTrack.getTrackTitle());
            track.setDurationTime(updatedTrack.getDurationTime());

            trackRepository.updateTrack(track);
            return "OK";
        } else {
            return "ERROR";
        }
    }

    @PatchMapping("/{id}")
    public String partiallyUpdateSingleTrackById(@PathVariable int id, @RequestBody Track updatedTrack) {
        Track track = trackRepository.getTrackById(id);

        if (track != null) {
            if (updatedTrack.getAlbumId() != 0) track.setTrackId(updatedTrack.getTrackId());
            if (updatedTrack.getTrackTitle() != null) track.setTrackTitle(updatedTrack.getTrackTitle());
            if (updatedTrack.getDurationTime() != null) track.setDurationTime(updatedTrack.getDurationTime());

            trackRepository.updateTrack(track);
            return "OK";
        } else {
            return "ERROR";
        }
    }

    @DeleteMapping("{id}")
    public String deleteTrack(@PathVariable int id) {
        return trackRepository.deleteTrack(id);
    }
}
