package com.homolangma.structural.decorator.v1;

/**
 * @author 36732
 * @date 2019/4/17 0:32
 */
public class BattercakeWithEggSausage extends BattercakeWithEgg {
    @Override
    public String getDesc() {
        return super.getDesc() + "-加椰果";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
