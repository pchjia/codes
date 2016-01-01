public class Q12 {
    public static void main (String[] args) {
        SmartDate d1 = new SmartDate(1, 1, 2016);
        System.out.println(d1.dayOfTheWeek());
        SmartDate d2 = new SmartDate(1, 2, 2016);
        System.out.println(d2.dayOfTheWeek());
        SmartDate d3 = new SmartDate(1, 3, 2016);
        System.out.println(d3.dayOfTheWeek());
        SmartDate d4 = new SmartDate(1, 4, 2016);
        System.out.println(d4.dayOfTheWeek());
    }
}

class SmartDate{
    private final int month;
    private final int day;
    private final int year;

    public SmartDate(int m, int d, int y){
        if(isIllegal(m, d, y)) {
            throw new RuntimeException();
        }

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
    
    private boolean isIllegal(int m, int d, int y) {
        if (y > 2016) {
            return true;
        }

        if (m > 12 || m < 1 || d < 1 || d > 31) {
            return true;
        }
        switch (m){
            case 1:case 3:case 5:case 7:case 8:case 10:case 12:
                if (d >= 1 && d <= 31) {
                    return false;
                }
                break;
            case 4:case 6:case 9:case 11:
                if(d >= 1 && d <= 30) {
                    return false;
                }
                 break;
            case 2:
                if (d % 100 == 0) {
                    if (d % 400 == 0) {
                        if (d >= 1 && d <= 29) {
                            return false;
                        }
                    } else {
                        if (d >= 1 && d <= 28) {
                            return false;
                        }
                    }
                } else {
                    if (d % 4 == 0) {
                        if (d >= 1 && d <= 29) {
                            return false;
                        }
                    } else {
                        if (d >= 1 && d <= 28) {
                            return false;
                        }
                    }
                }
                break;
            default:
                return true;
        }
        return true;
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

        SmartDate that = (SmartDate)x;
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

    public String dayOfTheWeek() {
        // zeller
        int c;
        int y;
        int m;
        if (this.month == 1 || this.month == 2) {
            m = this.month + 12;
            c = (this.year - 1) / 100;
            y = (this.year - 1) % 100;
        } else {
            c = this.year / 100;
            y = this.year % 100;
            m = this.month;
    
        }
        int d = this.day;
        int w = y + y/4 + c/4 - 2*c + 26 * (m+1) / 10 + d - 1;
        w = (w % 7 + 7) % 7;

        switch (w) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return null;
        }
    }
}
