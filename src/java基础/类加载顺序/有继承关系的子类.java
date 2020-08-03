package java基础.类加载顺序;

/**
 * 关于关键字static，大家 都知道它是静态的，相当于一个全局变量，也就是这个属性或者方法是可以通过类来访问，
 * 当class文件被加载进内存，开始初始化的时候，被static修饰的变量或者方法即被分配了内存，而其他变量是在对象被创建后，才被分配了内存的。
 *
 * 所以在类中，加载顺序为：
 *
 * 1.首先加载父类的静态字段或者静态语句块
 *
 * 2.子类的静态字段或静态语句块
 *
 * 3.父类普通变量以及语句块
 *
 * 4.父类构造方法被加载
 *
 * 5.子类变量或者语句块被加载
 *
 * 6.子类构造方法被加载
 */
public class 有继承关系的子类 extends 有继承关系的父类 {
    static {
        System.out.println("静态语句块和静态变量被初始化的顺序与代码先后顺序有关"); //3.被加载
    }

    static int num = 45;//4.被加载
    int numre = 0; //8.被加载

    {
        numre++;
        System.out.println("numre" + numre);//9.被加载

    }

    public 有继承关系的子类() {
        System.out.println("子类构造方法");//10.被加载
    }

    public static void main(String[] args) {
        有继承关系的子类 ht = new 有继承关系的子类();
    }
}