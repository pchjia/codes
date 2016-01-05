public class Q4 {
    private int[] id;
    private int[] sz;
    private int count;
    private int idCount;
    private int szCount;

    public Q4(int N) {
        count = N;
        idCount = N;
        szCount = N;
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

    public int szCount() {
        return szCount;
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

        szCount += 2;
        if (sz[pRoot] < sz[qRoot]) {
            idCount ++;
            id[pRoot] = qRoot;
            szCount += 2;
            sz[qRoot] += sz[p];
        } else {
            idCount ++;
            id[qRoot] = pRoot;
            szCount += 2;
            sz[pRoot] += sz[qRoot];
        }

        count --;
    }

    public void show() {
        for (int i=0; i<id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
    }

    public static void main (String[] args) {
        int N = StdIn.readInt();
        Q4 uf = new Q4(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
            uf.show();
            StdOut.println(uf.idCount() + " visited id[] ");
            StdOut.println(uf.szCount() + " visited sz[] ");
        }
        StdOut.println(uf.count() + " components");         // 2
        StdOut.println(uf.idCount() + " visited id[]");     // 70
    }
}
