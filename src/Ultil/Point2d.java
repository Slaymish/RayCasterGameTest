package Ultil;

public class Point2d {
    public double x,y;

    public Point2d(){
        this.x = 0;
        this.y = 0;
    }

    public Point2d(Point2d p){
        this.x = p.x;
        this.y = p.y;
    }

    public Point2d(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point2d add(double x, double y){
        return (new Point2d(this.x+x,this.y+y));
    }

    public Point2d add(Point2d p){
        return (new Point2d(this.x+p.x,this.y+p.y));
    }

    public void translate(int x, int y){
        this.x += x;
        this.y += y;
    }

    public int x(){
        return (int) this.x;
    }
    public int y(){
        return (int) this.y;
    }

    public Point2d add(Vector2d vel){
        return new Point2d(this.x+vel.x,this.y+vel.y);
    }

    public void addKeep(Vector2d vel){
        this.x += vel.x;
        this.y += vel.y;
    }




    public String toString(){
        return ("X: " + this.x + "  Y: " + this.y);
    }


}
