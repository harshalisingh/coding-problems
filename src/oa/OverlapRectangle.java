package oa;

public class OverlapRectangle {
    public static class Node {
        double x;
        double y;
        public Node(double x, double y) {
            this.x = x;
            this.y = y; 
        }
    }

    public static boolean check(Node topLeftA, Node topLeftB, Node bottomRightA, Node bottomRightB) {
        // one above the other one
        if(bottomRightA.y > topLeftB.y || bottomRightB.y > topLeftA.y) {
            return false;
        }
        // one on the left side of the other one
        if(bottomRightA.x < topLeftB.x || bottomRightB.x < topLeftA.x) {
            return false;
        }

        return true;
    }
}
