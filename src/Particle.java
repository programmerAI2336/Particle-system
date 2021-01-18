import java.awt.*;

public class Particle {
    public float x, y;
    public float xSpeed, ySpeed;
    public final int width, length;
    public final Color color;

    public Particle(float x, float y, int width, int length, Color color, float angle, float speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.color = color;
        spread(angle, speed);
    }

    public void spread(float angle, float speed) {
        xSpeed = (float) (Math.cos(angle) * speed);
        ySpeed = (float) (Math.sin(angle) * speed);
    }

    public void handleMovement() {
        x += xSpeed;
        y += ySpeed;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect((int) x, (int) y, width, length);
    }
}
