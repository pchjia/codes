import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer> []) new LinkedList[V];
        for (int i=0; i<V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public Graph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();
        for (int i=0; i<E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    public Graph(String filename) throws IOException {
        this(new Scanner(new File(filename)));
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E ++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w: G.adj(v)) {
            degree ++;
        }
        return degree;
    }

    public static int maxDegree(Graph G) {
         int max = 0;
         for (int i=0; i<G.V(); i++) {
             if (Graph.degree(G, i) > max) {
                 max = Graph.degree(G, i);
             }
         }
         return max;
    }

    public static double avgDegree(Graph G) {
         return 2 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v=0; v<G.V(); v++) {
            for (int w: G.adj(v)) {
                if (v == w) {
                    count ++;
                }
            }
        }
        return count;
    }

    public String toString() {
         String s = V + " vertices, " + E + " edges\n";
         for (int v=0; v<V; v++) {
             s += v + ": ";
             for (int w: this.adj(v)) {
                 s += w + " ";
             }
             s += "\n";
         }
         return s;
    }
}
