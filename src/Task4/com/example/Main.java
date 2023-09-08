package Task4.com.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\Work\\Home_Work_Java_Advanced\\Home_Work7_Java_Advanced\\src\\Task4\\com\\example\\city.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(City.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            City city = (City) jaxbUnmarshaller.unmarshal(file);

            System.out.println("City Size: " + city.getSize());
            for (Street street : city.getStreets()) {
                System.out.println("Street Name: " + street.getName());
                System.out.println("House Number: " + street.getHouse());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
