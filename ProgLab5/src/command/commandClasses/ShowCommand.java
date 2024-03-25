package command.commandClasses;

/**
Команда позволяет вывести в стандартный поток вывода все элементы коллекции в строковом представлении.
 */
public class ShowCommand implements Command {
    @Override
    public void execute(String[] arg) {
        Reciver.show();
    }

    @Override
    public String getName() {
        return "show: ";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
