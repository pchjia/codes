import java.util.Arrays;

public class Q28{
    public static void main (String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        
        int len = deleteRep(whitelist);

        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if(rank(key, whitelist, len) == -1){
                StdOut.println(key);
            }
        }
    }

    public static int rank(int key, int[] a, int len){
        int lo = 0;
        int hi = len - 1;
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
     * delete repeated element in an array;
     * returns the array's length after deletion.
     */
    public static int deleteRep(int[] wl){
        int len = wl.length;
        for(int i=0; i<len-1; i++){
            if(wl[i] == wl[i+1]){
                for(int j=i+1; j<len-1; j++){
                    wl[j] = wl[j+1];
                }
                len --;
                i --;
            }
        }
        return len;
    }
}
