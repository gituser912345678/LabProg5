package command.commandClasses;

import command.CollectionManager;
import data.Person;
import exception.IncorrectDataException;
import exception.UnknowElementException;

import java.util.LinkedHashMap;
import java.util.Scanner;
/*
Команда удаляет из колекции все элементы ключ которых превышает заданный.
 */
public class RemoveGreaterKeyCommand implements Command {

    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException {
        LinkedHashMap<String, Person> map = CollectionManager.getMap();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите желаемый ключ: ");
        String[] personsKey = in.nextLine().split(" ");
        for (String key : map.keySet()) {
            if (key.compareTo(personsKey[0]) > 0){
                map.remove(key);
            }
        }
        CollectionManager.setMap(map);
    }

    @Override
    public String getName() {
        return "remove_greater_key: ";
    }

    @Override
    public String getDescription() {
        return "удалить из  коллекции все элементы ключ которых превышает заданный";
    }
}
