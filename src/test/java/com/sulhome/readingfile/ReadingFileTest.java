package com.sulhome.readingfile;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;


public class ReadingFileTest {
  private final String filePath = "src/test/resources/sample-file-large.txt";

  @Test
  public void shouldReadFile_method1() throws FileNotFoundException {
    File myObj = new File(filePath);
    Scanner myReader = new Scanner(myObj);
    StringBuilder content = new StringBuilder();
    while (myReader.hasNextLine()) {
      content.append(myReader.nextLine());
      content.append('\n');
    }
    System.out.println(content);
    myReader.close();
  }

  @Test
  public void shouldReadFile_method2() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
    StringBuilder content = new StringBuilder();
    String line = bufferedReader.readLine();

    while (line != null) {
      content.append(line);
      content.append(System.lineSeparator());
      line = bufferedReader.readLine();
    }
    bufferedReader.close();
    System.out.println(content);
  }

  @Test
  public void shouldReadFile_method3() throws IOException {
    String content = new String(Files.readAllBytes(Paths.get(filePath)));
    System.out.println(content);
  }

  @Test
  public void shouldReadFile_method4() throws IOException {
    List<String> content = Files.readAllLines(Paths.get(filePath));
    content.forEach(System.out::println);
  }

  @Test
  public void shouldReadFile_method5() throws IOException {
    String content = Files.readString(Paths.get(filePath));
    System.out.println(content);
  }

  @Test
  public void shouldReadFile_method6() throws IOException {
    FileInputStream inputStream = new FileInputStream(filePath);
    String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    inputStream.close();
    System.out.println(content);
  }

  @Test
  public void shouldReadFile_method7() throws IOException {
    Collection<String> content = IOUtils.readLines(new FileInputStream(filePath), StandardCharsets.UTF_8);
    content.forEach(System.out::println);
  }
}
