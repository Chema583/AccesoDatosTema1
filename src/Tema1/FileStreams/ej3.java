package Tema1.FileStreams;

import java.io.*;
import java.util.Scanner;

public class ej3 {

    // Metodo principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        String nombreFichero = "datos_personales.txt";

        do {
            // Mostrar el menú
            System.out.println("Menú:");
            System.out.println("1. Crear un fichero de texto.");
            System.out.println("2. Mostrar el contenido del fichero.");
            System.out.println("3. Salir.");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearFichero(nombreFichero, scanner);
                    break;
                case 2:
                    mostrarContenidoFichero(nombreFichero);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 3);

        scanner.close();
    }

    // Metodo para crear el fichero de texto y escribir los datos
    private static void crearFichero(String nombreFichero, Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero))) {
            System.out.print("Introduce tu nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Introduce tus apellidos: ");
            String apellidos = scanner.nextLine();

            System.out.print("Introduce tu ciudad de nacimiento: ");
            String ciudad = scanner.nextLine();

            writer.write("Nombre: " + nombre + "\n");
            writer.write("Apellidos: " + apellidos + "\n");
            writer.write("Ciudad de Nacimiento: " + ciudad + "\n");

            System.out.println("Fichero creado y datos escritos correctamente.");

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el fichero: " + e.getMessage());
        }
    }

    // Metodo para leer y mostrar el contenido del fichero de texto
    private static void mostrarContenidoFichero(String nombreFichero) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            System.out.println("Contenido del fichero:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe. Crea primero el fichero.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al leer el fichero: " + e.getMessage());
        }
    }
}
