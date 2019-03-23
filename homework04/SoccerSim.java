import java.util.Arrays;
import java.util.ArrayList;

public class SoccerSim{

//vrible delaration
 public int poleSpotX = 3;
 public int poleSpotY = 3;
 public double timeScliceFinal;
 private static boolean running = true;
 public static int countBallMov;
 private static int[] hittersReport;

   public static void main( String args[] ) {
//makes the args into balls using temp vars and declares the bsics using other methods
     double temp1;
     double temp2;
     double temp3;
     double temp4;
     String[] names = new String[6];
     names[0] = "one";
     names[1] = "two";
     names[2] = "three";
     names[3] = "four";
     if(args.length % 4 == 1){
    Clock.declareTime(args[args.length - 1]);
    }
    else{
      Clock.declareTime("1.00");
    }
     Ball[] set = new Ball[args.length/4];
    for(int i = 0; i < args.length - 2; i += 4){
      temp1 = Ball.validateStarts(args[i]);
      temp2 = Ball.validateStarts(args[i + 1]);
      temp3 = Ball.validateVelocity(args[i + 2]);
      temp4 = Ball.validateVelocity(args[i + 3]);
      Ball temp = new Ball(temp1, temp2, temp3, temp4, names[i/4]);
      set[i/4] = temp;
    }
//while loop that chages time and position of balls until the boolean is chaged by hitting or stopping
    while(running){
      checkRunningHit(set);
      checkRunningStop(set);
      Clock.tick();
      for (int i = 0; i < set.length; i++){
        set[i].changeSpot(set[i]);
      }
    }
   }


//method to see if the balls stopped moving
public static boolean checkRunningStop(Ball[] ballsS){
   for (int i = 0; i < ballsS.length; i++){
     if(ballsS[i].getMoveX(ballsS[i]) == 0.00 && ballsS[i].getMoveY(ballsS[i]) == 0.00){
       countBallMov++;
     }
   }
   if(countBallMov == ballsS.length){
     running = false;
     System.out.println("No collisions on field!");
   }
   countBallMov = 0;
   return running;
 }

//prints out each collision based on the input array of balls
 public static void getCollision(Ball[] s){
   System.out.println("Ball " + s[0].getName(s[0]) + " hit ball "  + s[1].getName(s[1])
   + " at postion (" + s[0].getPosX(s[0]) + "," + s[0].getPosY(s[0]) + ") while moving at vector <" + s[0].getMoveX(s[0]) + "," + s[0].getMoveY(s[0])
    + "> at " + Clock.getTotalSeconds() + " seconds");
 }

//method to see if the ball collided
   public static boolean checkRunningHit(Ball[] ballsR){

     if (ballsR[1].didItHit(ballsR) != 0){
       hittersReport = ballsR[1].getHitters();
       for(int i = 0; i < hittersReport.length; i += 2){
         Ball[] temp = new Ball[2];
         temp[0] = ballsR[hittersReport[i]];
         temp[1] = ballsR[hittersReport[i + 1]];
         getCollision(temp);
     }
       running = false;
     }
     return running;
   }

}
