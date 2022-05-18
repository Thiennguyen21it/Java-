package XML;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import org.w3c.dom.Document;
import java.io.IOException;

public class GfgXmlExtractor {
    public static void main(String[] args) {
        File file = new File("Course.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            System.out.println("Root element "+ document.getDocumentElement().getNodeName());

            //create a nodelist
            NodeList nodeList = document.getElementsByTagName("geek");

            for (int i=0; i <nodeList.getLength();i++) {
                Node node = nodeList.item(i);
                System.out.println("\nNode name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("User id :"+element.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("User name :"+element.getElementsByTagName("username").item(0).getTextContent());
                    System.out.println("Enrolled Course:  :"+element.getElementsByTagName("EnrolledCourse").item(0).getTextContent());
                    System.out.println("Mode :"+element.getElementsByTagName("mode").item(0).getTextContent());
                    System.out.println("Duration:"+element.getElementsByTagName("duration").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }
}
