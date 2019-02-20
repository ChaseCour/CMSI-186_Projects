import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class HighRoll {
   private static int highScore = 0;
   private static BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

   public static void main( String args[] ) {
     boolean itsGoing = true;
     System.out.print("This game is called high roll and the objective is to roll the set of dice and get the highest value.");
     System.out.print(" You will have unlimited chances to roll one or all of the dice.");
     System.out.println();
     System.out.println();
     System.out.println("The commands will be as follows:");
     System.out.println("Roll all the dice = R");
     System.out.println("Roll a single die = S");
     System.out.println("Calculate score = C");
     System.out.println("Save as high score = H");
     System.out.println("Display current set = D");
     System.out.println("Display high score = DH");
     System.out.println("Quit the program = Q");
     System.out.println("Redisplay the instructions = I");
     System.out.println();
     DiceSet ds = null;
     String line = null;
     int whichDie;
     try {
     System.out.println("How many die do you want?");
     int dies = Integer.parseInt(input.readLine());
     System.out.println("How many sides do you want?");
     int sides = Integer.parseInt(input.readLine());
     ds = new DiceSet(dies, sides);
   }
   catch (Exception ioe)
   {
     System.out.println("Didn't work");
   }
     while (itsGoing){
     try {
       line = input.readLine();
       if (line != null){
         if (line.equals("R")){
       ds.roll();
     }
        if (line.equals("C")){
          System.out.println(ds.sum());
     }
        if (line.equals("H")){
          if(highScore < ds.sum()){
            highScore = ds.sum();
          }

     }
        if (line.equals("D")){
       System.out.println(ds.toString());
     }
     if (line.equals("DH")){
    System.out.println("The high score is: " + highScore);
  }
        if (line.equals("Q")){
          itsGoing = false;
      }
        if (line.equals("S")){
          System.out.println("Which one?");
          whichDie = Integer.parseInt(input.readLine());
          ds.rollIndividual(whichDie - 1);
             }
        if (line.equals("I")){
               System.out.println("This game is called high roll and the objective is to roll the set of dice and get the highest value");
               System.out.println("You will have three chances to roll one or all of the dice");
               System.out.println("The commands will be as follows:");
               System.out.println("Roll all the dice = R");
               System.out.println("To roll certian dice, put what die number they are after the letter R (ex. R, 4, 7, 8)");
               System.out.println("Calculate score = C");
               System.out.println("Save as high score = S");
               System.out.println("Display high score = D");
               System.out.println("Quit the program = Q");
               System.out.println("Redisplay the instructions = I");
               System.out.println();
                  }
}

     }
     catch (Exception ioe){
       System.out.println("Didn't work");
     }
   }
   }
}
