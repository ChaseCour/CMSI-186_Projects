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
   *  I declared timeInc and running to check that the clock was still in
   bounds of where it should be. TimeInc is what I use to tic and decide
   how far to move. The declareTime class is to set the time sclice to what it
   needs to be.
   */
        private static double timeInc;
        double movement = DEFAULT_TIME_SLICE_IN_SECONDS;
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
   Tick is meant to change the big and little hands to what they need to be at.
   It also changes running if the hour hand begins to go past 12 on the clock.
   LittleHand is the second hand and the hour hand is bigHand. Little hand
   resets every hour.
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
   Just validates and gives the double not the string
   */
   public static double validateAngleArg( String argValue ) throws NumberFormatException {
     double angle = Double.parseDouble(argValue);
      return angle;
   }

   /**
    Used to check if the clock is still in range because running is false if
    the time is too high.
    */

   public static boolean checkRunning( ){
      return running;
   }

  /**
   Checks to make sure that the time slice is legal and in range
   */
   public static double validateTimeSliceArg( String argValue ) {
      double timeSlice = Double.parseDouble(argValue);
      if (timeSlice < 180.1){
        return timeSlice;
      }
      return 60.0;
   }


  /**
   bigHand is the sconds and the value given is degrees per second.
   */

   public double getHourHandAngle() {
      return bigHand * HOUR_HAND_DEGREES_PER_SECOND;
   }
  /**
   What second mark it is at times the degree per second.
   */
   public double getMinuteHandAngle() {
      return littleHand * MINUTE_HAND_DEGREES_PER_SECOND;
   }


  /**
   Hour minus minute to get angle
   */
   public double getHandAngle() {
       return getMinuteHandAngle() - getHourHandAngle();
   }


  /**
   bigHand never resets so it is the full second count.
   */
   public double getTotalSeconds() {
    return bigHand;
   }


  /**
   String giving the angle and second count of each
   */
   public String toString() {
      return "MinuteHand angle is: " + getMinuteHandAngle() + "  HourHand angle is: " + getHourHandAngle() + "    MinuteHand time is: " + littleHand + "   HourHand time is: " + bigHand;
   }


  /**
   Not really needed
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
