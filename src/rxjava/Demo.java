package rxjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.lang.System.out;

/**
 * @author Vinodh Kumar Thimmisetty
 */
public class Demo {

    static class Vertex<T> {
        T value;

        public Vertex(T value) {
            this.value = value;
        }
    }

    static class Graph<T> {
        private Map<Vertex<T>, List<Vertex<T>>> neighbours = new HashMap<>();

        public void addVertex(T val) {
            neighbours.putIfAbsent(new Vertex<>(val), new ArrayList<>());
        }

        public void removeVertex(T val) {
            final Vertex<T> removedVertex = new Vertex<>(val);
            neighbours.remove(new Vertex<T>(val));
            neighbours.values().removeIf(vertices -> vertices.contains(removedVertex));
        }

        public void addEdge(T src, T dest) {
            if (neighbours.get(new Vertex<T>(src)) != null) {
                neighbours.get(new Vertex<T>(src)).add(new Vertex<T>(dest));
            } else {
                addVertex(src);
            }
            if (neighbours.get(new Vertex<T>(dest)) != null) {
                neighbours.get(new Vertex<T>(dest)).add(new Vertex<T>(src));
            } else {
                addVertex(dest);
            }
        }

        public void removeEdge(T src, T dest) {
            final Vertex<T> srcVertex = new Vertex<>(src);
            final Vertex<T> destVertex = new Vertex<>(dest);
            neighbours.get(srcVertex).removeIf(c -> Objects.equals(c, destVertex));
            neighbours.get(destVertex).removeIf(c -> Objects.equals(c, srcVertex));

        }

        static Graph<Integer> createGraph() {
            Graph<Integer> g = new Graph<>();
            g.addVertex(1);
            g.addVertex(2);
            g.addVertex(3);
            g.addVertex(4);
            g.addVertex(5);
            g.addVertex(6);

            g.addEdge(1, 2);
            g.addEdge(1, 4);
            g.addEdge(3, 4);
            g.addEdge(3, 2);
            g.addEdge(3, 5);
            g.addEdge(3, 6);

            return g;
        }


    }

    public static void main(String[] args) {

        // Visiting and exploring significant vertexes in the Graph
        final Graph<Integer> graph = Graph.createGraph();

        graph.neighbours.forEach((a, b) -> out.println(a + " :: " + b));


    }

}
