package command.commandClasses;

import exception.IncorrectDataException;
import exception.NoElementException;
import exception.UnknowElementException;

import java.io.IOException;

/**
Команда выполняет скрипт из указанного файла
 */
public class ExecuteScriptCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException, NoElementException, IOException {
        Reciver.executeScript();
    }

    @Override
    public String getName() {
        return "execute_script: ";
    }

    @Override
    public String getDescription() {
        return "исполняет скрипт из  указанного файла.";
    }
}
