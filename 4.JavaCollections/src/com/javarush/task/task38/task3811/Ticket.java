package com.javarush.task.task38.task3811;

import java.lang.annotation.*;

//) Должна быть публичная и доступна во время выполнения программы.
//2) Применяться может только к новым типам данных (Class, interface (including annotation type), or enum declaration).
//3) Должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.
//4) Приоритет будет задавать свойство priority - по умолчанию Priority.MEDIUM.
//5) Свойство tags будет массивом строк и будет хранить теги связанные с тикетом.
//6) Свойство createdBy будет строкой - по умолчанию Amigo.
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface Ticket {
    enum Priority{LOW,MEDIUM,HIGH}
    Priority priority() default Priority.MEDIUM;
    String[] tags() default {};
    String createdBy() default "Amigo";

}
