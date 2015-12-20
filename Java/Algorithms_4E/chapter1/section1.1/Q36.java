public class Q36{
    public static void main (String[] args) {
        ShuffleTest.run();
    }
}

class ShuffleTest{
    public static void run(){
        int M = StdIn.readInt();
        int N = StdIn.readInt();
        double[] a = new double[M];
        int[][] data = new int[M][M];
        double[][] ans = new double[M][M];

        for(int i=0; i<N; i++){
            setArr(a);
            StdRandom.shuffle(a);
            count(data, a);
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                ans[i][j] = (double)data[i][j]/(double)M;
                System.out.print(ans[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void setArr(double[] a){
        for(int i=0; i<a.length; i++){
            a[i] = (double)i;
        }
    }

    public static void count(int[][] data, double[] a){
        for(int i=0; i<data.length; i++){
            for(int j=0; j<data[0].length; j++){
                data[i][(int)a[j]] += 1;
            }
        }
    }
}
