package Tema1.FicheroBinario;

import java.io.*;
import java.util.Scanner;

public class ej1 {

    public static void main(String[] args) throws FileNotFoundException {


        Scanner sc = new Scanner(System.in);

        boolean salir = false;

        while (true) {
            //Pintamos el menú;
            System.out.println("Pulsa 1 para crear un fichero binario");
            System.out.println("Pulsa 2 para leer un fichero binario");
            System.out.println("Pulsa 3 para salir del programa");

            int opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    //pasamos los datos pedidos en el enunciado del ejercicio;
                    System.out.println("Introduce tu nombre");
                    String nombre = sc.nextLine();

                    System.out.println("Introduce tu edad");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Introduce tu ciudad de nacimiento");
                    String ciudad = sc.nextLine();

                    //para escribir los datos pasados desde el programa al fichero;
                    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("persona.dat"))) {
                        dos.writeUTF(nombre);
                        dos.writeInt(edad);
                        dos.writeUTF(ciudad);
                        System.out.println("Datos guardados correctamente en persona.dat.");
                    } catch (IOException e) {
                        System.out.println("Error al escribir en el fichero binario: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Opción 2: Mostrar contenido del fichero binario persona.dat
                    try (DataInputStream dis = new DataInputStream(new FileInputStream("persona.dat"))) {
                        String nombreLeido = dis.readUTF();
                        int edadLeida = dis.readInt();
                        String ciudadLeida = dis.readUTF();

                        System.out.println("\nContenido del fichero persona.dat:");
                        System.out.println("Nombre: " + nombreLeido);
                        System.out.println("Edad: " + edadLeida);
                        System.out.println("Ciudad de nacimiento: " + ciudadLeida);
                    } catch (FileNotFoundException e) {
                        System.out.println("El fichero persona.dat no existe. Crea primero el archivo.");
                    } catch (IOException e) {
                        System.out.println("Error al leer el fichero binario: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Opción 3: Salir del programa
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 3.");
                    break;
            }
        }

    }

}
