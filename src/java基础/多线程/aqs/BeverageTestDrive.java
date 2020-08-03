package java基础.多线程.aqs;

/**
 * 测试类
 */
public class BeverageTestDrive {

   public static void main(String[] args) {
       Tea tea = new Tea();
       /*Boiling water
       Steeping the tea
       Pouring into cup
       Adding Lemon*/
       tea.prepareRecipe();
   }
}