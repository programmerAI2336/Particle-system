import java.util.ArrayList;

public class ParticlePhysicManager {
    private final ArrayList<Particle> particle;

    public ParticlePhysicManager(ArrayList<Particle> particle) {
        this.particle = particle;
    }

    private void setInteraction() {
        for (Particle particle : particle) {
            if (particle.y >= 600) {
                particle.y = 600;
                particle.ySpeed = 0;
            }
        }
    }

    private void setGravity() {
        float gravity = 0.05f;
        for (Particle particle : particle) {
            particle.ySpeed += gravity;
        }
    }

    private void setFriction() {
        float friction = 0.005f;
        for (Particle particle : particle) {
            if (Math.abs(particle.xSpeed) <= friction) {
                particle.xSpeed = 0;
            }
            if (particle.xSpeed < -friction) {
                particle.xSpeed += friction;
            }
            if (particle.xSpeed > friction) {
                particle.xSpeed -= friction;
            }
        }
    }

    public void setPhysic() {
        setGravity();
        setFriction();
        setInteraction();
    }
}
