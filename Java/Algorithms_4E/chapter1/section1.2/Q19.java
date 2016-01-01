public class Q19 {

}

class Date{
    private final int month;
    private final int day;
    private final int year;

    public Date(String str) {
        String[] fields = str.split("/");
        this.month = Integer.parseInt(fields[0]);
        this.day = Integer.parseInt(fields[1]);
        this.year = Integer.parseInt(fields[2]);
    }

    public Date(int m, int d, int y){
        month = m;
        day = d;
        year = y;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    public boolean equals(Object x) {
        if (this == x) {
            return true;
        }

        if (x == null) {
            return false;
        }

        if (this.getClass() != x.getClass()) {
            return false;
        }

        Date that = (Date)x;
        if (this.day != that.day) {
            return false;
        }
        if (this.month != that.month) {
            return false;
        }
        if (this.year != that.year) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return month + day + year;
    }
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

    public Transaction(String str) {
        String[] fields = str.split(" ");
        this.name = fields[0];
        this.time = new Date(fields[1]);
        this.amount = Double.parseDouble(fields[2]);
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
