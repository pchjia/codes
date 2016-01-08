/*
 * P R I O * R  * * I * T * * * Q U E * * * U * E
 * R
 * R
 * P
 * O
 * T
 * I
 * I
 * U
 * Q
 * E
 * U
 */

public class Q1 {
    public static void main (String[] args) {
        MaxPQ<String> pq = new MaxPQ<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("*")) {
                System.out.println(pq.delMax());
            } else {
                pq.insert(s);
            }
        }
    }
}
