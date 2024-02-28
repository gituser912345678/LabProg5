package command.commandClasses;


import exception.IncorrectDataException;
import exception.NoElementException;
import exception.UnknowElementException;

import java.io.IOException;
/*
Интерфейс определяющий методы которые будут содержаться в командах.
 */
public interface Command {
    public void execute(String[] arg) throws UnknowElementException, IncorrectDataException, NoElementException, IOException;
    public String getName();
    public String getDescription();
}
