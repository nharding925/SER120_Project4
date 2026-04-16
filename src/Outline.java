
import java.awt.Color;
import java.awt.Graphics;

public class Outline implements Component {
    private Ball ball;

    @Override
    public void attach(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval((int) (ball.getX() - ball.getRadius()), 
                  (int) (ball.getY() - ball.getRadius()), 
                  (int) (ball.getRadius() * 2),
                  (int) (ball.getRadius() * 2));
    }
}