package carpeta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Files {
    public int countFileLine(String name) {
        File archivo;
        FileReader reader;
        BufferedReader bufer;

        int numLinea = 0;

        try {
            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);

            while (bufer.readLine() != null) {
                numLinea++;
            }
        } catch (IOException e) {
        }

        return numLinea;
    }

    public String[] fileToStringArray(String name) throws IOException {
        int t = countFileLine(name);
        String[] array = new String[t];

        try (FileReader reader = new FileReader("C:\\archivos\\" + name + ".txt");
             BufferedReader bufer = new BufferedReader(reader)) {
            int i = 0;
            String linea;
            while ((linea = bufer.readLine()) != null) {
                array[i] = linea;
                i++;
            }
        } catch (IOException e) {
        }

        return array;
    }

    public int[] fileToIntArray(String name) throws IOException {
        int t = countFileLine(name);
        int[] array = new int[t];

        try (FileReader reader = new FileReader("C:\\archivos\\" + name + ".txt");
             BufferedReader bufer = new BufferedReader(reader)) {
            int i = 0;
            String linea;
            while ((linea = bufer.readLine()) != null) {
                array[i] = Integer.parseInt(linea);
                i++;
            }
        } catch (IOException e) {
        }

        return array;
    }

    public double[] fileToDoubleArray(String name) throws IOException {
        int t = countFileLine(name);
        double[] array = new double[t];

        try (FileReader reader = new FileReader("C:\\archivos\\" + name + ".txt");
             BufferedReader bufer = new BufferedReader(reader)) {
            int i = 0;
            String linea;
            while ((linea = bufer.readLine()) != null) {
                array[i] = Double.parseDouble(linea);
                i++;
            }
        } catch (IOException e) {
        }

        return array;
    }

    public boolean[] fileToBooleanArray(String name) throws IOException {
        int t = countFileLine(name);
        boolean[] array = new boolean[t];

        try (FileReader reader = new FileReader("C:\\archivos\\" + name + ".txt");
             BufferedReader bufer = new BufferedReader(reader)) {
            int i = 0;
            String linea;
            while ((linea = bufer.readLine()) != null) {
                array[i] = Boolean.parseBoolean(linea);
                i++;
            }
        } catch (IOException e) {
        }

        return array;
    }

    public void writeKeyboardToFile(String name) {
        try (FileWriter Archivos = new FileWriter("C:\\Archivos\\" + name + ".txt");
             PrintWriter writer = new PrintWriter(Archivos);
             BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in)) ) {
            String entrada;
            char respuesta;

            do {
                System.out.println("Escribe el contenido del archivo");
                entrada = bufer.readLine();
                writer.println(entrada);

                System.out.println("Escribe la letra X para detener, cualquier otra tecla llena el archivo");
                entrada = bufer.readLine();
                respuesta = entrada.toLowerCase().charAt(0);
            } while (respuesta != 'x');
        } catch (IOException e) {
        }
    }

    public void writeArrayToFile(String name, double[] promindv) {
        try (FileWriter archivo = new FileWriter("C:\\archivos\\" + name + ".txt");
             PrintWriter writer = new PrintWriter(archivo)) {
            for (double unDato : promindv) {
                writer.println(unDato);
            }
        } catch (IOException e) {
        }
    }

    public double calcularPromedioGrupo(double[] array) {
        double suma = 0;
        for (double dato : array) {
            suma += dato;
        }
        return suma / array.length;
    }

    public double[] calcularPromedioIndividual(double[] array1, double[] array2, double[] array3, double[] array4) {
        double[] finalArray = new double[array1.length];

        for (int i = 0; i < array1.length; i++) {
            double suma = array1[i] + array2[i] + array3[i] + array4[i];
            finalArray[i] = suma / 4;
        }
        return finalArray;
    }
}
