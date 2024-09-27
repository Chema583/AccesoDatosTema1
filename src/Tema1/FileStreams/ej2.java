package Tema1.FileStreams;

import java.io.*;

public class ej2 {

    public static void main(String[] args) {
        // Verificar si se pasó un argumento (el nombre del fichero)
        if (args.length != 1) {
            System.out.println("Uso correcto: java MostrarFicheroTexto <nombre_del_fichero>");
            return;
        }

        String nombreFichero = args[0];  // Obtener el nombre del fichero del primer argumento

        // Llamar al metodo para mostrar el contenido del fichero
        mostrarContenidoFichero(nombreFichero);
    }

    // Metodo para leer y mostrar el contenido del fichero
    private static void mostrarContenidoFichero(String nombreFichero) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            System.out.println("Contenido del fichero '" + nombreFichero + "':");
            // Leer el fichero línea por línea
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero '" + nombreFichero + "' no existe.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al leer el fichero: " + e.getMessage());
        }
    }
}
