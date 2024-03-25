package command.commandClasses;

import exception.IncorrectDataException;
import exception.UnknowElementException;

/**
Команда удаляет из колекции все элементы ключ которых превышает заданный.
 */
public class RemoveGreaterKeyCommand implements Command {

    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException {
        Reciver.removeGreaterKey();
    }

    @Override
    public String getName() {
        return "remove_greater_key: ";
    }

    @Override
    public String getDescription() {
        return "удалить из  коллекции все элементы ключ которых превышает заданный";
    }
}
