package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();
//Метод AnyObject get(Long key) должен возвращать объект типа AnyObject из мапы cacheMap по ключу key.
// Если такого ключа в cacheMap нет - верни null.
//
//Метод AnyObject put(Long key, AnyObject value) должен добавлять в мапу пару key : value.
// Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения.
// Иначе - верни предыдущее значение value по этому ключу.
// Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.
//
//Метод AnyObject remove(Long key) должен удалить из мапы cacheMap пару key : value по ключу key.
// Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения.
// Иначе - верни предыдущее значение value по этому ключу.
// Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.
    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);

        //напишите тут ваш код
        if(cacheMap.containsKey(key))
            return softReference.get();
        else return null;
    }
    //Метод AnyObject put(Long key, AnyObject value) должен добавлять в мапу пару key : value.
// Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения.
// Иначе - верни предыдущее значение value по этому ключу.
// Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.
//

    public AnyObject put(Long key, AnyObject value) {

        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        AnyObject o = softReference == null ? null :softReference.get();
        if(softReference != null){
            softReference.clear();
        }
        return o;
        //напишите тут ваш код


    }
///Метод AnyObject remove(Long key) должен удалить из мапы cacheMap пару key : value по ключу key.
//// Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения.
//// Иначе - верни предыдущее значение value по этому ключу.
//// Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.
    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        AnyObject o = softReference == null ? null :softReference.get();
        if(softReference != null){
            softReference.clear();
        }
        return o;
        

        //напишите тут ваш код

    }
}