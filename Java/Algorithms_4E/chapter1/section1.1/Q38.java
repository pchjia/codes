import java.util.Arrays;

public class Q38{
    public static void main (String[] args) {
        int[] whitelist = In.readInts(args[0]);

        Arrays.sort(whitelist);

        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if(BruteForceSearch.rank(key, whitelist) == -1){
                StdOut.println(key);
            }
        }
    }
}

class BruteForceSearch{
    public static int rank(int key, int[] a){
        for(int i=0; i<a.length; i++){
            if(a[i] == key){
                return i;
            }
        }
        return -1;
    }
}
