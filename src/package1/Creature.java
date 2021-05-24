package package1;

abstract class Creature {
    String name;
    int health;
    int strength;
    int agility;
    int experience;
    int gold;
    boolean isAlive;

    protected abstract void die();
}
