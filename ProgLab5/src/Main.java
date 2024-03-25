import command.Input;
import command.JsonReader;
import command.JsonWriter;
import command.commandClasses.Reciver;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 0) {
            JsonReader jsonReader = new JsonReader();
            jsonReader.jsonReader(jsonReader.readJson(args));

            JsonWriter jsonWriter = new JsonWriter(args[0]);
            Reciver.setWriter(jsonWriter);
        }
        else{
            System.out.println("Ну не хочешь как хочешь сам теперь персонажей добавляй.");
        }

        Input input = new Input();

        input.start(System.in);
    }
}