package com.homolangma.structural.composite.v1;

/**
 * @author 36732
 * @date 2019/4/24 0:12
 */
public class Test1 {

    public static void main(String[] args) {
        CatalogComponent linuxCourse =new Course("Linux 课程",125.56);
        CatalogComponent winCourse =new Course("win 课程",1000);
        CatalogComponent javaCourseCatalog= new CourseCatalog("java 课程目录",2);
        CatalogComponent mallCourse1 = new Course("java 初级课程",11000);
        CatalogComponent mallCourse2 = new Course("java 中级级课程",12000);
        CatalogComponent designPattern = new Course("设计模式",1300);

        javaCourseCatalog.add(mallCourse1);
        javaCourseCatalog.add(mallCourse2);
        javaCourseCatalog.add(designPattern);

        CatalogComponent znwCatalog= new CourseCatalog("中农网系统",1);
        znwCatalog.add(linuxCourse);
        znwCatalog.add(winCourse);
        znwCatalog.add(javaCourseCatalog);
        znwCatalog.print();

    }


}
