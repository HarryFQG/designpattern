package com.homolangma.structural.facade.v1;

/**
 * @author 36732
 * @date 2019/4/16 0:17
 */
public class GiftExchangeService {

    private PointsPaymentService pointsPaymentService = new PointsPaymentService();
    private QualifyService qualifyService= new QualifyService();
    private ShippingService shippingService= new ShippingService();

    // 注入
    /*public void setPointsPaymentService(PointsPaymentService pointsPaymentService) {
        this.pointsPaymentService = pointsPaymentService;
    }

    public void setQualifyService(QualifyService qualifyService) {
        this.qualifyService = qualifyService;
    }

    public void setShippingService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }*/

    public void giftExchange(PointsGift pointsGift) {
        if (qualifyService.isAvailable(pointsGift)) {
            // 资格校检通过
            if (pointsPaymentService.pay(pointsGift)) {
                // 支付积分成功
                String shippingOrderNumber = shippingService.shipGift(pointsGift);
                System.out.println("兑换奖后，物流订单号：" + shippingOrderNumber);
            }

        }


    }


}
