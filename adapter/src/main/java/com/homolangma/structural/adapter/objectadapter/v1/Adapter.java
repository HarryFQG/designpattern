package com.homolangma.structural.adapter.objectadapter.v1;

/**
 * @author 36732
 * @date 2019/4/18 0:17
 */
public class Adapter implements Target{

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
