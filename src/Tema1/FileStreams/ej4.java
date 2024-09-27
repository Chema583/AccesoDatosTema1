package Tema1.FileStreams;

import java.io.*;
import java.util.Scanner;

public class ej4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numerosPares = new int[100];

        // Llenar el array con los 100 primeros números pares;

        for (int i = 0; i < 100; i++) {
            numerosPares[i] = i * 2;
        }

        boolean salir = false;

        //pintamos el menú;

        while (!salir) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Volcar los 100 primeros números pares a un fichero.");
            System.out.println("2. Mostrar el contenido del fichero.");
            System.out.println("3. Salir.");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();

            scanner.nextLine();

            // Consumir la nueva línea después del número

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del fichero (sin extensión): ");
                    String nombreFichero = scanner.nextLine() + ".txt";

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))) {
                        for (int num : numerosPares) {
                            bw.write(num + "\n");
                        }
                        System.out.println("Los números pares se han volcado al fichero " + nombreFichero);
                    } catch (IOException e) {
                        System.out.println("Error al escribir en el fichero: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Introduce el nombre del fichero a leer (sin extensión): ");
                    String nombreFicheroLectura = scanner.nextLine() + ".txt";

                    try (BufferedReader br = new BufferedReader(new FileReader(nombreFicheroLectura))) {
                        String linea;
                        System.out.println("\nContenido del fichero " + nombreFicheroLectura + ":");
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                    } catch (IOException e) {
                        System.out.println("Error al leer el fichero: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 3.");
                    break;
            }
        }

        scanner.close();
    }
}

