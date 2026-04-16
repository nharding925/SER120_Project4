import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

// This version of Ball cannot be extended. We must use composition instead of
// inheritance to customize its behavior.
public final class Ball {
    private ArrayList<Component> components;
    private Scene.Actions actions;
    private double x, y, radius;
    private Color color;

    // The ... syntax means you can include any number of component arguments in
    // this constructor.
    public Ball(Scene.Actions actions, Component... components) {
        this.actions = actions;

        Random rand = new Random();

        radius = rand.nextDouble(10, 50);
        x = rand.nextDouble(radius, actions.getWidth() - radius);
        y = rand.nextDouble(radius, actions.getHeight() - radius);
        color = new Color(rand.nextInt(0, 0x1000000));

        this.components = new ArrayList<>();
        for (Component c : components) {
            this.components.add(c);
            c.attach(this);
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (x - radius), (int) (y - radius), (int) (radius * 2), (int) (radius * 2));
    }

    public boolean contains(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        // squaring the radius is cheaper than taking a square root
        return radius * radius > dx * dx + dy * dy;
    }

    public void update() {
        for (Component c : components) {
            c.update();
        }
    }

    public void mousePressed(MouseEvent e) {
        for (Component c : components) {
            c.mousePressed(e);
        }
    }

    public void mouseReleased(MouseEvent e) {
        for (Component c : components) {
            c.mouseReleased(e);
        }
    }

    public void mouseDragged(MouseEvent e) {
        for (Component c : components) {
            c.mouseDragged(e);
        }
    }

    // the rest is just getters and setters, nothing interesting

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        // "this." isn't necessary, but it makes it clearer what's going on
        setPosition(x, this.y);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        // "this." isn't necessary, but it makes it clearer what's going on
        setPosition(this.x, y);
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Scene.Actions getActions() {
        return actions;
    }
}
