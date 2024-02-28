package command.commandClasses;

import command.CollectionManager;
import data.HairColor;
import data.Person;
import exception.IncorrectDataException;
import exception.NoElementException;
import exception.UnknowElementException;

import java.util.LinkedHashMap;
import java.util.Scanner;
/*
Команда выводящая все элементы значение поля hairColor равно заданному.
 */
public class FilterByHairColorCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException, NoElementException {
        LinkedHashMap<String, Person> map = CollectionManager.getMap();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите желаемый  цвет волос: ");
        String[] personsColor = in.nextLine().split(" ");
        HairColor color = HairColor.valueOf(personsColor[0]);

        for (String key : map.keySet()) {
            if (map.get(key).getHairColor().compareTo(color) == 0) {
                System.out.println(map.get(key).getHairColor().toString());
            }
        }
    }

    @Override
    public String getName() {
        return "filter_by_hair_color: ";
    }

    @Override
    public String getDescription() {
        return "вывести все элементы значение поля hairColor равно заданному";
    }
}
