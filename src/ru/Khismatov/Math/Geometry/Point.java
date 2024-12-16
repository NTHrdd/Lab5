package ru.Khismatov.Math.Geometry;

public record Point(int x, int y) {
    @Override
    public String toString() {return "{" + x + "; " + y + "}";}
}
