package test.mypac;

public class Computer {
   private Cpu cpu;
   private Memory memory;
   
   // Cpu type 과 Memory type 을 인자로 전달 받는 생성자
   public Computer(Cpu cpu, Memory memory) {
      this.cpu=cpu;
      this.memory=memory;
   }
   
   public void doGame() {
      if(cpu == null || memory == null) {
         System.out.println("부품이 부족해서 컴퓨터가 작동을 안해요!");
         return;
      }
      System.out.println("신나게 게임을 해요!");
   }
}