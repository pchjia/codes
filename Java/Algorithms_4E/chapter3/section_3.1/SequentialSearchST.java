import java.util.Queue;
import java.util.LinkedList;

public class SequentialSearchST <Key, Value> {
    private Node first;
    private class Node {
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SequentialSearchST() {}

    public Value get(Key key) {
        for (Node x=first; x!=null; x=x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x=first; x!=null; x=x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
    }

    public void delete(Key key) {
        if (first == null) {
            return;
        }

        if ((first != null) && (first.next == null)) {
            if (key.equals(first.key)) {
                first = null;
                return;
            }
        }

        for (Node x=first; x.next!=null; x=x.next) {
            if (key.equals(x.next.key)) {
                x.next = x.next.next;
                return;
            }
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedList<Key>();
        Node tmp = first;
        while (tmp != null) {
            q.add(tmp.key);
            tmp = tmp.next;
        }
        return q;
    }
}
