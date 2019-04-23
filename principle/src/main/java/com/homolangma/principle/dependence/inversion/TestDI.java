package com.homolangma.principle.dependence.inversion;

import com.homolangma.principle.dependence.inversion.v1.Student;
import com.homolangma.principle.dependence.inversion.v2.JavaCourse;
import com.homolangma.principle.dependence.inversion.v2.StudentV2;
import com.homolangma.principle.dependence.inversion.v2.StudentV3;
import com.homolangma.principle.dependence.inversion.v2.StudentV4;

public class TestDI {


    public static void main(String[] args) {
        // v1 面向编程
        Student student = new Student();
        student.studyJavaCourse();

        // v2 面向接口
        StudentV2 studentV2 = new StudentV2();
        studentV2.studyImoocCourse(new JavaCourse());

        // v3 面向构造注入
        StudentV3 studentV3 = new StudentV3(new JavaCourse());
        studentV3.studyImoocCourse();

        // v4 setter 注入
        StudentV4 studentV4 = new StudentV4();
        studentV4.setiCourse(new JavaCourse());
        studentV4.studyImoocCourse();



    }


}
