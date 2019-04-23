package com.homolangma.structural.flyweight.v1;

/**
 * @author 36732
 * @date 2019/4/18 23:38
 * 员工
 */
public class Manager implements Employee{
    private String dep;
    private String reportContent;
    // 内部状态
    private String title="部门经理";
    @Override
    public void report() {
        System.out.println(reportContent);
    }

    public Manager(String dep) {
        this.dep = dep;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "dep='" + dep + '\'' +
                ", reportContent='" + reportContent + '\'' +
                '}';
    }
}
