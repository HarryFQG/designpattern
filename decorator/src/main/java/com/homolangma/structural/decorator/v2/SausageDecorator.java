package com.homolangma.structural.decorator.v2;

/**
 * @author 36732
 * @date 2019/4/17 0:41
 */
public class SausageDecorator extends AbstractDecorator {
    public SausageDecorator(ABatterCake aBatterCake) {
        super(aBatterCake);
    }

    @Override
    public String getDesc() {
        return super.getDesc()+"-香肠";
    }

    @Override
    public int cost() {
        return super.cost()+2;
    }
}
