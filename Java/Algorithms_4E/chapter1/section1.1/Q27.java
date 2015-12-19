public class Q27{
    public static long n = 0;
    public static double[][] arr;
    
    public static void main (String[] args) {
        System.out.println(binomial(30, 15, 0.25));
        System.out.println(n);
    }

    public static double binomial(int N, int k, double p){
//        double[][] data = new double[N][k];
        arr = new double[N][k];
        return binomial2(N, k, p, data);
    }
    public static double binomial(int N, int k, double p, double[][] data){
        n = n + 1;
        if(N == 0 && k == 0){
            return 1.0;
        }

        if(N < 0 || k < 0){
            return 0.0;
        }

        return (1.0 - p) * binomial(N-1, k, p, data) + p * binomial(N-1, k-1, p, data);
    }
  
    public static double binomial2(int N, int k, double p, double[][] data){
        n = n + 1;
        if(N == 0 && k == 0){
            return 1.0;
        }

        if(N < 0 || k < 0){
            return 0.0;
        }

        if(N > 0 && k > 0){
            arr[N-1][k-1] = (1.0 - p) * binomial(N-1, k, p, data) + p * binomial(N-1, k-1, p, data);
        }

        return arr[N-1][k-1];
    }
}
