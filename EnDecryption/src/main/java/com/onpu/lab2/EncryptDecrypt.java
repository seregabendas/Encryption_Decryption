package com.onpu.lab2;

import com.onpu.lab2.encrypt.StringChanger;

import java.io.File;
import java.util.List;

public class EncryptDecrypt {

  public static void make(StringChanger changer) {
    File file = ReadWriteFile.selectFile("Select path from");
    if (file == null) {
      return;
    }
    List<String> text = ReadWriteFile.readFile(file);
    if (text == null) {
      return;
    }
    List<String> newText = changer.change(text);

    File fileWrite = null;
    while (fileWrite == null) {
      fileWrite = ReadWriteFile.selectFile("Select path to");
    }
    ReadWriteFile.writeFile(fileWrite, newText);
  }


}
