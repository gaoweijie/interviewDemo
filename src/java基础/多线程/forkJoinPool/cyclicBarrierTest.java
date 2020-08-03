package java基础.多线程.forkJoinPool;

import java.util.concurrent.CyclicBarrier;

/**
 * id:1
 * id:4
 * id:2
 * id:3
 * id:0
 * 线程组执行结束
 * 线程组任务4结束，其他任务继续
 * 线程组任务3结束，其他任务继续
 * 线程组任务1结束，其他任务继续
 * 线程组任务0结束，其他任务继续
 * 线程组任务2结束，其他任务继续
 */
public class cyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("线程组执行结束");
            }
        });
        for (int i = 0; i < 5; i++) {
            new Thread(new readNum(i,cyclicBarrier)).start();
        }
        //CyclicBarrier 可以重复利用，
        // 这个是CountDownLatch做不到的
//        for (int i = 11; i < 16; i++) {
//            new Thread(new readNum(i,cyclicBarrier)).start();
//        }
    }
    static class readNum  implements Runnable{
        private int id;
        private CyclicBarrier cyc;
        public readNum(int id,CyclicBarrier cyc){
            this.id = id;
            this.cyc = cyc;
        }
        @Override
        public void run() {
            synchronized (this){
                System.out.println("id:"+id);
                try {
                    cyc.await();
                    System.out.println("线程组任务\" + id + \"结束，其他任务继续");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


