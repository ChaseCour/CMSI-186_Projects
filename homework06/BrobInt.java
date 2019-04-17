import java.util.Arrays;
import java.util.ArrayList;

public class BrobInt{

  private int tempInt;
  private String tempString;
  private String a;
  private String b;
  private char charA;
  private int[] brob;
  private String toStringA;
  private boolean carry;

  public BrobInt( String value ) {
    a = value;
    brob = new int[a.length()];
    for (int i = a.length(); i > 0; i--){
      charA = a.charAt(i - 1);
       b = "" + charA;
      brob[i - 1] = Integer.parseInt(b);
    }
    }


    public String getString (){
      return a;
    }

    public int getLength (){
      return a.length();
    }

    public String toString (){
      return a;
    }

    public BrobInt add(BrobInt z){
      BrobInt tempBrob;
      int passed = z.getLength();
      int had = this.getLength();
      int i = passed;
      int j = had;;
      tempString = "";
      carry = false;
      while (i > -1 || j > -1){
        if (i == 0 && j == 0){
          if (carry){
            tempString = 1 + "" + tempString;
          }
          i--;
          j--;
        }
        if (i == 0 && j < 0){
          if (carry){
            tempString = 1 + "" + tempString;
          }
          i--;
          j--;
        }
        if (i < 0 && j == 0){
          if (carry){
            tempString = 1 + "" + tempString;
          }
          i--;
          j--;
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
          i--;
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
          i--;
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
        i--;
        j--;
      }
      else {
        i--;
        j--;
      }
    }
      tempBrob = new BrobInt(tempString);
      return tempBrob;
    }

    public BrobInt subtract(BrobInt z){
      BrobInt tempBrob;
      int passed = z.getLength();
      int had = this.getLength();
      int i = passed;
      int j = had;;
      tempString = "";
      carry = false;
      return z;
    }
}
