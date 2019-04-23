package com.homolangma.structural.decorator.v1;

/**
 * @author 36732
 * @date 2019/4/17 0:33
 */
public class Test1 {

    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println("描述："+battercake.getDesc()+"，价格："+battercake.cost());
        Battercake battercakeWithEgg=new BattercakeWithEgg();
        System.out.println("描述："+battercakeWithEgg.getDesc()+"，价格："+battercakeWithEgg.cost());
        Battercake battercakeWithEggSausage=new BattercakeWithEggSausage();
        System.out.println("描述："+battercakeWithEggSausage.getDesc()+"，价格："+battercakeWithEggSausage.cost());

    }



}
