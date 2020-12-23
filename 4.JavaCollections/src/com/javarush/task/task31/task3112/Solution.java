package com.javarush.task.task31.task3112;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://www.tme.eu/Document/c218b7853ab73d734a5d44f7ec800e99/1808.2035.pdf", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        Path dlDirectory = downloadDirectory.resolve(urlString.substring(urlString.lastIndexOf("/") + 1 ));
        InputStream inputStream = url.openStream();

        Path tempFile = Files.createTempFile("temp-", ".tmp");

        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

        return Files.move(tempFile, dlDirectory, StandardCopyOption.REPLACE_EXISTING) ;
    }
}