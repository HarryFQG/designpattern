package com.homolangma.structural.adapter.classadapter.v1;

/**
 * @author 36732
 * @date 2019/4/17 23:35
 * 类适配器
 */
public class Test1 {

    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();
        Target adapterTarget = new Adapter();
        adapterTarget.request();


    }

}
