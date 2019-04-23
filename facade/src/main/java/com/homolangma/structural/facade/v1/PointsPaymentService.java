package com.homolangma.structural.facade.v1;

/**
 * @author 36732
 * @date 2019/4/16 0:13
 * 支付系统
 */
public class PointsPaymentService {

    public boolean pay(PointsGift pointsGift) {
        System.out.println("支付" + pointsGift.getName() + "成功");
        return true;
    }

}
