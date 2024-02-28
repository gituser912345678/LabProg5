package command;

import data.Person;
import exception.UnknowElementException;

import java.time.LocalDate;
import java.util.LinkedHashMap;

/*
Класс управляющий основной коллекциейю
 */
public class CollectionManager {
    /*
    Целевая коллекция.
     */
    private static LinkedHashMap<String, Person> map;
    private static LocalDate date = LocalDate.now();
    /*
    Метод возвращающий дату инициализации коллекции.
     */
    public static LocalDate getDate() {
        return date;
    }
    /*
    Метод добавляющий новый объект в коллекцию.
     */
    public static void add(String key, Person person) {
        map.put(key, person);
    }
    /*
    Удаляет элемент коллекции по ключу.
     */
    public static void remove(String key) throws UnknowElementException {
        if (map.containsKey(key)) {
            map.remove(key);
        } else {
            throw new UnknowElementException();
        }
    }
    /*
    Возвращает основную коллекцию.
     */

    public static LinkedHashMap<String, Person> getMap() {
        return map;
    }
    /*
    Изменяет основную коллекцию.
     */
    public static void setMap(LinkedHashMap<String, Person> map) {
        if (map != null) {
            CollectionManager.map = map;
        } else {
            CollectionManager.map = new LinkedHashMap<>();
        }
    }
}
