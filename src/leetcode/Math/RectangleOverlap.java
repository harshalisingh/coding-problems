package leetcode.Math;

/*
 * http://www.geeksforgeeks.org/find-two-rectangles-overlap/
 */
class Point {
	int x; 
	int y;
	public Point(int i, int j) {
		this.x = i;
		this.y = j;
	}
}
public class RectangleOverlap {
	public static boolean rectangleOverlap(Point p1, Point p2, Point p3, Point p4){
		if((p1.x > p4.x) || (p3.x > p2.x))
			return false;
		
		if((p4.y > p1.y) || (p2.y > p3.y))
			return false;
		
		return true;

	}
	
	public static void main(String[] args){
		Point p1 = new Point(0, 10);
		Point p2 = new Point(10, 0);
		Point p3 = new Point(5, 5);
		Point p4 = new Point(15, 0);
		
		System.out.println(rectangleOverlap(p1,p2,p3,p4));
	}
}
