package test.mypac;

public class DarkTemplar {
   //필드
   
   /*   [체력]
    *  
    *  필드명 : hp
    *  data type : int
    *  non static  
    */
   public int hp=80;
   /*
    *  [공격력]
    *  
    *  필드명 : damage
    *  data type : int
    *  static 
    */
   public static int damage=40;
   
   //메소드
   
   //공격하는 메소드
   public void attack() {
      System.out.println(DarkTemplar.damage+" 의 공격력으로 공격합니다." );
   }
   //움직이는 메소드
   public void move() {
      System.out.println(this.hp+" 체력의 다크 템플러가 움직여요");
   }
}





