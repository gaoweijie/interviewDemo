package java基础.多线程.多线程异常;

import java.util.concurrent.*;

public class ThreadExceptionDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executorService = buildThreadPoolTaskExecutor();
        executorService.execute(() -> run("execute方法"));
        Future<?> submitResult = executorService.submit(() -> run("submit方法"));
        try {
            Object obj = submitResult.get();
            System.out.println("xxxxxxx=" + obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void run(String name) {
        String printStr = "【thread-name:" + Thread.currentThread().getName() + ",执行方式:" + name+"】";
        System.out.println(printStr);
        throw new RuntimeException(printStr + ",出现异常");
    }

    private static ThreadPoolExecutor buildThreadPoolTaskExecutor() {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 10, 10,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(100), new ThreadPoolExecutor.CallerRunsPolicy());
//        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
//        executorService.setThreadNamePrefix("(小罗技术笔记)-");
//        executorService.setCorePoolSize(5);
//        executorService.setMaxPoolSize(10);
//        executorService.setQueueCapacity(100);
//        executorService.setKeepAliveSeconds(10);
//        executorService.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executorService.initialize();
        return executorService;
    }

}
