import java.math.BigInteger;

public class Q19{
    /*
     * N=81839, finonacci got a  17103's long number
     */
    public static void main (String[] args) {
//        long[] a = new long[100];
        BigInteger[] a = new BigInteger[100];
        for(int N=0; N<100; N++){
            System.out.println(N + " " + Fibonacci.F2(a, N));
//            Fibonacci.F2(a, N);
        }
//        System.out.println(a[a.length-1]);
    }
}
class Fibonacci{
    public static long F(int N){
        if(N == 0){
            return 0;
        }
        if(N == 1){
            return 1;
        }
        return F(N-1) + F(N-2);
    }
    
    public static long F2(long[] a, int N){
        a[N] = N;
        if(N >= 2){
            a[N] = a[N-1]+ a[N-2];
        }
        return a[N];
    }
    
    public static BigInteger F2(BigInteger[] a, int N){
        a[N] = BigInteger.valueOf((long)N);
        if(N >= 2){
            a[N] = a[N-1].add(a[N-2]);
        }
        return a[N];
    }
}
