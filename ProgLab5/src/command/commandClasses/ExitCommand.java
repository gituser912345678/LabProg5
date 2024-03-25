package command.commandClasses;
/**
Команда осуществляющая выход из приложения.
 */
public class ExitCommand implements Command{
    @Override
    public void execute(String[] arg) {
        Reciver.exit();
    }

    @Override
    public String getName() {
        return "exit: ";
    }

    @Override
    public String getDescription() {
        return "завершить программу (без сохранения в файл)";
    }
}
