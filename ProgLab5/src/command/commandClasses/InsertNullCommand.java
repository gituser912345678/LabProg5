package command.commandClasses;

import command.CollectionManager;
import data.Person;
import data.generators.PersonGenerator;
import exception.IncorrectDataException;
/*
Команда позволяющая добавить новый элемент в коллекцию.
 */
public class InsertNullCommand implements Command {

    @Override
    public void execute(String[] arg) {
        try {
            Person person = PersonGenerator.createPerson(0);
            CollectionManager.add(arg[1], person);
        } catch (IncorrectDataException e) {
            throw new RuntimeException(e);
        }

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
