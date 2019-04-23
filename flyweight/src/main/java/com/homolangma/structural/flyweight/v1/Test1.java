package com.homolangma.structural.flyweight.v1;

/**
 * @author 36732
 * @date 2019/4/18 23:44
 */
public class Test1 {

    private static final String deps[]={"RD","QA","PM","BD"};
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            String dep=deps[(int) (Math.random()*deps.length)];
            Manager manager = (Manager) EmployeeFactory.getManager(dep);
            System.out.println(manager);

            manager.report();
        }

    }

}
