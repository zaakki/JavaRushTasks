package com.javarush.task.task31.task3106;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
       List<InputStream> files = new ArrayList<>();
        List<String> list = new ArrayList<>();
        FileOutputStream fos = new FileOutputStream(args[0]);
        for (String s : args
                ) {
            if (!s.equals(args[0]))
                list.add(s);
        }
        Collections.sort(list);
        for (String file : list
                ) {
            files.add(new FileInputStream(file));
        }
        try (ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(files)))) {
            while (zipInputStream.getNextEntry() != null) {
                byte[] buffer = new byte[1024];
                int countOfBytes;
                while ((countOfBytes = zipInputStream.read(buffer)) > 0) {
                    fos.write(buffer, 0, countOfBytes);
                    fos.flush();
                }
                zipInputStream.closeEntry();
            }
        }
        fos.close();
    }
}