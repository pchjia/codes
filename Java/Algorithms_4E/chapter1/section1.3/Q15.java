public class Q15 {
    public static void main (String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue<String> queue = new Queue<String>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            queue.enqueue(s);
        }

        int count=0;
        for (String s: queue) {
            if (queue.size() - count == k) {
                StdOut.println(s);
            }
            count ++;
        }
    }
}
