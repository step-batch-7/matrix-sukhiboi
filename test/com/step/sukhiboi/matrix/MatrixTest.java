package com.step.sukhiboi.matrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void shouldReturnTrueIfSameMatrixCompared() {
    int[][] values1 = { { 1, 1 }, { 1, 1 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    assertTrue(matrix1.equals(matrix1));
  }

  @Test
  public void shouldReturnFalseIfDifferentObjectCompared() {
    int[][] values1 = { { 1, 1 }, { 1, 1 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    assertFalse(matrix1.equals(new Object()));
    assertFalse(matrix1.equals(null));
  }

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
  public void shouldReturnNullIfDifferentSizeMatrixAdded() {
    int[][] values1 = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
    Matrix matrix1 = Matrix.createMatrix(3, 2, values1);

    int[][] values2 = { { 2, 2 }, { 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(2, 2, values2);

    assertNull(matrix1.add(matrix2));
  }

  @Test
  public void shouldReturnNullIfNullAdded() {
    int[][] values1 = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
    Matrix matrix1 = Matrix.createMatrix(3, 2, values1);

    assertNull(matrix1.add(null));
  }

  @Test
  public void shouldSubtractTwoMatrix() {
    int[][] values1 = { { 10, 10 }, { 10, 10 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    int[][] values2 = { { 2, 2 }, { 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(2, 2, values2);

    int[][] expectedValues = { { 8, 8 }, { 8, 8 } };
    Matrix expected = Matrix.createMatrix(2, 2, expectedValues);

    assertTrue(matrix1.subtract(matrix2).equals(expected));
  }

  @Test
  public void shouldReturnNullIfDifferentSizeMatrixSubtracted() {
    int[][] values1 = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
    Matrix matrix1 = Matrix.createMatrix(3, 2, values1);

    int[][] values2 = { { 2, 2 }, { 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(2, 2, values2);

    assertNull(matrix1.subtract(matrix2));
  }

  @Test
  public void shouldMultiplyTwoMatrix() {
    int[][] values1 = { { 10, 10 }, { 10, 10 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    int[][] values2 = { { 2, 2 }, { 2, 2 } };
    Matrix matrix2 = Matrix.createMatrix(2, 2, values2);

    int[][] expectedValues = { { 40, 40 }, { 40, 40 } };
    Matrix expected = Matrix.createMatrix(2, 2, expectedValues);

    assertTrue(matrix1.multiply(matrix2).equals(expected));
  }

  @Test
  public void shouldReturnDeterminantOfMatrix() {
    int[][] values1 = { { 10, 2 }, { 12, 10 } };
    Matrix matrix1 = Matrix.createMatrix(2, 2, values1);

    assertEquals(matrix1.determinant(), 76);
  }
}
