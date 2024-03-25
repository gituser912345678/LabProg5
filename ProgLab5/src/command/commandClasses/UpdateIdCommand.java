package command.commandClasses;

import exception.NoElementException;

/**
Команда позволяет обновить значение элемента коллекции, id которого равен заданному.
 */
public class UpdateIdCommand implements Command {
    @Override
    public void execute(String[] arg) throws NoElementException {
        Reciver.updateId(arg);
    }

    @Override
    public String getName() {
        return "update id: ";
    }

    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}