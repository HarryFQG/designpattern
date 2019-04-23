package com.homolangma.principle.interfacesegration.v1;

/**
 * 注意：违反了接口隔离原则定义的那些
 */
public class Dog implements IAnmalAction {
    @Override
    public void eat() {

    }

    @Override
    public void fly() {
        System.out.println("会飞");
    }

    @Override
    public void swim() {

    }
}
