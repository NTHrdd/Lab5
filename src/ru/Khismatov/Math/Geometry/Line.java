package ru.Khismatov.Math.Geometry;

public record Line (Point start, Point end) {
    @Override
    public String toString() {return "Линия от " + start + " до " + end;}
}
