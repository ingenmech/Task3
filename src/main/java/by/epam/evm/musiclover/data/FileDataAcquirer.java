package by.epam.evm.musiclover.data;

import by.epam.evm.musiclover.exception.DataException;
import by.epam.evm.musiclover.logic.MusicTrack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

public class FileDataAcquirer implements DataAcquirer {

    private final String fileName;

    public FileDataAcquirer(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<MusicTrack> getMusicTrackList() throws DataException {
        BufferedReader reader = null;
        MusicTrack track = null;
        String readLine = null;
        List<MusicTrack> trackList = new ArrayList<MusicTrack>();
        TrackDataParser parser = new TrackDataParser();

        try {
            reader = new BufferedReader(new FileReader(fileName));
            while ((readLine = reader.readLine()) != null) {
                track = parser.parse(readLine);
                trackList.add(track);
            }
        } catch (FileNotFoundException e) {
            throw new DataException(e.getMessage(), e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trackList;
    }
}
