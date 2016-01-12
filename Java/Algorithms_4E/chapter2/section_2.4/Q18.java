/*
 * ➜  section_2.4 git:(master) ✗ $ java Q18 5
 * 5  4  2  1  3  
 * 5  4  2  3  1 
 */

public class Q18 {
    public static void main (String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>();
        int N = Integer.parseInt(args[0]);
        for (int i=0; i<N; i++) {
            pq.insert(new Integer(i+1));
        }
        pq.show();
        pq.delMax();
        pq.insert(N);
        pq.show();

    }
}
