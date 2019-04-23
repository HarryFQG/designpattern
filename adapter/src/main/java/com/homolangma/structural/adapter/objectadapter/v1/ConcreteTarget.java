package com.homolangma.structural.adapter.objectadapter.v1;



/**
 * @author 36732
 * @date 2019/4/17 23:12
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("ConcreteTarget 目标方法");
    }
}
