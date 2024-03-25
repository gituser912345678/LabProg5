package command.commandClasses;

import exception.UnknowElementException;

/**
*Команда удаляет все элементы коллекции.
*/
public class ClearCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException {
        Reciver reciver = new Reciver();
        reciver.clear();
    }

    @Override
    public String getName() {
        return "clear: ";
    }

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }
}
