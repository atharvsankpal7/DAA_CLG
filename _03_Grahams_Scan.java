package Experiment_02;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class _03_Grahams_Scan {
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<Point>();
        Scanner io = new Scanner(System.in);
        System.out.println("Enter the amount of points that you want to enter -->");
        int pointCount = io.nextInt();
        if(pointCount<=3){
            System.out.println("Enter at-least three points");
            return;
        }
        for (int i = 0; i < pointCount; i++) {
            System.out.println("Enter the x and y co-ordinate of point number "+ (i+1)+"--> ");
            points.add(new Point(io.nextInt(),io.nextInt()));
        }
        points.sort((a, b) -> a.y == b.y ? a.x - b.x : a.y - b.y);
        ArrayList<Point> rightHull = new ArrayList<Point>();



        for (Point point : points) {
            while (
                    rightHull.size() >= 2 && isRightTurn(rightHull.get((rightHull.size() - 1)), rightHull.get((rightHull.size() - 2)), point)) {
                rightHull.remove(rightHull.size() - 1);
            }
            rightHull.add(point);
        }

        ArrayList<Point> leftHull = new ArrayList<Point>();
        for (int i = points.size() - 1; i >= 0; i--) {
            while (leftHull.size() >= 2 && isRightTurn(leftHull.get(leftHull.size() - 1), leftHull.get(leftHull.size() - 2), points.get(i))) {
                leftHull.remove(leftHull.size() - 1);
            }
            leftHull.add(points.get(i));
        }
        HashSet<Point> hull = new HashSet<>();
        hull.addAll(rightHull);
        hull.addAll(leftHull);

        ArrayList<Point> convexHull = new ArrayList<>(hull);

        for (Point point : convexHull) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }
    }

    static boolean isRightTurn(Point p1, Point p2, Point p3) {
        return (p1.x * (p3.y - p2.y) + p2.x * (p1.y - p3.y) + p3.x * (p2.y - p1.y)) < 0;
    }
}
