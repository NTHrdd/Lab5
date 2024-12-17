package ru.Khismatov.Math.Fraction;

public class FractionFactory {
    public static FractionInterface createFraction(int numerator, int denominator) {
        return new CacheFraction(new Fraction(numerator, denominator));
    }
}
