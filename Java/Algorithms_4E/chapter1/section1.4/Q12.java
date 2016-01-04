public class Q12 {
    public static void main (String[] args) {
        
    }

    public static int common(int[] a, int[] b) {
        assert a[0] <= a[a.length-1] && b[0] <= b[b.length-1]: "demand array sorted asc";
        int aLen = a.length;
        int bLen = b.length;
        int cnt = 0;

        int i=0;
        int j=0;
        while (i<aLen && j<aLen) {
            if (a[i] == b[j]) {
                System.out.println(a[i]);
                cnt ++;
                i ++;
                j ++;
            } else if (a[i] < b[j]) {
                i ++;
            } else if (a[i] > b[j]) {
                j ++;
            }
        }
        return cnt;
    }
}
