package command.commandClasses;

import command.CollectionManager;
import data.Person;
import data.generators.PersonGenerator;
import exception.IncorrectDataException;
import exception.UnknowElementException;

import java.util.Iterator;
import java.util.Map;
/*
Команда позволяет удалить из коллекции все элементы, меньшие, чем заданный.
 */
public class RemoveLowerCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException {
        Person person = PersonGenerator.createPerson(0);

        CollectionManager.add(arg[1], person);
        Iterator<Map.Entry<String, Person>> iterator = CollectionManager.getMap().entrySet().iterator();
        while (iterator.hasNext()) {
            iterator.remove();
            if (iterator.next().equals(person)) {
                while (iterator.hasNext()) {
                    iterator.remove();
                    break;
                }
                break;
            }
        }
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
