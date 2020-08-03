package java基础.多线程.aqs;

/**
 * 咖啡饮料
 */
public class Coffee extends CaffeineBeverage{
   @Override
   protected void brew() {
       System.out.println("Dripping Coffee through filter");
   }

   @Override
   protected void addCondiments() {
       System.out.println("Adding Sugar and Milk");
   }
}