
public class Shrink implements Component {
    private Ball ball;
    private double shrinkRate = 0.2;

    @Override
    public void attach(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void update() {
        double currentRadius = ball.getRadius();
        
        // Reduce the radius
        currentRadius -= shrinkRate;
        
        // If the radius becomes too small, remove the ball from the scene
        if (currentRadius <= 0) {
            ball.getActions().removeFromScene(ball);
        } else {
            ball.setRadius(currentRadius);
        }
    }
}