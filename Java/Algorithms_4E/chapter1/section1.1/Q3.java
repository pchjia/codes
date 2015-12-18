public class Q3{
    /*
     * read three ints from console, if they are equal, print "equal", otherwise print "not equal";
     */
    public static void main (String[] args) {
        int N = 3;
        int[] a = new int[N];
        boolean equal = true;
        for(int i=0; i<N; i++){
            a[i] = StdIn.readInt();
        }
        for(int i=0; i<N && equal; i++){
            for(int j=i+1; j<N; j++){
                if(a[i] != a[j]){
                    equal = false;
                }
            }
        }
        if(equal){
            StdOut.println("equal");
        }else{
            StdOut.println("not equal");
        }
    }
}
