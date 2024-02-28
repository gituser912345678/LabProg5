package command.commandClasses;

import command.CollectionManager;
import data.Person;
import data.generators.*;
import exception.IncorrectDataException;
import exception.NoElementException;
import exception.UnknowElementException;

import java.util.Objects;
/*
Команда позволяет обновить значение элемента коллекции, id которого равен заданному.
 */
public class UpdateIdCommand implements Command {
    @Override
    public void execute(String[] arg) throws NoElementException {
        try {
            Integer id = Integer.parseInt(arg[1]);

            for (String key : CollectionManager.getMap().keySet()) {
                if (Objects.equals(CollectionManager.getMap().get(key).getId(), id)) {
                    Person person = PersonGenerator.createPerson(id);
                    CollectionManager.remove(key);
                    CollectionManager.add(key, person);
                }
                else {
                    throw new NoElementException(id);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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