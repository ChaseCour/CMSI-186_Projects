import java.util.ArrayList;


public class ClockSolver {

  /**
   Added a not needed varible
   */
   private final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
   private final double DEFAULT_TIME_SLICE_SECONDS = 60.0;
   private static final double EPSILON_VALUE              = 0.1;      // small value for double-precision comparisons
   public static boolean running = true;

  /**
   Didn't touch
   */
   public ClockSolver() {
      super();
    }


  /**
   Didn't touch
   */
   public void handleInitialArguments( String args[] ) {
     // args[0] specifies the angle for which you are looking
     //  your simulation will find all the angles in the 12-hour day at which those angles occur
     // args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
     // you may want to consider using args[2] for an "angle window"

      System.out.println( ) ;
      if( 0 == args.length ) {
         System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Usage: java ClockSolver <angle> [timeSlice]\n" +
                             "   Please try again..........." );
         System.exit( 1 );
      }
      Clock clock = new Clock();
   }


  /**
   This makes a clock and uses a while loop to tick it until it is done. Every
   tick the angle is checked and added to an array list if it is the right
   angle. Then uses a for loop to print the array list and list each time that
   it hits the angle.
   */
   public static void main( String args[] ) {
      ClockSolver cse = new ClockSolver();
      Clock clock    = new Clock();
      int many = 0;
      clock.declareTime(args);
      ArrayList<Double> times = new ArrayList<>();
      cse.handleInitialArguments( args );
      while( clock.checkRunning() ) {
        if(Math.abs(clock.validateAngleArg(args[0])- clock.getHandAngle()) < EPSILON_VALUE){
          times.add(clock.getTotalSeconds());
          many++;
        }
         clock.tick();
      }
      System.out.println("The clock hit the angle " + times.size() + " times!");
      for(int i = 0; i < many; i++){
        if ((int)((times.get(i) % 3600) / 60) < 10){
          System.out.println((int)(times.get(i) / 3600) + ":0" + (int)((times.get(i) % 3600) / 60));
        }
        else{
      System.out.println((int)(times.get(i) / 3600) + ":" + (int)((times.get(i) % 3600) / 60));
    }}
      System.exit( 0 );
   }
}
