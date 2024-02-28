package command.commandClasses;

import command.JsonWriter;
import exception.IncorrectDataException;
import exception.NoElementException;
import exception.UnknowElementException;

import java.io.IOException;

/*
Команда сохраняет содержимое коллекции в файл.
 */
public class SaveCommand implements Command {

    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException, NoElementException, IOException {
        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.execute();
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
