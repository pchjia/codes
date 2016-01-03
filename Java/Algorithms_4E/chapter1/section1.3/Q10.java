public class Q10 { // InfixToPostfix
    public static void main (String[] args) {
        Queue<String> infix = new Queue<String>();
        while (!StdIn.isEmpty()) {
            infix.enqueue(StdIn.readString());
        }
        Queue<String> postfix = transform(infix);
        while(!postfix.isEmpty()) {
            StdOut.print(postfix.dequeue() + " ");
        }
        StdOut.println();
    }
    public static Queue<String> transform(Queue<String> infix) {
        Stack<String> opts = new Stack<String>();
        Queue<String> postfix = new Queue<String>();

        while (!infix.isEmpty()) {
            String s = infix.dequeue();
            if (s.equals("(")) {
            
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                opts.push(s);
            } else if (s.equals(")")) {
                postfix.enqueue(opts.pop());
            } else {
                postfix.enqueue(s);
            }
        }
        return postfix;
    }
}
