package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/*
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        detectAllWords(crossword, "home", "same","prr","meo");

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }




    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> listWords = new ArrayList<>();

        for (String w : words) {
            char firstChar = w.charAt(0);

            //search first character of word
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {

                    if ((char) crossword[i][j] == firstChar) { //first character was found
                        int startX = j;
                        int startY = i;

                        Word[] word = new Word[8]; // make new array, for each vector of our word.

                        word[0] = northEast(crossword, startX, startY, w);

                        word[1] = north(crossword, startX, startY, w);

                        word[2] = northWest(crossword, startX, startY, w);

                        word[3] = east(crossword, startX, startY, w);

                        word[4] = southEast(crossword, startX, startY, w);

                        word[5] = south(crossword, startX, startY, w);

                        word[6] = southWest(crossword, startX, startY, w);

                        word[7] = west(crossword, startX, startY, w);


                        for (int k = 0; k < word.length; k++)
                            if (word[k] != null)
                                listWords.add(word[k]);
                    }
                }
            }

        }
        for (Word word: listWords
             ) {
            System.out.println(word.toString());
        }
        return listWords;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }

    public static Word northEast(int[][] crossword, int startX, int startY, String s) {
        int x = startX - 1;
        int y = startY - 1;
        for (int i = 1; i < s.length(); i++) {
            if (x < 0 || y < 0)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            x--;
            y--;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x + 1, y + 1);
        return w;
    }

    public static Word north(int[][] crossword, int startX, int startY, String s) {
        int x = startX;
        int y = startY - 1;
        for (int i = 1; i < s.length(); i++) {
            if (y < 0)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            y--;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x, y + 1);
        return w;
    }

    public static Word northWest(int[][] crossword, int startX, int startY, String s) {
        int x = startX + 1;
        int y = startY - 1;
        for (int i = 1; i < s.length(); i++) {
            if (x >= crossword[0].length || y < 0)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            x++;
            y--;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x - 1, y + 1);
        return w;
    }


    public static Word east(int[][] crossword, int startX, int startY, String s) {
        int x = startX + 1;
        int y = startY;
        for (int i = 1; i < s.length(); i++) {
            if (x >= crossword[0].length)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            x++;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x - 1, y);
        return w;
    }

    public static Word southEast(int[][] crossword, int startX, int startY, String s) {
        int x = startX + 1;
        int y = startY + 1;
        for (int i = 1; i < s.length(); i++) {
            if (x >= crossword[0].length || y >= crossword.length)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            x++;
            y++;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x - 1, y - 1);
        return w;
    }


    public static Word south(int[][] crossword, int startX, int startY, String s) {
        int x = startX;
        int y = startY + 1;
        for (int i = 1; i < s.length(); i++) {
            if (y >= crossword.length)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            y++;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x, y - 1);
        return w;
    }

    public static Word southWest(int[][] crossword, int startX, int startY, String s) {
        int x = startX - 1;
        int y = startY + 1;
        for (int i = 1; i < s.length(); i++) {
            if (x < 0 || y >= crossword.length)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            x--;
            y++;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x + 1, y - 1);
        return w;
    }

    public static Word west(int[][] crossword, int startX, int startY, String s) {
        int x = startX - 1;
        int y = startY;
        for (int i = 1; i < s.length(); i++) {
            if (x < 0 || y >= crossword[0].length)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            x--;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x + 1, y);
        return w;
    }

}
