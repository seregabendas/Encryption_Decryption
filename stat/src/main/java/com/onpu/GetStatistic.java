package com.onpu;

import static java.lang.Character.isLetter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


import javax.swing.JFileChooser;

public class GetStatistic {

  public static void main(String[] args) {

    File file = selectFile();
    if (file == null) {
      return;
    }

    String text = readFile(file);
    Map<Character, Integer> charsRepeat = countChars(text);
    printCharsRepeat(charsRepeat);

  }

  private static void printCharsRepeat(Map<Character, Integer> charsRepeat) {
    int count = 0;
    for (Integer value : charsRepeat.values()) {
      count += value;
    }
    final int count1 = count;
    charsRepeat.entrySet().stream()
        .sorted(Entry.<Character, Integer>comparingByValue().reversed())
        .forEach((en) -> System.out
            .println(
                en.getKey() + " - " + String.format("%.2f", (double) en.getValue() * 100 / count1)
                    + "% (" + en.getValue() + ")"));
  }


  private static Map<Character, Integer> countChars(String text) {
    Map<Character, Integer> charIntMap = new HashMap<>();
    text = text.toLowerCase();
    for (char symbol : text.toCharArray()) {
      if (isLetter(symbol)) {
        if (charIntMap.containsKey(symbol)) {
          int counter = charIntMap.get(symbol);
          charIntMap.put(symbol, ++counter);
        } else {
          charIntMap.put(symbol, 1);
        }
      }
    }
    return charIntMap;
  }

  private static String readFile(File file) {

    StringBuilder text = new StringBuilder();
    try (BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(new FileInputStream(file), "UTF-8"))) {

      String line;
      while ((line = bufferedReader.readLine()) != null) {
        text.append(line);
      }
      return text.toString();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return null;
  }


  private static File selectFile() {
    JFileChooser fileChooser = new JFileChooser();
    int ret = fileChooser.showDialog(null, "Select File");
    if (ret != JFileChooser.APPROVE_OPTION) {
      return null;
    }
    return fileChooser.getSelectedFile();
  }
}
