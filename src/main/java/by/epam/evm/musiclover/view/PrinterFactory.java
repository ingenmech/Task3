package by.epam.evm.musiclover.view;


import by.epam.evm.musiclover.data.InputType;
import by.epam.evm.musiclover.exception.NotExistEnumException;

public class PrinterFactory {

    private final static String FILE_NAME = "src/main/resources/output.txt";

    public ResultPrinter createPrinter(InputType type) throws NotExistEnumException {
        ResultPrinter printer = null;

        switch (type) {
            case FILE:
                printer = new FileResultPrinter(FILE_NAME);
                break;
            default:
                throw new NotExistEnumException("Type not exist in the list" + " = " + type);
        }
        return printer;
    }

}
