package com.javarush.task.task29.task2909.human;

public class BloodGroup {
    private final int code;
    private BloodGroup(int code){
        this.code = code;

    }

    public  int getCode() {
        return code;
    }
    public static BloodGroup first(){
        BloodGroup first = new BloodGroup(1);
        return first;
    }
    public static BloodGroup second(){
        BloodGroup second = new BloodGroup(2);
        return second;
    }
    //third() и fourth(),
    public static BloodGroup third(){
        BloodGroup third = new BloodGroup(3);
        return third;
    }
    public static BloodGroup fourth(){
        BloodGroup fourth = new BloodGroup(4);
        return fourth;
    }
}
