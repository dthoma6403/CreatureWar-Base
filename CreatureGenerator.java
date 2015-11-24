/**
 * Write a description of class CreatureGenerator here.
 * 
 * @author Dean Thomas 
 * @version 2015.11.20
 */
import java.util.Random;
import java.util.ArrayList;

public class CreatureGenerator
{
    private Random rand = new Random();
    private ArrayList<String> creatureTypes= new ArrayList<String>();
    private Battle battle;
    
    /**
     * Constructor for objects of class CreatureGenerator
     */
    public CreatureGenerator(Battle battle)
    {
        this.battle = battle;
        creatureTypes.add("Human");
        creatureTypes.add("Elf");
        creatureTypes.add("Balrog");
        creatureTypes.add("CyberDemon");
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @return     the Creature created
     */
    public Creature generateCreature()
    {
        Creature created;
        int index = rand.nextInt(creatureTypes.size());
        String type = creatureTypes.get(index);
        switch (type) {
            case "Human":         created = new Human(rand.nextInt((16 - 10) + 1) + 10, rand.nextInt((16 - 10) + 1) + 10);
                                  break;
                           
            case "Elf":           created = new Elf(rand.nextInt((14 - 8) + 1) + 8, rand.nextInt((14 - 8) + 1) + 8);
                                  break;
                           
            case "Balrog":        created = new Balrog(rand.nextInt((24 - 18) + 1) + 18, rand.nextInt((24 - 18) + 1) + 18);
                                  break;
                           
            case "CyberDemon":    created = new CyberDemon(rand.nextInt((20 - 16) + 1) + 16, rand.nextInt((20 - 16) + 1) + 16);
                                  break;
                                 
            default:              created = null;
                                  break;
        }
        return created;
    }
}
