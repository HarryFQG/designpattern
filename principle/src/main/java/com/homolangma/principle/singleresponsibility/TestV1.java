package com.homolangma.principle.singleresponsibility;

import com.homolangma.principle.singleresponsibility.v1.Bird;
import com.homolangma.principle.singleresponsibility.v2.FlyBird;
import com.homolangma.principle.singleresponsibility.v2.WalkerBird;

public class TestV1 {

    public static void main(String[] args) {
        // v1 非单一职责
        Bird bird = new Bird();
        bird.mainMoveMode("麻雀");

        // v2 单一职责
        FlyBird flyBird = new FlyBird();
        flyBird.mainMoveMode("大雁");

        WalkerBird walkerBird = new WalkerBird();
        walkerBird.mainMoveMode("鸵鸟");



    }




}
