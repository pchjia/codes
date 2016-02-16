import java.util.Queue;
import java.util.LinkedList;

public class SeparateChainingHashST <Key, Value> {
    private int N;  // key-value number
    private int M;  // hash table size
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    @SuppressWarnings("unchecked")
    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i=0; i<M; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedList<Key>();
        for (int i=0; i<M; i++) {
            for (Key key: st[i].keys()) {
                q.add(key);
            }
        }
        return q;
    }

    public static void main(String[] args) {
        int N = args.length;
        SeparateChainingHashST<String, Integer> scHash = new SeparateChainingHashST<>(N);

        for (int i=0; i<N; i++) {
            scHash.put(args[i], i);
        }

        for (String key: scHash.keys()) {
            System.out.println(key + " " + scHash.get(key));
        }
    }
}
