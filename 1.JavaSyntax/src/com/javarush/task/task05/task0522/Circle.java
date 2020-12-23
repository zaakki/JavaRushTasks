package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    //напишите тут ваш код
    public Circle(){
        
    }
    public Circle(double _x, double _y, double _radius){
        this.x = _x;
        this.y = _y;
        this.radius = _radius;
    }
    public Circle(double _x, double _radius){
        this.x = _x;
        this.radius = _radius;
    }
    public Circle (double _radius){
        this(1, 1, _radius);
    }
    public Circle (Circle circle){
        this(circle.x, circle.y, circle.radius);
    }

    public static void main(String[] args) {

    }
}