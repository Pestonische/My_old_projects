package validation;

import java.io.File;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 * Class Validation
 */
public class Validation {

    private static Logger LOGGER = Logger.getLogger(String.valueOf(Validation.class));

    /**
     * The method check XML and XSD files for matching.
     * @param pathXml - path to XML
     * @param pathXsd - path to XSD
     */
    public static boolean checkXMLforXSD(String pathXml, String pathXsd) throws Exception {

        try {
            LOGGER.info("Opening files for validation.");

            File xml = new File(pathXml);
            File xsd = new File(pathXsd);

            if (!xml.exists()) {
                System.out.println("XML not found " + pathXml);
                LOGGER.info("XML not found " + pathXml);
            }

            if (!xsd.exists()) {
                System.out.println("XSD not found " + pathXsd);
                LOGGER.info("XSD not found " + pathXsd);
            }

            if (!xml.exists() || !xsd.exists()) {
                return false;
            }

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(pathXsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(pathXml));

            LOGGER.info("Validation completed, XML matches XSD");
            return true;
        } catch (SAXException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}