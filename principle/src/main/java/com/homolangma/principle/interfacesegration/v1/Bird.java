package com.homolangma.principle.interfacesegration.v1;

/**
 * 注意：违反了接口隔离原则定义的那些
 */
public class Bird implements IAnmalAction{

    @Override
    public void eat() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {
        System.out.println("游泳");
    }
}
