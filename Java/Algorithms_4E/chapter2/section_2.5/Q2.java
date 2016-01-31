public class Q2 {
    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }

        int len = q.size();
        String[] words = new String[len];
        for (int i=0; i<len; i++) {
            words[i] = q.dequeue();
        }

        for (int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                System.out.println(words[i] + words[j]);
            }
        }
    }
}
