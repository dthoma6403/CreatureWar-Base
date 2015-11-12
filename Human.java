
/**
 * Write a description of class Human here.
 * 
 * @author Dean Thomas
 * @version 2015.11.11
 */

public class Human extends Creature
{
  private final double SPECIAL_CHANCE = .1;

  Human() {
      super();
  }

  Human(int str, int hp){
      super(hp, str);
  }
}