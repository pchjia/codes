public class ArrayST <Key, Value>{
    private Key[] keys;
    private Value[] vals;
    private int N;

    @SuppressWarnings("unchecked")
    public ArrayST(int capacity) {
        keys = (Key[]) new Object[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }

        for (int i=0; i<N; i++) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }

        checkSize();
        keys[N] = key;
        vals[N++] = val;

    }

    public Value get(Key key) {
        for (int i=0; i<N; i++) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    public void delete(Key key) {

    }

    public void checkSize() {

    }
}
