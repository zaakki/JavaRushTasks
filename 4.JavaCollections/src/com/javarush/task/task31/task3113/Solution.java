package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*
Что внутри папки?

Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок - [количество папок в директории и поддиректориях]
Всего файлов - [количество файлов в директории и поддиректориях]
Общий размер - [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.

Квадратные скобки [ ] выводить на экран не нужно.

Требования:
•	Метод main должен считывать путь к папке с консоли.
•	Если введенный путь не является директорией - нужно вывести "[полный путь] - не папка" и завершить работу.
•	Используй только классы и методы из пакета java.nio.
•	На консоль должна быть выведена следующая информация: "Всего папок - [количество папок в директории и поддиректориях]".
•	На консоль должна быть выведена следующая информация: "Всего файлов - [количество файлов в директории и поддиректориях]".
•	На консоль должна быть выведена следующая информация: "Общий размер - [общее количество байт, которое хранится в директории]
*/
public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            Path path  = Paths.get(reader.readLine());
            FileVisitor fileVisitor = new FileVisitor();
            if(!Files.isDirectory(path)){
                System.out.println(path.toAbsolutePath() + " - не папка");
            } else {
                Files.walkFileTree(path, fileVisitor);
                System.out.println("Всего папок - " +   (fileVisitor.getDirCount()-1));
                System.out.println("Всего файлов - " + fileVisitor.getFileCount());
                System.out.println("Общий размер - " + fileVisitor.getSize());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static class FileVisitor extends SimpleFileVisitor<Path>{
        private int dirCount = 0;
        private int fileCount = 0;
        private int size = 0;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            size += attrs.size();
            fileCount++;
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            dirCount++;
            return super.postVisitDirectory(dir, exc);
        }

        int getDirCount() {
            return dirCount;
        }

        int getFileCount() {
            return fileCount;
        }

        int getSize() {
            return size;
        }
    }
}
