package Tema2.ejercicios;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import Tema1.FicheroBinario.ej2.Becario;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ej1 {

    public static void main(String[] args) throws FileNotFoundException {
        File archivoBinario = new File("datosbeca.bin");  // Archivo binario
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Leer los datos del becario desde el fichero binario
        try {
            ObjectInputStream dis = new ObjectInputStream(new FileInputStream(archivoBinario));
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Becarios", null);
            document.setXmlVersion("1.0");
            Becario b = (Becario) dis.readObject();
            Element raiz = document.createElement("becario"); //nodo empleado
            document.getDocumentElement().appendChild(raiz);

            //añadir ID
            CrearElemento("Nombre y Apellido:",b.getNombreApellido(), raiz, document);
            CrearElemento("Sexo (H/M):",Character.toString(b.getSexo()), raiz, document);

            CrearElemento("Edad:", Integer.toString(b.getEdad()), raiz, document);
            CrearElemento("Numero Suspensos", Integer.toString(b.getNumeroSuspensos()), raiz, document);
            CrearElemento("salario", b.getResidenciaFamiliar(), raiz, document);
            CrearElemento("Salario anual:", Double.toString(b.getIngresosAnuales()), raiz, document);
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Becarios.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch(Exception e) { System.err.println("Error: "+e); }
         //cerrar fichero

    }//fin del for que recorre el fichero


    static void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmple);
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegarnos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }
}
