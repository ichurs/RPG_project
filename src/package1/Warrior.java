package package1;


public class Warrior extends Creature implements Attackeable{

    final String name = "Conan";
    int health = 1000;
    int strength = 50;
    int agility = 25;
    boolean isAlive = true;
    int experience = 0;
    int gold = 0;
    int potions = 0;

    @Override
    public void die(){
        isAlive = false;
        System.out.println(name + " died");
    };

    @Override
    public <T extends Creature> void attack (T creature) {
        int hitchance = 1 + (int)(Math.random()*19);
        if (hitchance <= 5){
            System.out.println(name + " missed " + creature.name + "! No damage inflicted. Monster HP is " + creature.health);
        } else if (hitchance >= 16){
            int damage =(strength + (int)(Math.random()*agility))*2;
            creature.health -= damage;
            System.out.println(name + " does critical hit to " + creature.name + " for " + damage + " damage!! Monster HP is " + creature.health);
        } else {
            int damage =(strength + (int)(Math.random()*agility));
            creature.health -= damage;
            System.out.println(name + " does a hit to " + creature.name + " for " + damage + " damage. Monster HP is " + creature.health);
        }

        if (creature.health <= 0){
            creature.die();
            loot(creature);
        }
    }

    public <T extends Creature> void loot (T creature){
        experience += creature.experience;
        System.out.println(name + " gets " + creature.experience + " experience! Current EXP: " + experience);
        gold += creature.gold;
        System.out.println(name + " gets " + creature.gold + " gold! Current gold: " + gold);
    }

    public void usePotion(){
        health = 1000;
        potions -= 1;
    }

}
