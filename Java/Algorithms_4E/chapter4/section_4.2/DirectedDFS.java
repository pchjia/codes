import java.util.Scanner;
import java.util.HashSet;

public class DirectedDFS {
    private boolean[] marked;

    public static void main(String[] args) {
        Scanner in = new Scanner(args[0]);
        Digraph G = new Digraph(in);

        HashSet<Integer> sources = new HashSet<Integer>();
        for (int i=1; i<args.length; i++) {
            sources.add(Integer.parseInt(args[i]));
        }

        DirectedDFS reachable = new DirectedDFS(G, sources);

        for (int v=0; v<G.V(); v++) {
            if (reachable.marked(v)) {
                System.out.print(v + "");
            }
        }
        System.out.println();
    }

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s: sources) {
            if (!marked(s)) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w: G.adj(v)) {
            if (!marked(v)) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }
}
