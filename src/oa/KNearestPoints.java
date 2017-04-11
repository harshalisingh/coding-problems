package oa;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

/*
 * K <= 0 return new Point [0] is a test case
 * K > size is to return to the original array, but inside the points to sort side, 
 * the nearest point is the first, the second is the second and so on
 */
public class KNearestPoints {
	public List<Point> findKClosest(List<Point> points, Point center, int k) {
		if (points == null || points.size() == 0) {
			return points;
		}
		PriorityQueue<Point> queue = new PriorityQueue<>(k, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return calDistance(center, p1) - calDistance(center, p2);
			}
		});
		for (Point p: points) {
			queue.add(p);
		}
		List<Point> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			res.add(queue.poll());
		}
		return res;
	}

	private int calDistance(Point p1, Point p2) {
		return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		KNearestPoints test = new KNearestPoints();
		Point center = new Point(0, 0);
		List<Point> points = new ArrayList<>();
		for (int i = -3; i < 7; i++) {
			points.add(new Point(i - 3, i * i - 9));
		}

		List<Point> res = test.findKClosest(points, center, 5);
		for (Point p: res) {
			System.out.println(p.x + "," + p.y + " " + test.calDistance(center, p));
		}
	}
	
}
