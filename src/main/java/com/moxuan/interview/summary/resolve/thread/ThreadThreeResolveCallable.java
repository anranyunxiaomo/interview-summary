package com.moxuan.interview.summary.resolve.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ProjectName: interview-summary
 * @Package: com.moxuan.interview.summary.resolve.thread
 * @ClassName: ThreadThreeResolve
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/8/1 13:55
 */
public class ThreadThreeResolveCallable implements Callable<Integer> {
    int  i = 0;

    /**
     * 创建线程的方法   第三种  实现Callable接口    实现 call 方法 call 方法里面实现业务逻辑 call()⽅法的返回值；
     * 在其他方法 通过 new 类名 然后 new FutureTask<>(定义的类名称)  然后 通过 new Thread(定义的FutureTask名称).start; 即可实现
     *  调⽤FutureTask对象的get()⽅法来获得⼦线程执⾏结束后的返回值。
     *
     */

    @Override
    public  Integer call() throws Exception {

            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "-------------" + i);
            }
            return i;
    }

    public static void main(String[] args) {

        ThreadThreeResolveCallable threadThreeResolveCallable = new ThreadThreeResolveCallable();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(threadThreeResolveCallable);
        FutureTask<Integer> integer = new FutureTask<>(threadThreeResolveCallable);

        try {
            for(int i = 0;i < 100;i++){
                new Thread(integerFutureTask).start();
                new Thread(integer).start();
            }
            System.out.println(integerFutureTask.get());
            System.out.println(integer.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
