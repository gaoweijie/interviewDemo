package java基础.类加载顺序;

public class 有继承关系的父类 {
    static int num = 5;//1.首先被加载

    static {
        System.out.println("静态语句块已经被加载" + num); //2.被加载
    }

    int count = 0; //5.被加载

    {
        System.out.println("普通语句块" + count++);//6.被加载
    }

    public 有继承关系的父类() {
        System.out.println("父类的构造方法在这时候加载count=" + count);//7.被加载
    }
}