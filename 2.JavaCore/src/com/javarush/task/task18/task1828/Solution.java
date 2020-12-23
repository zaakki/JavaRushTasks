package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        reader.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        String id = args[1];
        String productName, price, quantity;
        List<String>  productList = new ArrayList<>();
        while (br.ready()){
            productList.add(br.readLine());
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        if(args.length>0 && args[0].equals("-u")){
            String newProductName = args[2], newPrice = args[3], newQuantity = args[4];
            for (int i = 0; i < productList.size() ; i++) {
                if (productList.get(i).substring(0, 8).contains(id)) {
                    System.out.println("Match");
                    productList.set(i, String.format("%-8s%-30s%-8s%-4s", id, newProductName, newPrice, newQuantity));
                }
            }
            for (int i = 0; i < productList.size() ; i++) {
                bw.write(productList.get(i) +"\r\n");
            }
        } else if(args.length>0 && args[0].equals("-d")){
            for (int i = 0; i < productList.size() ; i++) {
                if (productList.get(i).substring(0, 8).contains(id)) {
                    productList.remove(i);
                }
            }
            for (int i = 0; i < productList.size() ; i++) {
                bw.write(productList.get(i) + "\r\n");
            }
        }
        bw.flush();
        bw.close();


    }
}
