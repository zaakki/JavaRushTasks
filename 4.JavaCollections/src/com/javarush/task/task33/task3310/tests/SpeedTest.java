package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    //Он должен возвращать время в миллисекундах необходимое для получения идентификаторов для всех строк из strings.
    // Идентификаторы должны быть записаны в ids.
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date startDateTime = new Date();
        for (String s : strings
        ) {
            shortener.getId(s);
        }
        Date finishDateTime = new Date();

        long delta = finishDateTime.getTime() - startDateTime.getTime();
        return delta;
    }

    //Он должен возвращать время в миллисекундах необходимое для получения строк для всех идентификаторов из ids.
    // Строки должны быть записаны в strings.
    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date startDateTime = new Date();
        for (Long id : ids
        ) {
            shortener.getString(id);
        }
        Date finishDateTime = new Date();

        long delta = finishDateTime.getTime() - startDateTime.getTime();
        return delta;
    }

    //Создавать два объекта типа Shortener, один на базе HashMapStorageStrategy, второй на базе HashBiMapStorageStrategy.
    // Назовем их shortener1 и shortener2.
    //15.4.2. Генерировать с помощью Helper 10000 строк и помещать их в сет со строками, назовем его origStrings.
    //15.4.3. Получать время получения идентификаторов для origStrings (вызывать метод getTimeToGetIds для shortener1,
    // а затем для shortener2).
    //15.4.4. Проверять с помощью junit, что время, полученное в предыдущем пункте для shortener1 больше, чем для shortener2.
    //15.4.5. Получать время получения строк (вызывать метод getTimeToGetStrings для shortener1 и shortener2).
    //15.4.6. Проверять с помощью junit, что время, полученное в предыдущем пункте для shortener1 примерно равно времени
    // для shortener2. Используй метод assertEquals(float expected, float actual, float delta).
    // В качестве delta можно использовать 30, этого вполне достаточно для наших экспериментов.
    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();

        long timeId1 = getTimeToGetIds(shortener1, origStrings, ids1);
        long timeId2 = getTimeToGetIds(shortener2, origStrings, ids2);



        long timeStr1 = getTimeToGetStrings(shortener1, ids1, origStrings);
        long timeStr2 = getTimeToGetStrings(shortener2, ids2, origStrings);

        Assert.assertTrue(timeId1>timeId2);
        Helper.printMessage(String.valueOf(timeId1) + " > " + timeId2);
        Assert.assertEquals(timeStr1,timeStr2,30);
        Helper.printMessage(String.valueOf(timeStr1) + " = " + timeStr2);

    }
}
