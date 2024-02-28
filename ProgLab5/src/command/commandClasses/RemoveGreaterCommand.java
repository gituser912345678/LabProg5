package command.commandClasses;

import command.CollectionManager;
import data.Person;
import data.generators.PersonGenerator;
import exception.IncorrectDataException;
import exception.UnknowElementException;

import java.util.Iterator;
import java.util.Map;
/*
Удаляет из коллекции все элементы превышающие заданный.
 */
public class RemoveGreaterCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException {
        Person person = PersonGenerator.createPerson(0);

        CollectionManager.add(arg[1], person);
        Iterator<Map.Entry<String, Person>> iterator = CollectionManager.getMap().entrySet().iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals(person)) {
                while (iterator.hasNext()) {
                    iterator.remove();
                }
            }
        }

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
