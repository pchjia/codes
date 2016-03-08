public class KosarajuCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public Kosaraju(Digraph G) {
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        id = new int[G.V()];
        marked = new boolean[G.V()];
        for (int s: order.reversePost()) {
            if (!marked[s]) {
                dfs(G, s);
                count ++;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w: G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
