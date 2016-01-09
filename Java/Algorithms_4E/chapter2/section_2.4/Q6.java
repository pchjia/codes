/*
 * java Q6 P R I O * R * * I * T * Y * * * Q U E * * * U * E
 * P: P 
 * R: R P 
 * I: R P I 
 * O: R P I O 
 * *: P O I 
 * R: R P I O 
 * *: P O I 
 * *: O I 
 * I: O I I 
 * *: I I 
 * T: T I I 
 * *: I I 
 * Y: Y I I 
 * *: I I 
 * *: I 
 * *: 
 * Q: Q 
 * U: U Q 
 * E: U Q E 
 * *: Q E 
 * *: E 
 * *: 
 * U: U 
 * *: 
 * E: E 
 */

public class Q6 {
    public static void main (String[] args) {
        MaxPQ<String> pq = new MaxPQ<String>();
        for (int i=0; i<args.length; i++) {
            String s = args[i];
            if (s.equals("*")) {
                pq.delMax();
            } else {
                pq.insert(s);
            }
            System.out.print(s + ": ");
            pq.show();
        }
    }
}

class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public MaxPQ() {
        pq = (Key[]) new Comparable[2];
    }

    @SuppressWarnings("unchecked")
    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        if (N == (pq.length-1)) {
            resize(pq.length*2);
        }
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        if (N > 0 && N < pq.length/4) {
            resize(pq.length/2);
        }
        return max;
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        Key[] tmp = (Key[]) new Comparable[max];
        for (int i=1; i<=N; i++) {
            tmp[i] = pq[i];
        }
        pq = tmp;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j<N && less(j, j+1)) {
                j++;
            }
            exch(k, j);
            k = j;
        }
    }

    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public void show() {
        for (int i=1; i<=N; i++) {
            System.out.print(pq[i] + " ");
        }
        System.out.println();
    }
}
