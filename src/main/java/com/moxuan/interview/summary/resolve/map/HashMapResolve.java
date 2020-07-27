package com.moxuan.interview.summary.resolve.map;

import java.util.HashMap;

/**
 * @ProjectName dxyt-mdm
 * @ClassName HashMapResolve
 * @Author zhangkai
 * @Description
 * @Date 2020/7/4 4:10 下午
 */
public class HashMapResolve {

    public static void main(String[] args) {

        // hashMap  1.7 数组(主)+链表(副)
        /**
         * 在 1.7中
         * 1. 数组的下标: 即存储hashMap中键值对的key (源码中---获取对应的 key.hashcode()值 作为数组下标 )
         * 当 一个hashMap 中的 多个元素的key获取到的对应的hash值一直的情况时,这个时候存在一个情况,即为hash碰撞.
         * 由于之前元素对应的下标hash已经有对应的元素,需要将原来的元素移动至单链表中,将新添加的元素放入对应的数组下标中.
         * 1.7 中解决hash冲突的方法为链地址法.
         * 2. hashMap的键值对数量 = 数组键值对+所有单链表的键值对 (Map的大小)
         * 3. hashMap的容量大小 = 数组大小
         * 4. 每一个链表的头结点 =数组元素  链表的节点值 = 对应hash 键值对
         *
         *
         *
         */

         /**
          *  1.8 HashMap概述
          *  hashMap  1.8 链表+数组+红黑树    1.8中 在hashMap的链表长度大于等于8时,将链表 转换成红黑树存储 减少查询时间.
          *   链表的实现：
          *  hashmap 中有一个内部类 Node 实现了 map.entry接口 实际上是 键值对  Node 是单向链表,
          *  他的构造函数Hash值（hash） 键（key） 值(value) 下一个节点(next)  这里 next 就是当出现hash值 相同时，将新数据
          *  添加到当前的数据中，将原来的数据存储到单向链表，next就指向到原来的数据。
          *  面试常见问题.
          *
          *  为什么hashmap 中单链表长度大于等于 8后 才将单链表转换成 红黑树?
          *  因为树节点的大小是链表节点的两倍,只有在容器中有足够的节点的时候使用,才能使树查询的速度更快,在没有节点或者节点比较少的
          *  时候,对于红黑树来说内存劣势大于查询等操作的优势.
          *  根据源码看 通过概率统计,忽略方差,列表长度为K的期望出现概率
          *  列表大小k的预期出现是 (exp(-0.5) * pow(0.5, k) / factorial(k)).
          * The first values are:
          *       0:    0.60653066
          *       1:    0.30326533
          *       2:    0.07581633
          *       3:    0.01263606
          *       4:    0.00157952
          *       5:    0.00015795
          *       6:    0.00001316
          *       7:    0.00000094
          *       8:    0.00000006
          *
          *
          *
          *
          *
          */

        HashMap<String, String> HashMap = new HashMap<>(8);

    }

}
