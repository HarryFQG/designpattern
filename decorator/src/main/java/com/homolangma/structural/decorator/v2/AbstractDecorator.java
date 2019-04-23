package com.homolangma.structural.decorator.v2;

/**
 * @author 36732
 * @date 2019/4/17 0:39
 * 装饰器
 */
public class AbstractDecorator extends ABatterCake{
    private ABatterCake aBatterCake;

    public AbstractDecorator(ABatterCake aBatterCake) {
        this.aBatterCake = aBatterCake;
    }

    @Override
    public String getDesc() {
        return this.aBatterCake.getDesc();
    }

    @Override
    public int cost() {
        return this.aBatterCake.cost();
    }
}
