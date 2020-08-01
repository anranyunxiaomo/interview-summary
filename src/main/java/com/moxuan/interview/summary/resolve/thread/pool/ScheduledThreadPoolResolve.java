package com.moxuan.interview.summary.resolve.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: interview-summary
 * @Package: com.moxuan.interview.summary.resolve.thread.pool
 * @ClassName: ScheduledThreadPoolResolve
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/8/1 15:41
 */
public class ScheduledThreadPoolResolve {

    /**
     * ScheduledThreadPool
     *  创建一个定长线程池，支持定时及周期性任务执行。
     */

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        // 无返回值
        scheduledThreadPool.schedule(new Runnable() {

            @Override

            public void run() {

                System.out.println(Thread.currentThread().getName());
            }

        }, 3, TimeUnit.SECONDS);

        // 有返回值  可抛异常
        scheduledThreadPool.schedule(new Callable<Integer>() {

            @Override

            public Integer call() {
                System.out.println(Thread.currentThread().getName());
                return   1;
            }

        }, 3, TimeUnit.SECONDS);
    //执行结束后，手动关闭线程池
        scheduledThreadPool.shutdownNow();
    }



}
