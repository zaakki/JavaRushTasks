package com.javarush.task.task31.task3111;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int maxSize;
    private int minSize;
    private List<Path> foundFiles = new ArrayList<>();
    @Override
   public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String stringContent = new String(content);
        if ((partOfName == null || file.getFileName().toString().contains(partOfName))
                && (partOfContent == null || stringContent.contains(partOfContent))
                && (minSize == 0 || content.length > minSize)
                && (maxSize == 0 || content.length < maxSize)) {
            foundFiles.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}