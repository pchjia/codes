public class Q24{
    /*
     * gcd(105, 24):
     *  p 105  q 24
     *  p 24  q 9
     *  p 9  q 6
     *  p 6  q 3
     *  p 3  q 0
     */
    public static void main (String[] args) {
        int p = StdIn.readInt();
        int q = StdIn.readInt();
        System.out.println(gcd(p, q));
    }

    public static int gcd(int p, int q){
        System.out.println("p " + p + "  q " + q);
        if(q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}
