
import java.util.Random;

public class Moving implements Component {
    private Ball ball;
    private double vx, vy;

    @Override
    public void attach(Ball ball) {
        this.ball = ball;

        Random rand = new Random();

        double direction = rand.nextDouble(0, Math.TAU);
        double speed = rand.nextDouble(0.5, 5.0);
        vx = speed * Math.cos(direction);
        vy = speed * -Math.sin(direction);
    }

    @Override
    public void update() {
        ball.setPosition(ball.getX() + vx, ball.getY() + vy);

        if (ball.getX() < ball.getRadius() || ball.getX() + ball.getRadius() > ball.getActions().getWidth()) {
            vx = -vx;
        }
        if (ball.getY() < ball.getRadius() || ball.getY() + ball.getRadius() > ball.getActions().getHeight()) {
            vy = -vy;
        }
    }
}