package command.commandClasses;

import command.CollectionManager;
import exception.UnknowElementException;
/*
Команда позволяет удалить==т=т=ть элемент колекции с заданным ключом.
 */
public class RemoveKeyNullCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException {
        CollectionManager.remove(arg[2]);

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
