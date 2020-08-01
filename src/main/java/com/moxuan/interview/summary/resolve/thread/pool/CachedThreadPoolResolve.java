package com.moxuan.interview.summary.resolve.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ProjectName: interview-summary
 * @Package: com.moxuan.interview.summary.resolve.thread.pool
 * @ClassName: CachedThreadPoolResolve
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/8/1 14:44
 */
public class CachedThreadPoolResolve {
    /**
     * 可缓存线程池 CachedThreadPool
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     * 这里的线程池是无限大的，当一个线程完成任务之后，这个线程可以接下来完成将要分配的任务，而不是创建一个新的线程
     * (ThreadPoolExecutor)cachedThreadPool).getActiveCount()  获取当前线程池中活动线程数
     */
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //每一次循环都会创建一个线程，因为在新的线程执行的时候，原有创建的线程都还没有结束
        for (int i = 0; i < 1000; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(((ThreadPoolExecutor) cachedThreadPool).getActiveCount());
                    System.out.println(Thread.currentThread().getName() + "==>" + index);

                }
            });
        }
        //执行结束后，手动关闭线程池
        cachedThreadPool.shutdownNow();
    }
}