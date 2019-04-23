package com.homolangma.structural.facade.v1;

/**
 * @author 36732
 * @date 2019/4/16 0:14
 * 物流系统
 */
public class ShippingService {

    public String shipGift(PointsGift pointsGift) {
        System.out.println(pointsGift.getName() + "ShippingService:进入物流系统");
        return "wu-liu-123456";
    }


}
