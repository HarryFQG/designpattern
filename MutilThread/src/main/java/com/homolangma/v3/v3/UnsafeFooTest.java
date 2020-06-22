package com.homolangma.v3.v3;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author: Mr.Harry
 * @date : 2020/6/7 17:01
 * @title :
 */
public class UnsafeFooTest {

    public static void main(String[] args) throws Exception {
        Simple simple = Simple.class.newInstance();
        System.out.println(simple.get());
        // Class<?> aClass = Class.forName("com.homolangma.v3.v3.UnsafeFooTest$Simple");
        Unsafe unsafe = getUnsafe();
        Simple simple1 = (Simple) unsafe.allocateInstance(Simple.class);
        System.out.println("绕过初始化：" + simple1 + "   " + simple1.getClass().getClassLoader());

        Guard guard=new Guard();
        guard.work();
        Field field = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
        unsafe.putInt(guard,unsafe.objectFieldOffset(field),42);
        guard.work();
    }

    private static Unsafe getUnsafe() {

        try {
            Field unsafe = Unsafe.class.getDeclaredField("theUnsafe");
            unsafe.setAccessible(true);
            return (Unsafe) unsafe.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static class Simple {
        private long l = 0;

        public Simple() {
            this.l = 1;
            System.out.println("===============");
        }

        public long get() {


            return this.l;
        }
    }

    static class Guard {

        private int ACCESS_ALLOWED = 1;
        private boolean allow(){

            return 42==ACCESS_ALLOWED;
        }

        private void work(){
            System.out.println("------- starting----");
            if(allow()){
                System.out.println("-----------working--------");
            }

        }

    }

}
