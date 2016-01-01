public class Q17 {}

class Rational {
    private final int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator) {
        int denGcd = Euclid.gcd(numerator, denominator);

        this.numerator = numerator / denGcd;
        this.denominator = denominator / denGcd;
    }

    public int numerator() {
        return numerator;
    }

    public int denominator() {
        return denominator;
    }

    public Rational plus(Rational b) {
        long num = this.numerator()*b.denominator() + b.numerator()*this.denominator();
        long den = this.denominator() * b.denominator();
        long denGcd = Euclid.gcd(num, den);

        num /= denGcd;
        den /= denGcd;
        assert num <= Integer.MAX_VALUE && num >= Integer.MIN_VALUE;
        return new Rational((int)num, (int)den);
    }

    public Rational minus(Rational b) {
        long num = this.numerator()*b.denominator() - b.numerator()*this.denominator();
        long den = this.denominator() * b.denominator();
        long denGcd = Euclid.gcd(num, den);

        num /= denGcd;
        den /= denGcd;
        assert num <= Integer.MAX_VALUE && num >= Integer.MIN_VALUE;
        return new Rational((int)num, (int)den);
    }

    public Rational times(Rational b) {
        long num = this.numerator() * b.numerator();
        long den = this.denominator() * b.denominator();
        long denGcd = Euclid.gcd(num, den);

        num /= denGcd;
        den /= denGcd;
        assert num <= Integer.MAX_VALUE && num >= Integer.MIN_VALUE;
        return new Rational((int)num, (int)den);
    }

    public Rational divides(Rational b) {
        long num = this.numerator() * b.denominator();
        long den = this.denominator() * b.numerator();
        long denGcd = Euclid.gcd(num, den);

        num /= denGcd;
        den /= denGcd;
        assert num <= Integer.MAX_VALUE && num >= Integer.MIN_VALUE;
        return new Rational((int)num, (int)den);
    }

    public boolean equals(Rational that) {
        if (this == that) {
            return true;
        }

        if (that == null) {
            return false;
        }

        if (this.getClass() != that.getClass()) {
            return false;
        }

        if (this.numerator() != that.numerator()) {
            return false;
        }

        if (this.denominator() != that.denominator()) {
            return false;
        }

        return true;
    }

    public String toString() {
        return numerator() + " / " + denominator();
    }

    public int hashCode() {
        return numerator() + denominator();
    }
}
