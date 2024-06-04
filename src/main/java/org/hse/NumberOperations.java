package org.hse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class NumberOperations {


  public static void main(String[] args) throws FileNotFoundException {
    if (args.length != 1) {
      System.out.println("Usage: java NumberOperations.java <file_numbers_path>");
      return;
    }

    String filePath = args[0];
    List<Integer> numbers = readNumbersFromFile(filePath);

    if (numbers.isEmpty()) {
      System.out.println("File is empty");
      return;
    }

    System.out.println("Min: " + _min(numbers));
    System.out.println("Max: " + _max(numbers));
    System.out.println("Sum: " + _sum(numbers));
    System.out.println("Multiply: " + _mult(numbers));
  }

  public static List<Integer> readNumbersFromFile(String filePath) throws FileNotFoundException {
    List<Integer> numbers = new ArrayList<>();

    try (Scanner scanner = new Scanner(new File(filePath))) {
      while (scanner.hasNext()) {
        if (scanner.hasNextInt()) {
          numbers.add(scanner.nextInt());
        } else {
          scanner.next();
        }
      }
    }
    return numbers;

  }

  public static int _min(List<Integer> numbers) {
    if (numbers.isEmpty()) {
      throw new NoSuchElementException();
    }

    int min = Integer.MAX_VALUE;
    for (int number : numbers) {
      if (number < min) {
        min = number;
      }
    }
    return min;
  }

  public static int _max(List<Integer> numbers) {
    if (numbers.isEmpty()) {
      throw new NoSuchElementException();
    }

    int max = Integer.MIN_VALUE;
    for (int number : numbers) {
      if (number > max) {
        max = number;
      }
    }
    return max;
  }

  public static long _sum(List<Integer> numbers) {
    if (numbers.isEmpty()) {
      throw new NoSuchElementException();
    }

    long sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return sum;
  }

  public static long _mult(List<Integer> numbers) {
    if (numbers.isEmpty()) {
      throw new NoSuchElementException();
    }

    long mult = 1;
    for (int number : numbers) {
      mult *= number;
    }
    return mult;
  }
}