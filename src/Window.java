import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        Test test = new Test();
        add(test);
        setTitle("Particle system.");
        setVisible(true);
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        new Window();
    }
}
