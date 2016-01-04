public class Q2 {}

class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                int sum1 = a[i] + a[j];
                if ((a[i] > 0 && a[j] > 0 && sum1 < 0) || 
                        (a[i] < 0 && a[j] < 0 && sum1 > 0)) { // overflow
                    return -1;
                }
                for (int k=j+1; k<N; k++) {
                    int sum2 = sum1 + a[k];
                    if ((sum1 > 0 && a[k] > 0 && sum2 < 0) || 
                            (sum1 < 0 && a[k] < 0 && sum2 > 0)) { // overflow
                        return -1;
                    }
                    if (sum2 == 0) {
                        cnt ++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main (String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
