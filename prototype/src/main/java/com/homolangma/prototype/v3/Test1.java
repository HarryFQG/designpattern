package com.homolangma.prototype.v3;

import java.util.Date;

/**
 * @author 36732
 * @date 2019/4/14 22:54
 */
public class Test1 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Date birthday = new Date(0L);
        Pig pig = new Pig("佩奇", birthday);
        Pig pigTemp = (Pig) pig.clone();
        System.out.println(pig);
        System.out.println(pigTemp);
        // 1. 浅克隆
        pig.getBirthday().setTime(66666666666L);
        System.out.println(pig);
        System.out.println(pigTemp);

    }


}
