package com.onpu.lab2.encrypt;

import static java.lang.Character.isLetter;

import java.util.ArrayList;
import java.util.List;

public class CesarEncryptor implements StringChanger {

  @Override
  public List<String> change(List<String> text) {
    List<String> newText = new ArrayList<>();
    for (String line : text) {
      newText.add(encrypt(line));
    }
    return newText;
  }

  private String encrypt(String line) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < line.length(); i++) {
      char ch = line.charAt(i);
      if (isLetter(ch)) {
        if (ch >= 'z' - 4) {
          stringBuilder.append((char) (ch - 'z' + 'a' + 4));
        } else {
          stringBuilder.append((char) (ch + 4));
        }
      } else {
        stringBuilder.append(ch);
      }
    }
    return stringBuilder.toString();
  }
}
