package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код
    int left, top, width, height;
    public Rectangle(int left, int top, int width, int height){
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }
    public Rectangle(int left, int top){
        this.left = left;
        this.top = top;
    }
    public Rectangle(int widtht){
        this.width = width;
        this.height = width;
    }
    public Rectangle(Rectangle rect){
        this.width = rect.width;
        this.height = rect.height;
        this.top = rect.top;
        this.left = rect.left;
    }

    public static void main(String[] args) {

    }
}
