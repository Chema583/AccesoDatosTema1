package Tema1.FicheroBinario.ej3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            // Pintamos el menú
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear un fichero binario");
            System.out.println("2. Leer el fichero binario");
            System.out.println("3. Añadir una persona");
            System.out.println("4. Editar una persona existente");
            System.out.println("5. Salir");

            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    // Opción para crear un fichero (escribir los datos)
                    crearFichero(sc);
                    break;

                case 2:
                    // Opción para leer el fichero
                    leerFichero();
                    break;

                case 3:
                    // Opción para añadir una persona
                    añadirPersona(sc);
                    break;

                case 4:
                    // Opción para editar una persona existente
                    editarPersona(sc);
                    break;

                case 5:
                    // Opción para salir
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Elige una opción entre 1 y 5.");
                    break;
            }
        }
    }

    // Función para crear el fichero y escribir la primera persona
    public static void crearFichero(Scanner sc) {
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        System.out.print("Introduce tu ciudad de nacimiento: ");
        String ciudad = sc.nextLine();

        Persona persona = new Persona(nombre, edad, ciudad);

        // Escribimos los datos en el fichero binario (sobrescribe cualquier contenido existente)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persona.dat"))) {
            List<Persona> personas = new ArrayList<>();
            personas.add(persona);
            oos.writeObject(personas); // Guardamos la lista de personas
            System.out.println("Datos guardados correctamente en persona.dat.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero binario: " + e.getMessage());
        }
    }

    // Función para leer el contenido del fichero
    public static void leerFichero() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persona.dat"))) {
            List<Persona> personas = (List<Persona>) ois.readObject();
            System.out.println("\nContenido del fichero persona.dat:");
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero persona.dat no existe. Crea primero el archivo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el fichero binario: " + e.getMessage());
        }
    }

    // Función para añadir una nueva persona al fichero existente
    public static void añadirPersona(Scanner sc) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persona.dat"))) {
            List<Persona> personas = (List<Persona>) ois.readObject();

            // Pedimos los nuevos datos al usuario
            System.out.print("Introduce el nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Introduce la edad: ");
            int edad = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            System.out.print("Introduce la ciudad de nacimiento: ");
            String ciudad = sc.nextLine();

            Persona nuevaPersona = new Persona(nombre, edad, ciudad);
            personas.add(nuevaPersona);

            // Guardamos la nueva lista en el fichero
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persona.dat"))) {
                oos.writeObject(personas);
                System.out.println("Persona añadida correctamente.");
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al añadir persona: " + e.getMessage());
        }
    }

    // Función para editar una persona existente en el fichero
    public static void editarPersona(Scanner sc) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persona.dat"))) {
            List<Persona> personas = (List<Persona>) ois.readObject();

            // Mostramos la lista de personas
            System.out.println("\nLista de personas:");
            for (int i = 0; i < personas.size(); i++) {
                System.out.println((i + 1) + ". " + personas.get(i));
            }

            // Pedimos al usuario que elija una persona para editar
            System.out.print("Introduce el número de la persona que deseas editar: ");
            int indice = sc.nextInt() - 1;
            sc.nextLine(); // Limpiar buffer

            if (indice >= 0 && indice < personas.size()) {
                Persona personaAEditar = personas.get(indice);

                // Permitimos editar los datos
                System.out.println("Editando a: " + personaAEditar.getNombre());
                System.out.print("Nuevo nombre (deja en blanco para no cambiar): ");
                String nuevoNombre = sc.nextLine();
                if (!nuevoNombre.isEmpty()) {
                    personaAEditar.setNombre(nuevoNombre);
                }

                System.out.print("Nueva edad (deja en blanco para no cambiar): ");
                String nuevaEdadStr = sc.nextLine();
                if (!nuevaEdadStr.isEmpty()) {
                    int nuevaEdad = Integer.parseInt(nuevaEdadStr);
                    personaAEditar.setEdad(nuevaEdad);
                }

                System.out.print("Nueva ciudad (deja en blanco para no cambiar): ");
                String nuevaCiudad = sc.nextLine();
                if (!nuevaCiudad.isEmpty()) {
                    personaAEditar.setCiudad(nuevaCiudad);
                }

                // Guardamos los cambios en el fichero
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persona.dat"))) {
                    oos.writeObject(personas);
                    System.out.println("Persona editada correctamente.");
                }

            } else {
                System.out.println("Número no válido.");
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al editar persona: " + e.getMessage());
        }
    }
}


