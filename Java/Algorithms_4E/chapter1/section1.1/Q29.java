import java.util.Arrays;

public class Q29{
    public static void main (String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if(rank(key, whitelist) == -1){
                StdOut.println(key);
            }
        }
    }

    public static int rank(int key, int[] a){
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(key < a[mid]){
                hi = mid - 1;
            }else if(key > a[mid]){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /*
     * returns number of elem less than key in a;
     */
    public static int rank1(int key, int[] a){
        int count = 0;
        boolean flag = true;
        for(int i=0; i<a.length && flag; i++){
            if(a[i] < key){
                count ++;
            }else{
                flag = false;
            }
        }

        return count;
    }

    /*
     * returns number of elem that equals to key in a;
     */
    public static int count(int key, int[] a){
        int count = 0;
        int start = rank1(key, a);
        boolean flag = true;
        for(int i=start-1; i<a.length && flag; i++){
            if(a[i] == key){
                count ++;
            }else{
                flag = false;
            }
        }

        return count;
    }
}
