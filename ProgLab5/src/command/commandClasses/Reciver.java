package command.commandClasses;

import command.CollectionManager;
import command.JsonWriter;
import command.StartCommand;
import data.HairColor;
import data.Person;
import data.PersonComparator;
import data.generators.PersonGenerator;
import exception.IncorrectDataException;
import exception.NoElementException;
import exception.UnknowElementException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Reciver {

    private static JsonWriter jsonWriter;

    public static void setWriter(JsonWriter jsonWriter) {
        Reciver.jsonWriter = jsonWriter;
    }

    public static void save() throws IOException {
        jsonWriter.execute();
    }

    public void clear() {
        Map<String, Person> map = CollectionManager.getMap();
        map.clear();
        CollectionManager.setMap((LinkedHashMap<String, Person>) map);
        System.out.println("Clear...........");
    }

    public static void executeScript() throws IOException {
        System.out.println("Введите желаемый путь");
        Scanner scann = new Scanner(System.in);


        File file = new File(scann.nextLine());
        Scanner scanner = new Scanner(file);

        String line;
        try {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                kek:
                if (line.split(" ")[0].equals("insert")) {
                    ArrayList<String> array = new ArrayList<>();
                    String key = line.split(" ")[1];
                    StartCommand startCommand = new StartCommand();
                    while (!startCommand.getCommandTable().containsKey(line = scanner.nextLine())) {
                        if (scanner.hasNextLine()) {
                            if (startCommand.getCommandTable().containsKey(line.split(" ")[0])) {
                                startCommand.startExecute(line);
                            } else if (line.equals(" ") || line.isEmpty()) {
                                break kek;
                            } else {
                                array.add(line.split(" ")[0]);
                            }
                        } else {
                            System.out.println("...");
                            break kek;
                        }
                    }
                    CollectionManager.add(key, new Person(array));
                    System.out.println("Персонаж успешно добавлен.");
                } else if (line.split(" ")[0].equals("update")) {
                    LinkedList<String> array = new LinkedList<>();
                    String key = line.split(" ")[1];
                    StartCommand startCommand = new StartCommand();
                    while (!startCommand.getCommandTable().containsKey(line = scanner.nextLine())) {
                        if (scanner.hasNextLine()) {
                            if (line.equals(" ") || line.isEmpty()) {
                                break kek;
                            } else {
                                array.add(line.split(" ")[0]);
                            }
                        } else {
                            System.out.println("...");
                            break kek;
                        }
                    }
                    CollectionManager.add(key, new Person(array));
                    System.out.println("Персонаж успешно обновлён.");
                } else if (line.split(" ")[0].equals("execute_script") && line.split(" ").length < 2) {
                    System.out.println("Я не буду выполнять команду execute_scrip");
                } else {
                    StartCommand startCommand = new StartCommand();
                    if (startCommand.getCommandTable().containsKey(line.split(" ")[0])) {
                        startCommand.startExecute(line);
                    } else {
                        System.out.println("...");
                    }
                }
            }
        } catch (Exception | NoElementException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void exit() {
        System.exit(1);
    }

    public static void filterByHairColor() {
        try {
            LinkedHashMap<String, Person> map = CollectionManager.getMap();

            Scanner in = new Scanner(System.in);
            System.out.println("Введите желаемый  цвет волос: ");
            String[] personsColor = in.nextLine().split(" ");
            HairColor color = HairColor.valueOf(personsColor[0]);

            for (String key : map.keySet()) {
                if (map.get(key).getHairColor().compareTo(color) == 0) {
                    System.out.println(map.get(key).getHairColor().toString());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void help() {
        StartCommand startCommand = new StartCommand();
        LinkedHashMap<String, Command> commandTable = startCommand.getCommandTable();
        for (String s : commandTable.keySet()) {
            System.out.println(commandTable.get(s).getName() + " " + commandTable.get(s).getDescription());
        }
    }

    public static void info() {
        System.out.println("Data type - " + CollectionManager.getMap().getClass().getName());
        System.out.println("Count of persons - " + CollectionManager.getMap().size());
        System.out.println("Init date - " + CollectionManager.getDate());
    }

    public static void insert(String[] arg) {
        try {
            Person person = PersonGenerator.createPerson(0);
            CollectionManager.add(arg[1], person);
        } catch (IncorrectDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printFieldDescendingHairColor() {
        LinkedHashMap<String, Person> map = CollectionManager.getMap();

        PersonComparator personComparator = new PersonComparator();
        ArrayList<HairColor> array = new ArrayList<>();

        for (String key : map.keySet()) {
            array.add(map.get(key).getHairColor());
        }
        array.sort(personComparator);
        Collections.reverse(array);

        array.forEach(System.out::println);
    }

    public static void removeGreater(String[] arg) throws IncorrectDataException {
        Person person = PersonGenerator.createPerson(0);

        CollectionManager.add(arg[1], person);
        Iterator<Map.Entry<String, Person>> iterator = CollectionManager.getMap().entrySet().iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals(person)) {
                while (iterator.hasNext()) {
                    iterator.remove();
                }
            }
        }
    }

    public static void removeGreaterKey() {
        LinkedHashMap<String, Person> map = CollectionManager.getMap();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите желаемый ключ: ");
        String[] personsKey = in.nextLine().split(" ");
        for (String key : map.keySet()) {
            if (key.compareTo(personsKey[0]) > 0) {
                map.remove(key);
            }
        }
        CollectionManager.setMap(map);
    }

    public static void removeKey(String[] arg) throws UnknowElementException {
        CollectionManager.remove(arg[1]);
    }

    public static void removeLower(String[] arg) throws IncorrectDataException {
        Person person = PersonGenerator.createPerson(0);

        CollectionManager.add(arg[1], person);
        LinkedHashMap<String, Person> map = new LinkedHashMap<>();

        LinkedHashMap<String, Person> map1 = CollectionManager.getMap();

        List<String> reverseOrderedKeys = new ArrayList<>(map1.keySet());
        Collections.reverse(reverseOrderedKeys);
        for (String key : reverseOrderedKeys) {
            Person line = map.get(key);
            map.put(key, line);
        }

        Iterator<Map.Entry<String, Person>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            if (person.equals(iterator.next())) {
                while (iterator.hasNext()) {
                    iterator.remove();
                }
            }
        }
        LinkedHashMap<String, Person> map3 = new LinkedHashMap<>();
        for (String key : map.keySet()) {
            if (map.get(key) != null) {
                map3.put(key, map.get(key));
            }
        }
        CollectionManager.setMap(map3);
    }

    public static void show() {
        LinkedHashMap<String, Person> map = CollectionManager.getMap();
        if (map.isEmpty()) {
            System.out.println(CollectionManager.getMap().getClass().getName() + " is empty");
            return;
        }
        for (String s : map.keySet()) {
            System.out.println("Key: <" + s + "> " + map.get(s));
        }
    }

    public static void updateId(String[] arg) {
        try {
            Integer id = Integer.parseInt(arg[1]);

            for (String key : CollectionManager.getMap().keySet()) {
                if (Objects.equals(CollectionManager.getMap().get(key).getId(), id)) {
                    Person person = PersonGenerator.createPerson(id);
                    CollectionManager.remove(key);
                    CollectionManager.add(key, person);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
