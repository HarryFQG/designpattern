package com.homolangma.principle.singleresponsibility.v1;

/**
 * 单一职责原则
 *      v1: 目前增加新的就要改变既有功能代码
 */
public class Bird {


    public void mainMoveMode(String birdName){

        if("鸵鸟".equalsIgnoreCase(birdName)) {
            System.out.println(birdName + "用脚走.");
            return;
        }
        System.out.println(birdName + "用翅膀飞.");

    }


}
