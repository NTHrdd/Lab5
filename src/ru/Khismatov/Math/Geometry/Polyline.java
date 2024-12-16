package ru.Khismatov.Math.Geometry;

import java.util.List;

public record Polyline(List<Point> points) {
    @Override
    public String toString() {return "Линия " + points;}
}
