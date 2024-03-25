package command.commandClasses;

import exception.UnknowElementException;
/**
Команда позволяет удалить элемент колекции с заданным ключом.
 */
public class RemoveKeyNullCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException {
        Reciver.removeKey(arg);
    }

    @Override
    public String getName() {
        return "remove_key null {element}: ";
    }

    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его ключу";
    }
}
