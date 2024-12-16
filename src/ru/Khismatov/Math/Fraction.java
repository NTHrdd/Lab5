package ru.Khismatov.Math;

import java.util.Objects;

public final class Fraction extends Number implements Cloneable, FractionInterface {
    private int numerator;
    private int denominator;
    private Double cachedValue = null;

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

    private void invalidateCache(){cachedValue = null;}

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
        invalidateCache();
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.denominator = denominator;
        simplify();
        invalidateCache();
    }

    public double getValue() {
        if (cachedValue == null) {
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
    }

    public Fraction sum(Fraction other) {return new Fraction(this.numerator * other.denominator + this.denominator * other.numerator, this.denominator * other.denominator);}

    public Fraction sum(int value) {return new Fraction(this.numerator + this.denominator * value, this.denominator);}

    public Fraction minus(Fraction other) {return new Fraction(numerator * other.denominator - this.denominator * other.numerator, this.denominator * other.denominator);}

    public Fraction minus(int value) {return new Fraction(this.numerator - this.denominator * value, this.denominator);}

    public Fraction multiply(Fraction other) {return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);}

    public Fraction multiply(int value) {return new Fraction(this.numerator * value, this.denominator);}

    public Fraction divide(Fraction other) {return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);}

    public Fraction divide(int value) {return new Fraction(this.numerator, this.denominator * value);}

    @Override
    public String toString() {return numerator + "/" + denominator;}

    @Override
    public int intValue() {return numerator/denominator;}

    @Override
    public long longValue() {return (long) numerator/denominator;}

    @Override
    public float floatValue() {return (float) numerator/denominator;}

    @Override
    public double doubleValue() {return (double) numerator/denominator;}

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
            Fraction cloned  = (Fraction) super.clone();
            cloned.cachedValue = this.cachedValue;
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
