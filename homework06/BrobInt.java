import java.util.Arrays;
import java.util.ArrayList;

public class BrobInt{

//declares the diffrent strings and ints I need
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

//parses the long to a string and calls the other method
  public static BrobInt valueOf( long value ){
    c = String.valueOf(value);
    BrobInt temp = new BrobInt(c);
    return temp;
  }

//constructor by parsing and assigning
  public BrobInt( String value ) {
    a = value;
    brob = new int[a.length()];
    for (int i = a.length(); i > 0; i--){
      charA = a.charAt(i - 1);
       b = "" + charA;
      brob[i - 1] = Integer.parseInt(b);
    }
    }

    public int getElement(int i){
      return this.brob[i];
    }

//checks all slots to see if they equal
    public boolean equals (BrobInt z){
      if (this.brob.length != z.brob.length){
        return false;
      }
      for (int i = 0; i < this.brob.length; i++){
        if(this.brob[i] != z.brob[i])
          return false;
      }
      return true;
    }

//tries to go based on length but then compares numbers if the same
    public int compareTo( BrobInt z ){
      int i = this.brob.length;
      if(this.equals(z)){
        return 0;
      }
      if (this.getRealLength() > z.getRealLength()){
        return 1;
      }
      if (this.getRealLength() < z.getRealLength()){
        return -1;
      }
      while (i > 0){
        if (this.brob[this.brob.length - i] > z.brob[this.brob.length - i]){
          return 1;
        }
        if (this.brob[this.brob.length - i] < z.brob[this.brob.length - i]){
          return -1;
        }
        i--;
      }
      return 0;
    }

//uses divide code but passes out the last little BrobInt not the count
    public BrobInt remainder( BrobInt z ){
      if(this.biggerThan(z)){
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
  //      System.out.println(times.toString());
      }
      times.subtract(one);
      return tempBrob;
    }
    else{
    BrobInt tempBrob = z;
    BrobInt tempBrober;
    int passed = this.getLength();
    int had = z.getLength();
    int i = passed;
    int j = had;
    tempString = "0";
    BrobInt total;
    BrobInt times = new BrobInt(tempString);
    BrobInt one = new BrobInt("1");
    while (tempBrob.biggerThan(this)){
//        System.out.println(tempBrob.toString());
//        System.out.println("we live");
      times = times.add(one);
      tempBrober = tempBrob.subtract(this);
//        System.out.println(tempBrober.toString());
      tempBrober = tempBrober.zeroLessBrob();
      tempBrob = tempBrober;
//        System.out.println(times.toString());
    }
    times.subtract(one);
//    System.out.println(times.toString());
    return tempBrob;
  }
    }

//Adds zeros for the multiply function
    public BrobInt addZeros (int zeros){
      String temp = this.toString();
      for (int i = 0; i < zeros; i++){
        temp = temp + "0";
      }
      BrobInt passer = new BrobInt(temp);
      return passer;
    }

//takes away the zeros from brobbs that were subtacted
    public BrobInt zeroLessBrob(){
      String temp = "";
      int i = 0;
      int intTemp;
      while (this.brob[i] == 0 && i < this.brob.length - 1){
        i++;
      }
      while (i < this.brob.length){
        intTemp = this.brob[i];
        temp = temp + intTemp;
        i++;
      }
      if (temp.equals("")){
        BrobInt pass = new BrobInt("0");
        return pass;
      }
      BrobInt pass = new BrobInt(temp);
      return pass;
    }

//gets length based on when numbers start and not size of brob
    public int getRealLength(){
      int longer = this.getLength();
      int check = this.brob[0];
      int i = 0;
      while (check == 0 && i < this.brob.length - 1){
        i++;
        longer--;
        check = this.brob[i];
        System.out.println(check);
        System.out.println(longer);
      }
      return longer;
    }

//returns string
    public String getString (){
      return a;
    }

//length of the array
    public int getLength (){
      return this.brob.length;
    }

//just a repeat
    public String toString (){
      return a;
    }


//used this before I had to set up a function to do the -1/0/1 thing
    public boolean biggerThan (BrobInt z){
//      System.out.println("we live");
      int i = this.brob.length;
      if (this.getRealLength() > z.getRealLength()){
        return true;
      }
      if (this.getRealLength() < z.getRealLength()){
        return false;
      }
      while (i > 0){
        if (this.brob[this.brob.length - i] > z.brob[this.brob.length - i]){
          return true;
        }
        if (this.brob[this.brob.length - i] < z.brob[this.brob.length - i]){
          return false;
        }
        i--;
      }
      return true;
    }

/** Add just starts at the end of each array and based on the size and how many
  times it has been added it enters into a given little section of the code
  **/
    public BrobInt add(BrobInt z){
      BrobInt first = this.zeroLessBrob();
      BrobInt second = z.zeroLessBrob();
      if (first.toString().equals("0")){
        return second;
      }
      if (second.toString().equals("0")){
        return first;
      }
      BrobInt tempBrob;
      int passed = z.getLength();
      int had = this.getLength();
      int i = passed;
      int j = had;;
      tempString = "";
      carry = false;
      while (i > -1 || j > -1 || carry){
        if (i < 0 && j < 0 && carry){
          tempString = 1 + "" + tempString;
          carry = false;
        }
        if (i == 0 && j == 0){
          if (carry){
            tempString = 1 + "" + tempString;
          }
          carry = false;
        }
        if (i == 0 && j < 0){
          if (carry){
            tempInt = this.brob[j - 1] + 1;
            carry = false;
            if (tempInt > 9){
              tempInt = 0;
              carry = true;
              tempString = "0" + tempString;
            }
            else{
            tempString = tempInt + "" + tempString;
          }
          }
        }
        if (i < 0 && j == 0){
          if (carry){
            tempInt = 1;
            carry = false;
            if (tempInt > 9){
              tempInt = 0;
              carry = true;
              tempString = "0" + tempString;
            }
            else{
            tempString = 1 + "" + tempString;
          }
          }
        }
        if (i > 0 && j == 0){
          if (carry){
            tempInt = 1;
          }
          else{
            tempInt = 0;
          }
          carry = false;
          tempInt += z.brob[i - 1];
          if (tempInt > 9){
            tempInt -= 10;
            carry = true;
          }
            tempString = tempInt + "" + tempString;
        }
        if (i == 0 && j > 0){
          if (carry){
            tempInt = 1;
          }
          else{
            tempInt = 0;
          }
          carry = false;
          tempInt += this.brob[j - 1];
          if (tempInt > 9){
            tempInt -= 10;
            carry = true;
          }
            tempString = tempInt + "" + tempString;
        }
        if (i > 0 && j > 0){
        if (carry){
          tempInt = 1;
        }
        else{
          tempInt = 0;
        }
        carry = false;
        tempInt += z.brob[i - 1] + this.brob[j - 1];

        if (tempInt > 9){
          tempInt -= 10;
          carry = true;
        }
          tempString = tempInt + "" + tempString;
      }

      if (i < 0 && j > 0){
  //      System.out.println("we live   j");
//        System.out.println(j);
        if (carry){
          tempInt = this.brob[j - 1] + 1;
          carry = false;
          if (tempInt > 9){
            tempInt = 0;
            carry = true;
            tempString = "0" + tempString;
          }
          else{
          tempString = tempInt + "" + tempString;
        }
        }
        else{
          tempInt = this.brob[j - 1];
          tempString = tempInt + "" + tempString;
        }
      }
      if (j < 0 && i > 0){
//        System.out.println("we live   i");
  //      System.out.println(i);
        if (carry){
          tempInt = z.brob[i - 1] + 1;
          carry = false;
          if (tempInt > 9){
            tempInt = 0;
            carry = true;
            tempString = "0" + tempString;
          }
          else{
          tempString = tempInt + "" + tempString;
        }
        }
        else{
          tempInt = z.brob[i - 1];
          tempString = tempInt + "" + tempString;
        }
      }
        i--;
        j--;
    }
    if (carry){
      tempString = 1 + "" + tempString;
    }
      tempBrob = new BrobInt(tempString);
      tempBrob = tempBrob.zeroLessBrob();
      return tempBrob;
    }

    // Same idea as add but you hve to organize them first

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


//Continually subtraacts from the big number and adds one to the running count
    public BrobInt divide(BrobInt z){
      if(this.biggerThan(z)){
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
  //      System.out.println(times.toString());
      }
      times.subtract(one);
      return times;
    }
    else{
    BrobInt tempBrob = z;
    BrobInt tempBrober;
    int passed = this.getLength();
    int had = z.getLength();
    int i = passed;
    int j = had;
    tempString = "0";
    BrobInt total;
    BrobInt times = new BrobInt(tempString);
    BrobInt one = new BrobInt("1");
    while (tempBrob.biggerThan(this)){
//        System.out.println(tempBrob.toString());
//        System.out.println("we live");
      times = times.add(one);
      tempBrober = tempBrob.subtract(this);
//        System.out.println(tempBrober.toString());
      tempBrober = tempBrober.zeroLessBrob();
      tempBrob = tempBrober;
//        System.out.println(times.toString());
    }
    times.subtract(one);
//    System.out.println(times.toString());
    return times;
  }
    }

//gets each number multiplied by each one then adds the number of zeros behind
// in order to get the real value
    public BrobInt multiply(BrobInt z){
      BrobInt tempBrob = new BrobInt("1");
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
      /** while (z.biggerThan(tempBrob)){
        sum = sum.add(this);
        tempBrob = tempBrob.add(ONE);
      }
      **/
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
