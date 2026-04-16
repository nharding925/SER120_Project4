
import java.awt.event.MouseEvent;

public class Draggable implements Component {
    private Ball ball;
    private double mousePrevX, mousePrevY;

    @Override
    public void attach(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePrevX = e.getX();
        mousePrevY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        double dx = e.getX() - mousePrevX;
        double dy = e.getY() - mousePrevY;

        ball.setPosition(ball.getX() + dx, ball.getY() + dy);

        mousePrevX = e.getX();
        mousePrevY = e.getY();
    }
}