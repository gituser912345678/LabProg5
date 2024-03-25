package command.commandClasses;

import exception.IncorrectDataException;
import exception.NoElementException;
import exception.UnknowElementException;

import java.io.IOException;

/**
Команда сохраняет содержимое коллекции в файл.
 */
public class SaveCommand implements Command {

    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException, NoElementException, IOException {
       Reciver.save();
    }

    @Override
    public String getName() {
        return "save: ";
    }

    @Override
    public String getDescription() {
        return "сохранить содержимое коллекции в файл";
    }
}
