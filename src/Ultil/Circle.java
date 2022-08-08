package Ultil;

import java.awt.*;

public class Circle {
    public Point2d center;
    public int diameter;
    public static Integer radius = 35;
    public Color col;

    public Circle(Point2d c){
        this.center = new Point2d(c);
        this.diameter = radius*2;
        this.col = new Color(0,255,0);
    }

    public void draw(Graphics g){
        g.setColor(col);
        g.fillOval(center.x()-radius, center.y()-radius, diameter,diameter);
    }

    public Point2d hit(Ray ray){
        Vector2d U = new Vector2d(ray.origin,this.center);
        Vector2d U1 = ray.direction.scale(U.dot(ray.direction));
        Vector2d U2 = U.sub(U1);
        double d = U2.magnitude();
        double m = Math.sqrt((Math.pow((radius.doubleValue()),2) - Math.pow(d,2)));
        Point2d p1 = ray.origin.add(U1).add(ray.direction.scale(m));
        return p1;
    }

    public static void drawMini(Graphics g, Point2d p,Ray ray){
        g.setColor(new Color(0,0,255));
        g.drawLine(ray.origin.x(),ray.origin.y(),p.x(),p.y());
        g.fillOval(p.x()-radius,p.y()-radius,radius,radius);
    }


}
