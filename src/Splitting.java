
import java.awt.event.MouseEvent;

public class Splitting implements Component {
    private Ball ball;

    @Override
    public void attach(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (ball.getRadius() > 20) {
            createChild();
            createChild();
        }
        ball.getActions().removeFromScene(ball);
    }

    private void createChild() {
        Ball child = new Ball(ball.getActions(), new Splitting(), new Moving());
        child.setColor(ball.getColor());
        child.setRadius(ball.getRadius() / 2);
        child.setPosition(ball.getX(), ball.getY());
        ball.getActions().addToScene(child);
    }
}