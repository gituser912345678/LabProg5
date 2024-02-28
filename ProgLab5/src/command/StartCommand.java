package command;

import command.commandClasses.*;
import exception.IncorrectDataException;
import exception.NoElementException;
import exception.UnknowElementException;
import exception.UnknownCommandException;

import java.io.IOException;
import java.util.LinkedHashMap;
/*
Класс содержащий команды и вызывающий их.
 */
public class StartCommand {
    private static LinkedHashMap<String, Command> commandTable;

    public StartCommand() {
        commandTable = new LinkedHashMap<>();
        commandTable.put("help", new HelpCommand());
        commandTable.put("show", new ShowCommand());
        commandTable.put("info", new InfoCommand());
        commandTable.put("insert", new InsertNullCommand());
        commandTable.put("exit", new ExitCommand());
        commandTable.put("remove_key", new RemoveKeyNullCommand());
        commandTable.put("update", new UpdateIdCommand());
        commandTable.put("clear", new ClearCommand());
        commandTable.put("remove_greater", new RemoveGreaterCommand());
        commandTable.put("remove_lower", new RemoveLowerCommand());
        commandTable.put("remove_greater_key", new RemoveGreaterKeyCommand());
        commandTable.put("filter_by_hair_color", new FilterByHairColorCommand());
        commandTable.put("print_field_descending_hair_color", new PrintFieldDescendingHairColorCommand());
        commandTable.put("save", new SaveCommand());
        commandTable.put("execute_script", new ExecuteScriptCommand());
    }

    public static void startExecute(String line) throws UnknowElementException, IncorrectDataException, NoElementException, IOException {
        String name = line.split(" ")[0];
        if (!commandTable.containsKey(name)) {
            throw new UnknownCommandException();
        } else {
            Command command = commandTable.get(name);
            command.execute(line.split(" "));
        }
    }

    public static LinkedHashMap<String, Command> getCommandTable() {
        return commandTable;
    }
}
