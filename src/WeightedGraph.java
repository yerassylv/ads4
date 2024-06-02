package graph;

import edge.Edge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedGraph<Vertex> {


    private Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();
    /* public WeightedGraph(Map<Vertex, List<Edge<Vertex>>> map) {
        this.map = map;
    }*/

    public void addVertex(Vertex vertex) {
        map.put(vertex, new LinkedList());
    }

    public void addEdge(Vertex source, Vertex destination, double weight) {
        checkVertex(source);
        checkVertex(destination);
        Edge<Vertex> edge = new Edge<>(source, destination, weight);
        map.get(destination).add(edge);
        map.get(source).add(edge);
    }

    public boolean hasEdge(Vertex destination, Vertex source, double weight) {
        if (!map.containsKey(source) || !map.containsKey(destination)) {
            return false;
        }
        for (Edge<Vertex> edge : map.get(source)) {
            if (edge.getDestination().equals(destination)) {
                return true;
            }
        }
        return false;
    }

    public List<Edge<Vertex>> getEdge(Vertex vertex) {
        checkVertex(vertex);
        return new LinkedList<>(map.get(vertex));
    }


    public List<Vertex> getNeighbours(Vertex vertex) {
        List<Vertex> neighbour = (List<Vertex>) map.get(vertex);
        return neighbour;
    }


    public void checkVertex(Vertex vertex) {
        if (!map.containsKey(vertex)) {
            throw new IndexOutOfBoundsException("Vertex does not exist");
        }
    }


    public void printWeightedGraph() {
        for (Vertex vertex : map.keySet()) {
            System.out.print(" Vertex: " + vertex + " is connected to: ");
            for (Edge<Vertex> edge : map.get(vertex)) {
                System.out.print(edge.getDestination() + " (weight of edge: " + edge.getWeight() + "), ");
            }
            System.out.println();
        }
    }

    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public List<Vertex> adjacencyList(Vertex vertex) {
        if (!hasVertex(vertex)) return null;
        List<Vertex> vertices = new LinkedList<>();
        for (Edge<Vertex> e : map.get(vertex)) {
            vertices.add(e.getDestination());
        }

        return vertices;
    }


    public List<Vertex> getVertices() {
        return (List<Vertex>) map.keySet();
    }
}
