import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KMeans {
    private int k; // Número de clusters
    private List<Point> points; // Lista de puntos
    private List<Cluster> clusters; // Lista de clusters

    public KMeans(int k) {
        this.k = k;
        this.points = new ArrayList<>();
        this.clusters = new ArrayList<>();
    }

    // Método para cargar puntos desde un archivo CSV
    public void loadPointsFromCSV(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        // Omitir la primera línea (cabecera)
        reader.readLine(); // Ignorar la línea de cabecera

        List<Double> satisfactionValues = new ArrayList<>();
        List<Double> loyaltyValues = new ArrayList<>();

        // Leer los valores del CSV
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            try {
                double satisfaction = Double.parseDouble(values[0].trim()); // Primer valor
                double loyalty = Double.parseDouble(values[1].trim()); // Segundo valor
                satisfactionValues.add(satisfaction);
                loyaltyValues.add(loyalty);
            } catch (NumberFormatException e) {
                System.err.println("Error al convertir a número: " + line);
            }
        }

        reader.close();

        // Asegurarse de que ambas listas tienen el mismo tamaño
        if (satisfactionValues.size() != loyaltyValues.size()) {
            throw new IllegalArgumentException("El número de valores de satisfacción y lealtad no coincide.");
        }

        // Crear los puntos
        for (int i = 0; i < satisfactionValues.size(); i++) {
            points.add(new Point(satisfactionValues.get(i), loyaltyValues.get(i)));
        }
    }

    // Método para inicializar los clusters
    public void initializeClusters() {
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            Point randomPoint = points.get(random.nextInt(points.size()));
            Cluster cluster = new Cluster();
            cluster.setCentroid(randomPoint);
            clusters.add(cluster);
        }
    }

    // Método para asignar puntos a los clusters
    public void assignPointsToClusters() {
        for (Cluster cluster : clusters) {
            cluster.clearPoints();
        }

        for (Point point : points) {
            Cluster nearestCluster = null;
            double minDistance = Double.MAX_VALUE;

            for (Cluster cluster : clusters) {
                double distance = point.distance(cluster.getCentroid());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestCluster = cluster;
                }
            }

            if (nearestCluster != null) {
                nearestCluster.addPoint(point);
            }
        }
    }

    // Método para actualizar los centroides de los clusters
    public void updateCentroids() {
        for (Cluster cluster : clusters) {
            double sumX = 0;
            double sumY = 0;
            List<Point> points = cluster.getPoints();
            int n = points.size();

            if (n > 0) {
                for (Point point : points) {
                    sumX += point.getX();
                    sumY += point.getY();
                }

                double newX = sumX / n;
                double newY = sumY / n;
                cluster.setCentroid(new Point(newX, newY));
            }
        }
    }

    // Método para ejecutar el algoritmo K-Means
    public void run() {
        initializeClusters();
        for (int i = 0; i < 100; i++) { // número de iteraciones
            assignPointsToClusters();
            updateCentroids();
        }
    }

    // Método para imprimir los clusters
    public void printClusters() {
        for (int i = 0; i < clusters.size(); i++) {
            Cluster cluster = clusters.get(i);
            System.out.println("Cluster " + (i + 1) + ":");
            System.out.println("Centroid: " + cluster.getCentroid());
            System.out.println("Number of Points: " + cluster.getPoints().size());

            // Mostrar solo los primeros 5 puntos como ejemplo
            List<Point> points = cluster.getPoints();
            int maxPointsToShow = Math.min(points.size(), 5);
            for (int j = 0; j < maxPointsToShow; j++) {
                System.out.println("Point " + (j + 1) + ": " + points.get(j));
            }
            System.out.println();
        }
    }
}