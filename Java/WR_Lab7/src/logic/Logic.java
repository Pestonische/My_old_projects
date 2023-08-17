package logic;

import readers.dom.ReaderDOM;
import readers.sax.ReaderSAX;
import readers.stax.ReaderStAX;
import static validation.Validation.checkXMLforXSD;

/**
 * Class Logic
 */
public class Logic {
    String pathXml = "C:\\Users\\alexe\\Desktop\\web_rips\\Lab7\\accounts.xml";
    String pathXsd = "C:\\Users\\alexe\\Desktop\\web_rips\\Lab7\\schema.xsd";
    boolean b;

    /**
     * The method initialize and start xmlReaders
     */
    public void startReaders(){
        ReaderDOM readerDOM = new ReaderDOM();
        readerDOM.xmlReaderDOM(pathXml);

        ReaderSAX readerSAX = new ReaderSAX();
        readerSAX.xmlReaderSAX(pathXml);

        ReaderStAX readerStAX = new ReaderStAX();
        readerStAX.xmlReaderStAX(pathXml);
    }

    /**
     * The method make validation
     * @return boolean b
     * @throws Exception
     */
    public boolean makeValidation() throws Exception{
        return b = checkXMLforXSD(pathXml, pathXsd);
    }
}
