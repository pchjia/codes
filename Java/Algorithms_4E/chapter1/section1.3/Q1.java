public class Q1 {

}

class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(2*a.length);
        }
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length/4) {
            resize(a.length/2);
        }
        return item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i=0; i<a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
}
