package command;

import exception.NoElementException;

import java.io.InputStream;
import java.util.Scanner;
/*
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
            } catch (Exception ignored) {
                System.out.println("Ошибка:" + ignored);
            } catch (NoElementException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
