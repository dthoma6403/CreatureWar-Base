
/**
 * Write a description of class Human here.
 * 
 * @author Dean Thomas
 * @version 2015.11.11
 */

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Human extends Creature
{
    private int hp;
    private int strength;
    private final double SPECIAL_CHANCE = .1;
 
  Human() {
      super();
      hp = 30;
      strength = 18;
      
  }

  Human(int h, int s){
     hp = h;
     strength = s;
  }
  
   /**
     * take damage removes d hit points from the health
     *
     * @param damage - value to subtract from health
     */
    public void takeDamage(int damage){
        double roll = rand.nextDouble();
        super.takeDamage(damage);
        System.out.println("          Human took " + damage + " damage!");
        if(!this.isAlive() && roll < SPECIAL_CHANCE) {
            super.takeDamage(-damage);
            System.out.println("          Human got a second wind! It gains " + damage + " health.");
        }
    }

  public ImageIcon getImage() {
	  ImageIcon image;
	  if (super.isRight()) {
        image = new ImageIcon("rsz_human.jpg");
        return image;
	  }
	  else {
		image = new ImageIcon("human.jpg");
	  }
	  return image;
  }
}