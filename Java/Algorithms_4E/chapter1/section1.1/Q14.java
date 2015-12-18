public class Q14{
    /**
     * @author pchjia
     * @param N integer
     * @return an integer not more than log2(N)
     */
    public static int lg(int N){
        int lgN = 2;
        int i=0;
        while(lgN <= N && lgN > 0){
            lgN *= 2;
            i++;
        }
        return i;
    }

    public static void main (String[] args) {
        int N = StdIn.readInt();
        System.out.println(lg(N));
    }
}
