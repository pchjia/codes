public class Euclid{
    public static int gcd(int p, int q){
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
    
    public static long gcd(long p, long q){
        if (q == 0) {
            return p;
        }
        long r = p % q;
        return gcd(q, r);
    }
}
