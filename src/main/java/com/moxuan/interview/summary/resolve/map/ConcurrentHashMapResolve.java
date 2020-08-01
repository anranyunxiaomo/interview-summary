package com.moxuan.interview.summary.resolve.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ProjectName: interview-summary
 * @Package: com.moxuan.interview.summary.resolve.map
 * @ClassName: ConcurrentHashMapResolve
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/8/1 13:19
 */
public class ConcurrentHashMapResolve {

    public static void main(String[] args) {
        /**
         * 1. 分析  ConcurrentHashMap 的基本变量
         *    DEFAULT_CAPACITY =16
         *    默认基础容量为 16  2的4次方（16）
         *   loadFactor为0.75（负载因⼦，扩容时需要参考），
         *
         *   concurrentLevel为16  默认 ConcurrentHashMap 并发数据  最大值  1<<16   65536
         *
         *
         *
         *
         *
         *
         *    1.7  ConcurrentHashMap  实现
         *
         *   2. ConcurrentHashMap的机构
         *   3. ConcurrentHashMap 如何保证多线程下 高并发
         *   4. ConcurrentHashMap 如何实现分段锁
         *   5.
         *
         *   1.8 ConcurrentHashMap 实现
         *
         *
         *
         *
         */
        System.out.println(1<<16);

        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<>();




    }

}
