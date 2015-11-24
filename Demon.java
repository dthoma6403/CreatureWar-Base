
/**
 * Write a description of class Demon here.
 * 
 * @author Dean Thomas
 * @version 2015.11.11
 */

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public abstract class Demon extends Creature 
{
  
  Demon() {
      super();
  }
  
  Demon(int str, int hp){
      super(hp, str);
  }
   public int attack(){
       //ask creature for my attack damage
       int tempAttackDamage;
       tempAttackDamage = super.attack();
       
       //roll the dice (use creature's rand)
       //if less than 5%, damage = damage + 50
       if (rand.nextInt(20) == 0) {
           tempAttackDamage +=50;
           System.out.println("          FOOM!!!!");
       }
       
       return tempAttackDamage;  
  }
  
  public abstract ImageIcon getImage();
}