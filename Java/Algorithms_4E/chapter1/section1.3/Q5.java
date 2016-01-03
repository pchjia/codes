public class Q5 {
    public static void main (String[] args) {
        Integer N = new Integer(args[0]);
        Stack<Integer> stack = new Stack<Integer>();
        while (N > 0) {
            stack.push(N % 2);
            N /= 2;
        }
        for (int d: stack) {
            StdOut.print(d);
        }
        StdOut.println();
    }
}
