public class Q20{
    public static void main (String[] args) {
        int N = StdIn.readInt();
        System.out.println(ln(N));
    
        double fn = 1;
        for(int i=0; i<N; i++){
            fn *= (double)(i+1);
        }
        System.out.println(Math.log(fn));
    }

    /*
     * caculate ln(N!)
     */
    public static double ln(int N){
        if(N == 1){
            return 0;
        }
        else{
            return Math.log(N) + ln(N-1);
        }
    }
}
