package com.moxuan.interview.summary.resolve.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ProjectName: interview-summary
 * @Package: com.moxuan.interview.summary.resolve.thread.pool
 * @ClassName: SingleThreadExecutorResolve
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/8/1 16:00
 */
public class SingleThreadExecutorResolve {
    /**
     * newSingleThreadExecutor
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     */

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Integer i =0;
            for(;i<100;i++){
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName());
                    }
                });
                // 停止线程池
                executorService.shutdownNow();
            }
    }
}
