// Cluster.java
import java.util.ArrayList;
import java.util.List;

class Cluster {
    private List<Point> points;
    private Point centroid;

    public Cluster() {
        this.points = new ArrayList<>();
    }

    public List<Point> getPoints() {
        return points;
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public Point getCentroid() {
        return centroid;
    }

    public void setCentroid(Point centroid) {
        this.centroid = centroid;
    }

    public void clearPoints() {
        points.clear();
    }
}