package pl.github.annaZajac.MusicApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {

    @JsonIgnore
    private int trackId;
    private int albumId;
    private String trackTitle;
    private Duration durationTime;

}
