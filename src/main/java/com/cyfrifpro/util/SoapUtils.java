package com.cyfrifpro.util;

import java.io.StringReader;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.InputSource;

public class SoapUtils {

    // Utility method to parse SOAP response and extract <getPasswordResult>
    public static String parseGetPasswordResponse(String soapResponse) {
        try {
            // Initialize a DocumentBuilderFactory to parse the XML string
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Convert the XML string into an InputSource, then parse it into a Document
            InputSource inputSource = new InputSource(new StringReader(soapResponse));
            Document document = builder.parse(inputSource);

            // Use getElementsByTagName to find all nodes matching <getPasswordResult>
            NodeList nodeList = document.getElementsByTagName("getPasswordResult");

            // Check if the nodeList contains any items, and return the first one (should only be one)
            if (nodeList.getLength() > 0) {
                return nodeList.item(0).getTextContent();
            }

        } catch (Exception e) {
            // Handle XML parsing errors (invalid response, etc.)
            e.printStackTrace();
        }
        return null;  // Return null if something goes wrong or element is not found
    }
}
