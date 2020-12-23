package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        String s = "hello";
        char[] c = s.toCharArray();

        System.out.println(isPalindromePermutation("aabbcc"));
    }
    public static boolean isPalindromePermutation(String s){
        if(s == null )
            return false;
        s = s.toLowerCase().replaceAll(" ","");
        boolean[] isOdd = new boolean[256];

        for (int i = 0; i < s.length(); i++) {
            isOdd[s.charAt(i)] = !isOdd[s.charAt(i)];
        }
        int numberOdds = 0;
        for (int i = 0; i < isOdd.length; i++) {
            if(isOdd[i])
                numberOdds++;
            if(numberOdds>1)
                return false;
        }
        return true;
    }

//    public static boolean isPalindromePermutation(String s) {
//
//        int bitVector = createBitVector(s);
//        return bitVector == 0|| checkExactlyOneBitSet(bitVector);
//    }
////Создаем битовый вектор для строки. Для каждой буквы со значением i изменить состояние i-го бита
//    private static int createBitVector(String s) {
//        int bitVector = 0;
//        for (char c : s.toCharArray()) {
//            int x = Character.getNumericValue(c);
//            bitVector = toggle(bitVector, x);
//        }
//        return bitVector;
//    }
////Перекобчение i-го бита в целом значении
//    private static int toggle(int bitVector, int index) {
//        if (index < 0)
//            return bitVector;
//        int mask = 1 << index;
//        if ((bitVector & mask) == 0) {
//            bitVector |= mask;
//        } else
//            bitVector &= ~mask;
//        return bitVector;
//    }
////Что бы проверить, что в числе установлен ровно один бит, следует вычесть 1 и объединить с исходным числом операцией AND
//    private static boolean checkExactlyOneBitSet(int bitVector){
//        return (bitVector & (bitVector-1))==0;
//    }
}
