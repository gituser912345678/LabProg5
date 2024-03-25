package command.commandClasses;

import exception.IncorrectDataException;
import exception.NoElementException;
import exception.UnknowElementException;

/**
Команда выводящая все элементы значение поля hairColor равно заданному.
 */
public class FilterByHairColorCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException, NoElementException {
        Reciver.filterByHairColor();
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
