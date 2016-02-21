import java.util.Scanner;

public class DegreesOfSeparation {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();
        String source = args[2];
        if (!sg.contains(source)) {
            System.out.println("There is no such word.");
            System.exit(-1);
        }

        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String sink = in.nextLine();
            if (!sg.contains(sink)) {
                System.out.println("There is no such word.");
                continue;
            }
            int t = sg.index(sink);
            if (bfs.hasPathTo(t)) {
                for (int v: bfs.pathTo(t)) {
                    System.out.print("\t" + sg.name(v));
                }
                System.out.println();
            } else {
                System.out.println("not connected.");
            }
        }
    }
}
