import java.util.Arrays;

public class Q23{
    /* '+' represents not in list.
     * '-' represents that in list.
     */
    public static void main (String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        
        char flag = StdIn.readChar();

        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            boolean in = rank(key, whitelist) == -1 ? false: true;
            if(!in && flag == '+'){
                StdOut.println(key);
            }else if(in && flag == '-'){
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
}
