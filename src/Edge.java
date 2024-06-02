

import java.util.Objects;

public class Edge<Vertex> {

    private Vertex source;

    private Vertex destination;

    private Double weight;

    public Edge(Vertex source, Vertex destination, Double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getSource() {
        return source;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void updateEdge(Vertex newSource, Vertex newDestination, double newWeight) {
        this.source = newSource;
        this.destination = newDestination;
        this.weight = newWeight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source = " + source +
                ", destination = " + destination +
                ", weight = " + weight +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Edge<?> newEdge = (Edge<?>) obj;
        return Objects.equals(this.source, newEdge.source) && Objects.equals(this.destination, newEdge.destination);
    }
}