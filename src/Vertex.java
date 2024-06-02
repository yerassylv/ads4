package vertex;

import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public void addAdjVertices(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    public V getData() {
        return data;
    }

    public Map<Vertex<V>, Double> get() {
        return adjacentVertices;
    }


    public void remove(Vertex<V> neighbor) {
        if (adjacentVertices.containsKey(neighbor)) {
            adjacentVertices.remove(neighbor);
            neighbor.adjacentVertices.remove(this);
        }
    }

    public void printVertex() {
        for (Vertex<V> neighbor : adjacentVertices.keySet()) {
            System.out.println("- " + neighbor.getData() + " (Weight: " + adjacentVertices.get(neighbor) + ")");
        }

    }
}