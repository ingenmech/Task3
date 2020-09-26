package by.epam.evm.musiclover.logic;


import java.time.Duration;

public class MusicTrack {

    private String trackName;
    private String artist;
    private Duration trackDuration;

    public MusicTrack(String trackName, String artist, Duration trackDuration) {
        this.trackName = trackName;
        this.trackDuration = trackDuration;
        this.artist = artist;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getArtist() {
        return artist;
    }

    public Duration getTrackDuration() {
        return trackDuration;
    }

    @Override
    public String toString() {
        return "MusicTrack{" +
                "trackName='" + trackName + '\'' +
                ", artist='" + artist + '\'' +
                ", trackDuration=" + trackDuration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicTrack track = (MusicTrack) o;

        if (trackName != null ? !trackName.equals(track.trackName) : track.trackName != null) return false;
        if (artist != null ? !artist.equals(track.artist) : track.artist != null) return false;
        return trackDuration != null ? trackDuration.equals(track.trackDuration) : track.trackDuration == null;
    }

    @Override
    public int hashCode() {
        int result = trackName != null ? trackName.hashCode() : 0;
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (trackDuration != null ? trackDuration.hashCode() : 0);
        return result;
    }
}
