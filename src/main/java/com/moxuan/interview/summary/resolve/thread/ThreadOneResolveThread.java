package com.moxuan.interview.summary.resolve.thread;

/**
 * @ProjectName: interview-summary
 * @Package: com.moxuan.interview.summary.resolve.Thread
 * @ClassName: ThreadOneTest
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/8/1 13:40
 */
public class ThreadOneResolveThread extends Thread{

    /**
     * 创建线程的方法   第一种  继承 thread 类    通过重写 run 方法 (run  方法需要处理的业务逻辑)
     *  在其他方法 通过 new 类名.run 方法 进行调用.
     */
    @Override
    public void run() {

             System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
                    for (int i=0; i<100;i++ ){
                        System.out.println(Thread.currentThread().getName()+" : "+i);
                        new ThreadOneResolveThread().run();
                        new ThreadOneResolveThread().run();
        }
    }
}
