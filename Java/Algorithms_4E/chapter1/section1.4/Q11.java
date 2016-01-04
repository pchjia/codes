public class Q11 { // StaticSETofInts
    private int[] a;

    public Q11 (int[] a) {
        this.a = new int[a.length];
        for (int i=0; i<a.length; i++) {
            this.a[i] = a[i];
        }
    }

    public boolean contains(int key) {
        int index = BinarySearch.rank(key, a);
        return a[index] == key;
    }
}
