package com.homolangma.prototype.v2;

/**
 * @author 36732
 * @date 2019/4/14 22:50
 */
public class B extends A{

    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B();
        B bTemp= (B) b.clone();
        System.out.println(b+"--"+bTemp);

    }


}
