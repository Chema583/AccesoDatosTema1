package Tema1.FileStreams;

import java.io.*;
import java.util.Scanner;

public class ej6 {

    public static void main(String[] args) {
        String nombreFichero = "Tema1/FileStreams/numeros.txt";  // Nombre del fichero a leer
        int sumaTotal = 0;  // Variable para acumular la suma de los números

        try {
            // Abrimos el fichero con un Scanner
            Scanner scanner = new Scanner(new File(nombreFichero));

            // Leer línea por línea del fichero
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();  // Leemos una línea
                try {
                    // Convertimos la línea a un número entero
                    int numero = Integer.parseInt(linea);
                    sumaTotal += numero;  // Sumamos el número a la suma total
                } catch (NumberFormatException e) {
                    // Si la línea no puede convertirse a número, se muestra un mensaje de error
                    System.out.println("La línea no es un número válido: " + linea);
                }
            }

            scanner.close();  // Cerramos el Scanner

            // Mostrar la suma total
            System.out.println("La suma total de los números es: " + sumaTotal);

        } catch (FileNotFoundException e) {
            System.out.println("El fichero '" + nombreFichero + "' no se encuentra.");
        }
    }
}
