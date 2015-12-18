public class Q9{
    /*
     * convert positive integer N into binary-desc's String
     * this is an implement of Integer.toBinaryString(N)
     */
    public static void main (String[] args) {
        int N = StdIn.readInt();

        String s = "";
        for(int n=N; n>0; n/=2){
            s = (n%2) + s;
        }

        StdOut.println(s);
    }
}
