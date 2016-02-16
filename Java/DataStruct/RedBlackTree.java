import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class RedBlackTree <Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    public static void main(String[] args) {
        RedBlackTree<String, Integer> rbt = new RedBlackTree<String, Integer>();
        for (int i=0; i<args.length; i++) {
            rbt.put(args[i], new Integer(i));
        }
        System.out.print("size: " + rbt.size() + "; ");
        for (String key: rbt.keys()) {
            System.out.print(key + ": " + rbt.get(key) + ";\t");
        }
        Scanner in = new Scanner(System.in);
        System.out.print("\nenter a key you want to delete:");
        while (in.hasNext()) {
            String word = in.next();
            if (rbt.get(word) != null) {
                rbt.delete(word);
                if (rbt.get(word) == null) {
                    System.out.println(word + " deleted!");
                }
                System.out.print("size: " + rbt.size() + "; ");
                for (String key: rbt.keys()) {
                    System.out.print(key + ": " + rbt.get(key) + ";\t");
                }
            } else {
                System.out.println(word + " doesn't exist!");
            }
            System.out.print("\nenter a key you want to delete:");
        }
    }

    private class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        int N;
        boolean color;

        public Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    private Node rotateLeft(Node node) {
        Node tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        tmp.color = node.color;
        node.color = RED;
        tmp.N = node.N;
        node.N = size(node.left) + size(node.right) + 1;
        return tmp;
    }

    private Node rotateRight(Node node) {
        Node tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        tmp.color = node.color;
        node.color = RED;
        tmp.N = node.N;
        node.N = size(node.left) + size(node.right) + 1;
        return tmp;
    }

    public int size() {
        return size(root);
    }
    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    private void flipColor(Node node) {
        boolean colorChild = node.left.color;
        node.color = colorChild;
        node.left.color = !colorChild;
        node.right.color = !colorChild;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }
    private Node put(Node node, Key key, Value val) {
        if (node == null) {
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColor(node);
        }

        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.val;
        }
    }

    public Key min() {
        return min(root);
    }
    private Key min(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return min(node.left);
        }
        return node.key;
    }

    public Key max() {
        return max(root);
    }
    private Key max(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return max(node.right);
        }
        return node.key;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new LinkedList<Key>();
        keys(root, q, lo, hi);
        return q;
    }
    private void keys(Node node, Queue<Key> q, Key lo, Key hi) {
        if (node == null) {
            return;
        }
        int cmplo = lo.compareTo(node.key);
        int cmphi = hi.compareTo(node.key);
        if (cmplo < 0) {
            keys(node.left, q, lo, hi);
        }
        if ((cmplo <= 0) && (cmphi >= 0)) {
            q.add(node.key);
        }
        if (cmphi > 0) {
            keys(node.right, q, lo, hi);
        }
    }

    public void deleteMin() {
        if (isEmpty()) {
            return;
        }
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = deleteMin(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }
    private Node deleteMin(Node node) {
        if (node.left == null) {
            return null;
        }
        if (!isRed(node.left) && !isRed(node.left.left)) {
            node = moveRedLeft(node);
        }
        node.left = deleteMin(node.left);
        return balance(node);
    }
    private Node moveRedLeft(Node node) {
        flipColor(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }
        return node;
    }

    public void deleteMax() {
        if (isEmpty()) {
            return;
        }
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = deleteMax(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }
    private Node deleteMax(Node node) {
        if (isRed(node.left)) {
            node = rotateRight(node);
        }
        if (node.right == null) {
            return null;
        }
        if (!isRed(node.right) && !isRed(node.right.left)) {
            node = moveRedRight(node);
        }
        node.right = deleteMax(node.right);
        return balance(node);
    }
    private Node moveRedRight(Node node) {
        flipColor(node);
        if (!isRed(node.left.left)) {
            node = rotateRight(node);
        }
        return node;
    }

    public void delete(Key key) {
        if (isEmpty()) {
            return;
        }
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = delete(root, key);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }
    private Node delete(Node node, Key key) {
        if (key.compareTo(node.key) < 0) {
            if (!isRed(node.left) && !isRed(node.left.left)) {
                node = moveRedLeft(node);
            }
            node.left = delete(node.left, key);
        } else {
            if (isRed(node.left)) {
                node = rotateRight(node);
            }
            if ((key.compareTo(node.key) == 0) && (node.right == null)) {
                return null;
            }
            if (!isRed(node.right) && !isRed(node.right.left)) {
                node = moveRedRight(node);
            }
            if (key.compareTo(node.key) == 0) {
                node.val = get(node.right, min(node.right));
                node.key = min(node.right);
                node.right = deleteMin(node.right);
            } else {
                node.right = delete(node.right, key);
            }
        }
        return balance(node);
    }
    private Node balance(Node node) {
        if (isRed(node.right)) {
            node = rotateLeft(node);
        }
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColor(node);
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }
    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return floor(node.left, key);
        } else if (cmp > 0) {
            Node tmp = floor(node.right, key);
            if (tmp == null) {
                return node;
            } else {
                return tmp;
            }
        } else {
            return node;
        }
    }

    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }
    private Node ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            Node tmp = ceiling(node.left, key);
            if (tmp == null) {
                return node;
            }else {
                return tmp;
            }
        } else if (cmp > 0) {
            return ceiling(node.right, key);
        } else {
            return node;
        }
    }

    public Key select(int k) {
        Node node = select(root, k);
        if (node == null) {
            return null;
        }
        return node.key;
    }
    private Node select(Node node, int k) {
        if (node == null) {
            return null;
        }
        int t = size(node.left);
        if (k < t) {
            return select(node.left, k);
        } else if (k > t) {
            return select(node.right, k-t-1);
        } else {
            return node;
        }
    }

    public int rank(Key key) {
        return rank(root, key);
    }
    private int rank(Node node, Key key) {
        if (node == null) {
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return rank(node.left, key);
        } else if (cmp > 0) {
            return 1 + size(node.left) + rank(node.right, key);
        } else {
            return size(node.left);
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
