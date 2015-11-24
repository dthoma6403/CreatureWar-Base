
/**
 * Write a description of class Balrog here.
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

public class Balrog extends Demon
{
    public Balrog(int str, int hp) {
        super(str, hp);
    }
    
     public int attack(){
       //ask creature for my attack damage
       int tempAttackDamage;
       tempAttackDamage = super.attack();
       tempAttackDamage += super.attack();

       return tempAttackDamage;
    }

    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println("          Balrog took " + damage + " damage!");
    }

    public ImageIcon getImage() {
	    ImageIcon image;
	    if (super.isRight()) {
	    	 image = new ImageIcon("rsz_balrog.jpg");
	    	 return image;
	    }
	    else {
	    	image = new ImageIcon("balrog.jpg");
	    }
	    return image;
    }
}
