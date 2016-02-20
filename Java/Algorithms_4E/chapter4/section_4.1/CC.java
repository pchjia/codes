import java.io.IOException;
import java.util.HashSet;

public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public static void main(String[] args) {
        Graph G = null;
        try{
            G = new Graph(args[0]);
        } catch (IOException e) {
            System.out.println("File not found.");
            e.printStackTrace();
            System.exit(-1);
        }
        CC cc = new CC(G);

        int M = cc.count();
        System.out.println(M + " components.");

        @SuppressWarnings("unchecked")
        HashSet<Integer>[] components = (HashSet<Integer>[]) new HashSet[M];
        for (int i=0; i<M; i++) {
            components[i] = new HashSet<Integer>();
        }

        for (int v=0; v<G.V(); v++) {
            components[cc.id(v)].add(v);
        }

        for (int i=0; i<M; i++) {
            for (int v: components[i]) {
                 System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s=0; s<G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count ++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w: G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public int count() {
         return count;
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
         return id[v];
    }
}
