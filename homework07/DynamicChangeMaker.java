import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.*;
import java.lang.*;

public class DynamicChangeMaker {
// Declares lost of integers that will be used down the road
  public static  Tuple denominations;
  public static  int manyDeno;
  public static  int maxTimes;
  public static  int lowest = 1000;
  public static  int tryer;
  public static  int goal;
  public  static int[] counter;
  public  static Tuple lowTup;

/** Checks the data to make sure it is valid, creates an int array from they
    data that is given through the command prompt, then it calls the class
    **/
  public static void main( String args[] ) {
    checkData(args);
    int[] it = new int[args.length - 1];
    for (int i = 0; i < args.length - 1; i++){
      it[i] = Integer.parseInt(args[i]);
    }
    int goalie = Integer.parseInt(args[args.length - 1]);
    makeChangeWithDynamicProgramming(it, goalie);
   }

//Checks to see if it is negitive or repeating
   public static void checkData(String[] bad){
     for (int i = 0; i < bad.length; i++){
       if (Integer.parseInt(bad[i]) < 1){
         System.out.println("BAD DATA");
         System.exit(0);
       }
     }
     for (int i = 0; i < bad.length - 1; i++){
       for (int j = 0; j < bad.length - 1; j++){
         if (bad[i].equals(bad[j]) && i != j){
           System.out.println("BAD DATA");
           System.exit(0);
         }
       }
     }
   }

// Sums up the total number of cents using the two arrays as a dot product
   public int countItUp(Tuple count){
     int sum = 0;
     for(int i = 0; i < manyDeno; i++){
       sum = sum + (count.getElement(i) * denominations.getElement(i));
     }
     return sum;
   }

//not used
   public static Tuple organizeThem (Tuple passed){
     int temp[] = new int[passed.length()];
     passed.toString();
     int low = 1000;
     int indy = 0;
     for (int j = 0; j < manyDeno; j++){
     for (int i = 0; i < manyDeno; i++){
       if (passed.getElement(i) < low){
         indy = i;
         low = passed.getElement(i);
       }
     }
      temp[j] = low;
      passed.setElement(indy, 1000);
   }
   Tuple passer = new Tuple(temp);
   return passer;
   }

// Sends the code to the right method for the given the number denominations
   public static void makeChangeWithDynamicProgramming( int[] denom, int goal){
     int manyDeno = denom.length;
     counter = new int[manyDeno];
     for (int i = 0; i < manyDeno; i++){
       counter[i] = 0;
     }
     lowTup = new Tuple(counter);
     Tuple denominations = new Tuple(denom);
//     denominations = organizeThem(denominations);
     if (manyDeno == 1){
       useOne(denominations, goal);
     }
     if (manyDeno == 2){
       useTwo(denominations, goal);
     }
     if (manyDeno == 3){
       useThree(denominations, goal);
     }
     if (manyDeno == 4){
       useFour(denominations, goal);
     }
     if (manyDeno == 5){
       useFive(denominations, goal);
     }
     if (manyDeno == 6){
       useSix(denominations, goal);
     }
     if (manyDeno == 7){
       useSeven(denominations, goal);
     }
     lowTup.toString(lowTup.data);
   }

//counts the number of coins used
   public static int arrayCount (int[] game){
     int sum = 0;
     for(int i = 0; i < game.length; i++){
       sum += game[i];
     }
     return sum;
   }

/** the rest of the code is a repeat just sizes up as the numbers get bigger.
    It goes through every possible combination and if it is lower than then
    previous low, it replaces it. If it hits the bottom and there is no change
    in the lowest score it means that it was impossible.
    **/
  
   public  static void useOne(Tuple denom, int goal){
    maxTimes = goal / denom.getElement(0);
     for (int i = 0; i < maxTimes + 1; i++){
      counter[0] = i;
      tryer = denom.totalCount(counter);
      if(tryer == goal){
        if (arrayCount(counter) < lowest){
          lowest = arrayCount(counter);
          lowTup = new Tuple(counter);
        }
    }
     }
     if(lowest == 1000){
       System.out.println("IMPOSSIBLE");
     }
   }

   public  static void useTwo(Tuple denom, int goal){
     for (int i = 0; i < (goal / denom.getElement(0)) + 1; i++){
       for (int j = 0; j < (goal / denom.getElement(0)) + 1; j++){
               counter[0] = i;
               counter[1] = j;
               tryer = denom.totalCount(counter);
               if(tryer == goal){
                 if (arrayCount(counter) < lowest){
                   lowest = arrayCount(counter);
                   lowTup = new Tuple(counter);

             }
              }
       }
     }
     if(lowest == 1000){
       System.out.println("IMPOSSIBLE");
     }
   }

   public  static void useThree(Tuple denom, int goal){
     for (int i = 0; i < (goal / denom.getElement(0)) + 1; i++){
       for (int j = 0; j < (goal / denom.getElement(1)) + 1; j++){
         for (int k = 0; k < (goal / denom.getElement(2)) + 1; k++){
           counter[0] = i;
           counter[1] = j;
           counter[2] = k;
           tryer = denom.totalCount(counter);
           if(tryer == goal){
             if (arrayCount(counter) < lowest){
               lowest = arrayCount(counter);
               lowTup = new Tuple(counter);

         }
          }
         }
       }
     }
     if(lowest == 1000){
       System.out.println("IMPOSSIBLE");
     }
   }

   public  static void useFour(Tuple denom, int goal){
     for (int i = 0; i < (goal / denom.getElement(0)) + 1; i++){
       for (int j = 0; j < (goal / denom.getElement(1)) + 1; j++){
         for (int k = 0; k < (goal / denom.getElement(2)) + 1; k++){
           for (int l = 0; l < (goal / denom.getElement(3)) + 1; l++){
             counter[0] = i;
             counter[1] = j;
             counter[2] = k;
             counter[3] = l;
             tryer = denom.totalCount(counter);
             if(tryer == goal){
               if (arrayCount(counter) < lowest){
                 lowest = arrayCount(counter);
                 lowTup = new Tuple(counter);

           }
            }
           }
         }
       }
     }
     if(lowest == 1000){
       System.out.println("IMPOSSIBLE");
     }
   }

   public static  void useFive(Tuple denom, int goal){
     for (int i = 0; i < (goal / denom.getElement(0)) + 1; i++){
       for (int j = 0; j < (goal / denom.getElement(1)) + 1; j++){
         for (int k = 0; k < (goal / denom.getElement(2)) + 1; k++){
           for (int l = 0; l < (goal / denom.getElement(3)) + 1; l++){
             for (int m = 0; m < (goal / denom.getElement(4)) + 1; m++){
               counter[0] = i;
               counter[1] = j;
               counter[2] = k;
               counter[3] = l;
               counter[4] = m;
               tryer = denom.totalCount(counter);
               if(tryer == goal){
                 if (arrayCount(counter) < lowest){
                   lowest = arrayCount(counter);
                   lowTup = new Tuple(counter);

             }
              }
             }
           }
         }
       }
     }
     if(lowest == 1000){
       System.out.println("IMPOSSIBLE");
     }
   }

   public  static void useSix(Tuple denom, int goal){
     for (int i = 0; i < (goal / denom.getElement(0)) + 1; i++){
       for (int j = 0; j < (goal / denom.getElement(1)) + 1; j++){
         for (int k = 0; k < (goal / denom.getElement(2)) + 1; k++){
           for (int l = 0; l < (goal / denom.getElement(3)) + 1; l++){
             for (int m = 0; m < (goal / denom.getElement(4)) + 1; m++){
               for (int n = 0; n < (goal / denom.getElement(5)) + 1; n++){
                 counter[0] = i;
                 counter[1] = j;
                 counter[2] = k;
                 counter[3] = l;
                 counter[4] = m;
                 counter[5] = n;
                 tryer = denom.totalCount(counter);
                 if(tryer == goal){
                   if (arrayCount(counter) < lowest){
                     lowest = arrayCount(counter);
                     lowTup = new Tuple(counter);

               }
                }
               }
             }
           }
         }
       }
     }
     if(lowest == 1000){
       System.out.println("IMPOSSIBLE");
     }
   }

   public  static void useSeven(Tuple denom, int goal){
     for (int i = 0; i < (goal / denom.getElement(0)) + 1; i++){
       for (int j = 0; j < (goal / denom.getElement(1)) + 1; j++){
         for (int k = 0; k < (goal / denom.getElement(2)) + 1; k++){
           for (int l = 0; l < (goal / denom.getElement(3)) + 1; l++){
             for (int m = 0; m < (goal / denom.getElement(4)) + 1; m++){
               for (int n = 0; n < (goal / denom.getElement(5)) + 1; n++){
                 for (int p = 0; p < (goal / denom.getElement(6)) + 1; p++){
                   counter[0] = i;
                   counter[1] = j;
                   counter[2] = k;
                   counter[3] = l;
                   counter[4] = m;
                   counter[5] = n;
                   counter[6] = p;
                   tryer = denom.totalCount(counter);
                   if(tryer == goal){
                     System.out.println("we live");
                     if (arrayCount(counter) < lowest){
                       lowest = arrayCount(counter);
                       lowTup = new Tuple(counter);

                 }
                  }
                 }
               }
             }
           }
         }
       }
     }
     if(lowest == 1000){
       System.out.println("IMPOSSIBLE");
     }
   }




}
