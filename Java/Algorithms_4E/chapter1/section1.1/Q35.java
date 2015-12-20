import java.util.Random;

public class Q35{
    /*
     * N ~= 500 0000 can make sure there is three digits' accuracy after decimal point.
     */
    public static void main (String[] args) {
        int SIDES = 6;
        int N = StdIn.readInt();
        int[][] data = new int[N][2];
        int[] sum = new int[2*SIDES+1];

        Random ran = new Random();
        for(int i=0; i<N; i++){
            data[i][0] = ran.nextInt(SIDES) + 1;
            data[i][1] = ran.nextInt(SIDES) + 1;
            sum[data[i][0] + data[i][1]] += 1;
        }

        // experiment
        for(int i=0; i<sum.length; i++){
            if(sum[i] != 0){
                System.out.println((double)sum[i]/(double)N + "\t" + i);
            }
        }
        System.out.println();

        // destiny of probability
        double[] des = destiny();
        for(int i=0; i<des.length; i++){
            if(des[i] != 0){
                System.out.println(des[i] + "\t" + i);
            }
        }
    }

    public static double[] destiny(){
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for(int i=1; i<=SIDES; i++){
            for(int j=1; j<=SIDES; j++){
                dist[i+j] += 1.0;
            }
        }

        for(int k=2; k<=2*SIDES; k++){
            dist[k] /= 36.0;
        }
        return dist;
    }
}
