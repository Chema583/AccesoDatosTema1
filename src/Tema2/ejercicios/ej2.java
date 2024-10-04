package Tema2.ejercicios;

import Tema1.FicheroBinario.ej2.Becario;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ej2 {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("Becarios.xml"));
            document.getDocumentElement().normalize();
            System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());
            //crea una lista con todos los nodos becario
            NodeList becario= document.getElementsByTagName("Becario");
            System.out.printf("Nodos becarios a recorrer: %d %n", becario.getLength());
            //recorrer la lista
            for (int i=0; i < becario.getLength(); i ++){
                Node bec = bec.item(i);
                if (bec.getNodeType() == Node.ELEMENT_NODE){ //tipo nodo
                    //obtener los elementos del nodo
                    Element elemento= (Element) bec;
                    System.out.printf("Nombre y apellidos - %s %n", elemento.getElementsByTagName ("Nombre y Apellidos: ").item(0).getTextContent());
                    System.out.printf("Sexo - %s %n", elemento.getElementsByTagName ("Sexo: ").item(0).getTextContent());
                    System.out.printf(" * Departamento = %s %n", elemento.getElementsByTagName ("dep").item(0).getTextContent());
                    System.out.printf(" *Salario= %s %n", elemento.getElementsByTagName ("salario").item(0).getTextContent());
                    System.out.printf(" *Salario= %s %n", elemento.getElementsByTagName ("salario").item(0).getTextContent());
                    System.out.printf(" *Salario= %s %n", elemento.getElementsByTagName ("salario").item(0).getTextContent());
                    System.out.printf(" *Salario= %s %n", elemento.getElementsByTagName ("salario").item(0).getTextContent());
                }
            }
        }catch (Exception e) {e.printStackTrace();}

    }

}
