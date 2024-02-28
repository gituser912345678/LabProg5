package data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Person implements Comparable<Person> {
    private int id;//
    private String name;//
    private Coordinates coordinates;//
    private Date creationDate = new Date();//
    private Double height;//
    private EyeColor eyeColor;//
    private HairColor hairColor;//
    private Country nationality;
    private Location location;

    public int getId() {
        return id;
    }

    private static ArrayList<Integer> arrayListId = new ArrayList<>();

    public Person() {
        if (arrayListId.isEmpty()) {
            this.id = 0;
            arrayListId.add(this.id);
        } else {
            this.id = arrayListId.get(arrayListId.size() - 1) + 1;
            arrayListId.add(this.id);
        }
    }

    public Person(String[] data) {
        this.id = Integer.parseInt(data[0]);
        this.name = data[1];
        this.coordinates = new Coordinates(Double.parseDouble(data[2]), Integer.parseInt(data[3]));
        this.creationDate = new Date();
        this.height = Double.parseDouble(data[4]);
        this.eyeColor = EyeColor.valueOf(data[5]);
        this.hairColor = HairColor.valueOf(data[6]);
        this.nationality = Country.valueOf(data[7]);
        this.location = new Location(Double.parseDouble(data[8]), Long.parseLong(data[9]), Integer.parseInt(data[10]));
    }

    public Location getLocation() {
        return location;
    }

    public Country getNationality() {
        return nationality;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public Double getHeight() {
        return height;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public Person(Integer id) {
        this.id = id;
    }

    public void setCreationDate(Date d) {
        this.creationDate = d;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено");
        } else {
            this.coordinates = coordinates;
        }
    }

    public void setLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено");
        } else {
            this.location = location;
        }
    }

    public void setNationality(Country nationality) {
        if (nationality == null) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено");
        } else {
            this.nationality = nationality;
        }
    }

    public void setHeight(Double height) {
        if (height == null || height <= 0) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено и значение поля должно быть больше 0");
        } else {
            this.height = height;
        }
    }

    public void setHairColor(HairColor hairColor) {
        if (hairColor == null) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено");
        } else {
            this.hairColor = hairColor;
        }
    }

    public void setEyeColor(EyeColor eyeColor) {
        if (eyeColor == null) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено");
        } else {
            this.eyeColor = eyeColor;
        }
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено");
        } else {
            this.name = name;
        }

    }

    @Override
    public int compareTo(Person person) {
        return this.id - person.id;
    }
}
