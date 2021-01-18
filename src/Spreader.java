import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Spreader implements ActionListener {
    public int x, y;
    public int spread;
    public float speed;
    public int minAngle, maxAngle;
    public final ArrayList<Particle> particle = new ArrayList<>();
    public final ParticlePhysicManager physicManager = new ParticlePhysicManager(particle);
    Random random = new Random();
    float[] spreadAngle = new float[maxAngle - minAngle + 1];

    public Spreader(int x, int y, int spread, float speed, int minAngle, int maxAngle) {
        this.x = x;
        this.y = y;
        this.spread = spread;
        this.speed = speed;
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
    }

    {
        for (int i = 0; i < spreadAngle.length; i++) {
            spreadAngle[i] = (float) Math.toRadians(i + minAngle);
        }
    }

    public void spread() {
        for (int i = 0; i < spread; i++) {
            int index = random.nextInt(spreadAngle.length);
            particle.add(new Particle(x, y, 6, 6, Color.RED, spreadAngle[index], speed));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        spread();
        physicManager.setPhysic();
        for (Particle particle : particle) {
            particle.handleMovement();
        }
    }

    public void paint(Graphics g) {
        for (Particle particle : particle) {
            particle.paint(g);
        }
    }
}
