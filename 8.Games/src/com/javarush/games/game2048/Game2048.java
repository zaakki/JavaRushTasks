package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 6;
    private int[][] gameField = new int[SIDE][SIDE];
//    !№ 472

    private boolean isGameStopped = false;
    private int score;
    @Override
    public void initialize(){
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
        
    }

    private void createGame(){
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();

    }

    private void drawScene(){
        for(int x = 0; x < SIDE; x++){
            for (int y = 0; y < SIDE; y++){
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private void createNewNumber(){
        int x;
        int y;
        int c = getRandomNumber(10);
        do{
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        }while (gameField[x][y] != 0);
        if(c >= 0 && c < 9)
            gameField[x][y] = 2;
        else if(c == 9)
            gameField[x][y] = 4;
        if(getMaxTileValue() == 4096){
            win();
        }

    }

    private Color getColorByValue(int value){
        Color color;
        if(value == 2){
            color = Color.SKYBLUE;
        } else if (value == 4){
            color = Color.VIOLET;
        } else if( value == 8){
            color = Color.YELLOW;
        } else if(value == 16){
            color = Color.GREEN;
        } else  if (value == 32) {
            color = Color.DIMGREY;
        } else  if (value == 64){
            color = Color.CYAN;
        } else  if (value == 128){
            color = Color.DARKSEAGREEN;
        } else  if (value == 256){
            color = Color.DARKMAGENTA;
        } else if(value == 512){
            color = Color.GREENYELLOW;
        } else  if(value == 1024){
            color = Color.LIGHTPINK;
        } else if(value == 2048){
            color = Color.DARKGOLDENROD;
        } else if(value == 4096){
            color = Color.DARKBLUE;
        }
        else if(value == 0){
            color = Color.ANTIQUEWHITE;
        } else
            return null;

        return color;
    }

    private void setCellColoredNumber (int x, int y, int value){
        //getColorByValue(value);
        setCellValueEx(x, y, getColorByValue(value),value==0? "" : String.valueOf(value));
    }

    private boolean compressRow(int[] row){
       boolean flagCheck = false;
       for(int i = 0; i < row.length; i++){
           if(row[i] == 0){
               for (int j = i; j < row.length; j++){
                   if(row[j] != 0){
                       int tmp = row[i];
                       row[i] = row[j];
                       row[j] = tmp;
                       flagCheck = true;
                       break;
                   }
               }
           }else {

           }
       }
       return flagCheck;
    }

    private boolean mergeRow(int[] row){
        boolean mergeCheck = false;
        for(int i = 0; i < row.length-1; i++){
            if(row[i] != 0){
                if(row[i] == row[i+1]){
                    score=score + row[i] + row[i+1];
                    row[i] = 2 * row[i];
                    row[i + 1] = 0;
                    i++;
                    setScore(score);
                    mergeCheck = true;
                }
            } else {

            }
        }

        return mergeCheck;
    }
    @Override
    public void onKeyPress(Key key){
        if (!canUserMove()) {
            gameOver();
        } else if (isGameStopped && key == Key.SPACE) {
            isGameStopped = false;
            createGame();
            drawScene();
            score=0;
            setScore(0);
        } else if(!isGameStopped && key == Key.LEFT){
            moveLeft();
            drawScene();
        } else if(!isGameStopped && key == Key.RIGHT){
            moveRight();
            drawScene();
        } else if(!isGameStopped && key == Key.UP){
            moveUp();
            drawScene();
        } else if (!isGameStopped && key == Key.DOWN) {
            moveDown();
            drawScene();
        }
    }
    private void moveLeft(){
        boolean change = false;
        for (int x = 0; x < SIDE; x++){
            if(compressRow(gameField[x]))
                change = true;
            if (mergeRow(gameField[x]))
                change = true;
            if(compressRow(gameField[x]))
                change = true;
        }
        if(change)
            createNewNumber();

    }
    private void moveRight(){
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();

    }
    private void moveUp(){
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();


    }
    private void moveDown(){
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();

    }

    private void rotateClockwise(){
        int n = SIDE;
        int[][] temp = new int[n][n];
        for(int i = 0; i < n/2; i++){
            for (int j = i; j < n-i-1;j++){
                int tmp = gameField[i][j];
                temp[i][j] = gameField[n-j-1][i];
                temp[n-j-1][i] = gameField[n-i-1][n-j-1];
                temp[n-i-1][n-j-1] = gameField[j][n-i-1];
                temp[j][n-i-1] = tmp;
            }
        }
        gameField = temp;
    }
    private int getMaxTileValue(){
        int max = Integer.MIN_VALUE;
        for(int x = 0; x < SIDE;x++){
            for (int y = 0; y < SIDE; y++){
                if(max < gameField[x][y]){
                    max = gameField[x][y];
                }
            }
        }
        return max;
    }
    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.INDIANRED," YOU WIN!!! ", Color.DARKBLUE,82);
    }
    private boolean canUserMove() {
        for(int x = 0; x < SIDE; x++){
            for(int y = 0; y < SIDE; y++){
                if(gameField[x][y] ==0) {
                    return true;
                }

                if(x < SIDE - 1){
                    if(gameField[x][y]==gameField[x+1][y]){
                        return true;
                    }
                }
                if(y < SIDE - 1){
                    if(gameField[x][y] == gameField[x][y+1]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "YOU LOSE!!!!" + "\n"+"TRY AGAIN",
                                                    Color.DARKRED,75);

    }

}
