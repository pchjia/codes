import java.util.Scanner;
import java.io.IOException;

public class TestPaths {
    public static void main(String[] args) {
        Graph G = null;
        try {
            G = new Graph(args[0]);
        } catch (IOException e) {
            System.out.println("File not found.");
            e.printStackTrace();
            System.exit(-1);
        }
        if (G == null) {
            System.exit(-1);
        }
        int s = Integer.parseInt(args[1]);
//        BreadthFirstPaths search = new BreadthFirstPaths(G, s);
        DepthFirstPaths search = new DepthFirstPaths(G, s);
        for (int v=0; v<G.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (search.hasPathTo(v)) {
                for (int x: search.pathTo(v)) {
                    if (x == s) {
                        System.out.print(x);
                    } else {
                        System.out.print("-" + x);
                    }
                }
            }
            System.out.println();
        }
    }
}
