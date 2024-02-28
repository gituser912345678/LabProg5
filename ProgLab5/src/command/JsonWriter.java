package command;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
/*
Класс записывающий коллекцию в файл.
 */
public class JsonWriter {
    public void execute() throws IOException {
        LinkedHashMap<String, Person> map = CollectionManager.getMap();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/USER/IdeaProjects/ProgLab5/src/collection.json"))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(map, writer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
