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
        Vector2d e = new Vector2d(ray.direction.x,ray.direction.y);
        e = e.normalise();
        Vector2d h = new Vector2d(center,ray.origin);
        double lf = e.dot(h);
        double s = Math.pow(radius,2)-(h.dot(h)) + Math.pow(lf,2);
        if (s < 0.0) { return new Point2d(-1,-1);}
        s = Math.sqrt(s);

        Point2d intercection = new Point2d(e.x*(lf-s),e.y*(lf-s));
        intercection = intercection.add(ray.origin);

        return new Point2d(intercection);

        /*
            v1 = c.p - r.o
            double d = v1.mag
            find angle between ray and v1
            m = tan(angle)*d
            if m < radius

         */
    }

    public static void drawMini(Graphics g, Point2d p,Ray ray){
        g.setColor(new Color(0,0,255));
        g.drawLine(ray.origin.x(),ray.origin.y(),p.x(),p.y());
        g.fillOval(p.x()-10,p.y()-10,10,10);
    }


}
