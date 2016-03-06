public class Topological {
    private Iterable<Integer> order;

    public static void main(String[] args) {
        String filename = args[0];
        String sep = args[1];
        SymbolDigraph sg = new SymbolDigraph(filename, sep);
        Topological top = new Topological(sg.G());
        for (int v: top.order()) {
            System.out.println(sg.name(v));
        }
    }

    public Topological(Digraph G) {
        DirectedCycle cycleFinder = new DirectedCycle(G);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean idDAG() {
        return order != null;
    }
}
