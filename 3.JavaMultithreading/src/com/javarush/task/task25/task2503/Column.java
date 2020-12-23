package com.javarush.task.task25.task2503;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;
//Метод Column.getVisibleColumns должен возвращать список отображаемых колонок в скофигурированом порядке.
//6. Метод Column.getColumnName должен возвращать полное имя колонки.
//7. Метод Column.isShown должен возвращать true, если колонка видимая, иначе false.
//8. Метод Column.hide должен скрывать колонку и сдвигать индексы остальных отображаемых колонок.
    //* Output:
//     * <p/>
//     * Available Amount
//     * Account Number
//     * Bank Name
//     * --------------------
//     * Available Amount
//     * Bank Name
    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        Column[] columns = Column.values();


        for (int i = 0; i <realOrder.length ; i++) {
            if(realOrder[i] != -1)
                result.add(values()[i]);
            }
        result.sort((column,t1) -> ((realOrder[column.ordinal()] >= realOrder[t1.ordinal()]) ? 1 : -1));
       // Collections.reverse(result);


       // System.out.println(index+" " +column.getColumnName());
               return result;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
        if(realOrder[ordinal()] == -1)
            return false;
        else
            return  true;
    }

    @Override
    public void hide() {
        realOrder[ordinal()] = -1;

    }
}
