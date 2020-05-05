package data_structures.graphs;

import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.System.*;

/**
 * @author Vinodh Kumar Thimmisetty
 */

class Vertex {
    String name;
    Neighbour neighbour;

    public Vertex(String name, Neighbour neighbour) {
        this.name = name;
        this.neighbour = neighbour;
    }
}

class Neighbour {
    int vertexNumber;
    Neighbour next;

    public Neighbour(int vertexNumber, Neighbour next) {
        this.vertexNumber = vertexNumber;
        this.next = next;
    }

    @Override
    public String toString() {
        return "[" +
                "vertexNumber=" + vertexNumber +
                ", next=" + next +
                ']';
    }
}

public class AdjacentList {
    static Vertex[] vertices = new Vertex[10];

    public static void main(String[] args) {
        List<String> friends = List.of("sara", "sam", "sean", "ajay",
                "mira", "jane", "maria", "rahul", "sapna", "rohit");
        List<String> relations = List.of("sara#sam", "sara#ajay",
                "sam#mira", "sam#sean", "mira#jane", "jane#maria",
                "rahul#sapna", "sapna#rohit");

        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex(friends.get(i), null);
        }

        for (final String relation : relations) {
            final String[] srcAndDest = relation.split("#");
            final String src = srcAndDest[0];
            final String dest = srcAndDest[1];

            int srcIndex = -1;
            int destIndex = -1;
            for (int vertex = 0; vertex < vertices.length && (srcIndex == -1 || destIndex == -1); vertex++) {
                if (vertices[vertex].name.equalsIgnoreCase(src) && srcIndex == -1) {
                    srcIndex = vertex;
                }
                if (vertices[vertex].name.equalsIgnoreCase(dest) && destIndex == -1) {
                    destIndex = vertex;
                }
            }
            vertices[srcIndex].neighbour = new Neighbour(destIndex, vertices[srcIndex].neighbour);
            vertices[destIndex].neighbour = new Neighbour(srcIndex, vertices[destIndex].neighbour);

        }


        for (final Vertex vertex : vertices) {
            out.print(vertex.name + " :: [");
            Neighbour temp = vertex.neighbour;
            while (temp != null) {
                out.print(vertices[temp.vertexNumber].name + ",");
                temp = temp.next;
            }
            out.print("]\n");
        }

        out.print("---------------DFS----------");
        dfsDriver();
        out.print("\n---------------BFS----------");
        bfsDriver();
    }

    public static void dfsDriver() {
        boolean[] visited = new boolean[10];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                out.print("\nStarting @ " + vertices[i].name + " :: ");
                dfs(i, visited);
            }
        }
    }

    private static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        out.print(" Visiting:: " + vertices[node].name);
        Neighbour temp = vertices[node].neighbour;
        while (temp != null) {
            if (!visited[temp.vertexNumber]) {
                out.println("\n" + vertices[node].name + " == " + vertices[temp.vertexNumber].name);
                dfs(temp.vertexNumber, visited);
            }
            temp = temp.next;
        }
    }

    static Queue<Integer> vertexQueue = new LinkedList<>();

    public static void bfsDriver() {
        boolean[] visited = new boolean[10];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                out.print("\nStarting @ " + vertices[i].name + " :: ");
                bfs(i, visited);
            }
        }
    }

    private static void bfs(int node, boolean[] visited) {
        visited[node] = true;
        out.print(" Visiting:: " + vertices[node].name);
        vertexQueue.add(node);

        while (!vertexQueue.isEmpty()) {
            final Integer currentNode = vertexQueue.remove();
            Neighbour currentNeighbour = vertices[currentNode].neighbour;
            while (currentNeighbour.next != null) {
                if (!visited[currentNeighbour.vertexNumber]) {
                    vertexQueue.add(currentNeighbour.vertexNumber);
                    visited[currentNeighbour.vertexNumber] = true;
                    out.println("\n" + vertices[currentNode].name + " == " + vertices[currentNeighbour.vertexNumber].name);
                    dfs(currentNeighbour.vertexNumber, visited);
                }
                currentNeighbour = currentNeighbour.next;
            }
        }

    }
}
