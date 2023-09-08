package Task4.com.example;

import javax.xml.bind.annotation.XmlElement;

public class Street {
    private String name;
    private String house;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}
