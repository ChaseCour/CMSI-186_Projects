public class Ball{

   public static double timeSlice = 1.00;
   private static double velo;
   private static double posY;
   private static double posX;
   private static double moveX;
   private static double moveY;
   private static final double friction = .99;
   private static double start;
   public static final double radius =.3708333333333333333333333333333333333333333333333333333333333;

   public Ball(double startX, double startY, double moveX, double moveY) {
     posY = startY;
     posX = startX;
     moveX = moveX;
     moveY = moveY;
}

  public static double getPosX(){
    return posX;
  }
  public static double getPosY(){
    return posY;
  }
  public static double getMoveY(){
    return moveY;
  }
  public static double getMoveX(){
    return moveX;
  }


  public static void changeSpot (){
    posY += moveY;
    posX += moveX;
    moveX = moveX * friction;
    moveY = moveY * friction;
    if (moveX < 1){
      moveX = 0;
    }
    if (moveY < 1){
      moveY = 0;
    }
  }

  public static double setTimeSlice (double temp){
    if (temp > 0){
      return temp;
    }
    return timeSlice;
  }

  public static double validateStarts (String temp){
    start = Double.parseDouble(temp);
    return start;
  }

  public static double validateVelocity (String temp){
    velo = Double.parseDouble(temp);
    return velo;
  }

  public static int didItHit (Ball[] setBall){
    int hits = 0;
    for (int i = 0; i < setBall.length; i++){
      for (int j = 0; j < setBall.length; i++){
        if(i == j){
          j++;
        }
        if (Math.abs(setBall[i].posX - setBall[j].posX) < 8.9){
          if ((Math.abs(setBall[i].posY - setBall[j].posY) < 8.9)){
            hits++;
          }
        }
      }
    }
    return hits;
  }

   public static void main( String args[] ) {
     System.out.println("we live");

   }

}
