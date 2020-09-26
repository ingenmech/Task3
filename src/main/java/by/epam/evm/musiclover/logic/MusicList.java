package by.epam.evm.musiclover.logic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MusicList implements DurationCalculator {

    private List<MusicTrack> trackList = new ArrayList<MusicTrack>();

    public MusicList(List<MusicTrack> trackList) {
        this.trackList = trackList;
    }

    public MusicTrack getMusicTrack(int index) {
        return trackList.get(index);
    }

    public void addMusicTrack(MusicTrack track) {
        trackList.add(track);
    }

    public void removeMusicTrack(int index) {
        trackList.remove(index);
    }

    public void removeMusicTrack(MusicTrack track) {
        trackList.remove(track);
    }

    public int size() {
        return trackList.size();
    }

    @Override
    public Duration calculateDuration() {

        Duration fullDuration = Duration.ZERO;

        for (MusicTrack track : trackList) {
            fullDuration = fullDuration.plus(track.getTrackDuration());
        }
        return fullDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicList musicList = (MusicList) o;

        return trackList != null ? trackList.equals(musicList.trackList) : musicList.trackList == null;
    }

    @Override
    public int hashCode() {
        return trackList != null ? trackList.hashCode() : 0;
    }
}
