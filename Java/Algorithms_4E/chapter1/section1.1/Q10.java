public class Q10{
    /*
     * variable a might not have been initialized 
     */
    public static void main (String[] args) {
        int[] a;
        for(int i=0; i<10; i++){
            a[i] = i * i;
        }
    }
}
