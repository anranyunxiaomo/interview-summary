package com.moxuan.interview.summary.resolve.thread;

/**
 * @ProjectName: interview-summary
 * @Package: com.moxuan.interview.summary.resolve.thread
 * @ClassName: ThreadTowResolve
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/8/1 13:49
 */
public class ThreadTowResolveRunnable implements Runnable{

    /**
     * 创建线程的方法   第二种  实现Runnable接口    实现 run 方法 将run 方法里面实现业务逻辑
     *    在其他方法 通过 new 类名   通过  new Thread( 定义的类名称 ).start();
     */

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for(int i = 0;i < 100;i++){
            ThreadTowResolveRunnable threadTowResolveRunnable = new ThreadTowResolveRunnable();
            new Thread(threadTowResolveRunnable).start();
        }

    }
}
