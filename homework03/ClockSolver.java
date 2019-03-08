import java.util.ArrayList;


public class ClockSolver {

  /**
   *  Class field definintions go here
   */
   private final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
   private final double DEFAULT_TIME_SLICE_SECONDS = 60.0;
   private static final double EPSILON_VALUE              = 0.1;      // small value for double-precision comparisons
   public static boolean running = true;

  /**
   *  Constructor
   *  This just calls the superclass constructor, which is "Object"
   */
   public ClockSolver() {
      super();
    }


  /**
   *  Method to handle all the input arguments from the command line
   *   this sets up the variables for the simulation
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
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  @param  args  String array of the arguments from the command line
   *                args[0] is the angle for which we are looking
   *                args[1] is the time slice; this is optional and defaults to 60 seconds
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
