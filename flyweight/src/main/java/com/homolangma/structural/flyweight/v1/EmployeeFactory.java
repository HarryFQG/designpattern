package com.homolangma.structural.flyweight.v1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 36732
 * @date 2019/4/18 23:41
 * 工厂类
 */
public class EmployeeFactory {

    private static final Map<String, Employee> EMPLOYEE_MAP = new HashMap<>();

    public static Employee getManager(String dep) {
        Manager manager = (Manager) EMPLOYEE_MAP.get(dep);
        if (null == manager) {
            manager = new Manager(dep);
            System.out.println("创建部门经理" + dep + ".");
            manager.setReportContent(dep+"部门汇报");
            EMPLOYEE_MAP.put(dep, manager);
        }
        return manager;
    }


}
