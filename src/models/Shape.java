package models;

import java.util.ArrayList;

public class Shape {
    private ArrayList<Point> points = new ArrayList<>();

    public void addPoint(Point point) {
        points.add(point);
    }

    public double calculatePerimeter() {
        double perimeter = 0;
        for (int i = 0; i < points.size(); i++) {
            Point current = points.get(i);
            Point next = points.get((i + 1) % points.size());
            perimeter += current.distance(next);
        }
        return perimeter;
    }

    public double getAverageSide() {
        return calculatePerimeter() / points.size();
    }

    public double getLongestSide() {
        double max = 0;
        for (int i = 0; i < points.size(); i++) {
            double dist = points.get(i).distance(points.get((i + 1) % points.size()));
            if (dist > max) max = dist;
        }
        return max;
    }
}
