public class Q16{
    public static void main (String[] args) {
        System.out.println(exR2(StdIn.readInt()));
    }

    public static String exR2(int n){
        if(n <= 0){
            return "";
        }
        return exR2(n-3) + n + exR2(n-2) + n;
    }
}
