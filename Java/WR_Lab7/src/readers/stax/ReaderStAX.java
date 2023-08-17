package readers.stax;

import account.Account;
import account.Account;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * Class ReaderStAX
 */
public class ReaderStAX {

    private static Logger LOGGER = Logger.getLogger(String.valueOf(ReaderStAX.class));

    /**
     * The method show work of StAX parser
     * @param pathXml- path to XML
     */
    public static void xmlReaderStAX(String pathXml) {

        List<Account> accList = parseXML(pathXml);

        System.out.println("\nAccounts in the XML file by StAX:");

        for(Account acc : accList){
            System.out.println(acc.toString());
        }
    }

    /**
     *  The method parses XML file
     * @param pathXml - path to XML
     * @return List of Accounts objects
     */
    private static List<Account> parseXML(String pathXml) {

        List<Account> tbList = new ArrayList<>();
        Account acc = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(pathXml));

            while(xmlEventReader.hasNext()){

                XMLEvent xmlEvent = xmlEventReader.nextEvent();

                if (xmlEvent.isStartElement()){
                    LOGGER.info("Take start element.");

                    StartElement startElement = xmlEvent.asStartElement();

                    if(startElement.getName().getLocalPart().equals("Account")){
                        acc = new Account();
                    }
                    if(startElement.getName().getLocalPart().equals("accountNumber")){
                        xmlEvent = xmlEventReader.nextEvent();
                        acc.SetAccountNumber(xmlEvent.asCharacters().getData());
                    }
                    if(startElement.getName().getLocalPart().equals("amountMoney")){
                        xmlEvent = xmlEventReader.nextEvent();
                        acc.SetAmountMoney(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }
                    if(startElement.getName().getLocalPart().equals("blocked")){
                        xmlEvent = xmlEventReader.nextEvent();
                        acc.SetBlocked(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                    }
                }

                if(xmlEvent.isEndElement()){

                    EndElement endElement = xmlEvent.asEndElement();

                    if(endElement.getName().getLocalPart().equals("Account")){
                        LOGGER.info("End element is reached, adding Account object to list.");
                        tbList.add(acc);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return tbList;
    }
}