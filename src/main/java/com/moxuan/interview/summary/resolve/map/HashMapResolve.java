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
         * 5. 插入数据的方式为 头插法
         * 6. 数组元素 & 链表节点的 实现类
         *  HashMap的本质 = 1个存储Entry类对象的数组 + 多个单链表
         *  Entry对象本质 = 1个映射（键 - 值对），属性包括：键（key）、值（value） & 下1节点( next)
         *  = 单链表的指针 = 也是一个Entry对象，用于解决hash冲突
         * 源码分析:
         *    Entry类实现了Map.Entry接口
         *   即 实现了getKey()、getValue()、equals(Object o)和hashCode()等方法
         *   static class Entry<K,V> implements Map.Entry<K,V> {
         *      final K key;  // 键
         *     V value;      // 值
         *     Entry<K,V> next; // 指向下一个节点 ，也是一个Entry对象，从而形成解决hash冲突的单链表
         *     int hash;    // hash值
         *
         *      构造方法，创建一个Entry
         *     参数：哈希值h，键值k，值v、下一个节点n
         *     Entry(int h, K k, V v, Entry<K,V> n) {
         *         value = v;
         *         next = n;
         *         key = k;
         *         hash = h;
         *     }
         *      // 返回 与 此项 对应的键
         *     public final K getKey() {
         *         return key;
         *     }
         *
         *     // 返回 与 此项 对应的值
         *     public final V getValue() {
         *         return value;
         *     }
         *
         *     public final V setValue(V newValue) {
         *         V oldValue = value;
         *         value = newValue;
         *         return oldValue;
         *     }
         *
         *     equals（）
         *    作用：判断2个Entry是否相等，必须key和value都相等，才返回true
         *    public final boolean equals(Object o) {
         *         if (!(o instanceof Map.Entry))
         *             return false;
         *         Map.Entry e = (Map.Entry)o;
         *         Object k1 = getKey();
         *         Object k2 = e.getKey();
         *         if (k1 == k2 || (k1 != null && k1.equals(k2))) {
         *             Object v1 = getValue();
         *             Object v2 = e.getValue();
         *             if (v1 == v2 || (v1 != null && v1.equals(v2)))
         *                 return true;
         *         }
         *         return false;
         *     }
         *
         *     public final int hashCode() {
         *         return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
         *     }
         *
         *     public final String toString() {
         *         return getKey() + "=" + getValue();
         *     }
         *
         *      当向HashMap中添加元素时，即调用put(k,v)时，
         *      对已经在HashMap中k位置进行v的覆盖时，会调用此方法
         *      此处没做任何处理
         *      void recordAccess(HashMap<K,V> m) {
         *     }
         *
         *     当从HashMap中删除了一个Entry时，会调用该函数
         *     此处没做任何处理
         *     void recordRemoval(HashMap<K,V> m) {
         *     }
         *   }
         *   }
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
          *   1. 链表节点转换成红黑树节点的阈值, 节点数 >= 8 -1   TREEIFY_THRESHOLD - 1=7，
          *   也就是说一旦binCount=7时就会执行下面的转红黑树代码   但是通过源码可以看出  当链表节点长度等于 8 的时候 才会调用
          *     treeifyBin(tab, hash);
          *   2. 但是链表转换成红黑树 还需要确定 当前hashmap 的容量   MIN_TREEIFY_CAPACITY =64   是不是大于等于 64
          *   如果 hashmap 的容量 小于 64   会调用扩容方法resize(); 进行扩容
          *   当链表长度继续增加  对应的 会再次判断 hashmap 的容量是否大于64 当 容量还是小于 MIN_TREEIFY_CAPACITY=64
          *   会继续扩容resize() 直至 hashmap 容量 超过等于 64 后,才会去调用链表转换成红黑树的方法
          *  3.    DEFAULT_LOAD_FACTOR = 0.75f   负载因子
          *       hashMap   初始容量为 16，负载因子为 0.75
          *      当 hahMap 容量到多少时,会进行扩容呢   即当hashmap 当前的  size *  DEFAULT_LOAD_FACTOR 时,阈值. 会触发扩容方法
          *     resize();   初始容量  2的4次方（16）   增长时是2的整数次方（幂） 当前容量的 乘以 2
          *
          *
          *
          */


        HashMap<Object, String> HashMap = new HashMap<>(64);
        HashMap.put(new HashMapBean(4), "2221222");  //1
        HashMap.put(new HashMapBean(8), "2222122");  // 2
        HashMap.put(new HashMapBean(12), "2212222"); // 3
        HashMap.put(new HashMapBean(16), "2221222");  // 4
        HashMap.put(new HashMapBean(20), "2222122"); // 5
        HashMap.put(new HashMapBean(24), "2111122222"); //6
        HashMap.put(new HashMapBean(28), "2212222"); // 7
        HashMap.put(new HashMapBean(32), "2122222"); //8
        HashMap.put(new HashMapBean(36), "221111112222");
        HashMap.put(new HashMapBean(40), "111111111111");


    }

}
