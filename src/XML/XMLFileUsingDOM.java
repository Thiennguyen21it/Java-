package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLFileUsingDOM {
    public static void main(String[] args) {
        try{
            File xmlDoc = new File("Student.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlDoc);
            //Read root element                      //doc locate root            //give me its name
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            // read array of student elements
            //this array called nodelist
            NodeList nodeList = doc.getElementsByTagName("student");

            for (int i =0 ; i < nodeList.getLength();i++) {
                Node node = nodeList.item(i);
                System.out.println("Node name : " + node.getNodeName()+" " +(i+1));
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Student ID#: " + element.getAttribute("indo"));
                    System.out.println("Student First name : " +element.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Student Last name : " +element.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Student Score : " +element.getElementsByTagName("score").item(0).getTextContent());
                    System.out.println("--------------------------------------------------------------");
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
