package java基础.多线程.sleep和wait的区别;

public class WaitThread implements Runnable{

    private Service service;

    public WaitThread(Service service){
        this.service = service;
    }

    public void run(){
        service.mWait();
    }

}
