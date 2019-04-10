import java.util.Arrays;
import java.util.ArrayList;

public class MethodList{

  private static double delta;
  private static double total;

  public static void main( String args[] ) {
    System.out.println("We live");
   }

   public static double methodSin(double lower, double upper, int sections){
     total = 0;
     delta = (upper-lower)/sections;
     for (int i = 0; i < sections; i++){
       total += delta * Math.sin((lower + (delta / 2) + (i * delta)));
     }
     return total;
   }

   public static double methodExp(double lower, double upper, int sections){
     total = 0;
     delta = (upper-lower)/sections;
     for (int i = 0; i < sections; i++){
       total = (delta * Math.exp((lower + (delta / 2) + (i * delta)))) + total;
     }
     return total;
   }

   public static double methodLog(double lower, double upper, int sections){
     total = 0;
     delta = (upper-lower)/sections;
     for (int i = 0; i < sections; i++){
       total = delta * Math.log((lower + (delta / 2) + (i * delta))) + total;
     }
     return total;
   }

   public static double methodSqrt(double lower, double upper, int sections){
     if(lower < 0){
       lower = 0;
     }
     total = 0;
     delta = (upper-lower)/sections;
     for (int i = 0; i < sections; i++){
       total = delta * Math.sqrt((lower + (delta / 2) + (i * delta))) + total;
     }
     return total;
   }

   public static double methodPoly(double lower, double upper, int sections, ArrayList copyTemp){
     total = 0;
     delta = (upper-lower)/sections;
     int leng = copyTemp.size();
     double single;
     for (int i = 0; i < sections; i++){
       for (int j = 0; j < leng ; j++){
         total += delta * (Math.pow((lower + (delta / 2) + (i * delta)), j)) * (double)(copyTemp.get(j));
       }
     }
     System.out.println(total);
     return total;
   }

}
