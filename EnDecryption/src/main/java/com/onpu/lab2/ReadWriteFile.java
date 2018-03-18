package com.onpu.lab2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JFileChooser;

public class ReadWriteFile {

  public static void writeFile(File fileWrite, List<String> encrypted) {
    try (BufferedWriter bufferedWriter = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(fileWrite), "UTF-8"))) {
      for (String line : encrypted) {
        bufferedWriter.write(line);
        bufferedWriter.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static List<String> readFile(File file) {
    List<String> text = new ArrayList<>();
    try (BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(new FileInputStream(file), "UTF-8"))) {

      String line;
      while ((line = bufferedReader.readLine()) != null) {
        text.add(line.toLowerCase());
      }
      return text;
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public static File selectFile(String windowTitle) {
    JFileChooser fileChooser = new JFileChooser();
    int ret = fileChooser.showDialog(null, windowTitle);
    if (ret != JFileChooser.APPROVE_OPTION) {
      return null;
    }
    return fileChooser.getSelectedFile();
  }

}
