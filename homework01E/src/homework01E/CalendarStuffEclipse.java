package homework01E;
public class CalendarStuffEclipse {



  /**

   * A listing of the days of the week, assigning numbers; Note that the week arbitrarily starts on Sunday

   */

   private static final int SUNDAY    = 0;

   private static final int MONDAY    = SUNDAY    + 1;

   private static final int TUESDAY   = MONDAY    + 1;

   private static final int WEDNESDAY = TUESDAY   + 1;

   private static final int THURSDAY  = WEDNESDAY + 1;

   private static final int FRIDAY    = THURSDAY  + 1;

   private static final int SATURDAY  = FRIDAY    + 1;



  /**

   * A listing of the months of the year, assigning numbers; I suppose these could be ENUMs instead, but whatever

   */

   private static final int JANUARY    = 0;

   private static final int FEBRUARY   = JANUARY   + 1;

   private static final int MARCH      = FEBRUARY  + 1;

   private static final int APRIL      = MARCH     + 1;

   private static final int MAY        = APRIL     + 1;

   private static final int JUNE       = MAY       + 1;

   private static final int JULY       = JUNE      + 1;

   private static final int AUGUST     = JULY      + 1;

   private static final int SEPTEMBER  = AUGUST    + 1;

   private static final int OCTOBER    = SEPTEMBER + 1;

   private static final int NOVEMBER   = OCTOBER   + 1;

   private static final int DECEMBER   = NOVEMBER  + 1;



  /**

   * An array containing the number of days in each month

   *  NOTE: this excludes leap years, so those will be handled as special cases

   */

   private static int[]    days        = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };



  /**

   * The constructor for the class

   */

   public CalendarStuffEclipse() {

      System.out.println( "Constructor called..." );

   }



  /**

   * A method to determine if the year argument is a leap year or not<br />

   *  Leap years are every four years, except for even-hundred years, except for every 400

   * @param    year  long containing four-digit year

   * @return         boolean which is true if the parameter is a leap year

   */

   public static boolean isLeapYear( long year ) {
    if(year % 4 == 0){
      if (year % 100 == 0) {
        if(year % 400 == 0){
          return true;
      }
    }
    if (year % 100 != 0){
      return true;
    }
  }
      return false;
   }



  /**

   * A method to calculate the days in a month, including leap years

   * @param    month long containing month number, starting with "1" for "January"

   * @param    year  long containing four-digit year; required to handle Feb 29th

   * @return         long containing number of days in referenced month of the year

   * notes: remember that the month variable is used as an indix, and so must

   *         be decremented to make the appropriate index value

   */

   public static long daysInMonth( int month, int year ) {
     boolean extra = isLeapYear(year);
     if (extra && month == 2){
       return days[month - 1] + 1;
     }
      return days[month - 1];

   }



  /**

   * A method to determine if two dates are exactly equal

   * @param    month1 long    containing month number, starting with "1" for "January"

   * @param    day1   long    containing day number

   * @param    year1  long    containing four-digit year

   * @param    month2 long    containing month number, starting with "1" for "January"

   * @param    day2   long    containing day number

   * @param    year2  long    containing four-digit year

   * @return          boolean which is true if the two dates are exactly the same

   */

   public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {

     if (year1 == year2){
       if (month1 == month2){

         if (day1 == day2){
           return true;
         }
     }
    }
      return false;

   }



  /**

   * A method to compare the ordering of two dates

   * @param    month1 long   containing month number, starting with "1" for "January"

   * @param    day1   long   containing day number

   * @param    year1  long   containing four-digit year

   * @param    month2 long   containing month number, starting with "1" for "January"

   * @param    day2   long   containing day number

   * @param    year2  long   containing four-digit year

   * @return          int    -1/0/+1 if first date is less than/equal to/greater than second

   */

   public static int compareDate( int month1, int day1, int year1, int month2, int day2, int year2 ) {
     if (year1 < year2){
       return -1;
     }
     if (year1 > year2){
       return 1;
     }
     if (year1 == year2){
       if (month1 < month2){
         return -1;
       }
         if (month1 > month2){
           return 1;
       }
       if (month1 == month2){
         if (day1 < day2){
           return -1;
         }
           if (day1 > day2){
             return 1;
         }
         if (day1 == day2){
           return 0;
         }
     }
   }
   return 80085;
}


  /**

   * A method to return whether a date is a valid date

   * @param    month long    containing month number, starting with "1" for "January"

   * @param    day   long    containing day number

   * @param    year  long    containing four-digit year

   * @return         boolean which is true if the date is valid

   * notes: remember that the month and day variables are used as indices, and so must

   *         be decremented to make the appropriate index value

   */

   public static boolean isValidDate( int month, long day, long year ) {
     if (isLeapYear(year)){
       if(month == 2){
         if(day == 29){
           return true;
         }
       }
     }
     if (month < 13 && month > 0){
       if (days[month] >= day){
         if (year > 0) {
           return true;
         }
       }
     }
      return false;

   }



  /**

   * A method to return a string version of the month name

   * @param    month long   containing month number, starting with "1" for "January"

   * @return         String containing the string value of the month (no spaces)

   */

   public static String toMonthString( int month ) {

      switch( month - 1 ) {

         default: throw new IllegalArgumentException( "Illegal month value given to 'toMonthString()'." );

      }

   }



  /**

   * A method to return a string version of the day of the week name

   * @param    day int    containing day number, starting with "1" for "Sunday"

   * @return       String containing the string value of the day (no spaces)

   */

   public static String toDayOfWeekString( int day ) {

      switch( day - 1 ) {

         default       : throw new IllegalArgumentException( "Illegal day value given to 'toDayOfWeekString()'." );

      }

   }



  /**

   * A method to return a count of the total number of days between two valid dates

   * @param    month1 long   containing month number, starting with "1" for "January"

   * @param    day1   long   containing day number

   * @param    year1  long   containing four-digit year

   * @param    month2 long   containing month number, starting with "1" for "January"

   * @param    day2   long   containing day number

   * @param    year2  long   containing four-digit year

   * @return          long   count of total number of days

   */

   public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {

  //    long dayCount = 0;
    //  int day = day1 - day2 + 1;
      //int month = month1 - month2 + 1;
      //int year = year1 - year2 + 1;
        //return month "/" day "/" year;
return 8;

   }



}
