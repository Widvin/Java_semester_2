package by.gsu.ms42;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import by.gsu.ms42.Valute;


public class DOMparser {
    public static void DOMparser(String URL) throws ParserConfigurationException, IOException, SAXException {
        File file = new File("daily.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element valuteElement = (Element) document.getElementsByTagName("Valute").item(0);
        String charCode = valuteElement.getAttribute("CharCode");

        NodeList valuteNodeList = document.getElementsByTagName("Valute");

        List<Valute> valuteList = new ArrayList<>();

        for (int i = 0; i < valuteNodeList.getLength(); i++) {
            if (valuteNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element valutesElement = (Element) valuteNodeList.item(i);

                Valute valute = new Valute();
                valute.setCharcode(charCode);
                valute.setID(Integer.valueOf(valutesElement.getAttribute("ID")));

                NodeList childNotes = valuteElement.getChildNodes();
                for (int j = 0; j < childNotes.getLength(); j++) {
                    if (childNotes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNotes.item(j);

                        switch (childElement.getNodeName()) {
                            case "ID": {
                                valute.setID(Integer.valueOf(childElement.getTextContent()));
                            }
                            break;

                            case "NumCode": {
                                valute.setNumcode(Integer.valueOf(childElement.getTextContent()));
                            }
                            break;


                            case "CharCode": {
                                valute.setCharcode(childElement.getTextContent());
                            }
                            break;

                            case "Nominal": {
                                valute.setNominal(Integer.valueOf(childElement.getTextContent()));
                            }
                            break;

                            case "Name": {
                                valute.setName(childElement.getTextContent());
                            }
                            break;

                            case "Value": {
                                valute.setValue(Double.valueOf(childElement.getTextContent()));
                            }

                        }
                    }
                }

                valuteList.add(valute);

            }
        }

        valuteList.forEach(System.out::println);

    }



}


