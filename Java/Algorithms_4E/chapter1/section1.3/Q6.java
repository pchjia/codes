public class Q6 {
    public static void main (String[] args) {
        Queue<String> q = new Queue<String>();
        Stack<String> stack = new Stack<String>();
        while (!q.isEmpty()) {
            stack.push(q.dequeue());
        }
        while (!stack.isEmpty()) {
            q.enqueue(stack.pop());
        }
    }
}
