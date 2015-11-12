
/**
 * Write a description of class Demon here.
 * 
 * @author Dean Thomas
 * @version 2015.11.11
 */

public abstract class Demon extends Creature 
{
  
  Demon() {
      super();
  }
  
  Demon(int str, int hp){
      super(hp, str);
  }
}