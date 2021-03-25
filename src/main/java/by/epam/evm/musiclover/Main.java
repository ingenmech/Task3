package by.epam.evm.musiclover;

import by.epam.evm.musiclover.data.DataAcquirer;
import by.epam.evm.musiclover.data.DataAcquirerFactory;
import by.epam.evm.musiclover.data.InputType;
import by.epam.evm.musiclover.exception.DataException;
import by.epam.evm.musiclover.exception.NotExistEnumException;
import by.epam.evm.musiclover.logic.MusicList;
import by.epam.evm.musiclover.logic.MusicTrack;
import by.epam.evm.musiclover.view.PrinterFactory;
import by.epam.evm.musiclover.view.ResultPrinter;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            run(args);
        } catch (NotExistEnumException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        }
        hello it not exist in master branch
    }

    private static void run(String[] arguments) throws NotExistEnumException, DataException {

        String argument = arguments[0];
        InputType type = InputType.valueOf(argument);

        DataAcquirerFactory acquirerFactory = new DataAcquirerFactory();
        DataAcquirer dataAcquirer = acquirerFactory.create(InputType.FILE);
        List<MusicTrack> trackList = dataAcquirer.getMusicTrackList();

        MusicList musicList = new MusicList(trackList);
        Duration durationMusicList = musicList.calculateDuration();

        PrinterFactory printerFactory = new PrinterFactory();
        ResultPrinter printer = printerFactory.createPrinter(InputType.FILE);
        printer.print(musicList, durationMusicList);
    }
}
