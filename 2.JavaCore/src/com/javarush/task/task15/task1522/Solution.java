package com.javarush.task.task15.task1522;

/* 
Закрепляем паттерн Singleton
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(thePlanet);


    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        try {
            readKeyFromConsoleAndInitPlanet();
            System.out.println(thePlanet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String s = reader.readLine();
            if (s.equals(Planet.EARTH)){
                thePlanet = Earth.getInstance();
                System.out.println(thePlanet);
            } else if(s.equals(Planet.MOON)){
               thePlanet = Moon.getInstance();
                System.out.println(thePlanet);
            } else if (s.equals(Planet.SUN)){
               thePlanet = Sun.getInstance();
                System.out.println(thePlanet);
            } else if( !s.equals(Planet.SUN) && !s.equals(Planet.MOON) && !s.equals(Planet.EARTH)) {
                thePlanet = null;

            }

    }
}
