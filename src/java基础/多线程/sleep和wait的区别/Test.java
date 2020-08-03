package java基础.多线程.sleep和wait的区别;

public class Test{
    public static void main(String[] args){

        Service mService = new Service();

        Thread sleepThread = new Thread(new SleepThread(mService));
        Thread waitThread = new Thread(new WaitThread(mService));
        sleepThread.start();
        waitThread.start();

    }

}
