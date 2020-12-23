package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] clazz = Collections.class.getDeclaredClasses();
        for (Class<?> c:clazz ) {
            if(Modifier.isPrivate(c.getModifiers()) && Modifier.isStatic(c.getModifiers()) && List.class.isAssignableFrom(c) ){
                try{
                    Method method = c.getDeclaredMethod("get",int.class);
                    method.setAccessible(true);
                    Constructor<?> constructor = c.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    method.invoke(constructor.newInstance(),2);
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException e) {

                } catch (InvocationTargetException e) {
                    if(e.getCause().toString().contains("IndexOutOfBoundsException")){
                        return c;
                    }
                }
            }


        }
        return null;
    }
}
