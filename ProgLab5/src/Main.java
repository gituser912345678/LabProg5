import command.Input;
import command.JsonReader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        JsonReader jsonReader = new JsonReader();
        jsonReader.jsonReader();

        Input input = new Input();
        input.start(System.in);
    }
}