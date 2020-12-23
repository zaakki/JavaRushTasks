package com.javarush.task.task40.task4011;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* 
Свойства URL
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
    }

    public static void decodeURLString(String s) throws MalformedURLException {
       try{
           URL url = new URL(s);
           HashMap<String,String> property = new HashMap<>();
           property.put("protocol",url.getProtocol());
           property.put("authority",url.getAuthority());
           property.put("file", url.getFile());
           property.put("host",url.getHost());
           property.put("path", url.getPath());
           property.put("port",String.valueOf(url.getPort()));
           property.put("default port",String.valueOf(url.getDefaultPort()));
           property.put("query", url.getQuery());
           property.put("ref", url.getRef());
           for (Map.Entry<String, String> pair : property.entrySet() ) {
               System.out.println(pair.getKey() + " - " + pair.getValue());
           }

       }catch (Exception e){
           System.out.println("Parameter " + s + " is not a valid URL");
       }
    }
}

