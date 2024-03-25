package command.commandClasses;

import exception.IncorrectDataException;
import exception.NoElementException;
import exception.UnknowElementException;

/**
Выводит все элементы в порядке убывания поля hairColor.
 */
public class PrintFieldDescendingHairColorCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException, NoElementException {
        Reciver.printFieldDescendingHairColor();
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
