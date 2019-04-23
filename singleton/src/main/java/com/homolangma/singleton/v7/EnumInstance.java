package com.homolangma.singleton.v7;

/**
 * @author 36732
 * @date 2019/4/14 16:45
 * 枚举实现单例模式: 序列化机制，反射攻击
 */
public enum EnumInstance {
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }


}



