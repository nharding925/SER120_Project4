import java.awt.Color;

public class Shiny implements Component {
    private Ball ball;

    @Override
    public void attach(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void update() {
        Color c = ball.getColor();
        float[] hsb = Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
        hsb[0] = (hsb[0] + 0.005f) % 1f;
        ball.setColor(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    }
}