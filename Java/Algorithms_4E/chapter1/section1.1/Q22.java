public class Q22{
    public static void main (String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        rank(2, a);
    }

    public static int rank(int key, int[] a){
        return rank(key, a, 0, a.length, 1);
    }
    public static int rank(int key, int[] a, int lo, int hi, int lev){
        for(int i=0; i<lev; i++){
            System.out.print(" ");
        }
        System.out.printf("level %d, low %d, high %d.\n", lev, lo, hi);
        if(lo > hi){
            return -1;
        }else{
            int mid = lo + (hi - lo)/2;
            if(key < a[mid]){
                return rank(key, a, lo, mid-1, lev+1);
            }else if(key > a[mid]){
                return rank(key, a, mid+1, hi, lev+1);
            }else{
                return mid;
            }
        }
    }
}
