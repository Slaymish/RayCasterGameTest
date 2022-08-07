package Ultil;

public class Ray {
    public Point2d origin;
    public Vector2d direction;

    public Ray(Point2d o, Vector2d v){
        this.origin = new Point2d(o);
        this.direction = new Vector2d(v);
    }


}
