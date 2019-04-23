package com.homolangma.structural.decorator.v2;

/**
 * @author 36732
 * @date 2019/4/17 0:43
 */
public class Test1 {

    public static void main(String[] args) {
        ABatterCake aBatterCake;
        aBatterCake = new Battercake();
        aBatterCake = new EggDecorator(aBatterCake);
        System.out.println("描述："+aBatterCake.getDesc()+"，价格："+aBatterCake.cost());
        aBatterCake = new SausageDecorator(aBatterCake);
        System.out.println("描述："+aBatterCake.getDesc()+"，价格："+aBatterCake.cost());
    }

}
