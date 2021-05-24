package package1;

public class Skeleton extends Creature implements Attackeable{
    String name;
    int health;
    int strength;
    int agility;
    boolean isAlive = true;
    int experience;
    int gold;
    String[] title = {"Overseer", "Pirate", "Master", "Battlemaster", "Knuckler", "Spearman", "Goon",
            "Hoodlum", "Trasher", "Torturer", "Tormentor", "Strangler"};

    public Skeleton() {
        this.name = "Skeleton " + title[(int)Math.floor(Math.random() * title.length)];
        this.health = 500 + (int)(Math.random()*49);
        this.strength = 45 + (int)(Math.random()*9);
        this.agility = 45 + (int)(Math.random()*9);
        this.experience = 100 + (int)(Math.random()*25);
        this.gold = 10 + (int)(Math.random()*15);
    }

    @Override
    public <T extends Creature> void attack (T creature) {
        int hitchance = 1 + (int)(Math.random()*19);
        if (hitchance <= 2){
            System.out.println(name + " missed " + creature.name + "! No damage inflicted. " + creature.name + " HP is " + creature.health);
        } else if (hitchance >= 19){
            int damage =(strength/2 + (int)(Math.random()*agility))*2;
            creature.health -= damage;
            System.out.println(name + " does critical hit to " + creature.name + " for " + damage + " damage!! " + creature.name + " HP is " + creature.health);
        } else {
            int damage =(strength/2 + (int)(Math.random()*agility));
            creature.health -= damage;
            System.out.println(name + " does a hit to " + creature.name + " for " + damage + " damage. " + creature.name + " HP is " + creature.health);
        }

        if (creature.health <= 0){
            creature.die();
        }
    }

    @Override
    public String toString() {
        return "Name: " + name
                + ". HP: " + health + ", STR/AGI: "
                + strength + "/" + agility;
    }

    public void die(){
        isAlive = false;
        System.out.println(name + " died");
    }
}
