public class Q15{
    public static void main (String[] args) {
        int[] a = {4, 1, 2, 6, 3, 1, 7, 2, 1, 6};
        int[] b = histogram(a, 7);
        for(int i=0; i<b.length; i++){
            System.out.println(b[i]);
        }
    }

    /**
     * @author pchjia
     * @param a source array
     * @param M words between 1-M that may appear in a
     * @return array desc 1-M appear times in a
     */
    public static int[] histogram(int[] a, int M){
        int ret[] = new int[M];
        for(int i=0; i<M; i++){
            for(int j=0; j<a.length; j++){
                if(a[j] == i+1){
                    ret[i] ++;
                }
            }
        }
        return ret;
    }
}
