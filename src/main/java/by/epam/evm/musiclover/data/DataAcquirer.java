package by.epam.evm.musiclover.data;

import by.epam.evm.musiclover.exception.DataException;
import by.epam.evm.musiclover.logic.MusicTrack;

import java.util.List;

public interface DataAcquirer {
    List<MusicTrack> getMusicTrackList() throws DataException;
}
