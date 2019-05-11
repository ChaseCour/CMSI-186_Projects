import java.util.Arrays;
import java.util.ArrayList;



public class BrobIntTester{

  public static String printer;
  public static int leng;

/** This I made diffrent strings and brobints then I did the four diffrent
asserts that were meant to be done **/

  public static void main( String args[]) {
    String a = "435";
    String b = "356";
    String c = "43";
    String d = "7846";
    String e = "5784";
    String f = "39435";
    String g = "228092040";
    String h = "10";
    String i = "313";
    String j = "791";
    BrobInt one = new BrobInt(a);
    BrobInt two = new BrobInt(b);
    BrobInt three = new BrobInt(c);
    BrobInt four = new BrobInt(d);
    BrobInt five = new BrobInt(e);
    BrobInt six = new BrobInt(f);
    BrobInt seven = new BrobInt(g);
    BrobInt eight = new BrobInt(h);
    BrobInt nine = new BrobInt(i);
    BrobInt ten = new BrobInt(j);
    BrobInt eleven = new BrobInt("2");

    System.out.println(five.divide(eleven).toString());

    System.out.println(one.add(three).toString());
    System.out.println(one.add(four).toString());
    System.out.println(one.add(five).toString());
    System.out.println(one.add(six).toString());
    System.out.println(one.add(seven).toString());

    assert (one.add(two).equals(ten)) : "add doesn't work";
    assert (two.subtract(three).equals(nine)) : "subtract doesn't work";
//    System.out.println(one.divide(three).toString());
    assert (one.divide(three).equals(eight)) : "divide doesn't work";
//    System.out.println(five.multiply(six).toString());
    assert (five.multiply(six).equals(seven)) : "multipy doesn't work";

    }

}
