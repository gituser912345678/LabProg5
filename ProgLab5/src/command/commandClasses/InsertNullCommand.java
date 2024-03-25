package command.commandClasses;

/**
Команда позволяющая добавить новый элемент в коллекцию.
 */
public class InsertNullCommand implements Command {

    @Override
    public void execute(String[] arg) {
        Reciver.insert(arg);
    }

    @Override
    public String getName() {
        return "insert null: ";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент с заданным ключом";
    }
}
