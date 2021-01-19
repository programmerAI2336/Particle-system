import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JPanel implements ActionListener {
    private final Spreader spreader = new Spreader(200, 100, 50, 2, 0, 360);

    public Test() {
        Timer timer = new Timer(4, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        spreader.actionPerformed(e);
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.BLACK);
        spreader.paint(g);
    }
}
