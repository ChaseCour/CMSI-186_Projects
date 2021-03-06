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
        static double movement = DEFAULT_TIME_SLICE_IN_SECONDS;
        static double bigHand = 0.0;
        static double littleHand = 0.0;


   public Clock() {
     double angle;
     }

     public static void declareTime( String args ) {
           timeInc = validateTimeSliceArg(args);
  }

  /**
   Tick is meant to change the big and little hands to what they need to be at.
   It also changes running if the hour hand begins to go past 12 on the clock.
   LittleHand is the second hand and the hour hand is bigHand. Little hand
   resets every hour.
   */
   public static void tick() {
     bigHand += timeInc;
   }

  /**
   Checks to make sure that the time slice is legal and in range
   */
   public static double validateTimeSliceArg( String argValue ) {
      double timeSlice = Double.parseDouble(argValue);
      if (timeSlice < 180.1){
        return timeSlice;
      }
      return 1.00;
   }

  /**
   bigHand never resets so it is the full second count.
   */
   public static double getTotalSeconds() {
    return bigHand;
   }


  /**
   String giving the angle and second count of each
   */
   public String toString() {
      return "MinuteHand time is: " + littleHand + "   HourHand time is: " + bigHand;
   }


  /**
   Not really needed
   */
   public static void main( String args[] ) {
      System.out.println("we live");

   }

}
