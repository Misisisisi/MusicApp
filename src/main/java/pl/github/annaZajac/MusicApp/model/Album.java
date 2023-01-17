package pl.github.annaZajac.MusicApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {

    private int album_id;
    private String performer;
    private String albumTitle;
    private Date releaseDate;
    private String version;
    private String totalAlbumLength;

    public Album(int album_id) {
        this.album_id = album_id;
    }
}
