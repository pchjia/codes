public class Q3 {
    public static void main(String[] args) {

    }
}

class Balence implements Comparable<Balence> {
    private double amount;
    // below should be:
    // public int compareTo(Comparable that)
    public int compareTo(Balence that) {
        if (this.amount < that.amount - 0.005) {
            return -1;
        }

        if (this.amount > that.amount + 0.005) {
            return 1;
        }

        return 0;
    }
}
