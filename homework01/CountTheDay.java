public class CountTheDay {

   public static void main ( String [] args ) {
     CalendarStuff compare = new CalendarStuff();
     long month1 = Long.parseLong(args[0]);
     long day1 = Long.parseLong(args[1]);
     long year1 = Long.parseLong(args[2]);
     long month2 = Long.parseLong(args[3]);
     long day2 = Long.parseLong(args[4]);
     long year2 = Long.parseLong(args[5]);
     System.out.println(compare.daysBetween(month1, day1, year1, month2, day2, year2));
   }
 }
