public class Q9 {
    public static void main (String[] args) {
        Stack<String> input = new Stack<String>();
        Stack<String> output = new Stack<String>();
        Stack<String> outputVals = new Stack<String>();
        Stack<String> outputOpts = new Stack<String>();

        while (!StdIn.isEmpty()) {
            input.push(StdIn.readString());
        }

        for (String s: input) {
            if (s.equals(")")) {
                output.push(s);
                outputOpts.push(")");
            } else if (s.equals("+") || s.equals("-") || 
                    s.equals("*") || s.equals("/")) {
                outputOpts.push(s);
                output.push(s);

            } else {
                output.push(s);
                outputVals.push(s);
                while (!outputOpts.isEmpty()) {
                    String op = outputOpts.pop();
                    if (op.equals(")")) {
                        break;
                    }
                    outputVals.pop();
                    output.push("(");
                }
            }
        }
        for (String s: output) {
            StdOut.print(s + " ");
        }
    }
}
