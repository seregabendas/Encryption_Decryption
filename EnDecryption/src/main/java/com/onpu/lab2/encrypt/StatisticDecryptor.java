package com.onpu.lab2.encrypt;

import static java.lang.Character.isLetter;

import com.onpu.lab2.ReadWriteFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onpu.lab2.ReadWriteFile;

import java.util.Map.Entry;
import java.util.stream.Stream;

public class StatisticDecryptor implements StringChanger {

  private static final char[] charOrder = {'e', 't', 'a', 'o', 'n', 'r', 'i', 's', 'h', 'd', 'l',
      'f', 'c', 'm', 'u', 'g', 'y', 'p', 'w', 'b', 'v', 'k', 'x', 'j', 'q', 'z'};

  @Override
  public List<String> change(List<String> text) {
    Map<Character, Integer> charsMap = countLetters(text);
    List<Character> characters = orderLetters(charsMap);
    if (characters == null || characters.isEmpty()) {
      return null;
    }
    List<String> newText = new ArrayList<>();
    for (String line : text) {
      StringBuilder newLine = new StringBuilder();
      for (int i = 0; i < line.length(); i++) {
        newLine.append(changeLetter(line.charAt(i), characters));
      }
      newText.add(newLine.toString());
    }
    return newText;
  }

  private char changeLetter(char ch, List<Character> characters) {
    int index = characters.indexOf(ch);
    if (index < 0) {
      return ch;
    }
    return charOrder[index];
  }


  private List<Character> orderLetters(Map<Character, Integer> charsMap) {
    List<Entry<Character, Integer>> list = new ArrayList(charsMap.entrySet());
    list.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
    List<Character> characters = new ArrayList<>();
    for (Entry entry : list) {
      characters.add((Character) entry.getKey());
    }
    return characters;
   }

  private Map<Character, Integer> countLetters(List<String> text) {
    Map<Character, Integer> charIntMap = new HashMap<>();
    for (String line : text) {
      for (char symbol : line.toCharArray()) {
        if (isLetter(symbol)) {
          if (charIntMap.containsKey(symbol)) {
            int counter = charIntMap.get(symbol);
            charIntMap.put(symbol, ++counter);
          } else {
            charIntMap.put(symbol, 1);
          }
        }
      }
    }
    return charIntMap;
  }
}