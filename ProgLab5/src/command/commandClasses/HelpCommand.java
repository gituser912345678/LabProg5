package command.commandClasses;

import command.StartCommand;

import java.util.LinkedHashMap;
/*
Команда выводящая подсказку по доступным командам.
 */
public class HelpCommand implements Command {
    @Override
    public void execute(String[] arg) {
        StartCommand startCommand = new StartCommand();
        LinkedHashMap<String, Command> commandTable = startCommand.getCommandTable();
        for(String s: commandTable.keySet()){
            System.out.println(commandTable.get(s).getName() + " " + commandTable.get(s).getDescription());
        }

    }

    @Override
    public String getName() {
        return "help: ";
    }

    @Override
    public String getDescription() {
        return "вывести справку по доступным командам";
    }


}
