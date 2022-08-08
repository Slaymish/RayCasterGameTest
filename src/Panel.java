import Ultil.Circle;
import Ultil.Point2d;
import Ultil.Ray;
import Ultil.Vector2d;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.*;

public class Panel extends JPanel implements ActionListener, KeyListener{
    private Player player;
    public static final int y = 400;
    public static final int x = 600;
    private Timer timer;

    Random rand = new Random();

    Set<Circle> circles = new HashSet<Circle>();


    public Panel(){
        // set the game board size
        setPreferredSize(new Dimension(x, y));
        setFocusable(true);
        requestFocus();
        // set the game board background color
        setBackground(new Color(0, 232, 232));

        // initialize the game state
        player = new Player(new Point2d(x/2,y/2),30);

        // this timer will call the actionPerformed() method every DELAY ms
        timer = new Timer(25, this);
        timer.start();
        addKeyListener(this);


        for (int i=0;i<10;i++){
            int yRand = rand.nextInt(y);
            int xRand = rand.nextInt(x);
            circles.add(new Circle(new Point2d(xRand,yRand)));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // when calling g.drawImage() we can use "this" for the ImageObserver
        // because Component implements the ImageObserver interface, and JPanel
        // extends from Component. So "this" Board instance, as a Component, can
        // react to imageUpdate() events triggered by g.drawImage()

        // draw our graphics.
        drawBackground(g);
        player.draw(g);

        Vector2d camVect = new Vector2d(1,0);
        Point2d nullPoint = new Point2d(-1,-1);
        // Calculate camera ray
        for (int i = 0; i<20;i++){
            Ray ray = new Ray(new Point2d(player.pos.x,player.pos.y), camVect);
            for (Circle circle:circles){
                circle.draw(g);
                Point2d p1 = circle.hit(ray);
                if (p1.x != -1 && p1.y != -1){
                    Circle.drawMini(g,circle.hit(ray), ray);
                }
            }
            camVect.rotate(2);
        }

        // this smooths out animations on some systems
        Toolkit.getDefaultToolkit().sync();

    }



    private void drawBackground(Graphics g) {
        // draw a checkered background
        g.setColor(new Color(214, 214, 214));
        g.fillRect(0,0,x,y);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // react to key down events
        player.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // this method is called by the timer every DELAY ms.
        // use this space to update the state of your game or animation
        // before the graphics are redrawn.

        // prevent the player from disappearing off the board
        player.tick();

        // calling repaint() will trigger paintComponent() to run again,
        // which will refresh/redraw the graphics.
        repaint();
    }
}
