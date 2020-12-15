package by.gsu.ms42;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXparser {
    public static void StAXparser(String URL) {
        String fileName = "daily.xml";
        private static List<Valute> parseXMLfile List<Valute> ValuteList = parseXMLfile(fileName);
        for (Valute Valute : ValuteList) {
            System.out.println(
                    Valute.toString());
            }


            List<Valute> ValutesList = new ArrayList<>();
            Valute Valute = null;
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            try {
                XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
                while (reader.hasNext()) {
                    XMLEvent xmlEvent = reader.nextEvent();
                    if (xmlEvent.isStartElement()) {
                        StartElement startElement = xmlEvent.asStartElement();
                        if (startElement.getName().getLocalPart().equals("Valute")) {
                            Valute = new Valute();
                            Attribute idAttr = startElement.getAttributeByName(new QName("ID"));
                            if (idAttr != null) {
                                Valute.setID(Integer.parseInt(idAttr.getValue()));
                            }
                        } else if (startElement.getName().getLocalPart().equals("NumCode")) {
                            xmlEvent = reader.nextEvent();
                            Valute.setNumcode(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        } else if (startElement.getName().getLocalPart().equals("CharCode")) {
                            xmlEvent = reader.nextEvent();
                            Valute.setCharcode(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("Nominal")) {
                            xmlEvent = reader.nextEvent();
                            Valute.setNominal(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        } else if (startElement.getName().getLocalPart().equals("Name")) {
                            xmlEvent = reader.nextEvent();
                            Valute.setName(String.valueOf(xmlEvent.asCharacters().getData()));
                        } else if (startElement.getName().getLocalPart().equals("Value")) {
                            xmlEvent = reader.nextEvent();
                            Valute.setValue(Double.valueOf(xmlEvent.asCharacters().getData()));
                        }
                    }
                    if (xmlEvent.isEndElement()) {
                        EndElement endElement = xmlEvent.asEndElement();
                        if (endElement.getName().getLocalPart().equals("Valute")) {
                            ValutesList.add(Valute);
                        }
                    }
                }

            } catch (FileNotFoundException | XMLStreamException exc) {
                exc.printStackTrace();
            }
        }
    }

