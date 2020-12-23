package com.javarush.task.task37.task3712;

public abstract class Game {
    // public void prepareForTheGame() {
    //        System.out.println("Preparing for the Basketball game...");
    //    }
    //
    //    public void playGame() {
    //        System.out.println("Playing basketball!");
    //    }
    //
    //    public void congratulateWinner() {
    //        System.out.println("Give it up to the NBA finals champions!!!");
    //    }
    public abstract void prepareForTheGame();

    public abstract void playGame();

    public abstract void congratulateWinner();

    public void run(){
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }
}
