package package1;

public interface Attackeable {
    <T extends Creature> void attack(T creature);
}
