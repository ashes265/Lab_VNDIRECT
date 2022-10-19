package edu.java.jaxp;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ElementCounter extends DefaultHandler {
    private int counter=0;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element ----"+qName);
        if("book".equals(qName))counter++;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element ----"+qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Found "+counter+" book elements in the document!");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(" Text data = | "+new String(ch,start,length)+" | ");
    }

    public static void main(String[] args) throws SAXException, IOException {

        XMLReader parser=XMLReaderFactory.createXMLReader();
        ContentHandler handler=new ElementCounter();
        parser.setContentHandler(handler);
        File file=new File("./Books.xml");
        InputStream stream=ElementCounter.class.getResource(file.getAbsolutePath()).openStream();
        parser.parse(new InputSource(stream));
        System.out.println("Done");
    }
}
