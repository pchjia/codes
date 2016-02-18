import java.util.Scanner;

public class TestSearch {
    public static void main(String[] args) {
        Graph G = new Graph(new Scanner(args[0]));
        int s = Integer.parseInt(args[1]);
        Search search = new Search(G, s);

        for (int v=0; v<G.V(); v++) {
            if (search.marked(v)) {
                System.out.print(v + " ");
            }
        }

        System.out.println();
        if (search.count() != G.V()) {
            System.out.println("Not ");
        }
        System.out.println("connected!");
    }
}
