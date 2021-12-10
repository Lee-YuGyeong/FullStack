package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

   public static void main(String[] args) {
      Message message = new Message();
      message.sayHello("임지윤");
      System.out.println();
      MessageInter inter=new Message();
      inter.sayHello("지윤");
      
      System.out.println("--- 스프링으로 만든 객체 읽기 ---");
      ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
      //Message message2=(Message)context.getBean("nice");
      Message message2 = context.getBean("nice",Message.class);
      message2.sayHello("이유경");
      
      System.out.println();
      MessageInter inter2 = (MessageInter)context.getBean("nice");
      inter2.sayHello("유경");
   }   

}