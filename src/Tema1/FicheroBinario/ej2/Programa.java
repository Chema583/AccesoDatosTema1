package Tema1.FicheroBinario.ej2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Recogida de datos del becario
        System.out.print("Introduce el nombre y apellido del becario: ");
        String nombreApellido = scanner.nextLine();

        char sexo;

        do {

            System.out.print("Introduce el sexo (H/M): ");
            sexo = scanner.nextLine().toUpperCase().charAt(0);

        } while (sexo != 'H' && sexo != 'M');

        int edad;

        do {

            System.out.print("Introduce la edad (20 a 60): ");
            edad = scanner.nextInt();

        } while (edad < 20 || edad > 60);

        int numeroSuspensos;

        do {

            System.out.print("Introduce el número de suspensos del curso anterior (0 a 4): ");
            numeroSuspensos = scanner.nextInt();

        } while (numeroSuspensos < 0 || numeroSuspensos > 4);

        boolean residenciaFamiliar;
        String respuesta;
        do {
            System.out.print("¿Tiene residencia familiar? (Sí/No): ");
            respuesta = scanner.next().toUpperCase();
        } while (!respuesta.equals("SI") && !respuesta.equals("NO"));
        residenciaFamiliar = respuesta.equals("SI");

        System.out.print("Introduce los ingresos anuales de la familia: ");
        double ingresosAnuales = scanner.nextDouble();

        // Crear un objeto Becario con los datos proporcionados
        Becario becario = new Becario(nombreApellido, sexo, edad, numeroSuspensos, residenciaFamiliar, ingresosAnuales);

        // Guardar los datos del becario en un archivo binario
        guardarBecarioEnArchivo(becario);

        // Mostrar los datos almacenados del becario
        System.out.println("\nDatos del becario guardados correctamente.");
        becario.mostrarDatos();

        scanner.close();
    }

    // Metodo para guardar el objeto becario en un archivo binario
    public static void guardarBecarioEnArchivo(Becario becario) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("datosbeca.bin"))) {
            salida.writeObject(becario);  // Guardar el objeto becario en el archivo
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
}

