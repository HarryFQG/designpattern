package com.homolangma.structural.facade.v1;

/**
 * @author 36732
 * @date 2019/4/16 0:11
 * 兑换系统
 */
public class QualifyService {

    public boolean isAvailable(PointsGift pointsGift) {
        System.out.println("校验" + pointsGift.getName());
        return true;
    }


}
