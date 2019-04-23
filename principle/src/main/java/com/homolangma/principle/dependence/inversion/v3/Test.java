package com.homolangma.principle.dependence.inversion.v3;

public class Test {

    public static void main(String[] args) {

        Student student = new Student(new FECourse());
        student.studyCourse();

    }

}
