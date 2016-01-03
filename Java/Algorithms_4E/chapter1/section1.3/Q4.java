public class Q4 { // Parenthess
    public static void main (String[] args) {
        Stack<Character> s = new Stack<Character>();
        boolean flag = true;
        while (!StdIn.isEmpty()) {
            Character c = StdIn.readChar();
            if (c.equals('{') || c.equals('(') || c.equals('[')) {
                s.push(c);
            } else {
                Character now = s.pop();
                if (c.equals(')')) {
                    flag = now.equals('(');
                } else if (c.equals(']')) {
                    flag = now.equals('[');
                } else if (c.equals('}')) {
                    flag = now.equals('{');
                } else {
                    flag = false;
                }
            }
        }
        StdOut.println(flag);
    }
}
