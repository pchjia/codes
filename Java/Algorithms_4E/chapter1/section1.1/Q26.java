public class Q26{
    public static void main (String[] args) {
        rank(3, 6, 4);
    }

    public static void rank(int a, int b, int c){
        int t;
        if(a > b){
            t = a;
            a = b;
            b = t;
        }

        if(a > c){
            t = a;
            a = c;
            c = t;
        }

        if(b > c){
            t = b;
            b = c;
            c = t;
        }

        System.out.println(a + " " + b + " " + c);
    }
}
