package leetcode.Design;

/**
 * Given two straight lines, compute the point of intersection.
 * https://github.com/careercup/CtCI-6th-Edition/tree/master/Java/Ch%2016.%20Moderate/Q16_03_Intersection
 */
class Line {
	public double slope;
	public double yintercept;

	public Line(Point start, Point end) {
		double deltaY = end.y - start.y;
		double deltaX = end.x - start.x;
		slope = deltaY / deltaX; // Will be Infinity (not exception) when deltaX = 0 
		yintercept = end.y - slope * end.x;
	}

	public void print() {
		System.out.print("y = " + slope + "x + " + yintercept);
	}
}
class Point {
	public double x;
	public double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
public class LineIntersection {
	public static Point createPoint(int[] coordinates) {
		return new Point(coordinates[0],  coordinates[1]);
	}	

	/* Checks if middle is between start and end. */
	public static boolean isBetween(double start, double middle, double end) {
		if (start > end) {
			return end <= middle && middle <= start;
		} else {
			return start <= middle && middle <= end;
		}
	}

	/* Checks if middle is between start and end. */
	public static boolean isBetween(Point start, Point middle, Point end) {
		return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
	}

	public static void swap(Point one, Point two) {
		double x = one.x;
		double y = one.y;
		one.setLocation(two.x, two.y);
		two.setLocation(x, y);
	}

	public static Point intersection(Point start1, Point end1, Point start2, Point end2) {
		/* Rearranging these so that, in order of x values: start is before end and point 1 is before point 2. 
		 * This will make some of the later logic simpler. */
		if (start1.x > end1.x) swap(start1, end1);
		if (start2.x > end2.x) swap(start2, end2);
		if (start1.x > start2.x) {
			swap(start1, start2);
			swap(end1, end2);
		}

		/* Compute lines (including slope and y-intercept). */
		Line line1 = new Line(start1, end1);
		Line line2 = new Line(start2, end2);

		/* If the lines are parallel, they intercept only if they have the same y intercept and start 2 is on line 1. */
		if (line1.slope == line2.slope) {
			if (line1.yintercept == line2.yintercept && isBetween(start1, start2, end1)) {
				return start2;
			}
			return null;
		}

		/* Get intersection coordinate. */
		double x =  (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope);
		double y = x * line1.slope + line1.yintercept;
		Point intersection = new Point(x, y);

		/* Check if within line segment range. */
		if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
			return intersection;
		}
		return null;
	}

	public static void main(String[] args) {
		int[][] coordinates = {
				{8, 8}, {8, 16},
				{1, 1}, {1, 10}};
		Point[] points = {createPoint(coordinates[0]), createPoint(coordinates[1]), createPoint(coordinates[2]), createPoint(coordinates[3])};
		Point intersection = intersection(points[0], points[1], points[2], points[3]);
		if (intersection == null) {
			System.out.println("No intersection.");
		} else {
			System.out.println("Intersection: " + intersection.x + ", " + intersection.y);
		}
	}
}
