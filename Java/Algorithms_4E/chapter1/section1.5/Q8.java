public class Q8 {
    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }

        for (int i=0; i<id.length; i++) {
            if (id[i] == id[p]) {
                // error because once it comes to i==p: pid[p] = id[q], then the 'if' doesnot equals before
                id[i] = id[q];
            }
        }

        count --;
    }
}
