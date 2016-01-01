public class Q16 {}

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
        int num = this.numerator()*b.denominator() + b.numerator()*this.denominator();
        int den = this.denominator() * b.denominator();
        int denGcd = Euclid.gcd(num, den);

        num /= denGcd;
        den /= denGcd;
        return new Rational(num, den);
    }

    public Rational minus(Rational b) {
        int num = this.numerator()*b.denominator() - b.numerator()*this.denominator();
        int den = this.denominator() * b.denominator();
        int denGcd = Euclid.gcd(num, den);

        num /= denGcd;
        den /= denGcd;
        return new Rational(num, den);
    }

    public Rational times(Rational b) {
        int num = this.numerator() * b.numerator();
        int den = this.denominator() * b.denominator();

        int denGcd = Euclid.gcd(num, den);
        num /= denGcd;
        den /= denGcd;
        return new Rational(num, den);
    }

    public Rational divides(Rational b) {
        int num = this.numerator() * b.denominator();
        int den = this.denominator() * b.numerator();

        int denGcd = Euclid.gcd(num, den);
        num /= denGcd;
        den /= denGcd;
        return new Rational(num, den);
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
