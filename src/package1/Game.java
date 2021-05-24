package package1;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    public void start() throws InterruptedException {
        Attackeable hero = createHero();
        goToDungeon(hero);
    }

    public Attackeable createHero(){
        System.out.println("Chose your hero!");
        System.out.println("1. Press ONE to pick Warrior");
        System.out.println("2. Press TWO to pick Mage");
        System.out.println("1. Press ZERO to close game");
        Scanner scanner = new Scanner(System.in);
        Creature hero = null;
        switch (scanner.nextInt()) {
            case 1:
                hero = new Warrior();
                System.out.println("Warrior " + hero.name + " is your hero!");
                break;
            case 2:
                hero = new Mage();
                System.out.println("Mage " + hero.name + " is your hero!");
                break;
            case 0:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + scanner);
        }
        return (Attackeable) hero;
    }

    public void goToDungeon(Attackeable hero) throws InterruptedException {
        System.out.println("Now chose where to fight!");
        System.out.println("1. Press ONE to pick Goblin Cave");
        System.out.println("2. Press TWO to pick Graveyard");
        System.out.println("1. Press ZERO to close game");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                fightGoblin(hero);
                break;
            case 2:
                fightSkeleton(hero);
                break;
            case 0:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + scanner);
        }
    }

    public <T extends Attackeable> void fightGoblin(T creature) throws InterruptedException {
        Goblin goblin = new Goblin();
        System.out.println("New monster appeared! "+ goblin.toString());
        while (goblin.isAlive){
            creature.attack(goblin);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public <T extends Attackeable> void fightSkeleton(T creature) throws InterruptedException {
        Skeleton skeleton = new Skeleton();
        System.out.println("New monster appeared! "+ skeleton.toString());
        while (skeleton.isAlive){
            creature.attack(skeleton);
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
