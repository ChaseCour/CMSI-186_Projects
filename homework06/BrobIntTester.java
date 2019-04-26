import java.util.Arrays;
import java.util.ArrayList;

public class BrobIntTester{

  public static String printer;
  public static int leng;

  public static void main( String args[]) {
    BrobInt one = new BrobInt(args[0]);
    BrobInt two = new BrobInt(args[1]);

    leng = one.getLength();
//    System.out.println(printer);
    printer = two.toString();

    BrobInt three = one.add(two);
    printer = three.toString();
    System.out.println(printer);
//    System.out.println(one.biggerThan(two));
    BrobInt four = one.subtract(two);
    printer = four.toString();
    System.out.println(printer);
    System.out.println(one.biggerThan(two));
    }

}
