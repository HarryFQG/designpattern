package com.homolangma.structural.decorator.v2;

/**
 * @author 36732
 * @date 2019/4/17 0:40
 * 鸡蛋装饰器
 */
public class EggDecorator extends AbstractDecorator {


    public EggDecorator(ABatterCake aBatterCake) {
        super(aBatterCake);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + "-鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }

}
