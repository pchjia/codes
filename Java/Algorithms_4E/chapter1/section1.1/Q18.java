public class Q18{
    /*
     * mystery(2, 25): 50
     * mystery(3, 11): 33
     *
     * return 1;
     * + -> *:
     * mystery(2, 25): 1024
     * mystery(3, 11): 432
     */
    public static void main (String[] args) {
        System.out.println(mystery(StdIn.readInt(), StdIn.readInt()));
    }

    public static int mystery(int a, int b){
        if(b == 0){
            // return 0;
            return 1;
        }
        if(b%2 == 0){
            return mystery(a+a, b/2);
        }
        // return mystery(a+a, b/2) + a;
        return mystery(a+a, b/2) * a;
    }
}
