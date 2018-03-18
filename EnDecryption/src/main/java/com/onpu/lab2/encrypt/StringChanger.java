package com.onpu.lab2.encrypt;

import java.util.List;

@FunctionalInterface
public interface StringChanger {
  List<String> change(List<String> text);
}
