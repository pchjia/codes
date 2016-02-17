import java.util.Queue;
import java.util.LinkedList;

public class LinearProbingHashST <Key, Value> {
    private int N;
    private int M;
    private Key[] keys;
    private Value[] vals;

    public static void main(String[] args) {
        LinearProbingHashST<String, Integer> hash = new LinearProbingHashST<>();
        for (int i=0; i<args.length; i++) {
            hash.put(args[i], i);
        }

        for (String key: hash.keys()) {
            System.out.println(key + ": " + hash.get(key));
        }

        for (String key: hash.keys()) {
            hash.delete(key);
            System.out.println(key + " deleted!");
        }
    }

    public LinearProbingHashST() {
        this(16);
    }

    @SuppressWarnings("unchecked")
    public LinearProbingHashST(int M) {
        this.M = M;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value val) {
        if (N >= M/2) {
            resize(2*M);
        }
        int i;
        for (i=hash(key); keys[i]!=null; i=(i+1)%M) {
            if (key.equals(keys[i])) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N ++;
    }

    public Value get(Key key) {
         int i;
         for (i=hash(key); keys[i]!=null; i=(i+1)%M) {
             if (key.equals(keys[i])) {
                 return vals[i];
             }
         }
         return null;
    }

    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
             i = (i+1) % M;
        }

        keys[i] = null;
        vals[i] = null;
        N --;
        for (i=(i+1)%M; keys[i]!=null; i=(i+1)%M) {
             Key tmpKey = keys[i];
             Value tmpVal = vals[i];
             keys[i] = null;
             vals[i] = null;
             N --;
             put(tmpKey, tmpVal);
        }
        if ((N > 0) && (N == M/8)) {
             resize(M/2);
        }
    }

    public boolean contains(Key key) {
         return get(key) != null;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedList<>();
        for (int i=0; i<keys.length; i++) {
            if (keys[i] != null) {
                q.add(keys[i]);
            }
        }
        return q;
    }

    private void resize(int cap) {
         LinearProbingHashST<Key, Value> t = new LinearProbingHashST<Key, Value>(cap);
         for (int i=0; i<M; i++) {
             if (keys[i] != null) {
                 t.put(keys[i], vals[i]);
             }
         }
         keys = t.keys;
         vals = t.vals;
         this.M = t.M;
    }
}
