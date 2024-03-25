package command.commandClasses;

/**
Команда выводящая информацию о коллекции.
 */
public class InfoCommand  implements Command{

    @Override
    public void execute(String[] arg) {
        Reciver.info();
    }

    @Override
    public String getName() {
        return "info: ";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
