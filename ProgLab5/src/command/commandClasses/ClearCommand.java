package command.commandClasses;

import command.CollectionManager;
import data.Person;
import exception.UnknowElementException;

import java.util.LinkedHashMap;
import java.util.Map;
/*
Команда удаляет все элементы коллекции.
 */
public class ClearCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException {
        Map<String, Person> map = CollectionManager.getMap();
        map.clear();
        CollectionManager.setMap((LinkedHashMap<String, Person>) map);
        System.out.println("Clear...........");
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
