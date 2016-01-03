public class Q14 <Item> { // ResizingArrayQueueOfItems
    @SuppressWarnings("unchecked")
    private Item[] a =(Item[]) new Object[1];
    private int N;
    
    public Q14() {
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        if (N == a.length) {
            resize(2*a.length);
        }
        a[N++] = item;
    }

    public Item dequeue() {
        Item item = a[--N];
        if (N == a.length/4) {
            resize(a.length/2);
        }
        return item;
    }

    private void resize(int max) {
        @SuppressWarnings("unchecked")
        Item[] tmp = (Item[])new Object[max];
        for (int i=0; i<N; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }
}
