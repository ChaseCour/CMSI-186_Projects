public class Clock {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
   private static boolean running = true;
  /**
   *  Constructor goes here
   */
        private static double timeInc;
        double movement = DEFAULT_TIME_SLICE_IN_SECONDS;

   //     if (args[1]  double){
   //       timeInc = args[1];
   //     }
   //     else{
   //       timeInc = 60.0;
   //     }
        double bigHand = 0.0;
        double littleHand = 0.0;
   public Clock() {
     double angle;
     }

     public static void declareTime( String args[] ) {
        if( 2 == args.length ) {
           timeInc = validateTimeSliceArg(args[1]);
        }
        else{
          timeInc = 60.0;
        };
  }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick() {
     bigHand += timeInc;
     littleHand += timeInc;
     littleHand = littleHand % 3600.0;
     if(bigHand > 43200.0){
       running = false;
     }
      return timeInc;
   }


  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public static double validateAngleArg( String argValue ) throws NumberFormatException {
     double angle = Double.parseDouble(argValue);
      return angle;
   }

   public static boolean checkRunning( ){
      return running;
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public static double validateTimeSliceArg( String argValue ) {
     double timeSlice = Double.parseDouble(argValue);
      return timeSlice;
   }


  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */

   public double getHourHandAngle() {
      return bigHand * HOUR_HAND_DEGREES_PER_SECOND;
   }
  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
      return littleHand * MINUTE_HAND_DEGREES_PER_SECOND;
   }


  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
       return getMinuteHandAngle() - getHourHandAngle();
   }


  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
    return bigHand;
   }


  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
      return "MinuteHand angle is: " + getMinuteHandAngle() + "  HourHand angle is: " + getHourHandAngle() + "    MinuteHand time is: " + littleHand + "   HourHand time is: " + bigHand;
   }


  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {
      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

   }

}
