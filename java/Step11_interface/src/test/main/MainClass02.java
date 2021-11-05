package test.main;

import test.mypac.Remocon;

public class MainClass02 {
   
   static class YourRemocon implements Remocon{
      @Override
      public void up() {
         System.out.println("체널을 올려요");
      }
      @Override
      public void down() {
         System.out.println("체널을 내려요");
      }
   }
   
   public static void main(String[] args) {
      //inner 클래스를 이용해서 아래의 useRemocon() 메소드를 호출해 보세요.
      useRemocon(new YourRemocon());
      //local inner 클래스를 이용해서 아래의 useRemocon() 메소드를 호출해 보세요.
      class OurRemocon implements Remocon{
         @Override
         public void up() {
            System.out.println("아무거나 올려요!");
         }
         @Override
         public void down() {
            System.out.println("아무거나 내려요!");
         }   
      }
      useRemocon(new OurRemocon());
   }
   
   public static void useRemocon(Remocon r) {
      r.up();
      r.down();
   }
}






