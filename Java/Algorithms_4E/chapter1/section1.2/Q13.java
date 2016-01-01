public class Q13 {

}

class Transaction {
    private String name;
    private Date time;
    private double amount;

    public Transaction(String who, Date when, double amount) {
        this.name = who;
        this.time = when;
        this.amount = amount;
    }

    public String who() {
        return name;
    }

    public Date when() {
        return time;
    }

    public double amount() {
        return amount;
    }

    public String toString() {
        return name + " " + time + " " + amount;
    }

    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }

        if (that == null) {
            return false;
        }

        if (this.getClass() != that.getClass()) {
            return false;
        }

        Transaction test = (Transaction) that;
        if (!this.name.equals(test.name)) {
            return false;
        }
        if (!this.time.equals(test.time)) {
            return false;
        }
        if (this.amount != test.amount) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return name.hashCode() + time.hashCode() + (int)amount;
    }

    public int compareTo(Transaction that) {
        if (this.amount > that.amount) {
            return 1;
        } else if (this.amount == that.amount) {
            return 0;
        } else {
            return -1;
        }
    }
}
