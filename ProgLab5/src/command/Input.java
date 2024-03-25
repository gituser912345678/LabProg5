package command;

import exception.IncorrectDataException;
import exception.NoElementException;
import exception.UnknowElementException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
/**
Класс обрабатывающий ввод с консоли.
 */
public class Input {
    public void start(InputStream input) {
        Scanner scanner = new Scanner(input);
        StartCommand startCommand = new StartCommand();
        while (scanner.hasNext()) {

            String command = scanner.nextLine();
            try {
                startCommand.startExecute(command);
            } catch (NoElementException | UnknowElementException | IncorrectDataException | IOException | NullPointerException ignored) {
                System.out.println("Ошибка:" + ignored);
            }
            System.out.print(">>>");
        }
    }
}
