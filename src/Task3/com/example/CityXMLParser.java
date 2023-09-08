package Task3.com.example;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class CityXMLParser {
    public static void main(String[] args) {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            XMLHandler handler = new XMLHandler();

            parser.parse(new File("D:\\Work\\Home_Work_Java_Advanced\\Home_Work7_Java_Advanced\\src\\Task3\\com\\example\\city.xml"), handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class XMLHandler extends DefaultHandler {
        private String currentElement;
        private String citySize;
        private String cityName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;

            if ("city".equals(currentElement)) {
                citySize = attributes.getValue("size");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if ("city".equals(currentElement)) {
                cityName = new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("city".equals(qName)) {
                System.out.println("City: " + cityName);
                System.out.println("Size: " + citySize);
            }
        }
    }
}
