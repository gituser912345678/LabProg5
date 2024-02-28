package command.commandClasses;

import command.CollectionManager;
/*
Команда выводящая информацию о коллекции.
 */
public class InfoCommand  implements Command{

    @Override
    public void execute(String[] arg) {
        System.out.println("Data type - " + CollectionManager.getMap().getClass().getName());
        System.out.println("Count of persons - " + CollectionManager.getMap().size());
        System.out.println("Init date - " + CollectionManager.getDate());

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
