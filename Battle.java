/**
 * Write a description of class Battle here.
 *
 * @author Dean Thomas
 * @version 2015.11.20
 */
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

public class Battle
{
    private BattleViewer battleViewer;
    private ArrayList<Creature> sideOne;
    private ArrayList<Creature> sideTwo;
    private Random rand = new Random();
    private CreatureGenerator creatureGen = new CreatureGenerator(this);
    private Creature oneCurrent;
    private Creature twoCurrent;
    /**
     * Create a new battle
     */
    public Battle(int numCreatures)
    {
        sideOne = new ArrayList<Creature>();
        sideTwo = new ArrayList<Creature>();
        for(int i = 0; i < numCreatures; i++) {
            sideOne.add(creatureGen.generateCreature());
            sideTwo.add(creatureGen.generateCreature());
        }
        battleViewer = new BattleViewer(this);
    }

    public Creature getOneCurrent() {
        return oneCurrent;
    }

     public Creature getTwoCurrent() {
        return twoCurrent;
    }

     public String getOneRemainingText() {
        return Integer.toString(sideOne.size());
    }

     public String getTwoRemainingText() {
        return Integer.toString(sideTwo.size());
    }

    /**
     * Run one full turn
     */
    public void runOne()
    {
        //battleViewer.refresh();
        System.out.println("-------------------------------------");
        if(sideOne.size() == 0) {
            battleViewer.refresh();
            System.out.println("Side two wins!");
        }
        else if (sideTwo.size() == 0) {
            battleViewer.refresh();
            System.out.println("Side one wins!");
        }
        else {
            oneCurrent = sideOne.get(0);
            twoCurrent = sideTwo.get(0);
            battleViewer.refresh();

            System.out.println("Side One " + "(" + sideOne.size() + " creatures remaining):" );
            System.out.println(oneCurrent.getClass().getSimpleName() + " attacks the enemy "
                                + twoCurrent.getClass().getSimpleName() + ".");
            twoCurrent.takeDamage(oneCurrent.attack());
            System.out.println("          " + twoCurrent.getHealthText());
            battleViewer.refresh();

            System.out.println("Side Two " + "(" + sideTwo.size() + " creatures remaining):");
            if(!twoCurrent.isAlive() && sideTwo.size() > 1) {
                sideTwo.remove(twoCurrent);
                twoCurrent = sideTwo.get(0);
            }
            System.out.println(twoCurrent.getClass().getSimpleName() + " attacks the enemy "
                                + oneCurrent.getClass().getSimpleName() + ".");
            oneCurrent.takeDamage(twoCurrent.attack());
            System.out.println("          " + oneCurrent.getHealthText());
            battleViewer.refresh();

            if(!oneCurrent.isAlive()) {
                sideOne.remove(oneCurrent);
            }
            if(!twoCurrent.isAlive()) {
                sideTwo.remove(twoCurrent);
            }
        }

    }

        /**
     * Run one full turn
     */
    public void runOneWithSleep() throws InterruptedException
    {
        if(sideOne.size() == 0) {
            System.out.println("Side two wins!");
        }
        else if (sideTwo.size() == 0) {
            System.out.println("Side one wins!");
        }
        else {
            oneCurrent = sideOne.get(0);
            twoCurrent = sideTwo.get(0);
            twoCurrent.setRight(true);
            battleViewer.refresh();
            Thread.sleep(500);

            System.out.println("Side One: ");
            System.out.println(oneCurrent.getClass().getSimpleName() + " attacks the enemy "
                                + twoCurrent.getClass().getSimpleName() + ".");
            twoCurrent.takeDamage(oneCurrent.attack());
            System.out.println("          " + twoCurrent.getHealthText());
            battleViewer.refresh();
            Thread.sleep(500);

            System.out.println(" ");
            System.out.println("Side Two: ");
            if(!twoCurrent.isAlive() && sideTwo.size() > 1) {
                sideTwo.remove(twoCurrent);
                twoCurrent = sideTwo.get(0);
                twoCurrent.setRight(true);
            }
            System.out.println(twoCurrent.getClass().getSimpleName() + " attacks the enemy "
                                + oneCurrent.getClass().getSimpleName() + ".");
            oneCurrent.takeDamage(twoCurrent.attack());
            System.out.println("          " + oneCurrent.getHealthText());
            System.out.println("--------------------------------");
            battleViewer.refresh();
            Thread.sleep(500);

            if(!oneCurrent.isAlive()) {
                sideOne.remove(oneCurrent);
            }
            if(!twoCurrent.isAlive()) {
                sideTwo.remove(twoCurrent);
            }

        }

    }

    public void runToCompletionWithSleep() throws InterruptedException {
        while(sideOne.size() != 0 && sideTwo.size() != 0) {
            runOneWithSleep();
        }
        battleViewer.refresh();
        if(sideOne.size() == 0) {
            battleViewer.win("Side Two");
            System.out.println("--------------------------------");
            System.out.println("");
            System.out.println("Side two wins!");
            System.out.println("");
            System.out.println("--------------------------------");
        }
        else if (sideTwo.size() == 0) {
            battleViewer.win("Side One");
            System.out.println("--------------------------------");
            System.out.println("");
            System.out.println("Side one wins!");
            System.out.println("");
            System.out.println("--------------------------------");
        }
        
    }

    public void runToCompletion() {
        System.out.println("--------------------------------");
        while(sideOne.size() != 0 && sideTwo.size() != 0) {
            runOne();
        }

        if(sideOne.size() == 0) {
            System.out.println("--------------------------------");
            System.out.println("");
            System.out.println("Side two wins!");
            System.out.println("");
            System.out.println("--------------------------------");
        }
        else if (sideTwo.size() == 0) {
            System.out.println("--------------------------------");
            System.out.println("");
            System.out.println("Side one wins!");
            System.out.println("");
            System.out.println("--------------------------------");
        }
    }

    public void reset() {
        sideOne.clear();
        sideTwo.clear();
        for(int i = 0; i < 25; i++) {
            sideOne.add(creatureGen.generateCreature());
            sideTwo.add(creatureGen.generateCreature());
        }
    }

    public static void main(String[] args) {
        try {
            Object[] possibleValues = {5, 10, 25};
            Object selectedValue = JOptionPane.showInputDialog(null,
                                    "Choose number of combatants", "Creature War Setup",
                                    JOptionPane.INFORMATION_MESSAGE, null,
                                    possibleValues, possibleValues[0]);
            if((Integer)selectedValue != null) {
                Battle battle = new Battle((Integer)selectedValue);
                battle.runToCompletionWithSleep();
            }
            else{
                System.exit(1);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}