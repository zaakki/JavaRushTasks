package com.javarush.task.task30.task3008;
//отвечает за тип сообщений пересылаемых между клиентом и сервером.
public enum MessageType {
    NAME_REQUEST, // запрос имени
    USER_NAME, // имя пользователя
    NAME_ACCEPTED, // имя принято
    TEXT, // текстовое сообщение
    USER_ADDED, // Пользователья добавлен
    USER_REMOVED; //пользователь удален

}
