package ru.Khismatov.Math.Fraction;

import java.util.Objects;

public final class Fraction implements Cloneable, FractionInterface {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {throw new IllegalArgumentException("Denominator cannot be zero");}
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private int nod(int a, int b) {return (b == 0) ? a : nod(b, a % b);}

    private void simplify() {
        int nod = nod(Math.abs(numerator), Math.abs(denominator));
        numerator /= nod;
        denominator /= nod;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }
    @Override
    public double getValue(){
        return (double) numerator / denominator;
    }

    @Override
    public void setNumerator(int numerator) {this.numerator = numerator;simplify();}

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.denominator = denominator;
        simplify();
    }

    @Override
    public int hashCode() {return Objects.hash(numerator, denominator);}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction other)) return false;
        return numerator == other.numerator && denominator == other.denominator;
    }

    @Override
    public Fraction clone() {
        try{
            return (Fraction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {return numerator + "/" + denominator;}
}
