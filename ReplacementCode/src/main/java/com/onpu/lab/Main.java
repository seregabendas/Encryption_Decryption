package com.onpu.lab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    String abcNormal = "abcdefghijklmnopqrstuvwxyz";
    String abcReplace = "qetuosfhkzcbmwryipadgjlxvn";
    Map<Character, Character> replaceMap = getReplaceMap(abcNormal, abcReplace);

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter text:");
    String enterString = scanner.nextLine();

    String returnString = encryptText(enterString, replaceMap);

    System.out.println("Encrypted text:");
    System.out.println(returnString);

  }

  private static String encryptText(String text, Map<Character, Character> replaceMap) {
    StringBuilder stringBuilder = new StringBuilder();
    text = text.toLowerCase();
    for (int i = 0; i < text.length(); i++) {
      char elem = text.charAt(i);
      if (!Character.isLetter(elem)) {
        stringBuilder.append(elem);
        continue;
      }
      char replaceLetter = replaceMap.get(elem);
      stringBuilder.append(replaceLetter);
    }
    return stringBuilder.toString();
  }

  private static Map<Character, Character> getReplaceMap(String abcNormal, String abcReplace) {
    Map<Character, Character> replaceMap = new HashMap<>();

    while (abcNormal.length() >= abcReplace.length()) {
      abcReplace += abcReplace;
    }
    for (int i = 0; i < abcNormal.length(); i++) {
      char norm = abcNormal.charAt(i);
      char replace = abcReplace.charAt(i);
      replaceMap.put(norm, replace);
    }
    return replaceMap;
  }

}
