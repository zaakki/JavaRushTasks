package com.javarush.task.task31.task3101;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* 
Проход по дереву файлов
*/
public class Solution {
     public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        if(FileUtils.isExist(resultFileAbsolutePath)) {
            FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        }
        List<File> fileList = new ArrayList<>();
        try(FileOutputStream fos = new FileOutputStream(allFilesContent)){
            Files.walkFileTree(path.toPath(), new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if(file.toFile().length() > 50){
                        FileUtils.deleteFile(file.toFile());
                    } else {
                        fileList.add(file.toFile());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            Collections.sort(fileList, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            for (File file : fileList
                 ) {
                if(!file.equals(allFilesContent)){
                    FileReader reader = new FileReader(file);
                    while (reader.ready()){
                        fos.write(reader.read());
                    }
                    fos.write("\n".getBytes());
                }
            }
        }

    }
}
