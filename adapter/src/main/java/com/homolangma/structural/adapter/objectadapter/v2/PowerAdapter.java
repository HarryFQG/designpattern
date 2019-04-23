package com.homolangma.structural.adapter.objectadapter.v2;

/**
 * @author 36732
 * @date 2019/4/18 0:23
 */
public class PowerAdapter implements DC5 {

    private Ac220 ac220 = new Ac220();

    @Override
    public int outPutDc5() {
        int adapterInput = ac220.outPutAc220();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用PowerAdapter 输出Ac:"+adapterOutput+"V, 输入:"+ac220.outPutAc220()+"V.");
        return adapterOutput;
    }
}
