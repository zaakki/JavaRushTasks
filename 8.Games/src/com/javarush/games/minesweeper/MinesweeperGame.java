package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game implements onMouseClick {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private boolean isGameStopped;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }
    ///создает поле
    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1; // устанавливает максимальное количество мин

                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);//создается поле Х и У с минами
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
        isGameStopped = false;
    }
//////Получение списка соседей
    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);

            }
        }
        return result;
    }
        ////////Подсчет заминированных соседей
    private void countMineNeighbors(){
        List<GameObject> list;
        /// Смотрим поле
        for(int y = 0; y < SIDE; y++){
            for (int x = 0; x < SIDE; x++){
                ///////////Если ячейка не заменирована, добавляем в список соседние ячейки
                //////если соседния ячейка заменирована переводим счетчик на +1
                if(gameField[y][x].isMine == false){
                    list = getNeighbors(gameField[y][x]);
                    for(int i = 0; i < list.size();i++){
                        if(list.get(i).isMine){
                            gameField[y][x].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    private void openTile(int x, int y){
        if(gameField[y][x].isOpen){

        } else if (gameField[y][x].isFlag){

        }else if (isGameStopped){

        }else {
            gameField[y][x].isOpen = true;
            if (gameField[y][x].isMine) {
                setCellValue(x, y, MINE); //Если открытое поле заминировано, показывает мину
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            } else {
                //setCellNumber(x, y, gameField[y][x].countMineNeighbors); //показывает сколько заменированых ячеек рядом
                //gameField[y][x].isOpen = true;
                setCellColor(x, y, Color.GREEN);
                if (gameField[y][x].countMineNeighbors == 0) {
                    setCellValue(x, y, "");
                    ////Передаем список соседей и проходим по списку
                    for (GameObject gameObject : getNeighbors(gameField[y][x])) {
                        if (!gameObject.isOpen) {///если соседняя ячейка не открыта, открываем по рекурсии
                            openTile(gameObject.x, gameObject.y);
                        }
                    }
                } else {
                    setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                }
            }
        }

    }
    private void markTile(int x, int y){
        if(isGameStopped){//Если игра завершена ничего не делать
            return;
        } else  if(gameField[y][x].isOpen){ //Если ячейка открыта ничего не делать
            return;
        } else if(!gameField[y][x].isFlag && countFlags == 0){ //Если флагов не осталось ничего не делать
            return;
        }
        else if(!gameField[y][x].isOpen) { //если ячейка закрыта
            if(gameField[y][x].isFlag ) { ///Если нажимаем на флаг, снимает флаг
                gameField[y][x].isFlag = false;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.ORANGE);
                countFlags = countFlags + 1;
            } else { //Если ячейка закрыта устанавливат флаг
                gameField[y][x].isFlag = true;
                countFlags = countFlags - 1;
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.AZURE);
            //countFlags--;
            }
        }
    }
        ///Завершает игру
    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.BLUE,"Game Over", Color.BLACK, 8);
    }

    @Override
    public void onMouseLeftClick(int x, int y){
        openTile(x,y);
    }
    @Override
    public void onMouseRightClick(int x, int y){
        markTile(x,y);
    }


}