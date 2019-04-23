package com.homolangma.principle.test;

import com.homolangma.principle.openclose.ICourse;
import com.homolangma.principle.openclose.impl.JavaCourseImpl;
import com.homolangma.principle.openclose.impl.JavaDiscountCourse;

public class TestOpenClose {

    public static void main(String[] args) {
        /**
         * 1. 模拟Java 课程 做活动打折扣价
         */
        ICourse course= new JavaCourseImpl(1,"java",199.9);
        System.out.println("java:"+course.getId()+"-"+course.getName()+"-"+course.getPrice());
        /**
         * 2. 打折处理
         */
        ICourse course2= new JavaDiscountCourse(1,"java",199.9);
        JavaDiscountCourse javaDiscountCourse = (JavaDiscountCourse) course2;
        System.out.println("java:"+javaDiscountCourse.getId()+"-"+javaDiscountCourse.getName()+";原价:"+javaDiscountCourse.getOriginPrice()+"-折后价:"+javaDiscountCourse.getPrice());
    }


}
