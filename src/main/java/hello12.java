

public class hello12 {
 /**
  * @author www.Instanceofjava.com
  * @category interview questions
  * 
  * Description: how to run two java programs simultaneously
  *
  */
 public static void main(String[] args) throws InterruptedException {
  for (int i = 100; i < 200; i++) {
   System.out.println(i);
   Thread.sleep(1000);
  }

//System.out.println("hello1");
 }

}