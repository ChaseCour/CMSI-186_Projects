import java.util.Arrays;
import java.util.ArrayList;



public class Collatz{

  public static String printer;
  public static int leng;
  public static final BrobInt ONE = new BrobInt("1");
  public static final BrobInt TWO = new BrobInt("2");
  public static final BrobInt THREE = new BrobInt("3");


  public static void main( String args[]) {
    BrobInt real = new BrobInt(args[0]);
    while (real.biggerThan(TWO)){
      if (real.getElement(real.getLength() - 1) % 2 == 0){
//        System.out.println("we live");
        real = real.divide(TWO);
        System.out.println(real.toString());
        leng+=1;
      }
      else{
//        System.out.println("we live    2");
        real = real.multiply(THREE);
        real = real.add(ONE);
        System.out.println(real.toString());
        leng+=1;
      }

    }
    System.out.println("There were " + leng + " number of steps");
    }

}
