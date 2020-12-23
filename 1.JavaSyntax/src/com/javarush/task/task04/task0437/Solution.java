package com.javarush.task.task04.task0437;                                                                                                                                                      
                                                                                                                                                      
/*                                                                                                                                                       
Треугольник из восьмерок                                                                                                                                                      
*/                                                                                                                                                      
                                                                                                                                                      
public class Solution {                                                                                                                                                      
    public static void main(String[] args) {                                                                                                                                                      
        //напишите тут ваш код                                                                                                                                                      
          int m = 10;
        for(int i = 11; i >1; i--){

            for(int j = i-1; j <= m; j++){
                System.out.print("8");

            }
            System.out.println();                                                                                                                                                   
        }                                                                                                                                                      
                                                                                                                                                      
    }                                                                                                                                                      
}