package java基础.多线程.sleep和wait的区别;

public class SleepThread implements Runnable{

    private Service service;

    public SleepThread(Service service){
        this.service = service;
    }

    public void run(){
        service.mSleep();
    }

}
