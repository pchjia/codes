public class BinarySearchST <Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    @SuppressWarnings("unchecked")
    public BinarySearchST (int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i<N && keys[i].compareTo(key) == 0) {
             return vals[i];
        } else {
            return null;
        }
    }

    public int rank(Key key) {
        int lo = 0;
        int hi = N-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if (i<N && keys[i].compareTo(key) == 0) {
             vals[i] = val;
             return;
        }
        for (int j=N; j>i; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N ++;
    }

    public void delete(Key key) {

    }

    public boolean isEmpty() {
         return N == 0;
    }

    public Key min() {
         return keys[0];
    }

    public Key max() {
        return keys[N-1];
    }

    public Key select(int k) {
         return keys[k];
    }

    public Key ceiling(Key k) {
        int i = rank(k);
        return keys[i];
    }

    public Key floor(Key key) {
         int i = rank(key);
    }

    public Key delete(Key key) {

    }

    public Iterable<Key> keys(Key lo, Key hi) {
         Queue<Key> q = new Queue<Key>();
         for (int i=rank(lo); i<rank(hi); i++) {
             q.enqueue(keys[i]);
         }
         if (contains(hi)) {
              q.enqueue(keys[rank(hi)]);
         }
         return q;
    }

    public boolean contains(Key key) {
        int i = rank(key);
        return i<N && keys[i].equals(key);
    }
}
