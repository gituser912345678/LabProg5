package command.commandClasses;

import command.CollectionManager;
import command.StartCommand;
import data.Person;
import exception.IncorrectDataException;
import exception.NoElementException;
import exception.UnknowElementException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/*
Команда выполняет скрипт из указанного файла
 */
public class ExecuteScriptCommand implements Command {
    @Override
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException, NoElementException, IOException {
        String path = arg[1];
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        String line;
        String[] per = new String[11];
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.split(" ")[0].equals("insert")) {
                String key = line.split(" ")[1];
                for (int n = 0; n < 11; n++) {
                    line = scanner.nextLine();
                    per[n] = line;
                }
                CollectionManager.add(key, new Person(per));
            } else {
                StartCommand.startExecute(line);
            }
        }
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
