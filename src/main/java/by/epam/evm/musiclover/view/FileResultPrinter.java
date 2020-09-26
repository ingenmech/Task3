package by.epam.evm.musiclover.view;

import by.epam.evm.musiclover.logic.MusicList;
import by.epam.evm.musiclover.logic.MusicTrack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class FileResultPrinter implements ResultPrinter {

    private final String fileName;

    public FileResultPrinter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void print(MusicList musics, Duration listDuration) {

        BufferedWriter writer = null;
        MusicTrack track = null;
        String trackInfo = null;

        try {
            writer = new BufferedWriter(new FileWriter(fileName));

            for (int i = 0; i < musics.size(); i++) {
                track = musics.getMusicTrack(i);
                trackInfo = track.getTrackName() + " - " + track.getArtist() + '\n';
                writer.write(trackInfo);
            }
            writer.write("Total music duration " + formatDuration(listDuration));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String formatDuration(Duration listDuration) {
        int secondsInMinute = 60;
        long minutes = listDuration.getSeconds() / secondsInMinute;
        long seconds = listDuration.getSeconds() % secondsInMinute;

        return minutes + " minutes " + seconds + " seconds";
    }

}
