package java基础.多线程.aqs;

import java.util.concurrent.locks.LockSupport;

/**
 * 咖啡因饮料抽象类
 */
public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        //煮水
        boilWater();
        //酿造
        brew();
        //导入杯子
        pourInCup();
        //添加调味料
        addCondiments();
    }

    protected abstract void brew();

    protected abstract void addCondiments();

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread();
//        thread.start();
//        Thread.sleep(1000);
//        thread.interrupt();
//        boolean flag1 = thread.isInterrupted();
//        //false
//        System.out.println(flag1);
//        boolean flag2 = thread.isInterrupted();
//        //false
//        System.out.println(flag2);
//    }

    public static void main(String[] args) {

//        Thread.currentThread().interrupt();
//        System.out.println(Thread.currentThread().isInterrupted());
//        System.out.println(Thread.currentThread().isInterrupted());
//        boolean flag1 = Thread.interrupted();
//        System.out.println(flag1);  //true
//        System.out.println(Thread.currentThread().isInterrupted());
//
//        boolean flag2 = Thread.interrupted();
//        System.out.println(flag2);  //false
//
//        boolean flag3 = Thread.interrupted();
//        System.out.println(flag3);  //false

        boolean flag1 = Thread.interrupted();
        System.out.println(flag1);  //true
        System.out.println(Thread.currentThread().isInterrupted());


        Thread.currentThread().interrupt();
        LockSupport.park();
        //返回中断状态，并且清除中断状态
        Thread.interrupted();
        //输出start
        System.out.println("start");
        LockSupport.park();
        //end被阻塞，没有输出
        System.out.println("end");
    }
}