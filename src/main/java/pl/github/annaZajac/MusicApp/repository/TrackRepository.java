package pl.github.annaZajac.MusicApp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.github.annaZajac.MusicApp.model.Track;

import java.util.List;

@Repository
public class TrackRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Track> getAll(){
        return jdbcTemplate.query("SELECT track_id, album_id,  trackTitle, durationTime FROM track", BeanPropertyRowMapper.newInstance(Track.class));
    }

    public List<Track> getAllFromAlbumById(int id){
        return jdbcTemplate.query("SELECT track_id, album_id,  trackTitle, durationTime FROM track WHERE album_id=?", BeanPropertyRowMapper.newInstance(Track.class), id);
    }

    public String saveTracks (List<Track> tracks) {
        tracks.forEach(track -> jdbcTemplate.update("INSERT INTO track(album_id,  trackTitle, durationTime) VALUES (?, ?, ?)", track.getAlbumId(), track.getTrackTitle(), track.getDurationTime()));
        return "OK";
    }

    public String saveSingleTrack (Track track) {
        jdbcTemplate.update("INSERT INTO track(album_id, trackTitle, durationTime) VALUES (?, ?, ?)", track.getAlbumId(), track.getTrackTitle(), track.getDurationTime());
        return "OK";
    }

    public int updateTrack(Track track) {
        return jdbcTemplate.update("UPDATE track SET album_id=?, trackTitle=?, durationTime=? WHERE track_id=?",
                track.getAlbumId(), track.getTrackTitle(), track.getDurationTime(), track.getTrackId());
    }

    public Track getTrackById(int id) {
       return jdbcTemplate.queryForObject("SELECT track_id, album_id,  trackTitle, durationTime FROM track WHERE track_id=?", BeanPropertyRowMapper.newInstance(Track.class), id);
    }

    public String deleteTrack(int id) {
        jdbcTemplate.update("DELETE FROM track WHERE track_id=?", id);
        return "OK";
    }
}
