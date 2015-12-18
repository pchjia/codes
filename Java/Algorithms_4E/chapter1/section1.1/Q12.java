public class Q12{
    /*
     * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
     *         at Q12.main(Q12.java:10)
     *
     */
    public static void main (String[] args) {
        int[] a = new int[0];
        for(int i=0; i<10; i++){
            a[i] = 9 - i;
        }
        for(int i=0; i<10; i++){
            a[i] = a[a[i]];
        }
        for(int i=0; i<10; i++){
            System.out.println(i);
        }
    }
}
