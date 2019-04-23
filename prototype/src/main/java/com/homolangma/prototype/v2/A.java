package com.homolangma.prototype.v2;

/**
 * @author 36732
 * @date 2019/4/14 22:49
 * 原型模式: 抽象类形式
 */
public abstract class A implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("---clone----");
        return super.clone();
    }
}
