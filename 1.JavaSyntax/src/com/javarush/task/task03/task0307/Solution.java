package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
       Zerg zerg1 = new Zerg();
        zerg1.name = "Dorne";
        Zerg zerg2 = new Zerg();
        zerg2.name = "Zergling";
        Zerg zerg3 = new Zerg();
        zerg3.name = "Queen";
        Zerg zerg4 = new Zerg();
        zerg4.name = "Hydralisk";
        Zerg zerg5 = new Zerg();
        zerg5.name = "Mutalisk";

        Protoss toss1 = new Protoss();
        toss1.name = "Probe";
        Protoss toss2 = new Protoss();
        toss2.name = "Zealot";
        Protoss toss3 = new Protoss();
        toss3.name = "Carrier";

        Terran terr1 = new Terran();
        terr1.name = "SCV";
        Terran terr2 = new Terran();
        terr2.name = "Marine";
        Terran terr3 = new Terran();
        terr3.name = "Marauder";
        Terran terr4 = new Terran();
        terr4.name = "Medivac";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
