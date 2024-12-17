package ru.Khismatov.Math;

public class CacheFraction implements FractionInterface {
    private final FractionInterface fraction;
    private Double cachedValue = null;

    public CacheFraction(FractionInterface fraction) {this.fraction = fraction;}

    private void invalidateCache(){cachedValue = null;}

    public double getValue() {
        if (cachedValue == null) {
            cachedValue = (double) fraction.getValue();
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        fraction.setNumerator(numerator);
        invalidateCache();
    }

    @Override
    public void setDenominator(int denominator) {
        fraction.setDenominator(denominator);
        invalidateCache();
    }

    @Override
    public String toString(){
        return fraction.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof CacheFraction)) return false;
        CacheFraction other = (CacheFraction) obj;
        return this.fraction.equals(other.fraction);
    }
}
