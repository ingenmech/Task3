package by.epam.evm.musiclover.data;

import by.epam.evm.musiclover.exception.NotExistEnumException;

public class DataAcquirerFactory {

    private final static String FILE_NAME = "src/main/resources/input.txt";

    public DataAcquirer create(InputType type) throws NotExistEnumException {
        DataAcquirer acquirer = null;

        switch (type) {
            case FILE:
                acquirer = new FileDataAcquirer(FILE_NAME);
                break;
            default:
                throw new NotExistEnumException("Type not exist in the listing" + " = " + type);

        }
        return acquirer;
    }
}
