package practica3sp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import carpeta.Files;


        

public class Practica3SP {
   public static void main(String[] args) throws Exception {
        Files files = new Files ();
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        String fileName;
        double[] numero1;
        double[] numero2;
        double[] numero3;
        double[] numero4;
        double[] promid;
        double[] promPar = new double[4];
        double promGrupl;

        System.out.println("Lectura de calificaciones de Parcial");
        System.out.println("Escribe el nombre del archivo 1");
        fileName = bufer.readLine();
        numero1 = files.fileToDoubleArray(fileName);
       
        System.out.println("Escribe el nombre del archivo 2");
        fileName = bufer.readLine();
        numero2 = files.fileToDoubleArray(fileName);
        
        System.out.println("Escribe el nombre del archivo 3");
        fileName = bufer.readLine();
        numero3 = files.fileToDoubleArray(fileName);
        
        System.out.println("Escribe el nombre del archivo 4");
        fileName = bufer.readLine();
        numero4 = files.fileToDoubleArray(fileName);
        
        System.out.println("Contenido del arreglo de números enteros");

        promPar[0] = files.calcularPromedioGrupo(numero1);
        promPar[1] = files.calcularPromedioGrupo(numero2);
        promPar[2] = files.calcularPromedioGrupo(numero3);
        promPar[3] = files.calcularPromedioGrupo(numero4);

        promid = files.calcularPromedioIndividual(numero1, numero2, numero3, numero4);

        System.out.println("Escribe el nombre del archivo donde se van a guardar las calificaciones");
        fileName = bufer.readLine();
        files.writeArrayToFile(fileName, promid);

        System.out.println("Escribe el nombre del archivo donde se van a guardar las calificaciones parciales");
        fileName = bufer.readLine();
        files.writeArrayToFile(fileName, promPar);
        System.out.println();

        promGrupl = files.calcularPromedioGrupo(promPar);
        System.out.println("El promedio total es: " + promGrupl);
    }
}
    
    

