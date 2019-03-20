public class SoccerSim{

 public static int poleSpotX = 3;
 public static int poleSpotY = 3;
 public static double timeScliceFinal;
 public static String[] names = new String["one", "two", "three", "four", "five", "six"];

   public static void main( String args[] ) {
     if(args.length % 4 != 0){
     timeScliceFinal = declareTime(args[args.length]);
    }
    for(int i = 0; i < args.length - 2; i += 4){
      double temp1 = validateStarts(args[i]);
      double temp2 = validateStarts(args[i + 1]);
      double temp3 = Ball.validateVelocity(args[i + 2]);
      double temp4 = Ball.validateVelocity(args[i + 3]);
      Ball names[i] = new Ball(temp1, temp2, temp3, temp4);
    }
   }

}
