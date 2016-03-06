import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SymbolDigraph {
    private HashMap<String, Integer> hm;    // sign name -> index
    private String[] keys;                     // index -> sign name
    private Digraph G;

    public static void main(String[] args) {
        String filename = args[0];
        String sep = args[1];

        SymbolGraph sg = new SymbolGraph(filename, sep);
        Digraph G = sg.G();

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String source = in.nextLine();
            if (!sg.contains(source)) {
                continue;
            }
            for (int w: G.adj(sg.index(source))) {
                System.out.print("\t" + sg.name(w));
            }
            System.out.println();
        }
    }

    public SymbolGraph(String filename, String sep) {
        hm = new HashMap<String, Integer>();
        Scanner in = null;
        try {
            in = new Scanner(new File(filename));
        } catch (IOException e) {
            System.out.println("File not found.");
            e.printStackTrace();
            System.exit(-1);
        }

        while (in.hasNext()) {
            String line = in.nextLine();
            String[] tokens = line.split(sep);
            for (int i=0; i<tokens.length; i++) {
                if (!hm.containsKey(tokens[i])) {
                    hm.put(tokens[i], hm.size());
                }
            }
        }

        keys = new String[hm.size()];
        for (String name: hm.keySet()) {
            keys[hm.get(name)] = name;
        }

        G = new Digraph(hm.size());

        try {
            in = new Scanner(new File(filename));
        } catch (IOException e) {
            System.out.println("File not found.");
            e.printStackTrace();
            System.exit(-1);
        }

        while (in.hasNext()) {
            String[] tokens = in.nextLine().split(sep);
            int v = hm.get(tokens[0]);
            for (int i=1; i<tokens.length; i++) {
                G.addEdge(v, hm.get(tokens[i]));
            }
        }
    }

    public boolean contains(String s) {
        return hm.containsKey(s);
    }

    public int index(String s) {
        return hm.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Digraph G() {
        return G;
    }
}
