package Ultil;

public class Vector2d {
    public double x,y;

    public Vector2d(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2d(Vector2d p){
        this.x = p.x;
        this.y = p.y;
    }

    public Vector2d(Point2d p1, Point2d p2){
        this.x = p2.x - p1.x;
        this.y = p2.y - p1.y;
    }

    public Vector2d(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector2d add(double x, double y){
        return (new Vector2d(this.x+x,this.y+y));
    }

    public Vector2d add(Vector2d p){
        return (new Vector2d(this.x+p.x,this.y+p.y));
    }

    public Vector2d add(Point2d p){
        return (new Vector2d(this.x+p.x,this.y+p.y));
    }

    public double dot(Vector2d v){
        return ((this.x*v.x) + (this.y+v.y));
    }

    public Vector2d normalise(){
        double mag = Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));

        return new Vector2d(this.x/mag,this.y/mag);
    }

    public boolean isPerpendicular(Vector2d v){
        double dotted = this.dot(v);

        return (dotted == 0);

    }

    public void sub(int n){
        this.x -= n;
        this.y -= n;
    }

    public Vector2d scale(double n){
        return (new Vector2d(this.x*n,this.y*n));
    }

    public void rotate(double angle){
        // radian

        double x2 = Math.cos(this.x*angle)-Math.sin(this.y*angle);
        double y2 = Math.sin(this.x*angle)+Math.cos(this.y*angle);

        this.x = x2;
        this.y = y2;

    }

    public Vector2d sub(Vector2d v){
        return (new Vector2d(this.x-v.x,this.y-v.x));
    }


    public String toString(){
        return ("X: " + this.x + "  Y: " + this.y);
    }

    public double magnitude() {
        return (Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2)));
    }

}
