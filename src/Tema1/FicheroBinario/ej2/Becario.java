package Tema1.FicheroBinario.ej2;
import java.io.*;

// Clase Becario que implementa Serializable para que se pueda guardar en un archivo binario
public class Becario implements Serializable {
    private static final long serialVersionUID = 1L;  // Para manejar la serialización correctamente
    private String nombreApellido;
    private char sexo;
    private int edad;
    private int numeroSuspensos;
    private String residenciaFamiliar;
    private double ingresosAnuales;

    // Constructor de la clase Becario


    public Becario(String nombreApellido, int edad, char sexo, int numeroSuspensos, String residenciaFamiliar, double ingresosAnuales) {
        this.nombreApellido = nombreApellido;
        this.edad = edad;
        this.sexo = sexo;
        this.numeroSuspensos = numeroSuspensos;
        this.residenciaFamiliar = residenciaFamiliar;
        this.ingresosAnuales = ingresosAnuales;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumeroSuspensos() {
        return numeroSuspensos;
    }

    public void setNumeroSuspensos(int numeroSuspensos) {
        this.numeroSuspensos = numeroSuspensos;
    }

    public String getResidenciaFamiliar() {
        return residenciaFamiliar;
    }

    public void setResidenciaFamiliar(String residenciaFamiliar) {
        this.residenciaFamiliar = residenciaFamiliar;
    }

    public double getIngresosAnuales() {
        return ingresosAnuales;
    }

    public void setIngresosAnuales(double ingresosAnuales) {
        this.ingresosAnuales = ingresosAnuales;
    }

    // Metodo para mostrar los datos del becario
    public void mostrarDatos() {
        System.out.println("Nombre y Apellido: " + nombreApellido);
        System.out.println("Sexo: " + (sexo == 'H' ? "Hombre" : "Mujer"));
        System.out.println("Edad: " + edad);
        System.out.println("Número de Suspensos: " + numeroSuspensos);
        System.out.println("Residencia Familiar: " + (residenciaFamiliar));
        System.out.println("Ingresos Anuales: " + ingresosAnuales);
    }
}
