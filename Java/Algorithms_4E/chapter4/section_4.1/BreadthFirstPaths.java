import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        marked[s] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w: G.adj(v)) {
                if (!marked[w]) {
                    q.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
         return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        LinkedList<Integer> path = new LinkedList<Integer>();
        for (int x=v; x!=s; x=edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
