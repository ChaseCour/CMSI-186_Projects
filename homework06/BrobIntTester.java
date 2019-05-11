import java.util.Arrays;
import java.util.ArrayList;



public class BrobIntTester{

  private int tempInt;
  private String tempString;
  private String a;
  private String b;
  private static String c;
  private String d;
  private char charA;
  private int[] brob;
  private String toStringA;
  private boolean carry;
  public static final BrobInt ONE = new BrobInt("1");
  public static final BrobInt ZERO = new BrobInt("0");
  public static final BrobInt TEN = new BrobInt("10");

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
    if (carry){
      tempString = 1 + "" + tempString;
    }
      tempBrob = new BrobInt(tempString);
      tempBrob = tempBrob.zeroLessBrob();
      return tempBrob;
    }

    public BrobInt subtract(BrobInt z){
      BrobInt tempBrob;
      int passed = z.getLength();
      int had = this.getLength();
      int i = passed;
      int j = had;
      tempString = "";
      carry = false;
      if (this.biggerThan(z)){
      while (i > 0 || j > 0){

        if (i > 0 && j > 0){
          if (carry){
            tempInt = -1;
          }
          else{
            tempInt = 0;
          }
          carry = false;
          tempInt += this.brob[j - 1] - z.brob[i - 1];

          if (tempInt < 0){
            tempInt += 10;
            carry = true;
          }
            tempString = tempInt + "" + tempString;
          i--;
          j--;
        }


        if (i > 0 && j <= 0){
          j--;
          i--;
        }

        if (j > 0 && i <= 0){
          if (carry){
            carry = false;
            tempInt = this.brob[j - 1] - 1;
            if (tempInt == -1){
              carry = true;
              tempInt = 9;
            }
          tempString = tempInt + "" + tempString;
          i--;
          j--;
          }
          else{
            tempInt = this.brob[j - 1];
            tempString = tempInt + "" + tempString;
            i--;
            j--;
          }
        }}}
        else{
          while (i > 0 || j > 0){

            if (i > 0 && j > 0){
              if (carry){
                tempInt = -1;
              }
              else{
                tempInt = 0;
              }
              carry = false;
              tempInt += z.brob[i - 1] - this.brob[j - 1];

              if (tempInt < 0){
                tempInt += 10;
                carry = true;
              }
                tempString = tempInt + "" + tempString;
              i--;
              j--;
            }


            if (i > 0 && j <= 0){
              if (carry){
                carry = false;
                tempInt = z.brob[i - 1] - 1;
                if (tempInt == -1){
                  carry = true;
                  tempInt = 9;
                }
              tempString = tempInt + "" + tempString;
              i--;
              j--;
              }
              else{
                tempInt = z.brob[i - 1];
                tempString = tempInt + "" + tempString;
                i--;
                j--;
              }
            }

            if (j > 0 && i <= 0){
              j--;
              i--;
            }}
        }
      tempBrob = new BrobInt(tempString);
      tempBrob = tempBrob.zeroLessBrob();
      return tempBrob;
    }

    public BrobInt divide(BrobInt z){
      BrobInt tempBrob = this;
      BrobInt tempBrober;
      int passed = z.getLength();
      int had = this.getLength();
      int i = passed;
      int j = had;
      tempString = "0";
      BrobInt total;
      BrobInt times = new BrobInt(tempString);
      BrobInt one = new BrobInt("1");
      while (tempBrob.biggerThan(z)){
//        System.out.println(tempBrob.toString());
//        System.out.println("we live");
        times = times.add(one);
        tempBrober = tempBrob.subtract(z);
//        System.out.println(tempBrober.toString());
        tempBrober = tempBrober.zeroLessBrob();
        tempBrob = tempBrober;
//        System.out.println(times.toString());
      }
      times.subtract(one);
      return times;
    }

    public BrobInt multiply(BrobInt z){
      BrobInt tempBrob;
      BrobInt tempBrober;
      int quickSum;
      String toPass;
      int passed = z.getLength();
      int had = this.getLength();
      int zeros;
      int i = passed;
      int j = had;
      tempString = "0";
      BrobInt total;
      BrobInt sum = new BrobInt(tempString);
      for (int k = 0; k < had; k++){
        for (int m = 0; m < passed; m++){
//          System.out.println(k + "     " + m);
          quickSum = this.brob[had - 1 - k] * z.brob[passed - 1 - m];
          zeros = k + m;
          toPass = quickSum + "";
//          System.out.println(zeros);
          tempBrober = new BrobInt(toPass);
          tempBrob = tempBrober.addZeros(zeros);
//          System.out.println(tempBrob.toString());
          sum = sum.add(tempBrob);
//          System.out.println(sum.toString());
        }
      }
      return sum;
    }


    }
