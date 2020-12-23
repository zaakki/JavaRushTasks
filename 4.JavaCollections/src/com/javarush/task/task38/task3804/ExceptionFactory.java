package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getFactoryClass(Enum e){
        if(e != null){
           String message = e.name().charAt(0) + e.toString().substring(1).toLowerCase().replace("_"," ");
           if (e instanceof ApplicationExceptionMessage)
               return new Exception(message);
           if(e instanceof  DatabaseExceptionMessage)
               return new RuntimeException(message);
           if(e instanceof UserExceptionMessage)
               return new Error(message);
        }
        return new IllegalArgumentException();
    }
}
