import java.io.IOException;
import java.util.HashSet;

public class TestCC {
    public static void main(String[] args) {
        Graph G = null;
        try{
            Graph tmp = new Graph(args[0]);
            G = tmp;
        } catch (IOException e) {
            System.out.println("File not found.");
            e.printStackTrace();
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
}
