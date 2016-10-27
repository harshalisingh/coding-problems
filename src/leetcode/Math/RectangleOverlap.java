package leetcode.Math;

public class RectangleOverlap {
	class Point {
		int x; 
		int y;
	}
	public boolean rectangleOverlap(Point p1, Point p2, Point p3, Point p4){
		// Left x 
	    int leftX = Math.max(p1.x, p3.x);
	    // Right x
	    int rightX = Math.min(p3.x, p4.x);
	    // Bottom y
	    int botY = Math.max(p1.y, p3.y);
	    // TopY
	    int topY = Math.min(p2.y, p4.y);

	    if (rightX > leftX && topY > botY)
	       return true;
	    else 
	    	return false;

	}
}
