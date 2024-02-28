package command.commandClasses;

import command.CollectionManager;
import data.Person;

import java.util.LinkedHashMap;
/*
Команда позволяет вывести в стандартный поток вывода все элементы коллекции в строковом представлении.
 */
public class ShowCommand implements Command {
    @Override
    public void execute(String[] arg) {
        LinkedHashMap<String, Person> map = CollectionManager.getMap();
        if (map.isEmpty()) {
            System.out.println(CollectionManager.getMap().getClass().getName() + " is empty");
            return;
        }

        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }


    }

    @Override
    public String getName() {
        return "show: ";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
