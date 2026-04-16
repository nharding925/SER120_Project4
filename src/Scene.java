import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Scene {
    private ArrayList<Ball> balls, add, remove;
    private Actions actions;
    private int width, height;

    public Scene(int width, int height) {
        this.width = width;
        this.height = height;

        balls = new ArrayList<Ball>();
        add = new ArrayList<Ball>();
        remove = new ArrayList<Ball>();
        actions = new Actions(this, add, remove);
    }

    public Actions getActions() {
        return actions;
    }

    public void update() {
        for (Ball b : balls) {
            b.update();
        }
        for (Ball b : add) {
            if (!balls.contains(b)) {
                balls.add(b);
            }
        }
        add.clear();
        for (Ball b : remove) {
            balls.remove(b);
        }
        remove.clear();
    }

    public void draw(Graphics g) {
        for (Ball b : balls) {
            b.draw(g);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void registerMouseListener(JPanel dp) {
        MouseAdapter ma = new MouseAdapter() {
            Ball dragging = null;

            @Override
            public void mousePressed(MouseEvent e) {
                int mx = e.getX();
                int my = e.getY();
                // whichever ball is draw in front should get the mouse event, so we will
                // traverse the list in reverse draw order
                for (int i = balls.size() - 1; i >= 0; --i) {
                    Ball b = balls.get(i);
                    if (b.contains(mx, my)) {
                        dragging = b;
                        dragging.mousePressed(e);
                        // only one ball can interact with the mouse at a time, so we stop the loop here
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (dragging != null) {
                    dragging.mouseReleased(e);
                    dragging = null;
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging != null) {
                    dragging.mouseDragged(e);
                }
            }
        };
        dp.addMouseListener(ma);
        dp.addMouseMotionListener(ma);
    }

    // The Actions class exists to give balls access to a limited set of the
    // scene's methods. This prevents balls from calling methods they shouldn't
    // such as the scene's update method.
    public static class Actions {
        private Scene scene;
        private ArrayList<Ball> add, remove;

        public Actions(Scene scene, ArrayList<Ball> add, ArrayList<Ball> remove) {
            this.scene = scene;
            this.add = add;
            this.remove = remove;
        }

        public void addToScene(Ball ball) {
            add.add(ball);
        }

        public void removeFromScene(Ball ball) {
            remove.add(ball);
        }

        public int getWidth() {
            return scene.getWidth();
        }

        public int getHeight() {
            return scene.getHeight();
        }
    }
}
