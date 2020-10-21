package com.step.sukhiboi.matrix;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void shouldAddTwoMatrix() {
    int[][] values1 = { { 1, 1 }, { 1, 1 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    int[][] values2 = { { 2, 2 }, { 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(2, 2, values2);

    int[][] expectedValues = { { 3, 3 }, { 3, 3 } };
    Matrix expected = Matrix.createMatrix(2, 2, expectedValues);

    assertTrue(matrix1.add(matrix2).equals(expected));
  }

  @Test
  public void shouldSubtractTwoMatrix() {
    int[][] values1 = { { 10, 10 }, { 10, 10 }, { 10, 10 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    int[][] values2 = { { 2, 2 }, { 2, 2 }, { 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(2, 2, values2);

    int[][] expectedValues = { { 8, 8 }, { 8, 8 } };
    Matrix expected = Matrix.createMatrix(2, 2, expectedValues);

    assertTrue(matrix1.subtract(matrix2).equals(expected));
  }
}
