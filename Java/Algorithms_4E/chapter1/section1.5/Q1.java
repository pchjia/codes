public class Q1 {
    private int[] id;
    private int[] sz;
    private int count;
    private int idCount;

    public Q1(int N) {
        count = N;
        idCount = N;
        id = new int[N];
        sz = new int[N];
        for (int i=0; i<N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public int idCount() {
        return idCount;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        idCount ++;
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID != qID) {
            return;
        }

        for (int i=0; i<id.length; i++) {
            idCount ++;
            if (id[i] == pID) {
                idCount ++;
                id[i] = qID;
            }
        }
        
        count --;
    }

    public static void main (String[] args) {
        int N = StdIn.readInt();
        Q1 uf = new Q1(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
        StdOut.println(uf.count() + " components");     // 10
        StdOut.println(uf.idCount() + " visited id[]"); // 42
    }
}
