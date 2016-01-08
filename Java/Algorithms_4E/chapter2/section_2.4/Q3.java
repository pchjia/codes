public class Q3 {

}
class RandomArrayPQ {
    private String[] pq;
    private int N = 0;
    
    public RandomArrayPQ(int max) {
        pq = new String[max + 1];
    }

    public void insert(String s) {
        pq[++N] = s;
    }

    public String delMax() {
        String max = pq[1];
        for (int i=1; i<=N; i++) {
            if (max.compareTo(pq[i]) < 0) {
                max = pq[i];
            }
        }
        N--;
        return max;
    }
}

class SortedArrayPQ {
    private String[] pq;
    private int N = 0;
    
    public SortedArrayPQ(int max) {
        pq = new String[max + 1];
    }

    public void insert(String s) {
        pq[++N] = s;
        for (int i=N; i>1; i--) {
            if (less(i, i-1)) {
                exch(i, i-1);
            }
        }
    }

    public String delMax() {
        String max = pq[N--];
        return max;
    }

    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public void exch(int i, int j) {
        String tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
}

class RandomLinkedPQ {
    private class Node{
        String data;
        Node next;
    }

    private Node first;
    private int N = 0;

    public RandomLinkedPQ() {
        first = new Node();
        first.data = "";
        first.next = null;
    }

    public void insert(String s) {
        Node node = new Node();
        node.data = s;
        node.next = first.next;
        first.next = node;
        N ++;
    }

    public String delMax() {
        String max = first.next.data;
        Node tmp = first;
        while (tmp.next != null) {
            if (tmp.next.data.compareTo(max) > 0) {
                max = tmp.next.data;
            }
        }
        N --;
        return max;
    }
}

class SortedLinkedPQ {
    private class Node{
        String data;
        Node next;
    }

    private Node first;
    private int N = 0;

    public SortedLinkedPQ() {
        first = new Node();
        first.data = "";
        first.next = null;
    }

    public void insert(String s) {
        Node node = new Node();
        node.data = s;
        Node tmp = first;
        while (tmp.next != null) {
            if (tmp.next.data.compareTo(s) < 0) {
                node.next = tmp.next;
                tmp.next = node;
                break;
            }
        }
        N ++;
    }

    public String delMax() {
        String max = first.next.data;
        first.next = first.next.next;
        N --;
        return max;
    }
}
