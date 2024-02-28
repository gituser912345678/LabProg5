package command;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.*;
/*
Класс-парсер файла.
 */
public class JsonReader {
    Map<String, Person> map = new LinkedHashMap<>();
    File file = new File("C:/Users/USER/IdeaProjects/ProgLab5/src/collection.json");
    Scanner scanner = new Scanner(file);
    private Object Person;

    public JsonReader() throws FileNotFoundException {
    }


    public void jsonReader() {
        String str = "";
        Type type = new TypeToken<LinkedHashMap<String, Person>>(){}.getType();
        while (scanner.hasNextLine()) {
            str += scanner.nextLine() + "\n";
        }
        try {
            map = new Gson().fromJson(str, type);
            CollectionManager.setMap((LinkedHashMap<String, data.Person>) map);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
