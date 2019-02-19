public class DiceSet {



  /**

   * private instance data

   */

   private int count;

   private int sides;

   private Die[] ds = null;



   // public constructor:

  /**

   * constructor

   * @param  count int value containing total dice count

   * @param  sides int value containing the number of pips on each die

   * @throws IllegalArgumentException if one or both arguments don't make sense

   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"

   */

   public DiceSet( int count, int sides ) {
     this.count = count;
     this.sides = sides;
      ds = new Die[count];
      for (int i = 0; i < count; i++){
        Die temp = new Die(sides);
        ds[i] = temp;
      }
   }



  /**

   * @return the sum of all the dice values in the set

   */

   public int sum() {
    int total = 0;
     for (int i = 0; i < count; i++){
       total += ds[i].getValue();
     }
      return total;

   }



  /**

   * Randomly rolls all of the dice in this set

   *  NOTE: you will need to use one of the "toString()" methods to obtain

   *  the values of the dice in the set

   */

   public void roll() {
     for (int i = 0; i < count; i++){
       ds[i].roll();
     }
   }



  /**

   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'

   * @param  dieIndex int of which die to roll

   * @return the integer value of the newly rolled die

   * @trhows IllegalArgumentException if the index is out of range

   */

   public int rollIndividual( int dieIndex ) {
      return ds[dieIndex].roll();

   }



  /**

   * Gets the value of the die in this set indexed by 'dieIndex'

   * @param  dieIndex int of which die to roll

   * @trhows IllegalArgumentException if the index is out of range

   */

   public int getIndividual( int dieIndex ) {

      return ds[dieIndex].getValue();

   }



  /**

   * @return Public Instance method that returns a String representation of the DiceSet instance

   */

   public String toString() {
     String[] listy = new String[count];
     String listV = "";
     for (int i = 0; i < count; i++){
       listy[i] = ds[i].toString();
       listV += listy[i];
       if (i + 1 != count){
         listV += ", ";
       }
     }
      String dieCount = "There are " + count + " dice in the set.";
      String sideCount = "There are " + sides + " sides on each.";
      String valueList = "The list count goes:";

      return dieCount + sideCount + valueList + listV;

   }



  /**

   * @return Class-wide version of the preceding instance method

   */

   public static String toString( DiceSet ds ) {

      return ds.toString();

   }



  /**

   * @return  tru iff this set is identical to the set passed as an argument

   */

   public boolean isIdentical( DiceSet ds ) {
     int tester = 0;
     if (count != ds.ds.length){
       return false;
     }
     for (int i = 0; i < count; i++){
       if (this.ds[i].getValue() == ds.ds[i].getValue()){
         tester++;
       }
     }
     if (tester == count){
      return true;
    }
return false;
   }

  /**

   * A little test main to check things out

   */

   public static void main( String[] args ) {

            System.out.println( "Hello world from the DieSet class..." );

   }



}
