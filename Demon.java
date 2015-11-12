
/**
 * Write a description of class Demon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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