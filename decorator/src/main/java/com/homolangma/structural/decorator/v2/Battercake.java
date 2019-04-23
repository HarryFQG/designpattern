package com.homolangma.structural.decorator.v2;

/**
 * @author 36732
 * @date 2019/4/17 0:38
 */
public class Battercake extends ABatterCake {
    @Override
    public String getDesc() {
        return "煎饼";
    }

    @Override
    public int cost() {
        return 8;
    }
}
