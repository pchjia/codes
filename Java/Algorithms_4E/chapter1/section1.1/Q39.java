import java.util.Random;

public class Q39{
    /*
     * Average times:
     *      N = 1000     0
     *      N = 10000    1
     *      N = 100000   16
     */
    public static void main (String[] args) {
        int T = StdIn.readInt();
        System.out.println(BinarySearch.run(1000, T));
        System.out.println(BinarySearch.run(10000, T));
        System.out.println(BinarySearch.run(100000, T));
    }
}

class BinarySearch{
    /*
     * create two arrays, size is N, repeat T times for search there is how many bumbers are equal between both;
     */
    public static int run(int N, int T){
        int[] ans = new int[T];

        Random ran = new Random();
        int[] a = new int[N];
        int[] b = new int[N];

        int sum = 0;
        for(int k=0; k<T; k++){
            sum = 0;
            for(int i=0; i<N; i++){
                a[i] = ran.nextInt(100000) + 100000;
                b[i] = ran.nextInt(100000) + 100000;
            }

            for(int i=0; i<N; i++){
                if (search(a[i], b) != -1){
                    sum ++;
                }
            }
            ans[k] = sum;
        }

        sum = 0;
        for(int k=0; k<T; k++){
            sum += ans[k];
        }
        return sum/T;
    }

    public static int search(int key, int[] a){
        int lo = 0;
        int hi = a.length - 1;
        return search(key, a, lo, hi);
    }
    public static int search(int key, int[] a, int lo, int hi){
        if(lo > hi){
            return -1;
        }
        int mid = lo + (hi - lo)/2;
        if(a[mid] < key){
            return search(key, a, mid+1, hi);
        } else if (a[mid] > key) {
            return search(key, a, lo, mid-1);
        } else {
            return mid;
        }
    }
}
