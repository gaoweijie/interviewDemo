package java基础.多线程.aqs;

/**
 * 茶饮料
 */
public class Tea extends CaffeineBeverage{
   @Override
   protected void brew() {
       System.out.println("Steeping the tea");
   }

   @Override
   protected void addCondiments() {
       System.out.println("Adding Lemon");
   }
}