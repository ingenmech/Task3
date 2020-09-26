package by.epam.evm.musiclover.data;

import by.epam.evm.musiclover.logic.MusicTrack;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrackDataParser {

    private final static String TRACK_PATTERN = "(.+) - (.+) \\$(.+)\\$";
    private final static String DURATION_PATTERN = "(\\d+).(\\d+)";
    private final static int TRACK_NAME_GROUP = 1;
    private final static int TRACK_ARTIST_GROUP = 2;
    private final static int TRACK_DURATION_GROUP = 3;
    private final static int MINUTES_GROUP = 1;
    private final static int SECONDS_GROUP = 2;

    public MusicTrack parse(String trackData) {
        Pattern pattern = Pattern.compile(TRACK_PATTERN);
        Matcher matcher = pattern.matcher(trackData);
        matcher.find(); // if() else {write in log error}
        String trackName = matcher.group(TRACK_NAME_GROUP);
        String trackArtist = matcher.group(TRACK_ARTIST_GROUP);

        Duration trackDuration = parseTrackDuration(matcher.group(TRACK_DURATION_GROUP));

        return new MusicTrack(trackName, trackArtist, trackDuration);
    }

    private static Duration parseTrackDuration(String trackDuration) {
        Pattern pattern = Pattern.compile(DURATION_PATTERN);
        Matcher matcher = pattern.matcher(trackDuration);
        matcher.find();
        String minutesDuration = matcher.group(MINUTES_GROUP);
        String secondsDuration = matcher.group(SECONDS_GROUP);

        long minutes = Integer.parseInt(minutesDuration);
        long seconds = Integer.parseInt(secondsDuration);

        Duration duration = Duration.ofMinutes(minutes);
        duration = duration.plusSeconds(seconds);

        return duration;
    }
}
