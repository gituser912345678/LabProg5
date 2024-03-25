package command.commandClasses;

import exception.IncorrectDataException;
import exception.UnknowElementException;

/**
Удаляет из коллекции все элементы превышающие заданный.
 */
public class RemoveGreaterCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException {
        Reciver.removeGreater(arg);
    }

    @Override
    public String getName() {
        return "remove_greater {element}: ";
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции все элементы, превышающие заданный";
    }
}
