package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) throws IllegalAccessException {
            ImageReader reader;
            if(imageTypes == ImageTypes.JPG){
              reader = new JpgReader();
            }else if (imageTypes == ImageTypes.BMP){
                reader = new BmpReader();
            } else  if (imageTypes == ImageTypes.PNG){
                reader = new PngReader();
            } else
               throw new IllegalArgumentException();
        return reader;
    }
}
