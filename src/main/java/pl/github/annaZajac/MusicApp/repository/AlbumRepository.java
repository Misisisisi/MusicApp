package pl.github.annaZajac.MusicApp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.github.annaZajac.MusicApp.model.Album;

import java.util.List;

@Repository
public class AlbumRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Album> getAll(){
       return jdbcTemplate.query("SELECT album_id, performer, albumTitle, releaseDate, version FROM album", BeanPropertyRowMapper.newInstance(Album.class));
    }

    public Album getAlbumById(int id){
        return jdbcTemplate.queryForObject("SELECT album_id, performer, albumTitle, releaseDate, version FROM album WHERE album_id=?", BeanPropertyRowMapper.newInstance(Album.class), id);
    }

    public String saveAlbums (List<Album> albums) {
        albums.forEach(album -> jdbcTemplate.update("INSERT INTO album(performer, albumTitle, releaseDate, version) VALUES (?, ?, ?, ?)", album.getPerformer(), album.getAlbumTitle(), album.getReleaseDate(), album.getVersion()));
        return "OK";
    }

    public String saveSingleAlbum (Album album) {
        jdbcTemplate.update("INSERT INTO album(performer, albumTitle, releaseDate, version) VALUES (?, ?, ?, ?)", album.getPerformer(), album.getAlbumTitle(), album.getReleaseDate(), album.getVersion());
        return "OK";
    }

    public int updateAlbum(Album album) {
        return jdbcTemplate.update("UPDATE album SET performer=?, albumTitle=?, releaseDate=?, version=? WHERE album_id=?",
               album.getPerformer(), album.getAlbumTitle(), album.getReleaseDate(), album.getVersion(), album.getAlbum_id());
    }

    public String deleteAlbum(int id) {
         jdbcTemplate.update("DELETE FROM album WHERE album_id=?", id);
        return "OK";
    }
}
