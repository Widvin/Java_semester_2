import by.gsu.ms42.*;
import jdk.internal.org.objectweb.asm.tree.InsnList;
import org.xml.sax.SAXException;
import by.gsu.ms42.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        final String URL = "https://www.cbr-xml-daily.ru/daily.xml";


            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            int userInput;
            boolean isTrue = true;

            while (isTrue){
                System.out.println("Choose an operation");
                System.out.println("1:Dom parser");
                System.out.println("2:SAX parser");
                System.out.println("3:StAX parser");

                userInput = scanner.nextInt();
                
                switch (userInput) {
                    case (1): {
                        DOMparser.DOMparser(URL);
                        System.out.println();
                        break;
                    }
                    case (2): {
                       SAXParser.SAXparser(URL);
                        
                        break;
                    }
                    case (3):{
                        StAXparser.StAXparser(URL);
                        
                        break;
                    }



            }
        }

    }
    }
