package Task2.com.example;
import java.io.*;

class Animal implements Serializable {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        Animal cat = new Animal("Whiskers", 3);

        // Серіалізація об'єкта в файл
        try (FileOutputStream fileOut = new FileOutputStream("animal.txt");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(cat);
            System.out.println("Об'єкт Animal серіалізований у файл animal.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileIn = new FileInputStream("animal.txt");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Animal deserializedCat = (Animal) in.readObject();
            System.out.println("Об'єкт Animal десеріалізований з файлу:");
            System.out.println("Ім'я: " + deserializedCat.getName());
            System.out.println("Вік: " + deserializedCat.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
