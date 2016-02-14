import java.util.Queue;
import java.util.LinkedList;

public class BST <Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
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

    public void put(Key key, Value val) {
         root = put(root, key, val);
    }
    private Node put(Node node, Key key, Value val) {
        if (node == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
             node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key min() {
        if (root == null) {
            return null;
        }
        return min(root).key;
    }
    private Node min(Node node) {
        if (node.left == null) {
             return node;
        } else {
            return min(node.left);
        }
    }

    public Key max() {
        if (root == null) {
            return null;
        }
        return max(root).key;
    }
    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
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

    public void deleteMin() {
        root = deleteMin(root);
    }
    private Node deleteMin(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
             return node.right;
        }
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }
    private Node deleteMax(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
             return node.left;
        }
        node.right = deleteMax(node.right);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }
    private Node delete(Node node, Key key) {
        if (node == null) {
             return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                 return node.left;
            }
            Node tmp = node;
            node = min(tmp.right);
            node.right = deleteMin(tmp.right);
            node.left = tmp.left;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
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
        if (cmplo <= 0 && cmphi >= 0) {
            q.add(node.key);
        }
        if (cmphi > 0) {
            keys(node.right, q, lo, hi);
        }
    }
}
