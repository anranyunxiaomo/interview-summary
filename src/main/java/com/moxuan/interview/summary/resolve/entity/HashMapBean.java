package com.moxuan.interview.summary.resolve.entity;

import java.util.Objects;

/**
 * @ProjectName: interview-summary
 * @Package: com.moxuan.interview.summary.resolve.entity
 * @ClassName: HashMapBean
 * @Author: zhangkai
 * @Description:
 * @Date: 2020/7/27 13:13
 */

public class HashMapBean {
    protected int number;

    public HashMapBean(int number) {
        this.number = number;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        HashMapBean other = (HashMapBean) obj;
        if (number != other.number){
            return false;
        }
            return true;
    }

    @Override
    public int hashCode() {
        return number % 4;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
