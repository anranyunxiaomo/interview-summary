package com.moxuan.interview.summary.resolve.thread;

/**
 * @ProjectName: interview-summary
 * @Package: com.moxuan.interview.summary.resolve.thread
 * @ClassName: ThreadResolve
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/8/1 14:32
 */
public class ThreadResolve {

    /**
     * 创建线程的三种方式的对比
     *  1. 采用实现Runnable、Callable接口的方式创建多线程
     *   优势：
     *  线程类只是实现了Runnable接口或Callable接口，还可以继承其他类。
     *  在这种方式下，多个线程可以共享同一个target对象，所以非常适合多个相同线程来处理同一份资源的情况，
     *  从而可以将CPU、代码和数据分开，形成清晰的模型，较好地体现了面向对象的思想。
     *  劣势：
     * 编程稍微复杂，如果要访问当前线程，则必须使用Thread.currentThread()方法。
     * 2、使用继承Thread类的方式创建多线程
     *  优势：
     * 编写简单，如果需要访问当前线程，则无需使用Thread.currentThread()方法，直接使用this即可获得当前线程。
     *  劣势：
     * 线程类已经继承了Thread类，所以不能再继承其他父类。
     * 3、Runnable和Callable的区别
     * (1).Runnable 实现的方法 run() 方法 Callable 实现的方法 call() 方法
     * (2).Callable 执行完后 可以返回值  Runnable 执行完后,不能有返回值
     * (3).call方法可以抛出异常，run方法不可以。
     * (4). 运行Callable任务可以拿到一个Future对象，表示异步计算的结果。它提供了检查计算是否完成的方法，以等待计算的
     * 完成，并检索计算的结果。通过Future对象可以了解任务执行情况，可取消任务的执行，还可获取执行结果future.get()。
     *
     *  new Thread的弊端
     *  当你需要一个异步操作,通过 new thread 时,
     *  1.每次new Thread新建对象性能差。
     *  2.线程缺乏统一管理，可能无限制新建线程，相互之间竞争，及可能占用过多系统资源导致死机或oom（out of memory）。
     *  3. 缺乏更多功能，如定时执行、定期执行、线程中断。
     *
     *
     *
     *
     */

}
