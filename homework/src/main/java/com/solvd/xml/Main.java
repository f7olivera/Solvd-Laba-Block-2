package com.solvd.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SAXException {
        String xsdPath = "src/main/resources/schema.xsd";
        String xmlPath = "src/main/resources/schema.xml";
        boolean valid = XSDValidator.validateXMLSchema(xsdPath, xmlPath);
        LOGGER.info("XML file is " + (valid ? "valid." : "invalid."));
    }
}
