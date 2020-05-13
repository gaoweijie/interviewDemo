package java基础.多线程.forkJoinPool;

import java.util.concurrent.CountDownLatch;

/**
 * PROJECT_NAME:downLoad
 * Author:lucaifang
 * Date:2016/3/18
 */
public class countDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new readNum(i, countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.println("线程执行结束。。。。");
    }

    static class readNum implements Runnable {
        private int id;
        private CountDownLatch latch;

        public readNum(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            synchronized (this) {
                System.out.println("id:" + id);
                latch.countDown();
                System.out.println("线程组任务" + id + "结束，其他任务继续");
            }
        }
    }
}