package by.epam.evm.musiclover.data;

import by.epam.evm.musiclover.logic.MusicTrack;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class TrackDataParserTest {

    @Test
    public void testParseWhenDataIsCorrect() throws ParseException {
        //given
        TrackDataParser parser = new TrackDataParser();
        Duration trackDuration = Duration.ofMinutes(3);
        trackDuration = trackDuration.plusSeconds(30);
        MusicTrack expected = new MusicTrack("Nobody's Fool", "Cinderella",trackDuration);
        //when
        MusicTrack actual = parser.parse("Nobody's Fool - Cinderella $3:30$");
        //then
        Assert.assertEquals(expected, actual);
    }


}
