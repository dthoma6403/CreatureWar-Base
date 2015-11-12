
/**
 * Write a description of class Human here.
 * 
 * @author Dean Thomas
 * @version 2015.11.11
 */

public class Human extends Creature
{
    private int hp;
    private int strength;
 
  Human() {
      super();
      hp = 30;
      strength = 18;
      
  }

  Human(int h, int s){
     hp = h;
     strength = s;
  }
}