import java.util.Arrays;

public class Q9 {

}

class BinarySearch{
    public static void main (String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Counter count = new Counter("counts");
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if(rank(key, whitelist, count) == -1){
                StdOut.println(key);
            }
        }
    }

    public static int rank(int key, int[] a, Counter count){
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            count.increment();
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
}
