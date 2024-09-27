package Tema1.FicheroBinario.ej2;
import java.io.*;
import java.util.Scanner;

// Clase Becario que implementa Serializable para que se pueda guardar en un archivo binario
public class Becario implements Serializable {
    private static final long serialVersionUID = 1L;  // Para manejar la serialización correctamente
    private String nombreApellido;
    private char sexo;
    private int edad;
    private int numeroSuspensos;
    private boolean residenciaFamiliar;
    private double ingresosAnuales;

    // Constructor de la clase Becario
    public Becario(String nombreApellido, char sexo, int edad, int numeroSuspensos, boolean residenciaFamiliar, double ingresosAnuales) {
        this.nombreApellido = nombreApellido;
        this.sexo = sexo;
        this.edad = edad;
        this.numeroSuspensos = numeroSuspensos;
        this.residenciaFamiliar = residenciaFamiliar;
        this.ingresosAnuales = ingresosAnuales;
    }

    // Metodo para mostrar los datos del becario
    public void mostrarDatos() {
        System.out.println("Nombre y Apellido: " + nombreApellido);
        System.out.println("Sexo: " + (sexo == 'H' ? "Hombre" : "Mujer"));
        System.out.println("Edad: " + edad);
        System.out.println("Número de Suspensos: " + numeroSuspensos);
        System.out.println("Residencia Familiar: " + (residenciaFamiliar ? "Sí" : "No"));
        System.out.println("Ingresos Anuales: " + ingresosAnuales);
    }
}
