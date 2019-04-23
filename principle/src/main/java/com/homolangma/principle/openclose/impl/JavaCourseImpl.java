package com.homolangma.principle.openclose.impl;

import com.homolangma.principle.openclose.ICourse;

/**
 * 模拟Java 课程价格
 */
public class JavaCourseImpl implements ICourse{

    private Integer id;

    private String name;

    private Double price;

    public JavaCourseImpl (Integer id,String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
