import java.awt.Graphics;
import java.awt.event.MouseEvent;

public interface Component {

    // You must override the attach method. This is how your component will gain
    // access to the ball instance it is a component of. I recommend using this
    // method for initializing your component instead of its constructor. Some
    // of the components can't be initialized until they have a reference to
    // ball, which limits what you can do in the constructor.

    void attach(Ball ball);

    // These default methods have an implementation that does nothing. You don't
    // need to override them unless your component needs to use them.

    default void update() {
    }

    default void mousePressed(MouseEvent e) {
    }

    default void mouseReleased(MouseEvent e) {
    }

    default void mouseDragged(MouseEvent e) {
    }

    default void draw(Graphics g) {
    }
}
