import java.util.Arrays;
import java.util.ArrayList;

public class Reimann{

  private static int type;
  private static double temp;
  private static double upper;
  private static double lower;
  private static ArrayList<String> copy;

  public static void main( String args[] ) {
    copy = new ArrayList<String>;
    for (int i = 0; i < args.length; i++){
      copy.add(args[i]);
    }
    type = handleArgAndDecide(args[]);
    upper = getUpper(args);
    lower = getLower(args);
    callTheMethod(type);
    System.out.printLn("we live!");
   }

   public static int handleArgAndDecide(String args[]){
     if (args[0].equals("poly")){
       return 0;
     }
     if (args[0].equals("log")){
       return 2;
     }
     if (args[0].equals("exp")){
       return 3;
     }
     if (args[0].equals("sqrt")){
       return 4;
     }
     if (args[0].equals("sin")){
       return 1;
     }
   }

   public static double getLower(String args[]){
     for (int i = 0; i < args.length; i++){
       if(args[i].charAt(0) == '+'){
         double temp = Double.parseDouble(args[i]);
         return temp;
       }
     }
   }

   public static void getUpper(String args[]){
     for (int i = 0; i < args.length; i++){
       if(args[i].charAt(0) == '-'){
         double temp = Double.parseDouble(args[i]);
         return temp;
       }
     }
   }

   public static void callTheMethod(int ty){
     if (ty == 0){
       methodPoly();
     }
     if (ty == 1){
       methodSin();
     }
     if (ty == 2){
       methodLog();
     }
     if (ty == 3){
       methodExp();
     }
     if (ty == 4){
       methodSqrt();
     }
   }
}
