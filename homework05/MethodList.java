import java.util.Arrays;
import java.util.ArrayList;

private static double delta;
private static double total = 0;
public class MethodList{

  public static void main( String args[] ) {

   }

   public static double methodSin(double lower, double upper, int sections){
     delta = (upper-lower)/sections;
     for (int i = 0; i < sections; i++){
       total = delta * Math.sin((lower + (delta / 2) + (i * delta));
     }
   }

   public static double methodExp(double lower, double upper, int sections){
     delta = (upper-lower)/sections;
     for (int i = 0; i < sections; i++){
       total = delta * Math.exp((lower + (delta / 2) + (i * delta));
     }
   }
   }

   public static double methodLog(double lower, double upper, int sections){
     delta = (upper-lower)/sections;
     for (int i = 0; i < sections; i++){
       total = delta * Math.log((lower + (delta / 2) + (i * delta));
     }
   }
   }

   public static double methodSqrt(double lower, double upper, int sections){
     delta = (upper-lower)/sections;
     for (int i = 0; i < sections; i++){
       total = delta * Math.sqrt((lower + (delta / 2) + (i * delta));
     }
   }
   }

}
