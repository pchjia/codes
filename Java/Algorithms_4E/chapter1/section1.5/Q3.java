public class Q3 {
    private int[] id;
    private int[] sz;
    private int count;
    private int idCount;

    public Q3(int N) {
        count = N;
        idCount =N;
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
        while (p != id[p]) {
            idCount += 2;
            p = id[p];
        }
        idCount ++;
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (sz[pRoot] < sz[qRoot]) {
            idCount ++;
            id[pRoot] = qRoot;
            sz[qRoot] += sz[p];
        } else {
            idCount ++;
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

        count --;
    }

    public static void main (String[] args) {
        int N = StdIn.readInt();
        Q3 uf = new Q3(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
        StdOut.println(uf.count() + " components");         // 2
        StdOut.println(uf.idCount() + " visited id[]");     // 70
    }
}
