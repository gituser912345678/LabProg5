package command.commandClasses;

import exception.IncorrectDataException;
import exception.UnknowElementException;

/**
Команда позволяет удалить из коллекции все элементы, меньшие, чем заданный.
 */
public class RemoveLowerCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException {
        Reciver.removeLower(arg);
    }

    @Override
    public String getName() {
        return "remove lower: ";
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
