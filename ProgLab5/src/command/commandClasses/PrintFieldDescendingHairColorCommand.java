package command.commandClasses;

import command.CollectionManager;
import data.HairColor;
import data.Person;
import data.PersonComparator;
import exception.IncorrectDataException;
import exception.NoElementException;
import exception.UnknowElementException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
/*
Выводит все элементы в порядке убывания поля hairColor.
 */
public class PrintFieldDescendingHairColorCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException, NoElementException {
        LinkedHashMap<String, Person> map = CollectionManager.getMap();

        PersonComparator personComparator = new PersonComparator();
        ArrayList<HairColor> array = new ArrayList<>();

        for (String key : map.keySet()) {
            array.add(map.get(key).getHairColor());
        }
        array.sort(personComparator);
        Collections.reverse(array);

        array.forEach(System.out::println);

    }

    @Override
    public String getName() {
        return "print_field_descending_hair_color: ";
    }

    @Override
    public String getDescription() {
        return "вывести все элементы коллекции в порядке убывания поля hairColor";
    }
}
