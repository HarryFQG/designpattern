package com.homolangma.structural.facade.v1;

/**
 * @author 36732
 * @date 2019/4/16 0:23
 */
public class Test1 {
    public static void main(String[] args) {

        PointsGift pointsGift = new PointsGift("手机");
        GiftExchangeService giftExchangeService = new GiftExchangeService();

        giftExchangeService.giftExchange(pointsGift);

    }
}
