package com.moxuan.interview.summary.resolve.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ProjectName: interview-summary
 * @Package: com.moxuan.interview.summary.resolve.thread.pool
 * @ClassName: FixedThreadPoolResolve
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/8/1 15:32
 */
public class FixedThreadPoolResolve {

    /**
     * FixedThreadPool
     * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
     * 定长线程池的大小最好根据系统资源进行设置。  如Runtime.getRuntime().availableProcessors()
     *
     */

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 1000000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        //执行结束后，手动关闭线程池
        executorService.shutdownNow();
    }

}
