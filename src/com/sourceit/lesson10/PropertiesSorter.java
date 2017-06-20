package com.sourceit.lesson10;

import java.io.*;
import java.util.*;

public class PropertiesSorter {
    public static final String FOLDER = "D:/itsource/homeworks/resources/";
    public static final String FILE_IN = FOLDER + "creditBureau.properties";
    public static final String FILE_OUT = FOLDER + "creditBureau_sorted.properties";
    public static final int BUFFER = 1024;

    public static void main(String[] args) {
        File fileIn = new File(FILE_IN);
        File fileOut = new File(FILE_OUT);
        try (InputStream is = new FileInputStream(fileIn);
             OutputStream os = new FileOutputStream(fileOut)) {
            String propertiesString = readAsString(is);

            Map<String, String> propertiesMap = getPropertiesMap(propertiesString);
            String outString = "";
            String currentKey = "";
            for (Map.Entry<String, String> entry: propertiesMap.entrySet()) {
                String mainKeyPart = entry.getKey().split("\\.")[0];
                if (!currentKey.equals(mainKeyPart)) {
                    if (!currentKey.equals("")) {
                        outString += "\r\n";
                    }
                    currentKey = mainKeyPart;
                }
                outString += entry.getKey() + "=" + entry.getValue() + "\r\n";
            }
            writeString(os, outString);
            os.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Map<String, String> getPropertiesMap(String string) {
        String[] lines = string.split("\r\n");
        Map<String, String> propertiesMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String key1 = (String) o1;
                String key2 = (String) o2;
                List<String> key1Parts = Arrays.asList(key1.split("\\."));
                List<String> key2Parts = Arrays.asList(key2.split("\\."));
                int len = Math.min(key1Parts.size(), key2Parts.size());
                for (int i = 0; i < len; i++) {
                    String part1 = key1Parts.get(i);
                    String part2 = key2Parts.get(i);
                    if (part1 == null && part2 != null) {
                        return 1;
                    } else if (part1 != null && part2 == null) {
                        return -1;
                    }
                    int compResult = key1Parts.get(i).compareTo(key2Parts.get(i));
                    if (compResult != 0) {
                        return compResult;
                    }
                }
                return 0;
            }
        });
        for (String line: lines) {
            if (!line.startsWith("#") && !line.isEmpty() && !line.equals("")) {
                List<String> keyValue = Arrays.asList(line.split("="));
                if (keyValue.size() == 2) {
                    propertiesMap.put(keyValue.get(0), keyValue.get(1));
                } else if (keyValue.size() > 2) {
                    System.out.println("Incorrect property format: " + line);
                }
            }
        }
        return propertiesMap;
    }

    private static String readAsString(InputStream is) throws IOException {
        String result = "";
        byte[] buffer = new byte[BUFFER];
        int count = 0;
        while ((count = is.read(buffer)) != -1) {
            result += new String(buffer, 0, count);
        }
        return result;
    }

    private static void writeString(OutputStream os, String line) throws IOException {
        os.write(line.getBytes());
    }
}
