
/**
 * Write a description of class Elf here.
 * 
 * @author Dean Thomas
 * @version 2015.11.11
 */

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Elf extends Creature
{

    private final double CHANCE_TO_DODGE = .25;
    
  Elf() {
      super();
  }

  Elf(int str, int hp){
      super(hp, str);
  }
  
  public int attack(){
       //ask creature for my attack damage
       int tempAttackDamage;
       tempAttackDamage = super.attack();

       //roll the dice (use creature's rand)
       //if less than 10%, damage = damage * 2
       if (rand.nextInt(10) == 0) {
           tempAttackDamage *= 2;
           System.out.println("          SHAZAM!!!!");
           //tempAttackDamage = tempAttackDamage * 2;
           //tempAttackDamage = tempAttackDamage + tempAttackDamage;
       }

       return tempAttackDamage;
    }

  /**
     * take damage removes d hit points from the health
     *
     * @param damage - value to subtract from health
     */
    public void takeDamage(int damage){
        double roll = rand.nextDouble();
        if(roll >= CHANCE_TO_DODGE) {
            super.takeDamage(damage);
            System.out.println("          Elf took " + damage + " damage!");
        }
        else {
            super.takeDamage(0);
            System.out.println("          Elf dodged the attack!");
        }
    }

    public ImageIcon getImage() {
  		  ImageIcon image;
  	  if (super.isRight()) {
          image = new ImageIcon("rsz_elf.jpg");
          return image;
	  }
	  else {
          image = new ImageIcon("elf.jpg");
	  }
	  return image;
  }
}