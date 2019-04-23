package com.homolangma.structural.decorator.v1;

/**
 * @author 36732
 * @date 2019/4/17 0:31
 */
public class BattercakeWithEgg extends Battercake {
    @Override
    public String getDesc() {
        return super.getDesc() + "-加鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
