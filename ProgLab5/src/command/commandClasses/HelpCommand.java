package command.commandClasses;

/**
Команда выводящая подсказку по доступным командам.
 */
public class HelpCommand implements Command {
    @Override
    public void execute(String[] arg) {
        Reciver.help();
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
