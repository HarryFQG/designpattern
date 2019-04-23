package com.homolangma.structural.adapter.classadapter.v1;

/**
 * @author 36732
 * @date 2019/4/17 23:33
 * 适配者：继承被适配者，实现目标接口
 * 继承和接口 同时使用
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        // 调用继承的父类方法
        super.adapteeRequest();
    }
}
