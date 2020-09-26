package by.epam.evm.musiclover.view;


import by.epam.evm.musiclover.logic.MusicList;

import java.time.Duration;

public interface ResultPrinter {
    void print(MusicList musics, Duration listDuration);
}
