package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age){
        Human o;
        if(age <= KidGirl.MAX_AGE)
            o = new KidGirl();
        else if(age > KidGirl.MAX_AGE && age <= TeenGirl.MAX_AGE)
            o = new TeenGirl();
        else
            o = new Woman();
        return o;
    }
}
