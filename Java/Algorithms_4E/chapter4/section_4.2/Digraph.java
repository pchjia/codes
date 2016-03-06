import java.util.HashSet;
import java.util.Scanner;

public class Digraph {
    private final int V;
    private int E;
    private HashSet<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (HashSet<Integer>[]) new HashSet[V];
        for (int v=0; v<V; v++) {
            adj[v] = new HashSet<Integer>();
        }
    }

    public Digraph(Scanner in) {
        this(in.nextInt());
        E = in.nextInt();
        while (in.hasNext()) {
            addEdge(in.nextInt(), in.nextInt());
        }
    }

    public Digraph(String filename) {
        this(new Scanner(filename));
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E ++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v=0; v<V; v++) {
            for (int w: adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }
}
