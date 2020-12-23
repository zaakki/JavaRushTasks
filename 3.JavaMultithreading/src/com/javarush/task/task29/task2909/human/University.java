package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;
    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student student = null;

        for (Student s: students
             ) {
            if(s.getAverageGrade() == averageGrade)
                student = s;
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double max = 0.0;
        Student student = null;
        for (Student s:students
             ) {
            if(s.getAverageGrade()>max)
                max = s.getAverageGrade();
        }
        for (Student s:students
             ) {
            if(s.getAverageGrade() == max)
                student = s;
        }
        return student;
    }
    public Student getStudentWithMinAverageGrade(){
        Student student = null;
        double min = Integer.MAX_VALUE;
        for (Student s:students
             ) {
            if(s.getAverageGrade() < min)
                min = s.getAverageGrade();
        }
        for (Student s:students
             ) {
            if(s.getAverageGrade() == min)
                student = s;
        }
        return student;
    }
    public void expel(Student student){
        students.remove(student);
    }

//    public void getStudentWithMinAverageGradeAndExpel() {
//        //TODO:
//    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }
}