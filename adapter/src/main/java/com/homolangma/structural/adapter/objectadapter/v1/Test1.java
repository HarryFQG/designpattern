package com.homolangma.structural.adapter.objectadapter.v1;



/**
 * @author 36732
 * @date 2019/4/17 23:35
 * 对象适配器
 */
public class Test1 {

    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();
        Target adapterTarget=new Adapter();
        adapterTarget.request();



    }

}
