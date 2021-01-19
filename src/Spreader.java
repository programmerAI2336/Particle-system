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
    private final Random random = new Random();
    private int spreadTimer;
    private float[] spreadAngle;
    private float[] spreadSpeed;

    public Spreader(int x, int y, int spread, float speed, int minAngle, int maxAngle) {
        this.x = x;
        this.y = y;
        this.spread = spread;
        this.speed = speed;
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
        initSpreadAngle();
        initSpreadSpeed();
    }

    private void initSpreadAngle() {
        spreadAngle = new float[maxAngle - minAngle + 1];
        for (int i = 0; i < spreadAngle.length; i++) {
            spreadAngle[i] = (float) Math.toRadians(i + minAngle);
        }
    }

    private void initSpreadSpeed() {
        spreadSpeed = new float[(int) (speed * 10 + 1)];
        for (int i = 0; i < spreadSpeed.length; i++) {
            spreadSpeed[i] = (float) (0.1 * i);
        }
    }

    public void spread() {
        if (spreadTimer % 60 == 0) {
            for (int i = 0; i < spread; i++) {
                int spreadIndex = random.nextInt(spreadAngle.length);
                int speedIndex = random.nextInt(spreadSpeed.length);
                particle.add(new Particle(x, y, 4, 4, Color.RED, spreadAngle[spreadIndex], spreadSpeed[speedIndex]));
            }
        }
    }

    private void countTime() {
        spreadTimer++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        countTime();
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
