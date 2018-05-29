package game.auxilary;

import game.Board;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class AuxilaryMethodsXML {

    public static Object transferResultOfFire(boolean b) throws ParserConfigurationException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("FireResult");
        Element element = document.createElement("shot");
        element.setAttribute("result", String.valueOf(b));
        root.appendChild(element);
        document.appendChild(root);
        Object object = (Object) document;
        return object;
    }

    public static boolean acceptResultOfFire(Document document) throws IOException, ClassNotFoundException {
        boolean result = false;
        NodeList nodeList = document.getElementsByTagName("FireResult");
        Node node = nodeList.item(0);
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node childrenNode = children.item(i);
            if (childrenNode.getNodeType() == Node.ELEMENT_NODE) {
                NamedNodeMap attributes = childrenNode.getAttributes();
                result = Boolean.valueOf(attributes.getNamedItem("result").getNodeValue());
            }
        }

        return result;
    }

    public static Document writeXMLFire(int i, int j) throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("EnemyFire");
        Element shootOnRectangle = document.createElement("fire_on");
        shootOnRectangle.setAttribute("i", String.valueOf(i));
        shootOnRectangle.setAttribute("j", String.valueOf(j));
        root.appendChild(shootOnRectangle);
        document.appendChild(root);
        return document;
    }

/*    public static void readXMLFire(Object enemyShotCoordinates) {
        Document document = (Document) enemyShotCoordinates;
        NodeList nodeList = document.getElementsByTagName("EnemyFire");
        Node node = nodeList.item(0);
        NodeList children = node.getChildNodes();
        Node childrenNode = children.item(0);
    }*/
}
