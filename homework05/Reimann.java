import java.util.Arrays;
import java.util.ArrayList;

public class Reimann{

  private static int type;
  private static double temp;
  private static double upper;
  private static double lower;
  private static ArrayList<String> copy = new ArrayList<String>();
  private static ArrayList<Double> copyInts = new ArrayList<Double>();
  private static int section = 1;
  private static double diff;
  private static double last;
  private static double newer;
  private static double middle;
  private static boolean running = true;
  public static boolean percentThere;
  private static double percentage;

  public static void main( String args[] ) {
    percentThere = isThePercentThere(args);
    for (int i = 0; i < args.length; i++){
      copy.add(args[i]);
    }
    type = handleArgAndDecide(args);
    if (type == 5){
      System.out.println("ERROR: To use this program you must enter numbers in this order and all as doubles:");
      System.out.println("1) Enter poly (for polynomial), exp (for e to the x), sin (for sin(x)), sqrt (for square root x), log (for natural log of x)");
      System.out.println("2) Enter the coefficents you want for polynomials, starting with x^0 then x^1 and so on. Nothing entered if it's not a poly");
      System.out.println("3) Enter the range signified by a - sign in front of lower bound and + in the next argument");
      System.out.println("4) Enter the percent when the differance is small enough to get an accurate representation and double must end with % sign, defaults to 1.0%");
      System.exit(0);
    }
    percentage = getPercent(args);
    upper = getUpper(args);
    lower = getLower(args);
    copyOfIntsFill();
    while(running){
    last = callTheMethod(type, lower, upper, section);
    section = section + 1;
    newer =  callTheMethod(type, lower, upper, section);
    if (getPercentBetween(last, newer) >= .99){
      running = false;
    }
    }

    System.out.println("With " + section + " diffrent secions the estimated area is " + newer);
   }

   public static void copyOfIntsFill(){
     for (int i = 0; i < copy.size(); i++){
       double temp = Double.parseDouble(copy.get(i));
       copyInts.add(temp);
       System.out.println(temp);
     }
   }

   public static int handleArgAndDecide(String args[]){
     if (args[0].equals("poly")){
       copy.remove(0);
       return 0;
     }
     if (args[0].equals("log")){
       copy.remove(0);
       return 2;
     }
     if (args[0].equals("exp")){
       copy.remove(0);
       return 3;
     }
     if (args[0].equals("sqrt")){
       copy.remove(0);
       return 4;
     }
     if (args[0].equals("sin")){
       copy.remove(0);
       return 1;
     }
     else{
       return 5;
     }
   }

   public static double getPercentBetween(double lower1, double upper2){
     if (lower1 < upper2){
       return lower1 / upper2;
     }
     if (upper2 < lower1){
       return upper2 / lower1;
     }
     else{
       return upper2 /lower1;
     }
   }

   public static boolean isThePercentThere(String args[]){
     for (int i = 0; i < args.length; i++){
       for (int j = 0; j < args[i].length(); j++){
         if(args[i].charAt(j) == '%'){
           return true;
       }
       }
     }
     return false;
   }

   public static double getPercent(String args[]){
     for (int i = 0; i < args.length; i++){
       for (int j = 0; j < args[i].length(); j++){
         if(args[i].charAt(j) == '%'){
           args[i].replace("%", "");
           double temp = Double.parseDouble(args[i]);
           copy.remove(i - 1);
           return temp;
       }
       }
     }
     return 1.0;
   }

   public static double getLower(String args[]){
     if (percentThere){
       double temp = Double.parseDouble(args[args.length - 3]);
       copy.remove(copy.size() - 1);
       return temp;
     }
     else{
       double temp = Double.parseDouble(args[args.length - 2]);
       copy.remove(copy.size() - 1);
       return temp;
     }
   }

   public static double getUpper(String args[]){
     if (percentThere){
       double temp = Double.parseDouble(args[args.length - 2]);
       copy.remove(copy.size() - 1);
       return temp;
     }
     else{
       double temp = Double.parseDouble(args[args.length - 1]);
       copy.remove(copy.size() - 1);
       return temp;
     }
   }

   public static double callTheMethod(int ty, double lower, double upper, int sections){
     if (ty == 0){
       middle = MethodList.methodPoly( lower, upper, sections, copyInts);

     }
     if (ty == 1){
       middle = MethodList.methodSin(lower, upper, sections);
     }
     if (ty == 2){
       middle = MethodList.methodLog(lower, upper, sections);
     }
     if (ty == 3){
       middle = MethodList.methodExp(lower, upper, sections);
     }
     if (ty == 4){
       middle = MethodList.methodSqrt(lower, upper, sections);
     }
      System.out.println(middle);
     return middle;
   }
}
