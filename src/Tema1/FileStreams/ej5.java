package Tema1.FileStreams;

import java.io.*;
import java.util.Scanner;

public class ej5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedimos el nombre del fichero al usuario o  por teclado;

        System.out.print("Introduce el nombre del fichero (sin extensión): ");
        String nombreFichero = scanner.nextLine() + ".txt";

        // Pedimos el texto que queremos escribir en el fichero

        System.out.print("Introduce el texto que deseas guardar en el fichero: ");
        String texto = scanner.nextLine();

        // Escribir el texto en el fichero
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))) {
            bw.write(texto);
            System.out.println("El texto ha sido guardado en el fichero " + nombreFichero);
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
            return;
        }

        // Leer el texto del fichero y alternar entre mayúsculas y minúsculas
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            System.out.println("\nTexto del fichero alternando entre mayúsculas y minúsculas:");
            while ((linea = br.readLine()) != null) {
                System.out.println(alternarMayusculasMinusculas(linea));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        scanner.close();
    }

    // metodo para alternar mayúsculas y minúsculas respetando los espacios en blanco;
    public static String alternarMayusculasMinusculas(String texto) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isUpperCase(c)) {
                resultado.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                resultado.append(Character.toUpperCase(c));
            } else {
                resultado.append(c);  // Mantener caracteres que no son letras (como espacios)
            }
        }

        return resultado.toString();
    }
}

