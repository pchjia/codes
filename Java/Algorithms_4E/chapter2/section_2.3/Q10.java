/*
 * 1.0002763674710446E-22
 */

public class Q10 {
    public static void main (String[] args) {
        long N = 1000000;
        long p = new Long("100000000000") - (long)(N*Math.log(N));
        double res = 1/Math.pow(p, 2);
        System.out.println(res);
    }
}
