package Tema1.FileStreams;

import java.io.File;

public class ej1 {

    public static void main(String[] args) {

        String directorioPath;
        if (args.length > 0) {
            directorioPath = args[0];
        } else {
            directorioPath = System.getProperty("user.dir");
        }
        File directorio = new File(directorioPath);

        if (directorio.exists() && directorio.isDirectory()) {
            File[] listaArchivos = directorio.listFiles();

            if (listaArchivos != null && listaArchivos.length > 0) {
                System.out.println("Archivos y directorios en: " + directorioPath);
                for (File archivo : listaArchivos) {
                    if (archivo.isDirectory()) {
                        System.out.println("[Directorio] " + archivo.getName());
                    } else {
                        System.out.println("[Archivo] " + archivo.getName());
                    }
                }
            } else {
                System.out.println("El directorio está vacío.");
            }
        } else {
            System.out.println("El directorio no existe o no es un directorio válido.");
        }

    }

}
