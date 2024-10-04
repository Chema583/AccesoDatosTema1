package Tema2.ejercicios;

import java.io.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class ej3 {
    public static void main(String[] args)
            throws FileNotFoundException, IOException, SAXException, ParserConfigurationException{
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setNamespaceAware(true);
        EjercicioSAX gestor = new EjercicioSAX();
        SAXParser parser = parserFactory.newSAXParser();
        XMLReader reader = parser.getXMLReader();
        reader.setContentHandler(gestor);
        reader.parse(new InputSource("Becarios.xml"));
    }
}
//fin PruebaSax1

class EjercicioSAX extends DefaultHandler {
    public EjercicioSAX(){
        super();
    }
    public void startDocument(){
        System.out.println("Comienzo del XML");
    }
    public void endDocument(){
        System.out.println("Final del XML");
    }
    public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
        System.out.printf("\tPrincipio Elemento: %s %n",nombre);
    }
    public void endElement(String uri, String nombre, String nombreC) {
        System.out.printf("\tFin Elemento: %s %n", nombre);
    }
    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
        String car = new String(ch, inicio, longitud);
        //quitar saltos de línea
        car = car.replaceAll("[\t\n]", "");
        System.out.printf("\t Caracteres: %s %n", car);
    }
}
