import Ultil.Point2d;
import Ultil.Vector2d;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    public int size; // circular player
    public int rad;
    public Point2d pos;
    public Vector2d vel;

    public int speed = 5;

    public Player(Point2d p, int size){
        pos = new Point2d(p);
        this.size = size;
        this.rad = size/2;
        this.vel = new Vector2d();
    }

    public void draw(Graphics g){
        // draw the player to screen
        g.setColor(new Color(255,0,0));
        g.fillOval(pos.x()-rad,pos.y()-rad,size,size);


    }


    public boolean isOn(Point2d p){
        return (Math.sqrt(Math.pow(p.x-pos.x,2)+Math.pow(p.y-pos.y,2)) <= size);
    }

    public void keyPressed(KeyEvent e){
        // every keyboard get has a certain code. get the value of that code from the
        // keyboard event so that we can compare it to KeyEvent constants
        int key = e.getKeyCode();

        // depending on which arrow key was pressed, we're going to move the player by
        // one whole tile for this input
        if (key == KeyEvent.VK_UP) {
            vel.y -= speed;
        }
        if (key == KeyEvent.VK_RIGHT) {
            vel.x += speed;
        }
        if (key == KeyEvent.VK_DOWN) {
            vel.y += speed;
        }
        if (key == KeyEvent.VK_LEFT) {
            vel.x -= speed;
        }
    }

    public void tick() {
        // this gets called once every tick, before the repainting process happens.
        // so we can do anything needed in here to update the state of the player.

        // prevent the player from moving off the edge of the board sideways
        if (pos.x < 0) {
            pos.x = 0;
        }
        else if (pos.x >= Panel.x) {
            pos.x = Panel.x-1;
        }
        // prevent the player from moving off the edge of the board vertically
        if (pos.y < 0) {
            pos.y = 1;
        }
        else if (pos.y >= Panel.y) {
            pos.y = Panel.y -1;
        }


        vel = vel.scale(0.9);
        pos.addKeep(vel);
    }

}
