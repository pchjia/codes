public class Q11 { // EvaluatePostfix
    public static void main (String[] args) {
        Stack<Double> vals = new Stack<Double>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")) {
                double opt1 = vals.pop();
                double opt2 = vals.pop();
                double res = opt1 + opt2;
                vals.push(res);
            } else if (s.equals("-")) {
                double opt1 = vals.pop();
                double opt2 = vals.pop();
                double res = opt1 - opt2;
                vals.push(res);
            } else if (s.equals("*")) {
                double opt1 = vals.pop();
                double opt2 = vals.pop();
                double res = opt1 * opt2;
                vals.push(res);
            } else if (s.equals("/")) {
                double opt1 = vals.pop();
                double opt2 = vals.pop();
                double res = opt1 / opt2;
                vals.push(res);
            } else {
                vals.push(Double.parseDouble(s));
            }
       }
       StdOut.println(vals.pop());
    }
}
