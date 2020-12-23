package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        //Реализуй метод paintFill в классе PhotoPaint таким образом, чтобы он возвращал:
        //- false, если цвет начальной точки (координаты приходят в качестве параметров) совпадает с цветом заливки или если начальные координаты выходят за рамки массива.
        //- модифицировал входящий массив и возвращал true, если заливка все же может быть выполнена.
        //
        //Точке с координатами (x, y) соответствует элемент массив с индексом [y][x].
        //Требования:
        //1. Метод paintFill должен возвращать false, если переданные координаты выходят за границы изображения.
        //2. Метод paintFill должен возвращать false, если цвет начальной точки совпадает с цветом заливки.
        //3. Метод paintFill должен возвращать true и корректно модифицировать изображение, если это возможно.
        //4. Метод paintFill должен быть публичным.
        if(x<0 || y<0 || y>= image.length || x>= image[0].length)
            return false;
        if(image[y][x] == desiredColor)
            return false;
        Color  color = image[y][x];
        paintFill(image,x,y,desiredColor,color);
        return true;
    }
    private void paintFill(Color[][] image, int x, int y, Color desiredColor,Color color){
        if(x < 0 || y< 0 || y>= image.length || x >= image[0].length)
            return;
        if(image[y][x]!=color)
            return;
        else
            image[y][x] = desiredColor;
        printNewColor(image, x, y, desiredColor, color);
    }

    private void printNewColor(Color[][] image, int x, int y, Color desiredColor, Color color) {
        paintFill(image, x -1, y, desiredColor, color);
        paintFill(image, x +1, y, desiredColor, color);
        paintFill(image, x, y -1, desiredColor, color);
        paintFill(image, x, y +1, desiredColor, color);
    }
}
