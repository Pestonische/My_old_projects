package readers.sax;

import account.Account;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class MyHandler
 */
public class MyHandler extends DefaultHandler {

    private static Logger LOGGER = Logger.getLogger(String.valueOf(MyHandler.class));

    private List<Account> accList = null;
    private Account acc = null;

    /**
     * The method returns list of accounts objects
     * @return List of accounts objects
     */
    public List<Account> getAccList() {
        return accList;
    }

    boolean bAccountNumber = false;
    boolean bAmountMoney = false;
    boolean bBlocked = false;

    /**
     * Overriding the method startElement().
     * We are overriding this method to set boolean variables that will be used to identify the element.
     * @param uri - the namespace URI
     * @param localName - the local name
     * @param qName - the qualified name
     * @param attributes - the attributes attached to the element
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        LOGGER.info("Take start element.(SAX)");
        if (qName.equalsIgnoreCase("Account")) {
            acc = new Account();

            if (accList == null)
                accList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("accountNumber")) {
            bAccountNumber = true;
        } else if (qName.equalsIgnoreCase("amountMoney")) {
            bAmountMoney = true;
        } else if (qName.equalsIgnoreCase("blocked")) {
            bBlocked = true;
        }
    }

    /**
     * Overriding the method endElement().
     * @param uri - the namespace URI
     * @param localName - the local name
     * @param qName - the qualified name
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Account")) {
            LOGGER.info("End element is reached, adding TariffBonus object to list.(SAX)");
            accList.add(acc);
        }
    }

    /**
     * Overriding the method characters().
     * We are using boolean fields to set the value to correct field in account object.
     * @param ch - the characters
     * @param start - the start position in the character array
     * @param length -  the number of characters to use from the character array
     * @throws SAXException
     */
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bAccountNumber) {
            acc.SetAccountNumber(new String(ch, start, length));
            bAccountNumber = false;
        } else if (bAmountMoney) {
            acc.SetAmountMoney(Integer.parseInt(new String(ch, start, length)));
            bAmountMoney = false;
        } else if (bBlocked) {
            acc.SetBlocked(Boolean.parseBoolean(new String(ch, start, length)));
            bBlocked = false;
        }
    }
}