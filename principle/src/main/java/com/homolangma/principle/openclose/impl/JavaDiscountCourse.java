package com.homolangma.principle.openclose.impl;

/**
 * 模拟商品打折处理
 */
public class JavaDiscountCourse extends JavaCourseImpl {

    public JavaDiscountCourse(Integer id, String name, double price) {
        super(id, name, price);
    }

    public Double getOriginPrice(){
        return super.getPrice();
    }
    @Override
    public Double getPrice() {
        return super.getPrice()*0.8;
    }
}
