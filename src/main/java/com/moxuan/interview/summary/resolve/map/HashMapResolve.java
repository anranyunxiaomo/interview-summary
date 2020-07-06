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
         */

        // hashMap  1.8 链表+数组+红黑树    1.8中 在hashMap的链表长度大于等于8时,将链表 转换成红黑树存储.
        HashMap<String, String> HashMap = new HashMap<>(8);
        HashMap.put("1","1");

    }

}
