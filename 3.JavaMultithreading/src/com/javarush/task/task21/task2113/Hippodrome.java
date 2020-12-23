package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private  List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses(){
        return horses;
    }

    public Hippodrome(List<Horse> horse){
        this.horses = horse;
    }
    public void move(){
        for (Horse h: horses
             ) {
            h.move();
        }
    }
    public void print(){
        for (Horse h: horses
        ) {

            h.print();

        }
        for (int i = 0; i < 5 ; i++) {
            System.out.println();
        }
    }
    public void run() throws InterruptedException {
        System.out.println("В нашем забеге сегодня участвуют");
        horses.forEach(horse -> System.out.print(horse.name + " "));
        System.out.println("Поприветсвуем наших лошадок");
        System.out.println("А теперь переходим непосредственно к забегу");
        System.out.println("Всем участникам пригодовиться");
        for (int i = 2; i >=0 ; i--) {
            if(i == 2)
                System.out.println("На старт!!");
            else if(i == 1 )
                System.out.println("Внимание!!!!");
            else
                System.out.println("Марш!!!!!!");
            Thread.sleep(500);
        }
        for (int i = 0; i < 10 ; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        getWinner();

    }

    public Horse getWinner(){
        Horse horse = null;
        int max = 0;
        for (Horse h: horses
        ) {
            if ((int) h.distance > max) {
                max = (int) h.distance;
            }
        }
        for (Horse h: horses
             ) {
            if((int) h.distance == max)
               horse = h;
        }
        return horse;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().name + "!");
    }

    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome(new ArrayList<>());
        Horse horse1 = new Horse("Applejack", 3,0);
        Horse horse2 = new Horse("Fluttershy",3,0);
        Horse horse3 = new Horse("Rainbow Dash",3 ,0);
        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);
        game.run();
        game.printWinner();
        
    }
}
