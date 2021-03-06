public class Die {



  /**

   * private instance data

   */

   private int sides;

   private int pips;

   private int sideUp;

   private final int MINIMUM_SIDES = 4;



   // public constructor:

  /**

   * constructor

   * @param nSides int value containing the number of sides to build on THIS Die

   * @throws       IllegalArgumentException

   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"

   */

   public Die( int nSides ) {
     if (nSides >= MINIMUM_SIDES){
       this.sides = nSides;
     int[] sides = new int[nSides];
       for (int i = 0; i < nSides; i++){
         sides[i] = i + 1;
       }
     }
     this.sideUp = this.roll();
   }



  /**

   * Roll THIS die and return the result

   * @return  integer value of the result of the roll, randomly selected

   */

   public int roll() {
     int roll = 1 + (int)(Math.random() * this.sides);
     sideUp = roll;
      return roll;

   }



  /**

   * Get the value of THIS die to return to the caller; note that the way

   *  the count is determined is left as a design decision to the programmer

   *  For example, what about a four-sided die - which face is considered its

   *  "value"?

   * @return the pip count of THIS die instance

   */

   public int getValue() {

      return this.sideUp;

   }


   public int getSides() {

      return this.sides;

   }



  /**

   * @param  int  the number of sides to set/reset for this Die instance

   * @return      The new number of sides, in case anyone is looking

   * @throws      IllegalArgumentException

   */

   public void setSides( int sides ) {

   }



  /**

   * Public Instance method that returns a String representation of THIS die instance

   * @return String representation of this Die

   */

   public String toString() {
     String s1 = Integer.toString(sideUp);
      return s1;

   }



  /**

   * Class-wide method that returns a String representation of THIS die instance

   * @return String representation of this Die

   */

   public static String toString( Die d ) {
     String s1 = d.toString();
      return s1;

   }



  /**

   * A little test main to check things out

   */

   public static void main( String[] args ) {

      System.out.println( "Hello world from the Die class..." );

   }



}
