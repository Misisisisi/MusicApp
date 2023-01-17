package pl.github.annaZajac.MusicApp.calculations;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.github.annaZajac.MusicApp.model.Track;
import pl.github.annaZajac.MusicApp.repository.TrackRepository;

import java.time.Duration;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CalculateClass {

    @Autowired
    public final TrackRepository trackRepository;

    public String getDurationTimeOfAlbum(int id) {
        List<Track> allFromAlbumById = trackRepository.getAllFromAlbumById(id);
        List<Duration> durationTimes = allFromAlbumById.stream()
                .map(Track::getDurationTime)
                .toList();

        Duration sum = Duration.ZERO;
        for (Duration dur : durationTimes) {
            sum = sum.plus(dur);
        }

        long millis = sum.toMillis();
        return DurationFormatUtils.formatDuration(millis, "mm:ss", true);

    }
}
