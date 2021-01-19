import java.awt.*;

public class Particle {
    public float x, y;
    public float xSpeed, ySpeed;
    public final int width, length;
    public final Color color;
    public boolean appear;

    public Particle(float x, float y, int width, int length, Color color, float angle, float speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.color = color;
        appear = true;
        spread(angle, speed);
    }

    public void spread(float angle, float speed) {
        xSpeed = (float) (Math.cos(angle) * speed);
        ySpeed = (float) (Math.sin(angle) * speed);
    }

    private void handleAppearance() {
        if (!appear) {
            xSpeed = 0;
            ySpeed = 0;
            x = 0;
            y = 0;
        }
    }

    public void handleMovement() {
        x += xSpeed;
        y += ySpeed;
        handleAppearance();
    }

    public void paint(Graphics g) {
        if (appear) {
            g.setColor(color);
            g.fillOval((int) x, (int) y, width, length);
        }
    }
}
