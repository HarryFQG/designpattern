package com.homolangma.principle.singleresponsibility.v32;

/**
 * 方法级别：
 */
public class Method {


    /**
     * 职责不单一
     * @param userName
     * @param address
     */
    private void updateUserInfo(String userName,String  address){

        userName="lisi";
        address="123456";
    }

    /**
     * 职责模糊
     * @param userName
     * @param address
     * @param properties
     */
    private void updateUserInfo(String userName,String  address,String ... properties){

        userName="lisi";
        address="123456";
    }

    /**
     * 方法单一职责
     * @param userName
     */
    public void updateUserName(String userName){
        userName="wangwu";
    }

    /**
     *
     * @param address
     */
    public void updateAddress(String address){
        address="246810";
    }




}
