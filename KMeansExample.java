// KMeansExample.java
import java.io.IOException;

public class KMeansExample {
    public static void main(String[] args) {
        KMeans kMeans = new KMeans(2); // Cambiar el número de clusters según sea necesario
        String filePath = "/Users/ximenafernandez/Desktop/Machine Learning/KMEANS market egmentation/3.12. Example.csv"; // Ruta absoluta correcta
        try {
            kMeans.loadPointsFromCSV(filePath);
            kMeans.run();
            kMeans.printClusters();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error de argumento: " + e.getMessage());
        }
    }
}