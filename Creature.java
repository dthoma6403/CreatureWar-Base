import java.util.Random;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.image.BufferedImage;
/**
 * Write a description of class Creature here.
 * 
 * @author Dean Thomas 
 * @version 2015.11.11
 */
public  abstract class Creature
{
   public static Random rand = new Random();
   private int health;  // when health drops to 0 or below, creature is dead
   private int hp;
   private int strength;
   private boolean isRight = false;

  /**
    * default constructor with base stats of 12 health and strength
    */
   Creature(){
       hp = 10;
       strength = 10;
   }

   /**
    * Creature receives h and s to indicate max health and strength
    *
    * @param h intial hit points
    * @param s strength - used to determine damage
    */
   Creature(int h, int s) {
       hp = h;
       strength = s;
    }

   /**
    * attack causes up to 1-strength point(s) of damage
    *
    * @return damage caused by attack
    */
   public int attack(){
       return rand.nextInt(strength) + 1;
    }

    /**
     * take damage removes d hit points from the health
     *
     * @param damage - value to subtract from health
     */
    public void takeDamage(int damage){
        hp = hp - damage;
        

    }
 /**
     * @ return true if health > 0, else false
     */
    public boolean isAlive() {

        return hp > 0;

    }

    public String getHealthText() {
        if(hp > 0) {
            return hp + " health remaining.";
        }
        else {
            return "Creature is dead!";
        }
    }

    public void setRight(boolean state) {
		isRight = state;
	}

	public boolean isRight() {
		return isRight;
	}

    public abstract ImageIcon getImage();


}
