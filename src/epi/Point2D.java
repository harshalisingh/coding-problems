package epi;

public class Point2D {
    protected double x;
    protected double y;

    Point2D(double xCoord, double yCoord){
        this.x = xCoord;
        this.y = yCoord;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public static double distance(Point2D a, Point2D b)
    {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        Point2D p1 = new Point2D(2,2);
        Point2D p2 = new Point2D(5,6);
        System.out.println("Distance between them is " + Point2D.distance(p1, p2));
    }
}

public class Point3D extends Point2D {
    protected double z;

    Point3D(double x, double y, double zCoord){
        super(x, y);
        this.z = zCoord;
    }

    public double getZ(){
        return z;
    }

    public static double distance(Point2D p1, Point2D p2){
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        double dz = p1.z - p2.z;
        return Math.sqrt(dx * dx + dy * dy + dz *dz);
    }

    public static void main(String[] args) {
        Point3D p1 = new Point3D(-4,2,5);
        Point3D p2 = new Point3D(1,3,-2);
        System.out.println("Distance between them is " + Point3D.distance(p1, p2));
    }
}
