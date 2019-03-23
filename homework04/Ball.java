import java.util.Arrays;
import java.util.ArrayList;

public class Ball{
// Declareing all my varibles
   public static double timeSlice = 1.00;
   private static double velo;
   private static final double friction = .99;
   private static double start;
   public static final double radius =.3708333333333333333333333333333333333333333333333333333333333;
   private double posY;
   private double posX;
   private double moveX;
   private double moveY;
   private String name;
   private ArrayList<Integer> hitters = new ArrayList<Integer>();

//construstor for a ball with x and y start and initial movements
   public Ball(double startX, double startY, double moveXP, double moveYP, String tempName) {
     posY = startY;
     posX = startX;
     moveX = moveXP;
     moveY = moveYP;
     name = tempName;
}

//methods to retrive varibles
  public static double getPosX(Ball b){
    return b.posX;
  }
  public static double getPosY(Ball b){
    return b.posY;
  }
  public static double getMoveY(Ball b){
    return b.moveY;
  }
  public static double getMoveX(Ball b){
    return b.moveX;
  }
  public static String getName(Ball b){
    return b.name;
  }

//method to change the spot and velocity of each ball by 1% of its current speed
  public void changeSpot (Ball b){
    b.posY += b.moveY;
    b.posX += b.moveX;
    b.moveX = b.moveX * friction;
    b.moveY = b.moveY * friction;
    if (b.moveX < 1 && b.moveX > -1){
      b.moveX = 0;
    }
    if (b.moveY < 1 && b.moveY > -1){
      b.moveY = 0;
    }
  }

//sets the time incriment
  public static double setTimeSlice (double temp){
    if (temp > 0){
      return temp;
    }
    return timeSlice;
  }

//validates the starts and makes double
  public static double validateStarts (String temp){
    start = Double.parseDouble(temp);
    return start;
  }

//validates velocity and makes double
  public static double validateVelocity (String temp){
    velo = Double.parseDouble(temp);
    return velo;
  }

//method to make an array of the index for balls that hit
  public int[] getHitters(){
    int[] hittersArray = new int[hitters.size()];
    for (int i = 0; i < hittersArray.length; i++){
      hittersArray[i] = hitters.get(i);
    }
    return hittersArray;
  }

//runs through all the balls in the list to see if they hit
  public int didItHit (Ball[] setBall){
    int hits = 0;
    for (int i = 0; i < setBall.length; i++){
     for (int j = 0; j < setBall.length; j++){
         if(i == j){
          hits--;
        }
        if (Math.abs(setBall[i].getPosX(setBall[i]) - setBall[j].getPosX(setBall[j])) < .89){
          if ((Math.abs(setBall[i].getPosY(setBall[i]) - setBall[j].getPosY(setBall[j])) < .89)){
            hits++;
            if (i != j){
              hitters.add(i);
              hitters.add(j);
            }
          }
        }
      }
  }
  for (int i = 0; i < setBall.length; i++){
    if (Math.abs(setBall[i].getPosX(setBall[i]) - 500) < .89){
      if ((Math.abs(setBall[i].getPosY(setBall[i]) - 500) < .89)){
        System.out.println("Ball " + setBall[i].getName(setBall[i]) + " hit ball a pole at postion (" + setBall[i].getPosX(setBall[i]) + "," + setBall[i].getPosY(setBall[i]) + ") while moving at vector <" + setBall[i].getMoveX(setBall[i]) + "," + setBall[i].getMoveY(setBall[i])
         + "> at " + Clock.getTotalSeconds() + " seconds");
         hits++;
      }}
  }
//   System.out.println(hits);
    return hits;
   //public static void main( String args[] ) {
//     System.out.println("we live");

   //}
}
}
