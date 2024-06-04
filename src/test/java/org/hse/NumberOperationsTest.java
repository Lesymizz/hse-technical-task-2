package org.hse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberOperationsTest {
  private static List<Integer> generateRandomList(int size) {
    List<Integer> numbers = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < size; i++) {
      numbers.add(random.nextInt());
    }
    return numbers;
  }

  @Test
  @DisplayName("Min numbers")
  public void minTest() {
    List<Integer> numbers = Arrays.asList(3, 5, 1, 9, -2, 8, 4, 6, 13, 2);
    assertEquals(-2, NumberOperations._min(numbers));

    numbers = Arrays.asList(-5, -3, -1, -9, -2, -8, -4, -6, 13, -2);
    assertEquals(-9, NumberOperations._min(numbers));
  }

  @Test
  @DisplayName("Max numbers")
  public void maxTest() {
    List<Integer> numbers = Arrays.asList(3, 5, 1, 9, -2, 8, 4, 6, 13, 2);
    assertEquals(13, NumberOperations._max(numbers));

    numbers = Arrays.asList(-5, -43, -1, -9, -2, -8, -4, -6, -33, -2);
    assertEquals(-1, NumberOperations._max(numbers));
  }

  @Test
  @DisplayName("Sum numbers")
  public void sumTest() {
    List<Integer> numbers = Arrays.asList(3, 5, 1, 9, -2, 8, 4, 6, 13, 2);
    assertEquals(49, NumberOperations._sum(numbers));

    numbers = Arrays.asList(-5, -3, -1, -9, -2, -18, -4, -6, 10, -2);
    assertEquals(-40, NumberOperations._sum(numbers));
  }

  @Test
  @DisplayName("Multiply numbers")
  public void multTest() {
    List<Integer> numbers = Arrays.asList(3, 5, 1, 9, -2, 8, 4, 6, 13, 2);
    assertEquals(-1347840, NumberOperations._mult(numbers));

    numbers = Arrays.asList(-5, -3, -1, -9, 20, -8, -4, -6, -10, -2);
    assertEquals(-10368000, NumberOperations._mult(numbers));
  }

  @Test
  @DisplayName("Min with empty list")
  public void minEmptyTest() {
    assertThrows(NoSuchElementException.class, () -> {
      NumberOperations._min(Collections.emptyList());
    });
  }

  @Test
  @DisplayName("Max with empty list")
  public void maxEmptyTest() {
    assertThrows(NoSuchElementException.class, () -> {
      NumberOperations._max(Collections.emptyList());
    });
  }

  @Test
  @DisplayName("Sum with empty list")
  public void sumEmptyTest() {
    assertThrows(NoSuchElementException.class, () -> {
      NumberOperations._sum(Collections.emptyList());
    });
  }

  @Test
  @DisplayName("Multiply with empty list")
  public void multiplyEmptyTest() {
    assertThrows(NoSuchElementException.class, () -> {
      NumberOperations._mult(Collections.emptyList());
    });
  }

  @Test
  @DisplayName("Multiply performance")
  public void performanceMultTest() throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter("performance_mult.txt", false));

    for (int size = 10_000; size <= 1_000_001; size += 10_000) {
      List<Integer> numbers = generateRandomList(size);
      long startTime = System.nanoTime();
      NumberOperations._mult(numbers);
      long endTime = System.nanoTime();
      long elapsed = endTime - startTime;

      String result = "size: " + size + "; elapsed: " + elapsed;
      writer.write(result);
      writer.newLine();
    }
    writer.close();
  }

  @Test
  @DisplayName("Min performance")
  public void performanceMinTest() throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter("performance_min.txt", false));

    for (int size = 10_000; size <= 1_000_001; size += 10_000) {
      List<Integer> numbers = generateRandomList(size);
      long startTime = System.nanoTime();
      NumberOperations._min(numbers);
      long endTime = System.nanoTime();
      long elapsed = endTime - startTime;

      String result = "size: " + size + "; elapsed: " + elapsed;
      writer.write(result);
      writer.newLine();
    }
    writer.close();
  }

  @Test
  @DisplayName("Max performance")
  public void performanceMaxTest() throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter("performance_max.txt", false));

    for (int size = 10_000; size <= 1_000_001; size += 10_000) {
      List<Integer> numbers = generateRandomList(size);
      long startTime = System.nanoTime();
      NumberOperations._max(numbers);
      long endTime = System.nanoTime();
      long elapsed = endTime - startTime;

      String result = "size: " + size + "; elapsed: " + elapsed;
      writer.write(result);
      writer.newLine();
    }
    writer.close();
  }

  @Test
  @DisplayName("Sum performance")
  public void performanceSumTest() throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter("performance_sum.txt", false));

    for (int size = 10_000; size <= 1_000_001; size += 10_000) {
      List<Integer> numbers = generateRandomList(size);
      long startTime = System.nanoTime();
      NumberOperations._sum(numbers);
      long endTime = System.nanoTime();
      long elapsed = endTime - startTime;

      String result = "size: " + size + "; elapsed: " + elapsed;
      writer.write(result);
      writer.newLine();
    }
    writer.close();
  }
}