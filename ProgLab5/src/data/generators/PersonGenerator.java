package data.generators;

import data.*;
import exception.IncorrectDataException;

import java.time.LocalDate;
import java.util.Scanner;
/*
Класс-генератор обЪекта.
 */
public class PersonGenerator {
    public static Person createPerson(Integer id) throws IncorrectDataException {
        System.out.println("Generate...");

        Scanner scanner = new Scanner(System.in);

        int b;
        Double a;
        Coordinates coordinates;
        Location location;
        double x1;
        long y1;
        int z1;

        Person person;
        if (id == 0) {
            person = new Person();
        } else {
            person = new Person(id);
        }

//        person.setCreationDate(Date.now());

        while (true) {
            try {
                System.out.println("Введите имя: ");
                person.setName(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите координату x: ");
                a = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                throw new IncorrectDataException("координата x");
            }
        }

        while (true) {
            try {
                System.out.println("Введите координату y: ");
                b = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                throw new IncorrectDataException("координата y");
            }
        }

        coordinates = new Coordinates(a, b);
        person.setCoordinates(coordinates);

        while (true) {
            try {
                System.out.println("Введите цвет глаз: доступные варианты: GREEN" + "    BLACK" + "    YELLOW" + "    WHITE" + "    BROWN: ");
                person.setEyeColor(EyeColor.valueOf(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите цвет волос: доступные варианты: RED" + "    BLACK" + "    YELLOW" + "    WHITE" + "    BROWN: ");
                person.setHairColor(HairColor.valueOf(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите рост: ");
                person.setHeight(Double.parseDouble(scanner.nextLine()));
                break;
            } catch (Exception e) {
                throw new IncorrectDataException("рост не может задаваться данным значением");
            }
        }

        while (true) {
            try {
                System.out.println("Введите страну: доступные варианты: UNITED_KINGDOM," + "    CHINA," + "    VATICAN," + "    THAILAND," + "    NORTH_KOREA");
                person.setNationality(Country.valueOf(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите координату x: ");
                x1 = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                throw new IncorrectDataException("координата x");
            }
        }

        while (true) {
            try {
                System.out.println("Введите координату y: ");
                y1 = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                throw new IncorrectDataException("координата y");
            }
        }

        while (true) {
            try {
                System.out.println("Введите координату z: ");
                z1 = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                throw new IncorrectDataException("координата z");
            }
        }

        location = new Location(x1, y1, z1);
        person.setLocation(location);

        return person;
    }
}
